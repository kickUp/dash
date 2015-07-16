package aspect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import freemarker.log.Logger;

//@Component
public class MyJdbcRealm extends org.apache.shiro.realm.jdbc.JdbcRealm {
	
	 private Logger log = Logger.getLogger(this.getClass().getCanonicalName());
	 
 	    @Override
	    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
	        String username = upToken.getUsername();
	        log.info("MY REAL WAS CALLED: username " + username);
	        // Null username is invalid
	        if (username == null) {
	            throw new AccountException("Null usernames are not allowed by this realm.");
	        }

	        Connection conn = null;
	        AuthenticationInfo info = null;
	        try {
	            conn = dataSource.getConnection();

	            String password = getPasswordForUser(conn, username);

	            if (password == null) {
	                throw new UnknownAccountException("No account found for user [" + username + "]");
	            }

	            SimpleAuthenticationInfo saInfo = new SimpleAuthenticationInfo(username, password, getName());
	            /**
	             * This (very bad) example uses the username as the salt in this sample app.  DON'T DO THIS IN A REAL APP!
	             *
	             * Salts should not be based on anything that a user could enter (attackers can exploit this).  Instead
	             * they should ideally be cryptographically-strong randomly generated numbers.
	             */
	            saInfo.setCredentialsSalt(ByteSource.Util.bytes(username));

	            info = saInfo;

	        } catch (SQLException e) {
	            final String message = "There was a SQL error while authenticating user [" + username + "]";
	            if (log.isErrorEnabled()) {
	                log.error(message, e);
	            }

	            // Rethrow any SQL errors as an authentication exception
	            throw new AuthenticationException(message, e);
	        } finally {
	            JdbcUtils.closeConnection(conn);
	        }

	        return info;
	    }

	    private String getPasswordForUser(Connection conn, String username) throws SQLException {

	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        String password = null;
	        try {
	            ps = conn.prepareStatement(authenticationQuery);
	            ps.setString(1, username);

	            // Execute query
	            rs = ps.executeQuery();

	            // Loop over results - although we are only expecting one result, since usernames should be unique
	            boolean foundResult = false;
	            while (rs.next()) {

	                // Check to ensure only one row is processed
	                if (foundResult) {
	                    throw new AuthenticationException("More than one user row found for user [" + username + "]. Usernames must be unique.");
	                }

	                password = rs.getString(1);

	                foundResult = true;
	            }
	        } finally {
	            JdbcUtils.closeResultSet(rs);
	            JdbcUtils.closeStatement(ps);
	        }

	        return password;
	    }

	

}

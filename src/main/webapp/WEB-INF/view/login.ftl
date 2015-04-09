<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="/style/style.css"/> 
  </head>
  <body>
    <div class="container">
      <header>
        <h1>Login</h1>
      </header>
	   
			   
	  	<#if errors??> 
			<div class="alert alert-error">
			<strong>Okay, Houston, we've had a problem here.</strong>	<br>	
				<#list errors as error>		
						<li>${error.defaultMessage}</li> 
				</#list>
			</div>			
		</#if>
  user list:<br>
  <#list users as user>
    <li>${user}</li>
  </#list>
  <form action="login" class="form-horizontal" method="POST">
		<fieldset>
          <div class="control-group">
            <label class="control-label">Login</label>
            <div class="controls">
              <div class="input-prepend"> 
				<span class="add-on">@</span>	
                <input id="loginField" name="login" class="span3" type="text"/>
              </div>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Password</label>
            <div class="controls">
              <input id="passwordField" name="password" class="span3" type="password"/>
            </div>
          </div>
          <div class="form-actions">
            <button id="loginButton" class="btn btn-primary" type="submit">Login</button>

          </div>
        </fieldset>
      </form>
    </div>
  </body>
</html>

<#import "/spring.ftl" as spring />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="/style/style.css"/>
	<style>
		.error {
			color: red;
			padding: 8px;
			margin: 10px;
			font-size: 15px;
		}
	</style>
  </head>
  <body>
    <div class="container">
      <header>
        <h1>Login</h1>
      </header>  
	  
	  <#if spring.error>
	  <@spring.showErrors "<br>" "error" />
	  </#if>

 
      <form action="login" class="form-horizontal" method="POST">

		<fieldset>
          <div class="control-group">
            <label class="control-label">Login</label>
            <div class="controls">
              <div class="input-prepend"> 
				<span class="add-on">@</span>	
                 <@spring.formInput "user.login" "placeholder='login'"/> 
				 <@spring.showErrors "<br>" "error" />
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

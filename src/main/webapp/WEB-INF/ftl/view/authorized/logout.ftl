<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="/static/style/style.css"/>
  </head>
  <body>
    <div class="container">
      <header>
        <h1>
          Logout
        </h1>
      </header>
      <form action="logout"  class="form-horizontal" method="POST">
        <fieldset>
          <div class="control-group">
            <div class="controls text">
              You currently logged as '<span id="currentUserLogin">${Session.user}</span>'.
            </div>
            <div class="controls text">
              Are you sure you want to logout?
            </div>
          </div>
          <div class="form-actions"> 
				<button id="logoutButton" class="btn btn-danger" type="submit">Logout</button>     
			<a class="btn" href="courses">Back</a>
          </div>
        </fieldset>
      </form>
    </div>
  </body>
</html>

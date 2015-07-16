<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" type="text/css" href="/style/style.css"/>
  </head>
  <body>
    <div class="container">
      <header>
        <h1>
          Course Details
          <div class="logout">
            <span id="currentUserLogin">
              user-a@tc.edu
            </span>
            <a href="logout.html">
              <i class="icon-off"></i>
            </a>
          </div>
        </h1>
      </header>
      <div class="alert alert-error">
        <div>
          <strong>Okay, Houston, we've had a problem here.</strong>
        </div>
        <ul>
          <li>${exception.message}</li>
        </ul>
      </div>
      <div class="form-horizontal">
        <div class="form-actions">
          <a class="btn" href="/courses">Back</a>
        </div>
      </div>
    </div>
  </body>
</html>

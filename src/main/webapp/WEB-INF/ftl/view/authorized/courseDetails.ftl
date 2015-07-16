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
          Course Details
          <div class="logout">
            <span id="currentUserLogin">
				UserLogin
            </span>
            <a href="/logout">
              <i class="icon-off"></i>
            </a>
          </div>
        </h1>
      </header>
      <div class="form-horizontal">
        <div class="control-group">
          <div class="control-label">Name</div>
          <div id="titleField" class="controls text">${course.name}</div>
        </div>     
        <div class="control-group">
          <div class="control-label">Description</div>
          <div id="descriptionField" class="controls text">${course.description}</div>
        </div>
        <div class="control-group">
          <div class="control-label">Links</div>
          <div id="linksField" class="controls text">Lalala</div>
        <div class="form-actions">
          <a class="btn" href="/courses">Back</a>
        </div>
      </div>
    </div>
  </body>
</html>

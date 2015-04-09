
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
          Create Course
          <div class="logout">
            <span id="currentUserLogin">
              lecturer-a@tc.edu
            </span>
            <a href="logout.html">
              <i class="icon-off"></i>
            </a>
          </div>
        </h1>
      </header>
	  	  	<#if errors??> 
			<div class="alert alert-error">
			<strong>Okay, Houston, we've had a problem here.</strong>	<br>	
				<ul>
					<#list errors as error>						
							<li>${error.defaultMessage}</li>
					</#list>
				</ul>
			</div>			
		</#if>
      <form action="create" class="form-horizontal" method="POST">
        <fieldset>
          <div class="control-group">
            <label class="control-label">Name</label>
            <div class="controls">
              <input id="nameField" name="name" class="span5" type="text"/>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Description</label>
            <div class="controls">
              <textarea id="descriptionField" name="description" class="span5" rows="3"></textarea>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label">Links</label>
            <div class="controls">
              <textarea id="links" class="span5" rows="3"></textarea>
            </div>
          </div>
          <div class="form-actions">
            <button id="createButton" class="btn btn-primary" type="submit">Create</button>
            <a class="btn" href="/courses">Cancel</a>
          </div>
        </fieldset>
      </form>
    </div>
  </body>
</html>

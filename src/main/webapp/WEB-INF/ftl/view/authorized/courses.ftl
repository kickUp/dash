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
          Courses
          <div class="logout">
            <span id="currentUserLogin">
               In session: $_{Session.user}				   
            </span>
			<a href="logout">
              <i class="icon-off"></i>
            </a>
          </div>
        </h1>
      </header> 
	  <div class="courses-top-control">
        <a id="createCourseButton" class="btn btn-primary" href="/courses/create">Create</a>
       </div>
      <table class="table table-striped table-bordered">
        <thead>
          <tr>
            <th class="span1">Id</th>
            <th>Course</th>
			<th>Action</th>
			<th>Owner</th>
          </tr>
        </thead> 
          <tr>
            <#if courses??>
			  <#list courses as course>
					<tr>
						<td>
							${course.id}
						</td>
						<td>
							<a href="/courses/${course.id}">${course.name}</a>
						</td>
						<td>
							<a class="btn btn-mini" href="/courses/${course.id}/update">Update</a>
						</td>
						<td>
							${course.user.login}
						</td>
					</tr>
			  </#list>
		   </#if> 
          </tr>           
        </tbody>
      </table>
    </div>
  </body>
</html>

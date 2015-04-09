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
      <table class="table table-striped table-bordered">

        <thead>
          <tr>
            <th class="span1">Id</th>
            <th>Course</th>
          </tr>
        </thead>          
            <#if courses??>
			  <#list courses as course>
				<tr>
					<td>
						${course.id}
					</td>
					<td>
						<a href="courses/${course.id}">${course.name}</a>
					</td>	
				</tr>    					
			  </#list>
		   </#if>                 
        </tbody>
      </table>
    </div>
    <script src="/javascript/angular.js"></script>
  </body>
</html>

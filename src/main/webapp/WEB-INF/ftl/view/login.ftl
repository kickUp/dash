<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <script src="/static/elements/webcomponentsjs/webcomponents.js"></script>
    <link rel="stylesheet" type="text/css" href="/static/style/style.css" /> 
</head>

<body> 
    <#if errors??>
        <div class="alert alert-error">
            <strong>Okay, Houston, we've had a problem here.</strong>
            <br>
            <#list errors as error>
                <li>${error.defaultMessage}</li>
            </#list>
        </div>
    </#if>
    <b>user list (login/password/role):</b>
    <br>
    <#list users as user>
        <li>${user.login}/${user.password}/${user.role.role}</li>
    </#list>
    <div class="container">
    <form action="login" class="form-horizontal" method="POST">
        <fieldset>
            <div class="control-group">
                <label class="control-label">Login</label>
                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on">@</span>
                        <input id="loginField" name="login" class="span3" type="text" />
                    </div>
                </div>
            </div>
            <div class="control-group">
                <label class="control-label">Password</label>
                <div class="controls">
                    <input id="passwordField" name="password" class="span3" type="password" />
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

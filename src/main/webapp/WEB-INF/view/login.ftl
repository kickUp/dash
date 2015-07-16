<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <script src="/static/elements/webcomponentsjs/webcomponents.js"></script>
    <link rel="import" href="/static/elements/roles-list.html" />
    <!-- <link rel="import" href="/static/elements/paper-input/paper-input-container.html"/>  -->
    <link rel="import" href="/static/elements/paper-input/paper-input.html" />
    <link rel="import" href="/static/elements/paper-button/paper-button.html" />
    <link rel="import" href="/static/elements/paper-item/paper-item.html" />
    <link rel="import" href="/static/elements/paper-menu/paper-menu.html" />
    <link rel="import" href="/static/elements/paper-item/paper-icon-item.html" />
    <link rel="import" href="/static/elements/iron-form/iron-form.html" />
    <link rel="import" href="/static/elements/iron-icons/iron-icons.html" />
    <link rel="import" href="/static/elements/iron-icon/iron-icon.html" />
    <link rel="import" href="/static/elements/paper-material/paper-material.html" />
    <link rel="import" href="/static/elements/paper-header-panel/paper-header-panel.html" />
    <link rel="import" href="/static/elements/paper-checkbox/paper-checkbox.html">
    <link rel="import" href="/static/elements/paper-toggle-button/paper-toggle-button.html">
    <style is="custom-style">
        paper-item:hover {
            cursor: pointer;
        }
        .loginBlock {
            padding-top: 5em;
        }
        
        paper-button {
            display: block;
            margin-top: 1em;
            /*padding-left: 8em;*/
        }
        
        .list {
            padding: .5em;
            padding-top: 2em;
            background-color: white;
            margin: 12px;
            @apply(--shadow-elevation-3dp);
        }
        
        paper-material {
            display: inline-block;
            background: white;
            box-sizing: border-box;
            left: %;
            margin: 16px;
            padding: 16px;
            border-radius: 2px;
        }
        
        paper-header-panel {
            width: auto;
            height: 100%;
            @apply(--shadow-elevation-2dp);
        }
        
        .paper-header {
            height: 60px;
            font-size: 16px;
            line-height: 60px;
            padding: 0 10px;
            color: white;
            transition: height 0.2s;
        }
        
        .paper-header.medium-tall {
            height: 100px;
            line-height: 50px;
        }
        
        .content {
            height: 2000px;
        }
        
        .cover {
            margin: 60px;
        }
        
        .cyan .paper-header {
            background-color: var(--paper-cyan-500);
        }
        
        .cyan .content {
            background: linear-gradient(white, #b2ebf2);
        }
        
        a:link {
            color: black;
        }
        
        a:visited {
            color: black;
        }
        
        li {
            list-style-type: none;
            padding-top: .5em;
        }
        
        paper-button.colorful {
            color: #4285f4;
        }

        paper-button[raised].colorful {
          background: #A65128;
          color: #fff;
        }
    </style>
</head>
<body>
    <div class="horizontal center-center layout">
        <div class="loginBlock">
            <paper-material elevation="4">
                <form id="login_form" action="/login" method="POST">
                    <paper-input id="loginField" name="login" label="login" minlength="3" error-message="is required" required></paper-input>
                    <paper-input type="password" id="password" name="password" label="password" error-message="is required" required></paper-input>
                    <paper-button class="colorful" raised onclick="loginAction()">Submit</paper-button>
                </form>
            </paper-material>
        </div>
    </div>
    <!-- <div class="list short"> -->
    <paper-menu class="list">
        <#list users as user>
            <paper-item>
                <iron-icon icon="icons:perm-identity"></iron-icon> ${user.login}/${user.password}
            </paper-item>
        </#list>
    </paper-menu>
    <!-- </div> -->
    <div class="list">
        <paper-icon-item>
            <paper-checkbox checked item-icon></paper-checkbox>
            <div class="flex">Read</div>
            <!-- <iron-icon icon="icons:reorder"></iron-icon> -->
        </paper-icon-item>
        <paper-icon-item>
            <paper-checkbox item-icon></paper-checkbox>
            <div class="flex">Write</div>
            <!-- <iron-icon icon="icons:create"></iron-icon> -->
        </paper-icon-item>
        <paper-icon-item>
            <paper-checkbox item-icon></paper-checkbox>
            <div class="flex">Delete</div>
            <!-- <iron-icon icon="icons:delete"></iron-icon> -->
        </paper-icon-item>
        <paper-icon-item>
            <paper-checkbox item-icon></paper-checkbox>
            <div class="flex">Update</div>
            <!-- <iron-icon icon="icons:save"></iron-icon> -->
        </paper-icon-item>
    </div>
    <#if errors??>
        <paper-material>
            <strong>Okay, Houston, we've had a problem here.</strong>
            <br>
            <#list errors as error>
                <div>
                    ${error.defaultMessage}
                </div>
            </#list>
        </paper-material>
    </#if>
    <script>
        function validateInput(input) {
            if (!Array.isArray(input)) {
                input = Array.prototype.slice.call(input, 0);
            }
            // var isValid = input.every(function(i) {
            //     console.log("val:  " + i);
            //     return i.validate(); 
            // });
            var isValid = true;
            input.forEach(function(i) {
                if (!i.validate() && isValid)
                    isValid = false;
            })
            return isValid;
        }

        function loginAction() {
            var input = document.getElementsByTagName("paper-input");
            if (validateInput(input)) {
                document.getElementById("login_form").submit();
            }
        }
    </script>
</body>

</html>
<!-- 
   <#if errors??>
                <div class="alert alert-error">
                    <strong>Okay, Houston, we've had a problem here.</strong>
                    <br>
                    <#list errors as error>
                        <div>
                            ${error.defaultMessage}
                        </div>
                    </#list>
                </div>
            </#if>
            <br>
            <#list users as user>
                <li>
                    <a href="#">
                        <iron-icon icon="icons:perm-identity">
                        </iron-icon>
                        ${user.login}/${user.password}
                    </a>
                </li>
            </#list> 


   

            -->

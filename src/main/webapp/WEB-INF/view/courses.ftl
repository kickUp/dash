<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <script src="/static/elements/webcomponentsjs/webcomponents.js"></script>
    <link rel="import" href="/static/elements/courses-list.html" />
    <link rel="import" href="/static/elements/header-panel.html" />
    <link rel="import" href="/static/elements/side-panel.html" />
    <link rel="import" href="/static/elements/paper-scroll-header-panel/paper-scroll-header-panel.html" />
    <link rel="import" href="/static/elements/paper-toolbar/paper-toolbar.html" />
    <link rel="import" href="/static/elements/paper-drawer-panel/paper-drawer-panel.html" />
    <style is="custom-style">
    paper-scroll-header-panel {
        position: absolute;
        top: 0;
        right: 0;
        bottom: 0;
        left: 0;
        background-color: var(--paper-grey-200, #eee);
    }
    
/*    paper-toggle-button.blue {
        margin-right: 1em;
        --paper-toggle-button-unchecked-bar-color: var(--paper-grey-200);
        --paper-toggle-button-unchecked-button-color: var(--paper-grey-200);
        --paper-toggle-button-unchecked-ink-color: var(--paper-grey-200);
        --paper-toggle-button-checked-bar-color: var(--paper-light-blue-900);
        --paper-toggle-button-checked-button-color: var(--paper-light-blue-900);
        --paper-toggle-button-checked-ink-color: var(--paper-light-blue-900);
    }*/
    
    #paperDrawerPanel [main] {
        background-color: var(--google-grey-100);
    }
    
    #paperDrawerPanel [drawer] {
        border-right: 1px solid var(--google-grey-300);
    }
    
    #paperDrawerPanel[right-drawer] [drawer] {
        border-left: 1px solid var(--google-grey-300);
    }
    
    paper-button {
        color: white;
        margin: 10px;
        background-color: var(--google-blue-700);
        white-space: nowrap;
    }
    </style>
</head>

<body fullbleed vertical layout>
    <paper-drawer-panel id="paperDrawerPanel">
        <div drawer>
            <side-panel></side-panel>
        </div>
        <div main>
            <div>
                <paper-scroll-header-panel>
                    <header-panel>
                        <paper-icon-button icon="menu"  paper-drawer-toggle></paper-icon-button>
                        <!-- <paper-toggle-button class="blue" paper-drawer-toggle></paper-toggle-button> -->
                    </header-panel>
                    <courses-list></courses-list>
                </paper-scroll-header-panel>
            </div>
        </div>
    </paper-drawer-panel> 
    <!-- <paper-scroll-header-panel> -->
    <!-- <header-panel></header-panel> -->
    <!-- user='{"login":"$_{user.login}", "role":"$_{user.role}"' -->
    <!-- <courses-list></courses-list> -->
    <!-- <paper-toolbar> -->
    <!-- <span>Menu</span> -->
    <!-- </paper-toolbar> -->
    <!-- </paper-scroll-header-panel> -->
    <!-- <header>
      <paper-material elevation="3">
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
      </paper-material>
    </header> -->
</body>

</html>

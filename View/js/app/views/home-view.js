define(function() {

    var internals = {};
    var externals = {};

    internals.elements = {};
    internals.handlers = {};

    internals.renderLeftColumn = function() {
        internals.elements.button1.click(internals.handlers["homeClick"]);
        internals.elements.button2.click(internals.handlers["roomsClick"]);
        internals.elements.button3.click(internals.handlers["guestsClick"]);
        internals.elements.button4.click(internals.handlers["bookingsClick"]);
    };


    internals.renderLogin = function() {
        if(internals.elements.LoginArea) {
            internals.elements.LoginArea.detach();
        };

        internals.elements.LoginArea = $(internals.createLogin());
        internals.elements.LoginArea.click(internals.handlers["toBeDefined"]);
        internals.elements.column2.append(internals.elements.LoginArea);
        
        
    };

    externals.render = function() {
        internals.elements.column2 = $('.column2');
        internals.elements.button1 = $('.button1');
        internals.elements.button2 = $('.button2');
        internals.elements.button3 = $('.button3');
        internals.elements.button4 = $('.button4');
        
        internals.renderLogin();
        internals.elements.button5 = $('.button5');
        internals.elements.button5.click(internals.handlers["submitClick"]);
        internals.renderLeftColumn();
    };

    externals.bind = function (event, handler) {
        internals.handlers[event] = handler;
    };


    //String clutter and HTML modules here

    internals.createLogin = function() {
        return '<form action="/action_page.php">'
        + '<label for="fname">Username:</label><br>'
        + '<input type="text" id="username" name="username" placeholder="Kiko"><br>'
        + '<label for="lname">Password:</label><br>'
        + '<input type="password" id="password" name="password" placeholder="CoolestGuyInTheWorld"><br><br>'
        + '<input class="mainPageButton button5" type=button value=Login></input>'
        + '</form>';
    };




    return externals;
});
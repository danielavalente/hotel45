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
        if(internals.elements.LoginButton) {
            internals.elements.column2.detach();
        };

        internals.elements.LoginButton = $(internals.createLogin());
        //internals.elements.LoginButton.click(internals.handlers["toBeDefined"]);
        internals.elements.column2.append(internals.elements.LoginButton);

        
    };

    externals.render = function() {
        internals.elements.column2 = $('.column2');
        internals.elements.button1 = $('.button1');
        internals.elements.button2 = $('.button2');
        internals.elements.button3 = $('.button3');
        internals.elements.button4 = $('.button4');
        
        internals.renderLogin();
        internals.renderLeftColumn();
    };

    externals.bind = function (event, handler) {
        internals.handlers[event] = handler;
    };


    //String clutter and HTML modules here

    internals.createLogin = function() {
        return '<h1>Kiko is the boss!</h1>'
    };




    return externals;
});
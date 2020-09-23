define(function() {

    var internals = {};
    var externals = {};

    internals.routes = {
        home: {
            hash: '#home',
            controller: 'home-controller',
        },
        rooms: {
            hash: '#rooms',
            controller: 'rooms-controller',
        },
        guests: {
            hash: '#guests',
            controller: 'guests-controller',
        },
        bookings: {
            hash: '#bookings',
            controller: 'bookings-controller',
        },
    };

    internals.defaultRoute = 'home';
    internals.currentHash= '';

    internals.hashCheck = function() {
        if(window.location.hash === internals.currentHash) {
            return;
        }

        var routeName = Object.keys(internals.routes).find(function(name) {
            return window.location.hash === internals.routes[name].hash;
        });

        if(!routeName) {
            internals.loadDefaultRoute();
            return;
        }

        internals.loadController(internals.routes[routeName].controller);
    };

    internals.loadController = function(controllerName) {
        internals.currentHash = window.location.hash;
        console.log(controllerName);

        require(['controllers/' + controllerName], function(controller) {
            
            try {
                controller.start();
            } catch (err) {
                console.log(err.stack);
                window.location.hash =
                    internals.routes[internals.defaultRoute].hash;
            }
        });
    };

    internals.loadDefaultRoute = function() {
        console.log("default invoked.");
        window.location.hash = internals.routes[internals.defaultRoute].hash;
        internals.loadController(internals.routes[internals.defaultRoute].controller)
    };

    externals.start = function() {
        window.location.hash = window.location.hash ||
            internals.routes[internals.defaultRoute].hash;

            setInterval(internals.hashCheck,150);
    };

    return externals;
})
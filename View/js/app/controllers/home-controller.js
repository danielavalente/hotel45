define(['services/home-service', 'views/home-view'], function(homeService, homeView) {

    var internals = {};
    var externals = {};

    internals.bindEventHandlers = function() {
        homeView.bind('homeClick', internals.onHomeButtonClickHandler);
        homeView.bind('roomsClick', internals.onRoomsButtonClickHandler);
        homeView.bind('guestsClick', internals.onGuestsButtonClickHandler);
        homeView.bind('bookingsClick', internals.onBookingsButtonClickHandler);
        homeView.bind('submitClick', internals.onloginButtonClickHandler);
    };

    internals.onHomeButtonClickHandler = function () {
        window.location.hash = '#home';
    };

    internals.onRoomsButtonClickHandler = function () {
        window.location.hash = '#rooms';
    };

    internals.onGuestsButtonClickHandler = function () {
        window.location.hash = '#guests';
    };

    internals.onBookingsButtonClickHandler = function () {
        window.location.hash = '#bookings';
    };

    internals.onloginButtonClickHandler = function () {
        console.log($('#username').val());
        
    }

    externals.start = function() {
        internals.bindEventHandlers();
        homeService.get(homeView.render);
    };


    return externals;
});
define(['services/rooms-service', 'views/rooms-view'], function(roomsService, roomsView) {

    var internals = {};
    var externals = {};

    internals.bindEventHandlers = function() {
        roomsView.bind('homeClick', internals.onHomeButtonClickHandler);
        roomsView.bind('roomsClick', internals.onRoomsButtonClickHandler);
        roomsView.bind('guestsClick', internals.onGuestsButtonClickHandler);
        roomsView.bind('bookingsClick', internals.onBookingsButtonClickHandler);
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

    externals.start = function() {
        internals.bindEventHandlers();
        roomsService.get(roomsView.render);
    };


    return externals;
});
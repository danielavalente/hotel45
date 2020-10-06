$(document).ready(function () {

    listRoomsAvailable();

});

function clickOnUnavailable() {
    $('#available').removeClass('show active');
    $('#available-tab').removeClass('active');
    $('#unavailable').addClass('show active');
    $('#unavailable-tab').addClass('active');
    $('.listAvailableRooms').empty();
    listRoomsUnavailable();
}

function clickOnAvailable() {
    $('#unavailable').removeClass('show active');
    $('#unavailable-tab').removeClass('active');
    $('#available').addClass('show active');
    $('#available-tab').addClass('active');
    $('.listUnavailableRooms').empty();
    listRoomsAvailable();
}

function listRoomsAvailable() {

    $.ajax({
        url: 'http://localhost:8085/api/rooms/available',
        type: 'GET',
        async: true,
        success: function (response) {
            loadRoomsAvailable(response)
        },
        error: function () {
            errorCallback();
        },
    });

}

function loadRoomsAvailable(response) {
    // console.log(response);

    var table = $('.listAvailableRooms');

    $('.roomOptions').remove();

    response.forEach((item) => {
        table.append('<tr class="roomOptions">' +
            '<td>' + item.roomId + '</td>' +
            '<td>' + item.typeOfRoom + '</td>' +
            '<td>' + item.costPerDay + '</td>' +
            '<td>' + item.isAvailable + '</td>' +
            '<td>' + '<a onclick=openRoomEdit(' + item.roomId + ') ><img height="20px" src="images/eye_edit.svg"></img></a>' + '</td>' +
            '</tr>')
    });
}

function listRoomsUnavailable() {

    $.ajax({
        url: 'http://localhost:8085/api/rooms/unavailable',
        type: 'GET',
        async: true,
        success: function (response) {
            loadRoomsUnavailable(response);
        },
        error: function () {
            errorCallback();
        },
    });
}

function loadRoomsUnavailable(response) {
    // console.log(response);

    var table = $('.listUnavailableRooms');

    $('.roomOptions').remove();

    response.forEach((item) => {
        table.append('<tr class="roomOptions">' +
            '<td>' + item.roomId + '</td>' +
            '<td>' + item.typeOfRoom + '</td>' +
            '<td>' + item.costPerDay + '</td>' +
            '<td>' + item.isAvailable + '</td>' +
            '<td>' + '<a onclick=openRoomEdit(' + item.roomId + ') ><img height="20px" src="images/eye_edit.svg"></img></a>' + '</td>' +
            '</tr>')
    });
}

function openRoomEdit(roomNum) {
    window.location.hash = '#' + roomNum;
    $('#containerPage').load("pages/room-edit.html");
}

function openRoomAdd() {
    $('#containerPage').load("pages/room-add.html");
}


function errorCallback(request, status, error) {
    console.log('Sorry, something went wrong...');
}
$(document).ready(function () {

    listRoomsInUse();


});

function clickOnUnavailable() {
    $('#available').removeClass('show active');
    $('#available-tab').removeClass('active');
    $('#unavailable').addClass('show active');
    $('#unavailable-tab').addClass('active');
}

function clickOnAvailable() {
    $('#unavailable').removeClass('show active');
    $('#unavailable-tab').removeClass('active');
    $('#available').addClass('show active');
    $('#available-tab').addClass('active');
}

function listRoomsInUse() {

    $.ajax({
        url: 'http://localhost:8085/api/rooms/available',
        type: 'GET',
        async: true,
        success: function (response) {
            loadRoomsInUse(response)
        },
        error: function () {
            errorCallback();
        },
    });

}

function loadRoomsInUse(response) {
    console.log(response);

    var table = $('.listRooms');

    response.forEach((item) => {
        table.append('<tr>' +
        '<td>' + item.roomId + '</td>' +
        '<td>' + item.typeOfRoom + '</td>' +
        '<td>' + item.costPerDay + '</td>' +
        '<td>' + item.isAvailable + '</td>' + 
        '<td>' +  + '</td>' + 
        '</tr>')
      });
}


function errorCallback(request, status, error) {
    console.log('Sorry, something went wrong...');
}
$(document).ready(function () {

    var editButton = $('#editRoomButton');
    editButton.click(editRoom);

    var numberHash = window.location.hash.split('#')[1];
    // console.log(numberHash);
    listRoomId(numberHash);

    $('#isAvailable').attr('value', 'false');

    $("#isAvailable").on('change', function () {
        if ($(this).is(':checked')) {
            $(this).attr('value', 'true');
        }
        else {
            $(this).attr('value', 'false');
        }
    });

});

function openRoomList() {
    $('#containerPage').load("pages/rooms.html");
}

function listRoomId(roomNum) {

    $.ajax({
        url: 'http://localhost:8085/api/rooms/' + roomNum,
        type: 'GET',
        async: true,
        success: function (response) {
            fillFormWithRoom(response)
        },
        error: function () {
            errorCallback();
        },
    });

    function fillFormWithRoom(response) {
        // console.log(response);
        for (key in response) {
            if (response.hasOwnProperty(key))
                $('input[name=' + key + ']').val(response[key]);
            if (key === 'isAvailable') {
                if (response[key] == true) {
                    $('#isAvailable').click();
                }
            }
            if (key === 'typeOfRoom') {
                $('#inputTypeOfRoom').val(response[key]);
            }
        }
    }
}

function editRoom() {
    var roomId = $('#inputRoomId').val();
    var roomType = $('#inputTypeOfRoom').val();
    var roomCost = $('#inputCostPerDay').val();
    var switchAvailable = $('#isAvailable').val();

    var updatedRoom = '{' +
        '"typeOfRoom"' + ':"' + roomType + '",' +
        '"costPerDay"' + ':' + roomCost + ',' +
        '"isAvailable"' + ':' + switchAvailable + '}';

    console.log(updatedRoom);

    $.ajax({
        url: 'http://localhost:8085/api/rooms/update' + roomId,
        type: 'PUT',
        data: updatedRoom,
        async: true,
        contentType: 'application/json',
        success: function (data) {
            console.log(data);
            alert("success");
        },
        error: function () {
            errorCallback();
        },
    });

    openRoomList();

}

function openRoomList() {
    $('#containerPage').load("pages/rooms.html");
  }
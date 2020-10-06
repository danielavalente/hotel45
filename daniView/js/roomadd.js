$(document).ready(function () {

    var addButton = $('#addRoomButton');
    addButton.click(addRoom);

    $('#switchValue').attr('value', 'false');

    $("#switchValue").on('change', function() {
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

function addRoom() {
    var roomId = $('#inputRoomId').val();
    var roomType = $('#inputTypeOfRoom').val();
    var roomCost = $('#inputCostPerDay').val();
    var switchAvailable = $('#switchValue').val();

    // console.log(roomId);
    // console.log(roomType);
    // console.log(roomCost);
    // console.log(switchAvailable);

    var newRoom = '{' +
        '"typeOfRoom"' + ':"' + roomType + '",' +
        '"costPerDay"' + ':' + roomCost + ',' +
        '"isAvailable"' + ':' + switchAvailable +'}';
    // console.log(newRoom);

    $.ajax({
        url: 'http://localhost:8085/api/rooms/add',
        type: 'POST',
          data: newRoom,
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
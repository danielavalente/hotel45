$(document).ready(function () {

    listCustomersInRooms();

});

function clickOnAllCustomers() {
    $('#inRooms').removeClass('show active');
    $('#inRooms-tab').removeClass('active');
    $('#allCustomers').addClass('show active');
    $('#allCustomers-tab').addClass('active');
    $('.listAllCustomers').empty();
    listAllCustomers();
}

function clickOnCustomersInRooms() {
    $('#allCustomers').removeClass('show active');
    $('#allCustomers-tab').removeClass('active');
    $('#inRooms').addClass('show active');
    $('#inRooms-tab').addClass('active');
    $('.listInRooms').empty();
    listCustomersInRooms();
}

function listAllCustomers() {

    $.ajax({
        url: 'http://localhost:8085/api/customers',
        type: 'GET',
        async: true,
        success: function (response) {
            loadAllCustomers(response)
        },
        error: function () {
            errorCallback();
        },
    });

    function loadAllCustomers(response) {

        var table = $('.listAllCustomers');

        $('.guestsOptions').remove();

        response.forEach((item) => {
            table.append('<tr class="guestsOptions">' +
                '<td>' + item.customerId + '</td>' +
                '<td>' + item.firstName + '</td>' +
                '<td>' + item.lastName + '</td>' +
                '<td>' + item.email + '</td>' +
                '<td>' + item.phone + '</td>' +
                '<td>' + '<a onclick=openCustomerEdit(' + item.customerId + ') ><img height="20px" src="images/eye_edit.svg"></img></a>' + '</td>' +
                '</tr>')
        });
    }

}

function listCustomersInRooms() {

    $.ajax({
        url: 'http://localhost:8085/api/bookings/activebookings',
        type: 'GET',
        async: true,
        success: function (response) {
            loadAllCustomers(response)
        },
        error: function () {
            errorCallback();
        },
    });

    function loadAllCustomers(response) {
        var table = $('.listInRooms');

        $('.guestsOptions').remove();

        response.forEach((item) => {
            table.append('<tr class="guestsOptions">' +
                '<td>' + item.customer.customerId + '</td>' +
                '<td>' + item.customer.firstName + '</td>' +
                '<td>' + item.customer.lastName + '</td>' +
                '<td>' + item.checkInDate + '</td>' +
                '<td>' + item.checkOutDate + '</td>' +
                '<td>' + '<a onclick=openCustomerEdit(' + item.customer.customerId + ') ><img height="20px" src="images/eye_edit.svg"></img></a>' + '</td>' +
                '</tr>')
        });
    }

}

function openCustomerEdit(guestNum) {
    window.location.hash = '#' + guestNum;
    $('#containerPage').load("pages/guest-edit.html");
}

function openCustomerAdd() {
    $('#containerPage').load("pages/guest-add.html");
}

function openGuestList() {
    $('#containerPage').load("pages/guests.html");
}

function errorCallback(request, status, error) {
    console.log('Sorry, something went wrong...');
}
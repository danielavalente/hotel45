$(document).ready(function () {

    var editButton = $('#editCustomerButton');
    editButton.click(editCustomer);

    var numberHash = window.location.hash.split('#')[1];
    listCustomerId(numberHash);

});

function listCustomerId(cusNum) {

    $.ajax({
        url: 'http://localhost:8085/api/customers/' + cusNum,
        type: 'GET',
        async: true,
        success: function (response) {
            fillFormWithCustomer(response)
        },
        error: function () {
            errorCallback();
        },
    });

    function fillFormWithCustomer(response) {
        // console.log(response);
        for (key in response) {
            if (response.hasOwnProperty(key))
                $('input[name=' + key + ']').val(response[key]);

        }
    }
}

function editCustomer() {
    var customerId = $('#inputCustomerId').val();
    var fisrtName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var email = $('#inputemail').val();
    var phone = $('#inputPhone').val();
    var address = $('#inputCity').val();

    var updateCustomer = '{' +
        '"firstName"' + ':"' + fisrtName + '",' +
        '"lastName"' + ':"' + lastName + '",' +
        '"email"' + ':"' + email + '",' +
        '"phone"' + ':"' + phone + '",' +
        '"address"' + ':"' + address + '"}';
    // console.log(newCustomer);

    $.ajax({
        url: 'http://localhost:8085/api/customers/update' + customerId,
        type: 'PUT',
        data: updateCustomer,
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

    openGuestList();
}

function openGuestList() {
    $('#containerPage').load("pages/guests.html");
}
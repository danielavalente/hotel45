$(document).ready(function () {

    var addButton = $('#addCustomerButton');
    addButton.click(addNewCustomer);

});

function addNewCustomer() {
    var fisrtName = $('#inputFirstName').val();
    var lastName = $('#inputLastName').val();
    var email = $('#inputemail').val();
    var phone = $('#inputPhone').val();
    var address = $('#inputCity').val();


    var newCustomer = '{' +
        '"firstName"' + ':"' + fisrtName + '",' +
        '"lastName"' + ':"' + lastName + '",' +
        '"email"' + ':"' + email + '",' +
        '"phone"' + ':"' + phone + '",' +
        '"address"' + ':"' + address +'"}';
    // console.log(newCustomer);

    $.ajax({
        url: 'http://localhost:8085/api/customers/add',
        type: 'POST',
          data: newCustomer,
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
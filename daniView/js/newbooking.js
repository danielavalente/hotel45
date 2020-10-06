$(document).ready(function() {

    var searchButton = $('#searchButton');
    searchButton.click(list);

    var roomTypeField = $('#inputRoomTypeSelect');
    roomTypeField.click(checkIfDatesChangedforRoomType);

    var bookButton = $('#bookButton');
    bookButton.click(makeABooking);

    $('.inputsCustomer').prop('disabled', true);

   

  });
  
  // loads guests by search
    function list() {
      var searchInput = $('#inputSearch').val();
      // console.log(searchInput);
      // console.log('clicked');

      if(searchInput === '') {
        $('.searchResults').empty();
        return;
      }

      $.ajax({
        url: 'http://localhost:8085/api/customers/search=' + searchInput,
        type: 'GET',
        async: true,
        success: function (response) {
          // console.log(response)
          loadGuestsbySearch(response)
        },
        error: function () {
          errorCallback();
          },
        });

        function loadGuestsbySearch(response) {
          var table = $('.searchResults');
          table.show();
    
          $('.searchResults').empty();

          table.append('<li id="itemLink" class="list-group-item createNewCustomer"><a onclick="createNewCustomer()">Create a new customer</a></li>');
    
          response.forEach((item) => {
          table.append('<li id="itemLink" class="list-group-item"><a onclick="getCustomer(' + item.customerId + ')">' + item.firstName + ' ' + item.lastName + '</a></li>');
        });
      };
    };

    //Get Customer
    function getCustomer (customerNumber){
      $('.searchResults').hide();
      $('.inputsCustomer').prop('disabled', true);
      
      $.ajax({
        url: 'http://localhost:8085/api/customers/' + customerNumber,
        type: 'GET',
        async: true,
        success: function (response) {
          fillFormWithCustomer(response);
        },
        error: function () {
          errorCallback();
          },
        });

        function fillFormWithCustomer(response) {
          for(key in response)
          {
            if(response.hasOwnProperty(key))
              $('input[name='+key+']').val(response[key]);
          }
        }
    };

    function createNewCustomer(){
      $('.searchResults').hide();
      $('.inputsCustomer').prop('disabled', false);
      $('.inputsCustomer').val('');
    }
    
    //Check to Get Room Types
    function checkIfDatesChangedforRoomType() {
      var checkInDateField = formatDate($('#inputCheckIn').val());
      var checkOutDateField = formatDate($('#inputCheckOut').val());

      if(checkInDateField == "" || checkOutDateField == "") {
        // console.log("date missing...")
        return;
      }

      if (typeof checkInBefore === 'undefined' && typeof checkOutBefore === 'undefined') {
        // console.log('first date input...')
        checkInBefore = checkInDateField;
        checkOutBefore = checkOutDateField;
        getRoomTypes(checkInDateField, checkOutDateField);
        return;
      }
    
      if(checkInDateField == checkInBefore && checkOutDateField == checkOutBefore) {
        // console.log("dates didn't change...")
        checkChangesforRoomField(checkInDateField, checkOutDateField);
        return;
      } else {
        checkInBefore = checkInDateField;
        checkOutBefore = checkOutDateField;
        getRoomTypes(checkInDateField, checkOutDateField);
      }
    };

      //Load Room Types between dates
      function getRoomTypes(checkInDateField, checkOutDateField) {

      $.ajax({
        url: 'http://localhost:8085/api/rooms/freerooms/' + checkInDateField + "&" + checkOutDateField,
        type: 'GET',
        async: true,
        success: function (response) {
          fillFormWithFreeRooms(response);
        },
        error: function () {
          errorCallback();
          },
        });

        function fillFormWithFreeRooms(response) {
          var table = $('.selectRoomType');
          table.show();
    
          $('.roomTypeOptions').remove();
          $('.roomNumberOptions').remove();
    
          response.forEach((item) => {
          table.append('<option class="roomTypeOptions" value="' + item + '">' + item + '</option>');  
        });
        }

        checkChangesforRoomField(checkInDateField, checkOutDateField)
    
    };

    //Check to Get Room Numbers
    function checkChangesforRoomField(checkInDateField, checkOutDateField) {
      var checkRoomTypeField = $('#inputRoomTypeSelect').val();

      if(checkRoomTypeField == "Choose a type...") {
        // console.log("Type is not chosen...")
        return;
      }

      if (typeof checkRoomTypeBefore == 'undefined') {
        // console.log('first type field input...')
        checkRoomTypeBefore = checkRoomTypeField;
        getRoomNumbers(checkInDateField, checkOutDateField, checkRoomTypeField);
        return;
      }

      if(checkRoomTypeBefore == checkRoomTypeField) {
        // console.log("inputs didn't change...")
        return;
      } else {
        checkRoomTypeBefore = checkRoomTypeField;
        getRoomNumbers(checkInDateField, checkOutDateField, checkRoomTypeField);
      }
    }

    //Load Room Numbers between dates
    function getRoomNumbers(checkInDateField, checkOutDateField, checkRoomTypeField) {
      // console.log(checkRoomTypeField);

      $.ajax({
        url: 'http://localhost:8085/api/rooms/freerooms/' + checkInDateField + "&" + checkOutDateField + '/' + checkRoomTypeField,
        type: 'GET',
        async: true,
        success: function (response) {
          fillFormWithFreeRoomsNumbers(response);
        },
        error: function () {
          errorCallback();
          },
        });

        function fillFormWithFreeRoomsNumbers(response) {
          var table = $('.selectRoomNumber');
          table.show();
    
          $('.roomNumberOptions').remove();
    
          response.forEach((item) => {
          table.append('<option class="roomNumberOptions" value="' + item + '">' + item + '</option>');  
        });
        }
    };

    //Post a new booking
    function makeABooking() {
      var customerIdBooking = $('#inputCustomerId').val();
      var firstNameBooking = $('#inputFirstName').val();
      var lastNameBooking = $('#inputLastName').val();
      var addressBooking = $('#inputCity').val();
      var phoneBooking = $('#inputPhone').val();
      var emailBooking = $('#inputemail').val();
      var checkInBooking = formatDate($('#inputCheckIn').val());
      var checkOutBooking = formatDate($('#inputCheckOut').val());
      var roomIdBooking = $('#inputRoomNumberSelect').val();

      var newBookingUser = '{' +
        '"customerId"' + ':' + customerIdBooking + ',' +
        '"firstName"' + ':"' + firstNameBooking + '",' +
        '"lastName"' + ':"' + lastNameBooking + '",' +
        '"address"' + ':"' + addressBooking + '",' +
        '"phone"' + ':"' + phoneBooking + '",' +
        '"email"' + ':"' + emailBooking + '",' +
        '"checkInDate"' + ':"' + checkInBooking + '",' +
        '"checkOutDate"' + ':"' + checkOutBooking + '",' +
        '"roomId"' + ':' + roomIdBooking +'}';
      console.log(newBookingUser);
      
        $.ajax({
        url: 'http://localhost:8085/api/bookings/add',
        type: 'POST',
          data: newBookingUser,
          async: true,
          contentType: 'application/json',
        success: function (data) {
          // console.log(data);
          $('#containerPage').load("pages/newbooking.html");
          alert("success");
        },
        error: function () {
          errorCallback();
          },
        });
    }

    function errorCallback(request, status, error) {
      console.log('Sorry, something went wrong...');
  }

  function formatDate(oldDate) {
      var datesplit = oldDate.split("-");
      return datesplit[2] + '-' + datesplit[1] + '-' + datesplit[0];
  }
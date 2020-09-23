$(document).ready(function() {

    var searchButton = $('#searchButton');
    searchButton.click(list);

    var bookButton = $('#bookButton');
    bookButton.click(getCustomer);

  });
  
    function list() {
      var searchInput = $('#inputSearch').val();
      console.log(searchInput);
      console.log('clicked');

      if(searchInput === '') {
        $('.searchResults').empty();
        return;
      }

      $.ajax({
        url: 'http://localhost:8085/api/customers/search=' + searchInput,
        type: 'GET',
        async: true,
        success: function (response) {
          console.log(response)
          loadGuestsbySearch(response)
        },
        error: function () {
          errorCallback();
          },
        });
    };

    // loads guests by search
    function loadGuestsbySearch(response) {
      var table = $('.searchResults');
      table.show();

      $('.searchResults').empty();

      response.forEach((item) => {
      table.append('<li id="itemLink" class="list-group-item"><a onclick="getCustomer(' + item.id + ')">' + item.firstName + ' ' + item.lastName + '</a></li>');
    });
  };

    function errorCallback(request, status, error) {
        console.log('Sorry, something went wrong on the list...');
    }

    //Get Customer
    function getCustomer (customerNumber){
      $('.searchResults').hide();
      
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
    
 
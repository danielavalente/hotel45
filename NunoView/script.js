$(document).ready(function () {
    getCustomers();
});

function getCustomers() {
    $.ajax({
        url: "http://localhost:8085/api/customers",
        type: 'GET', 
        dataType: 'json',
        crossDomain: 'true',
        success: getApiCustomers,
        error: getErrorProcess
    });
}


function getErrorProcess() {
    console.log("oh my");
}


function getApiCustomers(response) {
    //TEST
    console.log("Test# OK: GET getAllCustomers");
    console.log(response);

    createTable(response);

    createButton();
}



createTable = function(response) {
    
    //TEST
    console.log(response);
    var keys = Object.keys(response[0]);
    console.log("TEST# key 1 from response is: " + keys[1]);
    //TEST
    var values = Object.values(response[0]);
    console.log("TEST# value 1 from response is: " + values[1]);

    var table = '<div id="customerWindow" class"divType">' +
    '<table id="customerTable" class="tableType">' +
    '</table>' + 
    '</div>';

    $('body').append(table);
    $('#tableOne').append('<h1>test</h1>');


    
    keys.forEach(element => {
        $('#customerTable').append('<th class="customerTableHeadersType">' + element + '</th>')
        console.log("Added the headers to the table");  
              
    }); 
    
    response.forEach(elementA => {
        var values = Object.values(response[elementA.id-1]);
        $('#customerTable').append('<tr id="tr'+ elementA.id +'" class="tableRow"></tr>')
        $('#customersTable').append(
            values.forEach(elementB => {
            $('#tr' + elementA.id).append('<td>' + elementB + '</td>')
            //TEST
            console.log("TEST# elementB: " + elementB);
        })) 
        
        
        //TEST
        console.log("TEST# elementA: " );
        console.log(elementA);
           
    })
};

createButton = function() {
    $('body').append ('<input type="button" id="gobutton" onclick="flipButton()" value="flip"></input>');
}

var flipButton = function() {
    $.getScript("calendar.js");
}

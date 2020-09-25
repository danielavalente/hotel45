$(document).ready(function () {
    buildCalendar();
    console.log("calendar.js loaded")
});

function getCalendar() {
    $.ajax({
        url: "http://localhost:8085/api/bookings",
        type: 'GET', 
        dataType: 'json',
        crossDomain: 'true',
        success: getApiCustomers,
        error: getErrorProcess
    });
}

var buildCalendar = function(startDate, endDate) {
    $('body').append('<div id="calendarOne" class="divCalendarType></div>')
    for (let day = 1; day <= 31; day++) {
        document.querySelector('#calendarOne').insertAdjacentHTLM('beforeend', '<div class="day">${day}</div>');
    }


}

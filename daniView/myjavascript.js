$(document).ready(function() {

  $('#containerPage').load("pages/room-edit.html"); 

  });

  function openHome() {
    $('#containerPage').load("pages/home.html"); 
    $('.menuList').css("color", "#373A3C");
    $('.menuOptions').css("background-color", "transparent");
    $('.menuOptions').css("border", "0px");
    $('#homeMenu').css("color", "#D30000");
  }

  function openRoomsPage() {
    $('#containerPage').load("pages/rooms.html"); 
    $('.menuList').css("color", "#373A3C");
    $('.menuOptions').css("background-color", "transparent");
    $('.menuOptions').css("border", "0px");
    $('#roomMenu').css("color", "#D30000");
  }

  function openGuestsPage() {
    $('#containerPage').load("pages/guests.html"); 
    $('.menuList').css("color", "#373A3C");
    $('.menuOptions').css("background-color", "transparent");
    $('.menuOptions').css("border", "0px");
    $('#guestMenu').css("color", "#D30000");
  }

  function openNewBooking() {
    $('#containerPage').load("pages/newbooking.html"); 
    $('.menuList').css("color", "#373A3C");
    $('.menuOptions').css("background-color", "transparent");
    $('.menuOptions').css("border", "0px");
    $('#bookMenu').css("color", "#D30000");
  }
  
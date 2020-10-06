$(document).ready(function() {

  openGuestsPage();

  });

  function openHome() {
    window.location.hash = '#home';
    $('#containerPage').load("pages/home.html"); 
    $('.menuList').css("color", "#373A3C");
    $('.menuOptions').css("background-color", "transparent");
    $('.menuOptions').css("border", "0px");
    $('#homeMenu').css("color", "#D30000");
  }

  function openRoomsPage() {
    window.location.hash = '#rooms';
    $('#containerPage').load("pages/rooms.html"); 
    $('.menuList').css("color", "#373A3C");
    $('.menuOptions').css("background-color", "transparent");
    $('.menuOptions').css("border", "0px");
    $('#roomMenu').css("color", "#D30000");
  }

  function openGuestsPage() {
    window.location.hash = '#guests';
    $('#containerPage').load("pages/guests.html"); 
    $('.menuList').css("color", "#373A3C");
    $('.menuOptions').css("background-color", "transparent");
    $('.menuOptions').css("border", "0px");
    $('#guestMenu').css("color", "#D30000");
  }

  function openNewBooking() {
    window.location.hash = '#makebooking';
    $('#containerPage').load("pages/newbooking.html"); 
    $('.menuList').css("color", "#373A3C");
    $('.menuOptions').css("background-color", "transparent");
    $('.menuOptions').css("border", "0px");
    $('#bookMenu').css("color", "#D30000");
  }
  
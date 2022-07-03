
!function(e){"use strict";var o,t;e(".dropdown-menu a.dropdown-toggle").on("click",function(t){return e(this).next().hasClass("show")||e(this).parents(".dropdown-menu").first().find(".show").removeClass("show"),e(this).next(".dropdown-menu").toggleClass("show"),!1}),[].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]')).map(function(t){return new bootstrap.Tooltip(t)}),[].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]')).map(function(t){return new bootstrap.Popover(t)}),o=document.getElementsByTagName("body")[0],(t=document.querySelectorAll(".light-dark-mode"))&&t.length&&t.forEach(function(t){t.addEventListener("click",function(t){o.hasAttribute("data-layout-mode")&&"dark"==o.getAttribute("data-layout-mode")?document.body.setAttribute("data-layout-mode","light"):document.body.setAttribute("data-layout-mode","dark")})}),Waves.init()}(jQuery);




const locations=[
  {    id:1,lat:28.558899,long:77.202800},
  {    id:2,lat:28.737324,long:77.090981},
  {    id:3,lat:28.610722,long:77.065971},
  {    id:4,lat:28.647284,long:77.202835},
  {    id:5,lat:28.719646,long:77.174065},
  {    id:6,lat:28.719646,long:77.174065},
  {    id:7,lat:28.670048,long:77.181854},
  {    id:8,lat:28.549507,long:77.203613},
  {    id:9,lat:28.548244,long:77.288719},
  {    id:10,lat:28.642361,long:77.217110},
]


function getRandomLat() {

  return locations[Math.floor(Math.random() * locations.length)];
}
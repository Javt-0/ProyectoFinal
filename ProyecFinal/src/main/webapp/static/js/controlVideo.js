/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
var videos = document.querySelectorAll("video");

for (var i = 0; i < videos.length; i++) {
  videos[i].addEventListener("mouseover", function() {
    this.play();
  });
  videos[i].addEventListener("mouseout", function() {
    this.pause();
  });
}


/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

let modal = document.getElementById('mediaModal');

modal.addEventListener('show.bs.modal', function (event) {
  let button = event.relatedTarget; // Button that triggered the modal
  let id = button.getAttribute('data-id'); // Extract info from data-* attributes

  // Do something with the id
  console.log("El id del juego seleccionado es: " + id);
});

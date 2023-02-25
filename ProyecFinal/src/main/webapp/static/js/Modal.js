/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function openMediaModal(id) {
    let modal = document.getElementById('mediaModal');
    let idInput = document.getElementById('idInput');
    idInput.value = id;
    modal.showModal();
}

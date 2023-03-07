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

function openEditModal(id) {
    console.log('Se hizo clic en el botón con ID ' + id);
    let modal = document.getElementById('editarGameModal');
    let idInput = document.getElementById('idGame');
    idInput.value = id;
    modal.showModal();
}
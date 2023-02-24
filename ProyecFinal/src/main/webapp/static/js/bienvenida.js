const navbar = document.querySelector(".navbar");
const bienvenida = document.querySelector(".bienvenida");
const navbarToggle = document.querySelector("#navbarNav");

const alturaImg = () => {
  const altura = window.innerHeight - navbar.clientHeight;
  bienvenida.style.height = `${altura}px`;
};


navbarToggle.ontransitionend = alturaImg;
navbarToggle.ontransitionstart = alturaImg;
window.onresize = alturaImg;
window.onload = alturaImg;



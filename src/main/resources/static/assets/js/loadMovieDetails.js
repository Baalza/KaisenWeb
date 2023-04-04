var img = document.getElementById("home"),
  style = img.currentStyle || window.getComputedStyle(img, false),
  bi = style.backgroundImage.slice(4, -1).replace(/"/g, "");

var img =
  "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/ss0Os3uWJfQAENILHZUdX8Tt1OC.jpg";

document.getElementById("home").style.backgroundImage = "url(" + img + ")";

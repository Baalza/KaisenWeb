/*var img = document.getElementById("homeDetails"),
  style = img.currentStyle || window.getComputedStyle(img, false),
  bi = style.backgroundImage.slice(4, -1).replace(/"/g, "");

var img =
  "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/r7Dfg9aRZ78gJsmDlCirIIlNH3d.jpg";

document.getElementById("homeDetails").style.backgroundImage =
  "url(" + img + ")";*/

var url_string = window.location.href;
var url = new URL(url_string);
var pathType = url.pathname;
var app = pathType.split("/movie/");
var id = app[1];

async function getHtml() {
  const response = await fetch(
    "http://192.168.1.224:8080/movie/details?id=" + id
  );
  const myJson = await response.json(); //extract JSON from the http response
  return myJson;
}
getHtml().then((data) => {
  console.log(data);
  var genresC = document.getElementById("genres-cont");
  data.genres.forEach((entity) => {
    console.log(entity.id);
    const linkGenre = document.createElement("a");
    linkGenre.classList.add("no-dec");
    linkGenre.classList.add("genre-link");
    linkGenre.setAttribute(
      "href",
      "http://192.168.1.224:8080/genre" + "/" + entity.id
    );
    const genreName = document.createElement("p");
    genreName.classList.add("details");
    genreName.classList.add("info");
    genreName.classList.add("inline");
    genreName.innerHTML = entity.name;

    linkGenre.appendChild(genreName);
    genresC.appendChild(linkGenre);
  });
  var img = document.getElementById("homeDetails"),
    style = img.currentStyle || window.getComputedStyle(img, false),
    bi = style.backgroundImage.slice(4, -1).replace(/"/g, "");
  var img = data.backdropPath;
  document.getElementById("homeDetails").style.backgroundImage =
    "url(" + img + ")";

  var imageElement = document.getElementById("imgDet");
  imageElement.setAttribute(
    "src",
    "https://image.tmdb.org/t/p/w300_and_h450_face/" + data.posterPath
  );
  var title = document.getElementById("titleDet");
  title.innerHTML = data.title;

  var release = document.getElementById("releaseDet");
  release.innerHTML = data.releaseDate;

  var desc = document.getElementById("descDet");
  desc.innerHTML = data.overview;

  var desc2 = document.getElementById("descDetmb");
  desc2.innerHTML = data.overview;

  var desc2 = document.getElementById("runtimeDet");
  desc2.innerHTML = data.runtime;

  var tag = document.getElementById("taglineDet");
  tag.innerHTML = data.tagline;

  var tag2 = document.getElementById("taglineDetmb");
  tag2.innerHTML = data.tagline;
});

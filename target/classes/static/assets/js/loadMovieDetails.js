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
var app = pathType.split("/MOVIE/");
var id = app[1];

async function getHtml() {
  const response = await fetch(
    "http://192.168.1.224:8080/movie/details?id=" + id
  );
  const myJson = await response.json(); //extract JSON from the http response
  return myJson;
}
getHtml().then((data) => {
  console.log(data.backdropPath);
  var img = document.getElementById("homeDetails"),
    style = img.currentStyle || window.getComputedStyle(img, false),
    bi = style.backgroundImage.slice(4, -1).replace(/"/g, "");

  var img = data.backdropPath;

  document.getElementById("homeDetails").style.backgroundImage =
    "url(" + bi + img + ")";
});

var el = document.getElementById("homeDetails");
var $o = $("#homeDetails");
//console.log($o.height());
var alt = $o.height() + 96;
//console.log(alt);
var element = window.window.getComputedStyle(
  document.querySelector("#homeDetails"),
  ":before"
);
//console.log(element);
//element.style.height = alt;
var ss = document.styleSheets;

for (i = 0; i < ss.length; i++) {
  var rules = ss[i];
  for (j = 0; j < rules.cssRules.length; j++) {
    var r = rules.cssRules[j];
    if (
      r.selectorText == ".details:before" ||
      r.selectorText == ".details::before"
    ) {
      console.log("Old rule: " + r.cssText);
      r.style.height = alt + "px";
      console.log("Modified rule: " + r.cssText);
    }
  }
}
var selector = ".details::before";
var rule = "min-height";
var sheetName = "style.css";
var sheets = document.styleSheets,
  stylesheet = sheets[sheets.length - 1];

for (var i in document.styleSheets) {
  if (sheets[i].href && sheets[i].href.indexOf(sheetName + ".css") > -1) {
    stylesheet = sheets[i];
    break;
  }
}

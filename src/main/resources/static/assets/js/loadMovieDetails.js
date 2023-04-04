var img = document.getElementById("homeDetails"),
  style = img.currentStyle || window.getComputedStyle(img, false),
  bi = style.backgroundImage.slice(4, -1).replace(/"/g, "");

var img =
  "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/ss0Os3uWJfQAENILHZUdX8Tt1OC.jpg";

document.getElementById("homeDetails").style.backgroundImage =
  "url(" + img + ")";

var el = document.getElementById("homeDetails");
var $o = $("#homeDetails");
console.log($o.height());
var alt = $o.height() + 96;
console.log(alt);
var element = window.window.getComputedStyle(
  document.querySelector("#homeDetails"),
  ":before"
);
console.log(element);
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

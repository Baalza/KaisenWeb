// Example starter JavaScript for disabling form submissions if there are invalid fields
(() => {
  "use strict";

  // Fetch all the forms we want to apply custom Bootstrap validation styles to
  const forms = document.querySelectorAll(".needs-validation");

  // Loop over them and prevent submission
  Array.from(forms).forEach((form) => {
    form.addEventListener(
      "submit",
      (event) => {
        if (!form.checkValidity()) {
          event.preventDefault();
          event.stopPropagation();
        }

        form.classList.add("was-validated");
      },
      false
    );
  });
})();
$(document).on("click", "div.movie a", function () {
  var yt = this.className; // "this" is the element clicked
  var title = this.parentNode.classList.toString();
  var app;
  app = title.split("/-");
  title;
  title = app[0];
  title = title.substring(11, title.length);

  id = app[1];
  id = id.substring(1, id.length);
  const result = $("#video-yt").attr("src", yt);
  document.getElementById("title").innerHTML = title;
  var aid = document.getElementById("trailer-id");
  aid.href = "/movie/" + id;
  if (title.length > 55) {
    var contyt = document.getElementById("container-yt");
    contyt.classList.add("mt-t-mb");
  }
});

$("#staticBackdrop").on("hide.bs.modal", function (e) {
  $("#staticBackdrop iframe").attr(
    "src",
    $("#staticBackdrop iframe").attr("src")
  );
});

const menu = document.querySelectorAll("ol#sper li");
function passto(elem) {
  var app;
  var current = elem.getAttribute("id");
  app = elem.id + "-t";
  item = document.getElementById(app);
  item.classList.remove("hidden");
  menu.forEach((li) => {
    li.classList.remove("active");
    if (li.classList.contains(current)) {
      li.classList.add("active");
    }
  });
  if (app != "uscite-t") {
    var app1 = document.getElementById("uscite-t");
    var parent = app1.parentNode;
    app1.classList.add("hidden");
  }
  if (app != "cinema-t") {
    var app1 = document.getElementById("cinema-t");
    app1.classList.add("hidden");
  }
  if (app != "popolari-t") {
    var app1 = document.getElementById("popolari-t");
    app1.classList.add("hidden");
  }
}
const menu2 = document.querySelectorAll("ol#sper2 li");
function passto2(elem) {
  var app;
  var current = elem.getAttribute("id");
  app = elem.id + "-t";
  item = document.getElementById(app);
  item.classList.remove("hidden");
  menu2.forEach((li) => {
    li.classList.remove("active");
    if (li.classList.contains(current)) {
      li.classList.add("active");
    }
  });
  if (app != "oggi-t") {
    var app1 = document.getElementById("oggi-t");
    var parent = app1.parentNode;
    app1.classList.add("hidden");
  }
  if (app != "sett-t") {
    var app1 = document.getElementById("sett-t");
    app1.classList.add("hidden");
  }
}
const menu3 = document.querySelectorAll("ul#sper3 li");
function passto3(elem) {
  //var app;
  var current = elem.getAttribute("id");

  /*app = elem.id + "-t";
  item = document.getElementById(app);
  item.classList.remove("hidden");*/
  menu3.forEach((li) => {
    li.classList.remove("active");
    li.classList.remove("featured");
    if (li.classList.contains(current)) {
      li.classList.add("active");
      li.classList.add("featured");
    }
  });
  /*if (app != "uscite-t") {
    var app1 = document.getElementById("uscite-t");
    var parent = app1.parentNode;
    app1.classList.add("hidden");
  }
  if (app != "cinema-t") {
    var app1 = document.getElementById("cinema-t");
    app1.classList.add("hidden");
  }
  if (app != "popolari-t") {
    var app1 = document.getElementById("popolari-t");
    app1.classList.add("hidden");
  }*/
}
const menu4 = document.querySelectorAll("ul#sper4 li");
function passto4(elem) {
  //var app;
  var current = elem.getAttribute("id");

  /*app = elem.id + "-t";
  item = document.getElementById(app);
  item.classList.remove("hidden");*/
  menu4.forEach((li) => {
    li.classList.remove("active");
    li.classList.remove("featured");
    if (li.classList.contains(current)) {
      li.classList.add("active");
      li.classList.add("featured");
    }
  });
  /*if (app != "uscite-t") {
    var app1 = document.getElementById("uscite-t");
    var parent = app1.parentNode;
    app1.classList.add("hidden");
  }
  if (app != "cinema-t") {
    var app1 = document.getElementById("cinema-t");
    app1.classList.add("hidden");
  }
  if (app != "popolari-t") {
    var app1 = document.getElementById("popolari-t");
    app1.classList.add("hidden");
  }*/
}
const tooltipTriggerList = document.querySelectorAll(
  '[data-bs-toggle="tooltip"]'
);
const tooltipList = [...tooltipTriggerList].map(
  (tooltipTriggerEl) => new bootstrap.Tooltip(tooltipTriggerEl)
);

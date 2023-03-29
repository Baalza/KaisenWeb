var url_string = window.location.href;
var url = new URL(url_string);
var query = url.searchParams.get("query");
var page = url.searchParams.get("page");

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
var totalPage = 10;
let currentPage = 1;
if (page == null) {
  currentPage = 1;
} else {
  currentPage = page;
}
console.log(page);
const pagination = document.querySelector(".pagination");

window.onload = function () {
  render();
};

function render() {
  // 1. find pageGroup through currentPage
  let pageGroup = Math.ceil(currentPage / 5);
  // 2. lastPage
  let lastPage = pageGroup * 5;
  // 3. firstPage
  let firstPage = lastPage - 4;
  // 4. if lastPage overs totalPage
  if (lastPage > totalPage) {
    lastPage = totalPage;
  }
  // 5. if firstPage get lower than 0
  if (firstPage <= 0) {
    firstPage = 1;
  }
  let next = lastPage + 1;
  let prev = firstPage - 1;
  let pageHTML = ``;

  // forloop pagelist and save in pageHTML
  for (let i = firstPage; i <= lastPage; i++) {
    console.log(currentPage == i);
    pageHTML += `<li class="page-item ${
      currentPage == i ? "active" : ""
    }"><a class="page-link"  onclick="pageMove(${i});pageSelector(${i});">${i}</a></li>`;
  }

  // render left right arrow and render
  let paginationHTML = `<li class="page-item">
      <a class="page-link left ${
        firstPage === 1 ? "hidden" : ""
      }"  aria-label="Previous" onclick="pageMove(${prev})">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
  ${pageHTML}
  <li class="page-item">
      <a class="page-link right ${
        lastPage === totalPage ? "hidden" : ""
      }"  aria-label="Next" onclick="pageMove(${next})">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>`;

  // render inside <ul class="pagination"></ul>
  pagination.innerHTML = paginationHTML;
}

// page move after click (make active class on currentPage)
function pageMove(i) {
  currentPage = i;
  render();
}
$(document).ready(function () {
  var url_string = window.location.href;
  var url = new URL(url_string);
  var path = url.pathname;
  var app = path.split("/search/");
  path = app[1];
  if (path == "movie") {
    var movie = document.getElementById("movieResTab");
    var movie2 = document.getElementById("movieResTab2");
    var tv = document.getElementById("tvResTab");
    var tv2 = document.getElementById("tvResTab2");
    var coll = document.getElementById("collResTab");
    var coll2 = document.getElementById("collResTab2");
    movie.classList.add("active");
    movie2.classList.add("active");
    movie.classList.add("featured");
    movie2.classList.add("featured");
    tv.classList.remove("active");
    tv2.classList.remove("active");
    tv.classList.remove("featured");
    tv2.classList.remove("featured");
    coll.classList.remove("active");
    coll2.classList.remove("active");
    coll.classList.remove("featured");
    coll2.classList.remove("featured");
  } else if (path == "tv") {
    var movie = document.getElementById("movieResTab");
    var movie2 = document.getElementById("movieResTab2");
    var tv = document.getElementById("tvResTab");
    var tv2 = document.getElementById("tvResTab2");
    var coll = document.getElementById("collResTab");
    var coll2 = document.getElementById("collResTab2");
    movie.classList.remove("active");
    movie2.classList.remove("active");
    movie.classList.remove("featured");
    movie2.classList.remove("featured");
    tv.classList.add("active");
    tv2.classList.add("active");
    tv.classList.add("featured");
    tv2.classList.add("featured");
    coll.classList.remove("active");
    coll2.classList.remove("active");
    coll.classList.remove("featured");
    coll2.classList.remove("featured");
  } else if (path == "collection") {
    var movie = document.getElementById("movieResTab");
    var movie2 = document.getElementById("movieResTab2");
    var tv = document.getElementById("tvResTab");
    var tv2 = document.getElementById("tvResTab2");
    var coll = document.getElementById("collResTab");
    var coll2 = document.getElementById("collResTab2");
    movie.classList.remove("active");
    movie2.classList.remove("active");
    movie.classList.remove("featured");
    movie2.classList.remove("featured");
    tv.classList.remove("active");
    tv2.classList.remove("active");
    tv.classList.remove("featured");
    tv2.classList.remove("featured");
    coll.classList.add("active");
    coll2.classList.add("active");
    coll.classList.add("featured");
    coll2.classList.add("featured");
  }
});
function pageSelector(i) {
  var url_string = window.location.href;
  var url = new URL(url_string);
  var path = url.pathname;
  var app = path.split("/search/");
  path = app[1];

  history.pushState(
    null,
    null,
    "/search/" + path + "?query=" + query + "&page=" + i
  );

  document.getElementById("s-pag").scrollIntoView({
    behavior: "smooth",
    block: "start",
  });
  document.g;
}
function loadMovie() {
  var url_string = window.location.href;
  var url = new URL(url_string);
  var query = url.searchParams.get("query");
  history.pushState(null, null, "/search/movie?query=" + query);
  totalPage = 2;
  render();
}
function loadTv() {
  var url_string = window.location.href;
  var url = new URL(url_string);
  var query = url.searchParams.get("query");
  history.pushState(null, null, "/search/tv?query=" + query);
  totalPage = 3;
  render();
}
function loadColl() {
  var url_string = window.location.href;
  var url = new URL(url_string);
  var query = url.searchParams.get("query");
  history.pushState(null, null, "/search/collection?query=" + query);
  totalPage = 4;
  render();
}

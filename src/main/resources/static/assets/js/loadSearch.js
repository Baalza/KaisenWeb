var url_string = window.location.href;
var url = new URL(url_string);
var query = url.searchParams.get("query");
var url = new URL(url_string);
var pathType = url.pathname;
var app = pathType.split("/search/");
pathType = app[1];

async function getHtml() {
  const response = await fetch("http://localhost:8080/NumRes?query=" + query);
  const myJson = await response.json(); //extract JSON from the http response
  return myJson;
}

getHtml().then((data) => {
  var movieRes = document.getElementById("movieRes");
  var tvRes = document.getElementById("tvRes");
  var collRes = document.getElementById("collRes");
  movieRes.innerHTML = data.movieRes;
  tvRes.innerHTML = data.tvRes;
  collRes.innerHTML = data.CollectionRes;

  var movieRes2 = document.getElementById("movieRes2");
  var tvRes2 = document.getElementById("tvRes2");
  var collRes2 = document.getElementById("collRes2");
  movieRes2.innerHTML = data.movieRes;
  tvRes2.innerHTML = data.tvRes;
  collRes2.innerHTML = data.CollectionRes;
});

async function getHtml2() {
  const response = await fetch("http://localhost:8080/NumPage?query=" + query);
  const myJson = await response.json(); //extract JSON from the http response
  return myJson;
}

var url_string = window.location.href;
var url = new URL(url_string);
var query = url.searchParams.get("query");
var page = url.searchParams.get("page");

var totalPage;
let currentPage = 1;

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
  var moviePage = 0;
  var tvPage = 0;
  var collPage = 0;
  getHtml2().then((data) => {
    moviePage = data.movieRes;
    tvPage = data.tvRes;
    collPage = data.CollectionRes;
    var url_string = window.location.href;
    var url = new URL(url_string);
    var path = url.pathname;
    var app = path.split("/search/");
    path = app[1];
    if (path == "movie") {
      totalPage = moviePage;
      render();
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
      totalPage = tvPage;
      render();
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
      totalPage = collPage;
      render();
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
  var url_string = window.location.href;
  var url = new URL(url_string);

  var page = url.searchParams.get("page");
  var url = new URL(url_string);
  var pathType = url.pathname;
  var app = pathType.split("/search/");
  pathType = app[1];
  getHtml3(pathType, page);
}
function loadMovie() {
  getHtml2().then((data) => {
    currentPage = 1;
    var moviePage = data.movieRes;
    var url_string = window.location.href;
    var url = new URL(url_string);
    var query = url.searchParams.get("query");
    history.pushState(null, null, "/search/movie?query=" + query);
    totalPage = moviePage;
    render();
    var url_string = window.location.href;
    var url = new URL(url_string);

    var page = url.searchParams.get("page");
    var url = new URL(url_string);
    var pathType = url.pathname;
    var app = pathType.split("/search/");
    pathType = app[1];
    console.log(pathType);
    getHtml3(pathType, page);
  });
}
function loadTv() {
  getHtml2().then((data) => {
    currentPage = 1;
    var tvPage = data.tvRes;
    var url_string = window.location.href;
    var url = new URL(url_string);
    var query = url.searchParams.get("query");
    history.pushState(null, null, "/search/tv?query=" + query);
    totalPage = tvPage;
    render();
    var url_string = window.location.href;
    var url = new URL(url_string);

    var page = url.searchParams.get("page");
    var url = new URL(url_string);
    var pathType = url.pathname;
    var app = pathType.split("/search/");
    pathType = app[1];
    console.log(pathType);
    getHtml3(pathType, page);
  });
}
function loadColl() {
  getHtml2().then((data) => {
    currentPage = 1;
    var collPage = data.CollectionRes;
    var url_string = window.location.href;
    var url = new URL(url_string);
    var query = url.searchParams.get("query");
    history.pushState(null, null, "/search/collection?query=" + query);
    totalPage = collPage;
    render();
    var url_string = window.location.href;
    var url = new URL(url_string);

    var page = url.searchParams.get("page");
    var url = new URL(url_string);
    var pathType = url.pathname;
    var app = pathType.split("/search/");
    pathType = app[1];
    console.log(pathType);
    getHtml3(pathType, page);
  });
}
async function getHtml3(p, page) {
  const response = await fetch(
    "http://localhost:8080/LoadEntity?query=" +
      query +
      "&category=" +
      p +
      "&page=" +
      page
  );
}

getHtml3(pathType, page);

var url_string = window.location.href;
var url = new URL(url_string);
var query = url.searchParams.get("query");
var url = new URL(url_string);
var pathType = url.pathname;
var app = pathType.split("/search/");
pathType = app[1];

const searchBar = document.createElement("template");

searchBar.innerHTML = /*html*/ `
<form
                class="d-flex animate__animated animate__flipInX"
                action="https://kaisenweb.herokuapp.com/search/movie"
                method="GET"
                _lpchecked="1"
              >
                <input
                  class="form-control me-2"
                  type="text"
                  name="query"
                  placeholder="Cerca un Film o una SerieTV"
                  aria-label="Search"
                />
                <button class="btn search" type="submit">
                  <i class="fa-sharp fa-solid fa-magnifying-glass"></i>
                </button>
              </form>
`;
var prototype_copy = searchBar.cloneNode(true);

prototype_copy.id = "whatever"; //note--must be an Element!

async function getHtml() {
  const response = await fetch(
    "https://kaisenweb.herokuapp.com/NumRes?query=" + query
  );
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
  const response = await fetch(
    "https://kaisenweb.herokuapp.com/NumPage?query=" + query
  );
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
  const cardContainer = document.getElementById("renderEntity");
  cardContainer.replaceChildren();
  cardContainer.appendChild(prototype_copy);
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
  getHtml3(pathType, page).then((data) => {
    console.log(data);
    console.log(data.type);
    const cardContainer = document.getElementById("renderEntity");
    data.forEach((entity) => {
      const mainCard = document.createElement("div");
      mainCard.classList.add("card");
      mainCard.classList.add("main-card");
      mainCard.classList.add("pt-3");

      const row = document.createElement("div");
      row.classList.add("row");
      row.classList.add("g-0");

      const col2 = document.createElement("div");
      col2.classList.add("col-2");

      const cardRes = document.createElement("div");
      cardRes.classList.add("card-res");

      const link = document.createElement("a");
      link.classList.add("image");
      link.setAttribute("href", entity.type + "/" + entity.id);

      const img = document.createElement("img");
      img.classList.add("img-mb");
      img.setAttribute("loading", "lazy");
      img.setAttribute("alt", "");
      img.setAttribute(
        "src",
        "https://image.tmdb.org/t/p/w220_and_h330_face" + entity.posterPath
      );
      link.appendChild(img);
      cardRes.appendChild(link);
      col2.appendChild(cardRes);

      const col10 = document.createElement("div");
      col10.classList.add("col-10");

      const cardBody = document.createElement("div");
      cardBody.classList.add("card-body");
      cardBody.classList.add("ms-5");
      cardBody.classList.add("pt-0");

      const link2 = document.createElement("a");
      link2.classList.add("image");
      link2.classList.add("title-s");
      link2.setAttribute("href", entity.type + "/" + entity.id);

      const h5 = document.createElement("h5");
      h5.classList.add("card-title");
      h5.innerHTML = entity.title;

      link2.appendChild(h5);

      const release = document.createElement("p");
      release.classList.add("card-text");

      const small = document.createElement("small");
      small.classList.add("text-muted");
      small.innerHTML = entity.release;

      release.appendChild(small);

      const desc = document.createElement("p");
      desc.classList.add("card-text");
      desc.classList.add("card-desc");
      desc.innerHTML = entity.description;

      cardBody.appendChild(link2);
      cardBody.appendChild(release);
      cardBody.appendChild(desc);

      col10.appendChild(cardBody);

      row.appendChild(col2);
      row.appendChild(col10);

      mainCard.appendChild(row);

      cardContainer.appendChild(mainCard);
    });
  });
}
function loadMovie() {
  const cardContainer = document.getElementById("renderEntity");
  cardContainer.replaceChildren();
  cardContainer.appendChild(prototype_copy);
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
    getHtml3(pathType, page).then((data) => {
      console.log(data);
      console.log(data.type);
      const cardContainer = document.getElementById("renderEntity");
      data.forEach((entity) => {
        const mainCard = document.createElement("div");
        mainCard.classList.add("card");
        mainCard.classList.add("main-card");
        mainCard.classList.add("pt-3");

        const row = document.createElement("div");
        row.classList.add("row");
        row.classList.add("g-0");

        const col2 = document.createElement("div");
        col2.classList.add("col-2");

        const cardRes = document.createElement("div");
        cardRes.classList.add("card-res");

        const link = document.createElement("a");
        link.classList.add("image");
        link.setAttribute("href", entity.type + "/" + entity.id);

        const img = document.createElement("img");
        img.classList.add("img-mb");
        img.setAttribute("loading", "lazy");
        img.setAttribute("alt", "");
        img.setAttribute(
          "src",
          "https://image.tmdb.org/t/p/w220_and_h330_face" + entity.posterPath
        );
        link.appendChild(img);
        cardRes.appendChild(link);
        col2.appendChild(cardRes);

        const col10 = document.createElement("div");
        col10.classList.add("col-10");

        const cardBody = document.createElement("div");
        cardBody.classList.add("card-body");
        cardBody.classList.add("ms-5");
        cardBody.classList.add("pt-0");

        const link2 = document.createElement("a");
        link2.classList.add("image");
        link2.classList.add("title-s");
        link2.setAttribute("href", entity.type + "/" + entity.id);

        const h5 = document.createElement("h5");
        h5.classList.add("card-title");
        h5.innerHTML = entity.title;

        link2.appendChild(h5);

        const release = document.createElement("p");
        release.classList.add("card-text");

        const small = document.createElement("small");
        small.classList.add("text-muted");
        small.innerHTML = entity.release;

        release.appendChild(small);

        const desc = document.createElement("p");
        desc.classList.add("card-text");
        desc.classList.add("card-desc");
        desc.innerHTML = entity.description;

        cardBody.appendChild(link2);
        cardBody.appendChild(release);
        cardBody.appendChild(desc);

        col10.appendChild(cardBody);

        row.appendChild(col2);
        row.appendChild(col10);

        mainCard.appendChild(row);

        cardContainer.appendChild(mainCard);
      });
    });
  });
}
function loadTv() {
  const cardContainer = document.getElementById("renderEntity");
  cardContainer.replaceChildren();
  cardContainer.appendChild(prototype_copy);
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
    getHtml3(pathType, page).then((data) => {
      console.log(data);
      console.log(data.type);
      const cardContainer = document.getElementById("renderEntity");
      data.forEach((entity) => {
        const mainCard = document.createElement("div");
        mainCard.classList.add("card");
        mainCard.classList.add("main-card");
        mainCard.classList.add("pt-3");

        const row = document.createElement("div");
        row.classList.add("row");
        row.classList.add("g-0");

        const col2 = document.createElement("div");
        col2.classList.add("col-2");

        const cardRes = document.createElement("div");
        cardRes.classList.add("card-res");

        const link = document.createElement("a");
        link.classList.add("image");
        link.setAttribute("href", entity.type + "/" + entity.id);

        const img = document.createElement("img");
        img.classList.add("img-mb");
        img.setAttribute("loading", "lazy");
        img.setAttribute("alt", "");
        img.setAttribute(
          "src",
          "https://image.tmdb.org/t/p/w220_and_h330_face" + entity.posterPath
        );
        link.appendChild(img);
        cardRes.appendChild(link);
        col2.appendChild(cardRes);

        const col10 = document.createElement("div");
        col10.classList.add("col-10");

        const cardBody = document.createElement("div");
        cardBody.classList.add("card-body");
        cardBody.classList.add("ms-5");
        cardBody.classList.add("pt-0");

        const link2 = document.createElement("a");
        link2.classList.add("image");
        link2.classList.add("title-s");
        link2.setAttribute("href", entity.type + "/" + entity.id);

        const h5 = document.createElement("h5");
        h5.classList.add("card-title");
        h5.innerHTML = entity.title;

        link2.appendChild(h5);

        const release = document.createElement("p");
        release.classList.add("card-text");

        const small = document.createElement("small");
        small.classList.add("text-muted");
        small.innerHTML = entity.release;

        release.appendChild(small);

        const desc = document.createElement("p");
        desc.classList.add("card-text");
        desc.classList.add("card-desc");
        desc.innerHTML = entity.description;

        cardBody.appendChild(link2);
        cardBody.appendChild(release);
        cardBody.appendChild(desc);

        col10.appendChild(cardBody);

        row.appendChild(col2);
        row.appendChild(col10);

        mainCard.appendChild(row);

        cardContainer.appendChild(mainCard);
      });
    });
  });
}
function loadColl() {
  const cardContainer = document.getElementById("renderEntity");
  cardContainer.replaceChildren();
  cardContainer.appendChild(prototype_copy);
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
    getHtml3(pathType, page).then((data) => {
      console.log(data);
      console.log(data.type);
      const cardContainer = document.getElementById("renderEntity");
      data.forEach((entity) => {
        const mainCard = document.createElement("div");
        mainCard.classList.add("card");
        mainCard.classList.add("main-card");
        mainCard.classList.add("pt-3");

        const row = document.createElement("div");
        row.classList.add("row");
        row.classList.add("g-0");

        const col2 = document.createElement("div");
        col2.classList.add("col-2");

        const cardRes = document.createElement("div");
        cardRes.classList.add("card-res");

        const link = document.createElement("a");
        link.classList.add("image");
        link.setAttribute("href", entity.type + "/" + entity.id);

        const img = document.createElement("img");
        img.classList.add("img-mb");
        img.setAttribute("loading", "lazy");
        img.setAttribute("alt", "");
        img.setAttribute(
          "src",
          "https://image.tmdb.org/t/p/w220_and_h330_face" + entity.posterPath
        );
        link.appendChild(img);
        cardRes.appendChild(link);
        col2.appendChild(cardRes);

        const col10 = document.createElement("div");
        col10.classList.add("col-10");

        const cardBody = document.createElement("div");
        cardBody.classList.add("card-body");
        cardBody.classList.add("ms-5");
        cardBody.classList.add("pt-0");

        const link2 = document.createElement("a");
        link2.classList.add("image");
        link2.classList.add("title-s");
        link2.setAttribute("href", entity.type + "/" + entity.id);

        const h5 = document.createElement("h5");
        h5.classList.add("card-title");
        h5.innerHTML = entity.title;

        link2.appendChild(h5);

        const release = document.createElement("p");
        release.classList.add("card-text");

        const small = document.createElement("small");
        small.classList.add("text-muted");
        small.innerHTML = entity.release;

        release.appendChild(small);

        const desc = document.createElement("p");
        desc.classList.add("card-text");
        desc.classList.add("card-desc");
        desc.innerHTML = entity.description;

        cardBody.appendChild(link2);
        cardBody.appendChild(release);
        cardBody.appendChild(desc);

        col10.appendChild(cardBody);

        row.appendChild(col2);
        row.appendChild(col10);

        mainCard.appendChild(row);

        cardContainer.appendChild(mainCard);
      });
    });
  });
}
async function getHtml3(p, page) {
  const response = await fetch(
    "https://kaisenweb.herokuapp.com/LoadEntity?query=" +
      query +
      "&category=" +
      p +
      "&page=" +
      page
  );
  const myJson = await response.json(); //extract JSON from the http response
  return myJson;
}

getHtml3(pathType, page).then((data) => {
  console.log(data);
  console.log(data.type);
  const cardContainer = document.getElementById("renderEntity");
  data.forEach((entity) => {
    const mainCard = document.createElement("div");
    mainCard.classList.add("card");
    mainCard.classList.add("main-card");
    mainCard.classList.add("pt-3");

    const row = document.createElement("div");
    row.classList.add("row");
    row.classList.add("g-0");

    const col2 = document.createElement("div");
    col2.classList.add("col-2");

    const cardRes = document.createElement("div");
    cardRes.classList.add("card-res");

    const link = document.createElement("a");
    link.classList.add("image");
    link.setAttribute("href", entity.type + "/" + entity.id);

    const img = document.createElement("img");
    img.classList.add("img-mb");
    img.setAttribute("loading", "lazy");
    img.setAttribute("alt", "");
    img.setAttribute(
      "src",
      "https://image.tmdb.org/t/p/w220_and_h330_face" + entity.posterPath
    );
    link.appendChild(img);
    cardRes.appendChild(link);
    col2.appendChild(cardRes);

    const col10 = document.createElement("div");
    col10.classList.add("col-10");

    const cardBody = document.createElement("div");
    cardBody.classList.add("card-body");
    cardBody.classList.add("ms-5");
    cardBody.classList.add("pt-0");

    const link2 = document.createElement("a");
    link2.classList.add("image");
    link2.classList.add("title-s");
    link2.setAttribute("href", entity.type + "/" + entity.id);

    const h5 = document.createElement("h5");
    h5.classList.add("card-title");
    h5.innerHTML = entity.title;

    link2.appendChild(h5);

    const release = document.createElement("p");
    release.classList.add("card-text");

    const small = document.createElement("small");
    small.classList.add("text-muted");
    small.innerHTML = entity.release;

    release.appendChild(small);

    const desc = document.createElement("p");
    desc.classList.add("card-text");
    desc.classList.add("card-desc");
    desc.innerHTML = entity.description;

    cardBody.appendChild(link2);
    cardBody.appendChild(release);
    cardBody.appendChild(desc);

    col10.appendChild(cardBody);

    row.appendChild(col2);
    row.appendChild(col10);

    mainCard.appendChild(row);

    cardContainer.appendChild(mainCard);
  });
});

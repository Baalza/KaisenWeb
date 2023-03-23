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
  title = app[0];
  title = title.substring(11, title.length);
  id = app[1];
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
let totalPage = 40;
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
    pageHTML += `<li class="page-item ${
      currentPage === i ? "active" : ""
    }"><a class="page-link" href="http://192.168.1.224:8080/search/movie?query=Dune?page=${i}" onclick="pageMove(${i})">${i}</a></li>`;
  }

  // render left right arrow and render
  let paginationHTML = `<li class="page-item">
      <a class="page-link left ${
        firstPage === 1 ? "hidden" : ""
      }" href="#footer" aria-label="Previous" onclick="pageMove(${prev})">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
  ${pageHTML}
  <li class="page-item">
      <a class="page-link right ${
        lastPage === totalPage ? "hidden" : ""
      }" href="#footer" aria-label="Next" onclick="pageMove(${next})">
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

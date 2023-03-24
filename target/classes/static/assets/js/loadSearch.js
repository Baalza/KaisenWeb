var url_string = window.location.href;
console.log(url_string);
var url = new URL(url_string);
var query = url.searchParams.get("query");
console.log(query);

async function getHtml() {
  const response = await fetch(
    "http://192.168.1.224:8080/NumRes?query=" + query
  );
  const myJson = await response.json(); //extract JSON from the http response
  return myJson;
}

getHtml().then((data) => {
  console.log(data);
  var movieRes = document.getElementById("movieRes");
  var tvRes = document.getElementById("tvRes");
  var collRes = document.getElementById("collRes");
  movieRes.innerHTML = data.movieRes;
  tvRes.innerHTML = data.tvRes;
  collRes.innerHTML = data.CollectionRes;
});
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
    }"><a class="page-link" href="#" onclick="pageMove(${i})">${i}</a></li>`;
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

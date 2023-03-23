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

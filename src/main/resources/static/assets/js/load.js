const array = ["Popolari", "Trending", "Upcoming", "Cinema", "Av"];

array.forEach((api) => {
  var cont = 0;
  async function getHtml() {
    const response = await fetch("https://kaisenweb.herokuapp.com/" + api);
    const myJson = await response.json(); //extract JSON from the http response
    return myJson;
  }

  getHtml().then((data) => {
    data.forEach((movie) => {
      const popSlider = document.getElementById("mySlider" + api);
      const movieElement = document.createElement("div");
      movieElement.classList.add("movie");
      if (api === "Popolari") {
        cont = 1;
      } else if (api === "Trending") {
        cont = 2;
      } else if (api === "Upcoming") {
        cont = 3;
      } else if (api === "Cinema") {
        cont = 4;
      } else if (api === "Av") {
        cont = 5;
      }
      movieElement.setAttribute("id", "main" + cont);

      const linkElement = document.createElement("a");
      linkElement.classList.add("image");
      linkElement.setAttribute("href", "/movie/" + movie.id);

      const imageElement = document.createElement("img");
      imageElement.classList.add("img-mb");
      imageElement.setAttribute("loading", "lazy");
      imageElement.setAttribute(
        "src",
        "https://image.tmdb.org/t/p/w220_and_h330_face/" + movie.poster_path
      );

      imageElement.setAttribute("alt", "");

      linkElement.appendChild(imageElement);
      movieElement.appendChild(linkElement);
      popSlider.appendChild(movieElement);
    });
  });
});

const arrayT = ["Trailerinarrivo", "Trailercinema", "Trailerpopolari"];

arrayT.forEach((apiT) => {
  var cont2 = 0;
  async function getHtml2() {
    const response = await fetch("https://kaisenweb.herokuapp.com/" + apiT);
    const myJson = await response.json(); //extract JSON from the http response
    return myJson;
  }

  getHtml2().then((data) => {
    data.forEach((trailer) => {
      var app;
      const Slider = document.getElementById("mySlider" + apiT);
      const movieElement2 = document.createElement("div");

      movieElement2.classList.add("movie");
      movieElement2.classList.add("film");
      app = trailer.title.split(" ");

      app.forEach((fix) => {
        movieElement2.classList.add(fix);
      });

      movieElement2.classList.add("/-");
      movieElement2.classList.add(trailer.id);
      if (apiT === "Trailerinarrivo") {
        cont2 = 6;
      } else if (apiT === "Trailercinema") {
        cont2 = 7;
      } else if (apiT === "Trailerpopolari") {
        cont2 = 8;
      }
      movieElement2.setAttribute("id", "main" + cont2);

      const linkElement2 = document.createElement("a");
      linkElement2.classList.add(trailer.video);
      linkElement2.setAttribute("data-bs-toggle", "modal");
      linkElement2.setAttribute("data-bs-target", "#staticBackdrop");

      const playEl = document.createElement("div");
      playEl.classList.add("play-icon");

      const playIcon = document.createElement("i");
      playIcon.classList.add("fa-solid");
      playIcon.classList.add("fa-play");

      const imageElement = document.createElement("img");
      imageElement.classList.add("img-mb");
      imageElement.classList.add("trailer");

      imageElement.setAttribute(
        "src",
        "https://image.tmdb.org/t/p/w355_and_h200_multi_faces/" +
          trailer.backdrop_path
      );
      imageElement.setAttribute("alt", "");
      playEl.appendChild(imageElement);
      playEl.appendChild(playIcon);
      linkElement2.appendChild(playEl);
      movieElement2.appendChild(linkElement2);
      Slider.appendChild(movieElement2);
    });
  });
});

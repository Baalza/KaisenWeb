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
const slider = document.querySelector(".slider");
const btnLeft = document.getElementById("moveLeft");
const btnRight = document.getElementById("moveRight");
const indicators = document.querySelectorAll(".indicator");

let baseSliderWidth = slider.offsetWidth;
let activeIndex = 0; // the current page on the slider

let movies = [
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/qOQGNTDXPe8AMa3g1Ll60yNfKid.jpg",
  },

  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },

  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/qOQGNTDXPe8AMa3g1Ll60yNfKid.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/qOQGNTDXPe8AMa3g1Ll60yNfKid.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/qOQGNTDXPe8AMa3g1Ll60yNfKid.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/qOQGNTDXPe8AMa3g1Ll60yNfKid.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/qOQGNTDXPe8AMa3g1Ll60yNfKid.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/qOQGNTDXPe8AMa3g1Ll60yNfKid.jpg",
  },

  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/qOQGNTDXPe8AMa3g1Ll60yNfKid.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/lVlwOuF9TQeYJ8oY7cpehvEaE4k.jpg",
  },
  {
    src: "https://image.tmdb.org/t/p/w220_and_h330_face/3PNftGpAkQJvDSX7XhCNJiNPFh8.jpg",
  },
];

// Fill the slider with all the movies in the "movies" array
function populateSlider() {
  movies.forEach((image) => {
    // Clone the initial movie thats included in the html, then replace the image with a different one
    const newMovie = document.getElementById("movie0");
    let clone = newMovie.cloneNode(true);
    let img = clone.querySelector("img");
    img.src = image.src;

    slider.insertBefore(clone, slider.childNodes[slider.childNodes.length - 1]);
  });
}

populateSlider();
populateSlider();

// delete the initial movie in the html
const initialMovie = document.getElementById("movie0");
initialMovie.remove();

// Update the indicators that show which page we're currently on
function updateIndicators(index) {
  indicators.forEach((indicator) => {
    indicator.classList.remove("active");
  });
  let newActiveIndicator = indicators[index];
  newActiveIndicator.classList.add("active");
}

// Scroll Left button
btnLeft.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider.scrollBy({
    top: 0,
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex = (activeIndex - 1) % 3;
  console.log(activeIndex);
  updateIndicators(activeIndex);
});

// Scroll Right button
btnRight.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  console.log(`movieWidth = ${movieWidth}`);
  console.log(`scrolling right ${scrollDistance}`);

  // if we're on the last page
  if (activeIndex == 2) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    populateSlider();
    slider.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex = 0;
    updateIndicators(activeIndex);
  } else {
    slider.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex = (activeIndex + 1) % 3;
    console.log(activeIndex);
    updateIndicators(activeIndex);
  }
});

// slider.addEventListener("scroll", (e) => {
//   console.log(slider.scrollLeft);
//   console.log(slider.offsetWidth);
// });

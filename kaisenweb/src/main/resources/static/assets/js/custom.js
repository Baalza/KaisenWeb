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

const slider2 = document.querySelector(".sl2");
const btnLeft2 = document.getElementById("moveLeft2");
const btnRight2 = document.getElementById("moveRight2");

const slider3 = document.querySelector(".sl3");
const btnLeft3 = document.getElementById("moveLeft3");
const btnRight3 = document.getElementById("moveRight3");

const slider4 = document.querySelector(".sl4");
const btnLeft4 = document.getElementById("moveLeft4");
const btnRight4 = document.getElementById("moveRight4");

const indicators = document.querySelectorAll(".indicator");
let baseSliderWidth = slider.offsetWidth;
let activeIndex = 0; // the current page on the slider
let activeIndex2 = 0; // the current page on the slider
let activeIndex3 = 0; // the current page on the slider
let activeIndex4 = 0; // the current page on the slider
// Update the indicators that show which page we're currently on
let app = 0;

// Scroll Left button
btnLeft.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider.scrollBy({
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex = (activeIndex - 1) % 3;
  console.log(activeIndex);
  //updateIndicators(activeIndex);
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
  if (activeIndex == 3 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main").scrollIntoView();
    slider.scrollBy({
      right: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex = 0;
    //updateIndicators(activeIndex);
  } else {
    slider.scrollBy({
      left: +scrollDistance,
      behavior: "smooth",
    });
    if (app == 1) {
      activeIndex = (activeIndex + 1) % 4;
    } else {
      activeIndex = (activeIndex + 1) % 3;
      if (activeIndex == 0) {
        document.getElementById("main").scrollIntoView({
          behavior: "smooth",
        });
      }
    }
    console.log(activeIndex);
    //updateIndicators(activeIndex);
  }
});
//scroll left button
btnLeft2.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider2.scrollBy({
    top: 0,
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex2 = (activeIndex2 - 1) % 3;
  console.log(activeIndex2);
  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight2.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  console.log(`movieWidth = ${movieWidth}`);
  console.log(`scrolling right ${scrollDistance}`);

  // if we're on the last page
  if (activeIndex2 == 3 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main2").scrollIntoView();
    slider2.scrollBy({
      top: 0,
      right: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex2 = 0;
    //updateIndicators(activeIndex);
  } else {
    slider2.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    if (app == 1) {
      activeIndex2 = (activeIndex2 + 1) % 4;
    } else {
      activeIndex2 = (activeIndex2 + 1) % 3;
      if (activeIndex2 == 0) {
        document.getElementById("main2").scrollIntoView({
          behavior: "smooth",
        });
      }
    }
    console.log(activeIndex2);
    //updateIndicators(activeIndex);
  }
});
//scroll left button
btnLeft3.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider3.scrollBy({
    top: 0,
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex3 = (activeIndex3 - 1) % 3;
  console.log(activeIndex2);
  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight3.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  console.log(`movieWidth = ${movieWidth}`);
  console.log(`scrolling right ${scrollDistance}`);

  // if we're on the last page
  if (activeIndex3 == 3 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main3").scrollIntoView();
    slider3.scrollBy({
      top: 0,
      right: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex3 = 0;
    //updateIndicators(activeIndex);
  } else {
    slider3.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    if (app == 1) {
      activeIndex3 = (activeIndex3 + 1) % 4;
    } else {
      activeIndex3 = (activeIndex3 + 1) % 3;
      if (activeIndex3 == 0) {
        document.getElementById("main3").scrollIntoView({
          behavior: "smooth",
        });
      }
    }
    console.log(activeIndex3);
    //updateIndicators(activeIndex);
  }
});
//scroll left button
btnLeft4.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider4.scrollBy({
    top: 0,
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex4 = (activeIndex4 - 1) % 3;
  console.log(activeIndex4);
  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight4.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  console.log(`movieWidth = ${movieWidth}`);
  console.log(`scrolling right ${scrollDistance}`);

  // if we're on the last page
  if (activeIndex4 == 3 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main4").scrollIntoView();
    slider4.scrollBy({
      top: 0,
      right: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex4 = 0;
    //updateIndicators(activeIndex);
  } else {
    slider4.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    if (app == 1) {
      activeIndex4 = (activeIndex4 + 1) % 4;
    } else {
      activeIndex4 = (activeIndex4 + 1) % 3;
      if (activeIndex4 == 0) {
        document.getElementById("main4").scrollIntoView({
          behavior: "smooth",
        });
      }
    }
    console.log(activeIndex4);
    //updateIndicators(activeIndex);
  }
});

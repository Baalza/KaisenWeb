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

const slider5 = document.querySelector(".sl5");
const btnLeft5 = document.getElementById("moveLeft5");
const btnRight5 = document.getElementById("moveRight5");

const slider6 = document.querySelector(".sl6");
const btnLeft6 = document.getElementById("moveLeft6");
const btnRight6 = document.getElementById("moveRight6");

const slider7 = document.querySelector(".sl7");
const btnLeft7 = document.getElementById("moveLeft7");
const btnRight7 = document.getElementById("moveRight7");

const slider8 = document.querySelector(".sl8");
const btnLeft8 = document.getElementById("moveLeft8");
const btnRight8 = document.getElementById("moveRight8");

const indicators = document.querySelectorAll(".indicator");
let baseSliderWidth = slider.offsetWidth;
let activeIndex = 0; // the current page on the slider
let activeIndex2 = 0; // the current page on the slider
let activeIndex3 = 0; // the current page on the slider
let activeIndex4 = 0; // the current page on the slider
let activeIndex5 = 0; // the current page on the slider
let activeIndex6 = 0; // the current page on the slider
let activeIndex7 = 0; // the current page on the slider
let activeIndex8 = 0; // the current page on the slider
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

  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  // if we're on the last page
  if (activeIndex == 3 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main1").scrollIntoView();

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
        document.getElementById("main1").scrollIntoView({
          behavior: "smooth",
          block: "nearest",
          inline: "start",
        });
      }
    }

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

  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight2.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

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
          block: "nearest",
        });
      }
    }

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

  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight3.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

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
          block: "nearest",
        });
      }
    }

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

  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight4.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

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
          block: "nearest",
        });
      }
    }

    //updateIndicators(activeIndex);
  }
});

//scroll left button
btnLeft5.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider5.scrollBy({
    top: 0,
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex5 = (activeIndex5 - 1) % 3;

  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight5.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 6; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  // if we're on the last page
  if (activeIndex5 == 3 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main5").scrollIntoView();
    slider5.scrollBy({
      top: 0,
      right: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex5 = 0;
    //updateIndicators(activeIndex);
  } else {
    slider5.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    if (app == 1) {
      activeIndex5 = (activeIndex5 + 1) % 4;
    } else {
      activeIndex5 = (activeIndex5 + 1) % 3;
      if (activeIndex5 == 0) {
        document.getElementById("main5").scrollIntoView({
          behavior: "smooth",
          block: "nearest",
        });
      }
    }

    //updateIndicators(activeIndex);
  }
});
//scroll left button
btnLeft6.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 7.5; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider6.scrollBy({
    top: 0,
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex6 = (activeIndex6 - 1) % 3;

  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight6.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 7.5; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  // if we're on the last page
  if (activeIndex6 == 4 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main6").scrollIntoView();
    slider6.scrollBy({
      top: 0,
      right: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex6 = 0;
    //updateIndicators(activeIndex);
  } else {
    slider6.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    if (app == 1) {
      activeIndex6 = (activeIndex6 + 1) % 5;
    } else {
      activeIndex6 = (activeIndex6 + 1) % 4;
      if (activeIndex6 == 0) {
        document.getElementById("main6").scrollIntoView({
          behavior: "smooth",
          block: "nearest",
        });
      }
    }

    //updateIndicators(activeIndex);
  }
});
//scroll left button
btnLeft7.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 7.5; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider7.scrollBy({
    top: 0,
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex7 = (activeIndex7 - 1) % 3;

  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight7.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 7.5; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  // if we're on the last page
  if (activeIndex7 == 3 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main7").scrollIntoView();
    slider7.scrollBy({
      top: 0,
      right: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex7 = 0;
    //updateIndicators(activeIndex);
  } else {
    slider7.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    if (app == 1) {
      activeIndex7 = (activeIndex7 + 1) % 5;
    } else {
      activeIndex7 = (activeIndex7 + 1) % 4;
      if (activeIndex7 == 0) {
        document.getElementById("main7").scrollIntoView({
          behavior: "smooth",
          block: "nearest",
        });
      }
    }

    //updateIndicators(activeIndex);
  }
});
//scroll left button
btnLeft8.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 7.5; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  slider8.scrollBy({
    top: 0,
    left: -scrollDistance,
    behavior: "smooth",
  });
  activeIndex8 = (activeIndex8 - 1) % 3;

  //updateIndicators(activeIndex);
});

// Scroll Right button
btnRight8.addEventListener("click", (e) => {
  let movieWidth = document
    .querySelector(".movie")
    .getBoundingClientRect().width;
  let scrollDistance = movieWidth * 7.5; // Scroll the length of 6 movies. TODO: make work for mobile because (4 movies/page instead of 6)

  // if we're on the last page
  if (activeIndex8 == 3 && app == 1) {
    // duplicate all the items in the slider (this is how we make 'looping' slider)
    //populateSlider();
    app--;
    console.log("app" + app);
    document.getElementById("main8").scrollIntoView();
    slider8.scrollBy({
      top: 0,
      right: +scrollDistance,
      behavior: "smooth",
    });
    activeIndex8 = 0;
    //updateIndicators(activeIndex);
  } else {
    slider8.scrollBy({
      top: 0,
      left: +scrollDistance,
      behavior: "smooth",
    });
    if (app == 1) {
      activeIndex8 = (activeIndex8 + 1) % 5;
    } else {
      activeIndex8 = (activeIndex8 + 1) % 4;
      if (activeIndex8 == 0) {
        document.getElementById("main8").scrollIntoView({
          behavior: "smooth",
          block: "nearest",
        });
      }
    }

    //updateIndicators(activeIndex);
  }
});

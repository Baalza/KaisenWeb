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

$("a").click(function () {
  var yt = this.className; // "this" is the element clicked
  var title = this.parentNode.classList.toString();
  title = title.substring(11, title.length);
  //alert(title);
  const result = $("#video-yt").attr("src", yt);
  document.getElementById("title").innerHTML = title;
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
  //app = elem.id + "-c";
  //item = document.getElementById(app);
  //item.classList.remove("hidden");
  menu.forEach((li) => {
    li.classList.remove("active");
    if (li.classList.contains(current)) {
      li.classList.add("active");
    }
  });
  /*if (app != "sviluppo-c") {
    var app1 = document.getElementById("sviluppo-c");
    var parent = app1.parentNode;
    app1.classList.add("hidden");
  }
  if (app != "produzione-c") {
    var app1 = document.getElementById("produzione-c");
    app1.classList.add("hidden");
  }
  if (app != "controllo-c") {
    var app1 = document.getElementById("controllo-c");
    app1.classList.add("hidden");
  }*/
}

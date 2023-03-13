const template = document.createElement("template");

template.innerHTML = `
<section id="nav">
<nav class="navbar navbar-expand-lg fixed-top">
  <div class="container-fluid ">
    <a class="navbar-brand" href="#home">
      <img
        class="d-inline-block align-text-top pt-1 img-fluid"
        src="../static/assets/image/logo/logo.png"
        alt=""
        width="80"
        height="60"
      />
    </a>
    <button
      class="navbar-toggler"
      type="button"
      data-bs-toggle="collapse"
      data-bs-target="#navbarNav"
      aria-controls="navbarNav"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"
        ><i class="fa-solid fa-bars"></i>
      </span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul id="navLink" class="navbar-nav">
        <li class="nav-item">
          <a
            class="nav-link matter home active"
            aria-current="page"
            href="#home"
            >
            Home</a
          >
        </li>
        <li class="nav-item">
          <a class="nav-link aboutme matter" href="#aboutme">
            
            About Me</a
          >
        </li>
        <li class="nav-item">
          <a class="nav-link project matter" href="#project">
           
            Project</a
          >
        </li>
        <li class="nav-item">
          <a class="nav-link contact matter" href="#contact"
            
            Contact
          </a>
        </li>
      </ul>
    </div>
  </div>
</nav>
</section>
`;

document.body.appendChild(template.content);

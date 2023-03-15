const footer = document.createElement("template");

footer.innerHTML = /*html*/ `
<footer class="fixed-bottom">
<div class="container-fluid">
  <div class="container">
    <div class="row justify-content-center text-center pe-3">
      <div class="col text-center align-items-center">
        <p class="matter mt-3">Designed & Developed by</p>
        <a
          class="no-dec"
          href="https://baalza.github.io/Balzarotti-Niccolo/"
          target="_blank"
          ><p class="sign mb-4">Balzarotti Niccolò</p></a
        >
      </div>
    </div>
  </div>
</div>
</footer>
`;

document.body.appendChild(footer.content);

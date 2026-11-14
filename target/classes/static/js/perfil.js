const usuario =
    JSON.parse(
        localStorage.getItem(
            "usuario"));

if (!usuario) {

    window.location.href =
        "/login";

}

document.getElementById(
    "tituloBienvenida")
    .innerText =
        "Bienvenido "
        + usuario.nombre;

document.getElementById(
    "nombre")
    .innerText =
        usuario.nombre;

document.getElementById(
    "correo")
    .innerText =
        usuario.correo;

document.getElementById(
    "rol")
    .innerText =
        usuario.rol;

if (usuario.rol !== "ADMIN") {

    document.getElementById(
        "panelAdmin")
        .style.display =
        "none";
}

document.getElementById(
    "btnLogout")
    .addEventListener(
        "click",
        () => {

            localStorage.removeItem(
                "usuario");

            window.location.href =
                "/login";
        });
document
    .getElementById("loginForm")
    .addEventListener(
        "submit",
        async function (event) {

    event.preventDefault();

    const correo =
        document
        .getElementById("correo")
        .value;

    const password =
        document
        .getElementById("password")
        .value;

    const mensaje =
        document
        .getElementById("mensaje");

    try {

        const response =
            await fetch(
                "/usuarios/login",
                {
                    method: "POST",

                    headers: {
                        "Content-Type":
                            "application/json"
                    },

                    body: JSON.stringify({
                        correo,
                        password
                    })
                });

        if (response.ok) {

            const usuario =
                await response.json();

            localStorage.setItem(
                "usuario",
                JSON.stringify(usuario)
            );

            window.location.href =
                "/perfil";

        } else {

            mensaje.innerText =
                "Credenciales inválidas";
        }

    } catch (error) {

        console.error(error);

        mensaje.innerText =
            "Error al conectar con el servidor";
    }
});
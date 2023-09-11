<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Captura datos</title>
    <script src="../jr/capturadatos.js"></script>
</head>
<body>
    <h1>Captura de datos desde el formulario</h1>
    <form action="capturadatos" method="get">
        <label for="">Latitud<input type="text" name="latitud"></label>
        <label for="">Longitud<input type="text" name="longitud" ></label>
        <input type="submit" value="Enviar" name="accion">
    </form>
    
    <form id="miFormulario">
  <!-- Campos ocultos para almacenar la longitud y latitud -->
  <input type="hidden" name="longitud" id="longitud">
  <input type="hidden" name="latitud" id="latitud">
  <!-- Resto del formulario con otros campos -->
  <!-- ... -->
  <button type="button" onclick="obtenerUbicacionYEnviar()">Enviar</button>
</form>

<script>
function obtenerUbicacionYEnviar() {
  // Verificar si el navegador admite geolocalización
  if ("geolocation" in navigator) {
    // Obtener la posición del usuario
    navigator.geolocation.getCurrentPosition(
      function (position) {
        const latitud = position.coords.latitude;
        const longitud = position.coords.longitude;

        // Asignar los valores a los campos ocultos
        document.getElementById("latitud").value = latitud;
        document.getElementById("longitud").value = longitud;

        // Enviar el formulario a tu JSP utilizando Fetch
        enviarFormularioFetch();
      },
      function (error) {
        console.error("Error al obtener la ubicación:", error.message);
      }
    );
  } else {
    console.error("Geolocalización no soportada por el navegador.");
  }
}

function enviarFormularioFetch() {
  // Obtener referencia al formulario
  const formulario = document.getElementById("miFormulario");

  // Obtener los datos del formulario
  const formData = new FormData(formulario);

  // Realizar la solicitud Fetch
  fetch("index.jsp", {
    method: "POST",
    body: formData
  })
  .then(response => {
    if (!response.ok) {
      throw new Error("Error en la solicitud. Código de estado: " + response.status);
    }
    return response.text();
  })
  .then(data => {
    // Procesar la respuesta del servidor si es necesario
    console.log("Respuesta del servidor:", data);
  })
  .catch(error => {
    console.error("Error al enviar la solicitud:", error);
  });
}
</script>
    
    
</body>
</html>
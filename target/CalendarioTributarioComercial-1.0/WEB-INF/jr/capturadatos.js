function obtenerUbicacionYEnviar() {
  // Verificar si el navegador admite geolocalización
  if ("geolocation" in navigator) {
    // Obtener la posición del usuario
    navigator.geolocation.getCurrentPosition(
      function (position) {
        const latitud = position.coords.latitude;
        const longitud = position.coords.longitude;

        // Enviar los datos al servidor utilizando Fetch
        fetch("ruta/de/tu/jsp", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          body: `latitud=${latitud}&longitud=${longitud}`
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
      },
      function (error) {
        console.error("Error al obtener la ubicación:", error.message);
      }
    );
  } else {
    console.error("Geolocalización no soportada por el navegador.");
  }
}

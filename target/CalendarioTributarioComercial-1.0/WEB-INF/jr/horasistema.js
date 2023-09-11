function mostrarHoraActualizada() {
    var fechaHora = new Date();
    var hora = fechaHora.getHours();
    var minutos = fechaHora.getMinutes();
    var segundos = fechaHora.getSeconds();
    // Agregar un cero inicial a los minutos y segundos si son menores a 10
    if (minutos < 10) {
        minutos = "0" + minutos;
    }
    if (segundos < 10) {
        segundos = "0" + segundos;
    }

    var horaActualizada = hora + ":" + minutos + ":" + segundos;
    document.getElementById("hora-actualizada").innerHTML = horaActualizada;
}

// Actualizar la hora cada segundo (1000 milisegundos)
setInterval(mostrarHoraActualizada, 1000);




const btnObtenerGastosPorCategoria = document.getElementById('obtieneGastosPorCategoria');
btnObtenerGastosPorCategoria.addEventListener('click', () => {
    cargarDatosSP();
});


function cargarDatosSP() {
    // Hacer una petición GET a la API
    fetch('http://localhost:8080/api/v1/controlGastos/sumaGastosPorCategoria')
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // Obtener la tabla
            const table = document.getElementById('gastosPorCategoriaTable');

            // Limpiar la tabla antes de agregar nuevos datos
            while (table.rows.length > 1) {
                table.deleteRow(1);
                //alert('Se ha limpiado la tabla')
            }

            // Crear una nueva fila para cada item
            data.forEach(item => {
                const row = table.insertRow();

                // Crear una nueva celda para cada campo del item
                const categoriaCelda = row.insertCell();
                const totalPorCategoriaCelda = row.insertCell();

                // Establecer el texto de cada celda
                categoriaCelda.textContent = item.categoria;

                let montoFormateado = item.totalPorCategoria.toLocaleString('es-Mx', {style: 'currency', currency: 'MXN'});
                totalPorCategoriaCelda.textContent = montoFormateado;


            });
        })
        .catch(error => {
            console.error('Error:', error);
            alert('Ha ocurrido un error: ' + error);
        });

}
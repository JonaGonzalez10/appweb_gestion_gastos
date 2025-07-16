const btnObtenerGraficaGastosXCategoria = document.getElementById('graficaGastosXCategoria');

btnObtenerGraficaGastosXCategoria.addEventListener('click', () => {
    cargarGraficaGastosXCategoria();
});

let graficaGastosXCategoria
function cargarGraficaGastosXCategoria() {
    let categorias = [];
    let montos = [];
    let table = document.getElementById('gastosPorCategoriaTable');
    for (let i = 1; i < table.rows.length; i++) {
        categorias.push(table.rows[i].cells[0].textContent);
        montos.push(table.rows[i].cells[1].textContent);
    }

    if (graficaGastosXCategoria) {
        graficaGastosXCategoria.destroy();
    }


    //Crea la gráfica de barras
    let ctx = document.getElementById('graficaGastosXCategoria').getContext('2d');
    let graficaGastosXCategoria = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: categorias,
            datasets: [{
                label: 'Monto por categoría',
                data: montos,
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1
            }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });
}
//fin del script para la grafica de barras
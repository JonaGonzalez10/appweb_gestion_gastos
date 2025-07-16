const toggle = document.querySelector(".toggle")
const menuDashboard = document.querySelector(".menu-dashboard")
const iconoMenu = toggle.querySelector("i")
const enlacesMenu = document.querySelectorAll(".enlace")
//variables para la paginacion de la tabla de gastos
let currentPage = 0;
const pageSize = 30;
// Obtén la referencia al botón
const btnObtenerGastos = document.getElementById('navbarObtenerGastos');
const btnNextPage = document.getElementById('siguientePagina'); // Asegúrate de tener este botón en tu HTML
const btnPreviousPage = document.getElementById('anteriorPagina'); // Asegúrate de tener este botón en tu HTML

//script para los efectos del menu
toggle.addEventListener("click", () => {
    menuDashboard.classList.toggle("open")

    if(iconoMenu.classList.contains("bx-menu")){
        iconoMenu.classList.replace("bx-menu", "bx-x")
    }else {
        iconoMenu.classList.replace("bx-x", "bx-menu")
    }
})

enlacesMenu.forEach(enlace => {
    enlace.addEventListener("click", () => {
        menuDashboard.classList.add("open")
        iconoMenu.classList.replace("bx-menu", "bx-x")
    })
})
//fin del script para los efectos del menu


//scrip para llenar la tabla de gastos

// Agrega un event listener al botón
btnObtenerGastos.addEventListener('click', () => {
    currentPage = 0; // Reset the page number
    cargarGastos();
});

btnNextPage.addEventListener('click', () => {
    currentPage++; // Incrementa el número de página
    cargarGastos();
});
btnPreviousPage.addEventListener('click', () => {
    currentPage--; // Decrementa el número de página
    cargarGastos();
});

function cargarGastos() {
    // Hacer una petición GET a la API
    fetch(`http://localhost:8080/api/v1/controlGastos/?page=${currentPage}&size=${pageSize}`)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            // Obtener la tabla
            const table = document.getElementById('gastosTable');

            // Limpiar la tabla antes de agregar nuevos datos
            while (table.rows.length > 1) {
                table.deleteRow(1);
            }

            // Crear una nueva fila para cada gasto
            data.content.forEach(gasto => { // Use data.content to access the data
                const row = table.insertRow();

                // Crear una nueva celda para cada campo del gasto
                const fechaCelda = row.insertCell();
                const mesCelda = row.insertCell();
                const categoriaCelda = row.insertCell();
                const subcategoriaCelda = row.insertCell();
                const descripcionCelda = row.insertCell();
                const montoCelda = row.insertCell();

                // Establecer el texto de cada celda
                fechaCelda.textContent = gasto.fecha;
                mesCelda.textContent = gasto.mes;
                categoriaCelda.textContent = gasto.categoria;
                subcategoriaCelda.textContent = gasto.subcategoria;
                descripcionCelda.textContent = gasto.descripcion;
                //formato de moneda para el monto
                let montoFormateado = gasto.monto.toLocaleString('es-Mx', {style: 'currency', currency: 'MXN'});
                montoCelda.textContent = montoFormateado;

            });
        })
        .catch(error => console.error('Error:', error));
}
//fin del script para llenar la tabla de gastos


document.addEventListener("DOMContentLoaded", () => {
    // Selecciona el enlace del menú
    const menuIngresarGastos = document.getElementById("menuIngresarGastos");
    const contenidoDashboard = document.querySelector(".contenido-dashboard");

    // Agrega un evento click al enlace
    menuIngresarGastos.addEventListener("click", () => {
        // Carga el contenido de ingreso_gastos.html
        fetch("ingreso_gastos.html")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Error al cargar la página");
                }
                return response.text();
            })
            .then(html => {
                // Reemplaza el contenido de la sección contenido-dashboard
                contenidoDashboard.innerHTML = html;
            })
            .catch(error => {
                console.error("Error:", error);
            });
    });
});


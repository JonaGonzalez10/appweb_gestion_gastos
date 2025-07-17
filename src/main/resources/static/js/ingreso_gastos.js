document.addEventListener("DOMContentLoaded", () => {
    const fechaInput = document.getElementById("fecha");
    const mesInput = document.getElementById("mes");
    const categoriaSelect = document.getElementById("categoria");
    const subcategoriaSelect = document.getElementById("subcategoria");
    const gastoForm = document.getElementById("gastoForm");

    // Subcategorías por categoría
    const subcategorias = {
        Transporte: ["Casetas", "Gasolina", "Mantenimiento"],
        Alimentación: ["Restaurantes", "Supermercado", "Snacks"],
        Entretenimiento: ["Cine", "Conciertos", "Viajes"]
    };

    // Actualizar el campo de mes basado en la fecha seleccionada
    fechaInput.addEventListener("change", () => {
        const fecha = new Date(fechaInput.value);
        if (!isNaN(fecha)) {
            const meses = [
                "enero", "febrero", "marzo", "abril", "mayo", "junio",
                "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"
            ];
            mesInput.value = meses[fecha.getMonth()];
        } else {
            mesInput.value = "";
        }
    });

    // Actualizar las subcategorías cuando se selecciona una categoría
    categoriaSelect.addEventListener("change", () => {
        const categoria = categoriaSelect.value;
        subcategoriaSelect.innerHTML = '<option value="" disabled selected>Selecciona una subcategoría</option>';
        if (subcategorias[categoria]) {
            subcategorias[categoria].forEach(subcategoria => {
                const option = document.createElement("option");
                option.value = subcategoria;
                option.textContent = subcategoria;
                subcategoriaSelect.appendChild(option);
            });
        }
    });

    // Limpiar el formulario después de enviar
    gastoForm.addEventListener("submit", (e) => {
        e.preventDefault();
        alert("Gasto agregado exitosamente!");
        gastoForm.reset();
        mesInput.value = ""; // Limpiar el campo de mes
    });
});
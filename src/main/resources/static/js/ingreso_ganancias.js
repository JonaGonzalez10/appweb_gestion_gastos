document.addEventListener("DOMContentLoaded", () => {
    const fechaInput = document.getElementById("fecha");
    const mesInput = document.getElementById("mes");
    const categoriaSelect = document.getElementById("categoria");
    const subcategoriaSelect = document.getElementById("subcategoria");
    const gananciaForm = document.getElementById("gananciaForm");

    // Subcategorías por categoría
    const subcategorias = {
        Nomina: ["Bancaria", "Vales de despensa"],
        Inversiones: ["Acciones", "Fondos de inversión"],
        Otros: ["Regalos", "Premios"]
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
    gananciaForm.addEventListener("submit", (e) => {
        e.preventDefault();
        alert("Ganancia agregada exitosamente!");
        gananciaForm.reset();
        mesInput.value = ""; // Limpiar el campo de mes
    });
});
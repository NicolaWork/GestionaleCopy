document.addEventListener('DOMContentLoaded', (event) => {
    const modificaBtn = document.getElementById('modifica-btn');
    if (modificaBtn) {
        modificaBtn.addEventListener('click', () => {
            const formFields = document.querySelectorAll('input, select, textarea');
            formFields.forEach(field => {
                field.disabled = !field.disabled;
            });
            const salvaBtn = document.querySelector('button[type="submit"]');
            if (salvaBtn) {
                salvaBtn.disabled = !salvaBtn.disabled;
            }
        });
    }
});

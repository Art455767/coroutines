function fetchData() {
    fetch('/api/posts')
        .then(response => {
            if (!response.ok) {
                throw new Error('Ошибка сети');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            // Обработка данных
        })
        .catch(error => {
            console.error('Ошибка:', error);
            // Показать кнопку "Повторить"
            document.getElementById('retryButton').style.display = 'block';
        });
}

document.getElementById('retryButton').addEventListener('click', () => {
    document.getElementById('retryButton').style.display = 'none';
    fetchData();
});
const API_URL = 'https://jubilant-space-chainsaw-9r4g46x5jx5hx76j-1488.app.github.dev';

const messageDiv = document.getElementById('message');
const tableBody = document.getElementById('tableBody');

// Завантажити дані при старті
loadEvents();

function showMessage(text, type) {
    messageDiv.textContent = text;
    messageDiv.className = `message ${type} show`;
    setTimeout(() => {
        messageDiv.className = 'message';
    }, 3000);
}

async function loadEvents() {
    try {
        const response = await fetch(`${API_URL}/api/events`, {
            method: 'GET',
            mode: 'cors'
        });

        if (response.ok) {
            const events = await response.json();
            updateTable(events);
        } else {
            const errorText = await response.text();
            showMessage('Помилка завантаження даних: ' + errorText, 'error');
            tableBody.innerHTML =
                '<tr><td colspan="4" class="empty-state">Помилка: ' + errorText + '</td></tr>';
        }
    } catch (error) {
        showMessage('Помилка з\'єднання з сервером', 'error');
        tableBody.innerHTML =
            '<tr><td colspan="4" class="empty-state">Помилка з\'єднання з сервером: ' + error.message + '</td></tr>';
    }
}

function updateTable(events) {
    if (!events || events.length === 0) {
        tableBody.innerHTML =
            '<tr><td colspan="4" class="empty-state">Немає даних</td></tr>';
        return;
    }

    // очікуємо, що кожен елемент має вигляд:
    // { type: "...", measure: { value: ..., limit: ... } }
    tableBody.innerHTML = events.map((event, index) => `
        <tr>
            <td>${index + 1}</td>
            <td>${event.type}</td>
            <td>${event.measure?.value}</td>
            <td>${event.measure?.limit}</td>
        </tr>
    `).join('');
}

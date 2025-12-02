Програма екологічного моніторингу
Це імітаційний прототип об'єктно-орієнтованої програми на Java з архітектурою MVC, використанням бази даних SQLite, вебсервером Javalin та інжекцією залежностей через Google Guice.

Структура проєкту
com.ecomonitoring.Event – клас події
com.ecomonitoring.Measure – клас вимірювання (значення та ліміт)
com.ecomonitoring.Dispatcher – клас для обробки сповіщень
com.ecomonitoring.Operator – клас оператора моніторингу
com.ecomonitoring.Ecologist – клас еколога
com.ecomonitoring.EventService – сервіс для роботи з базою даних SQLite (Model)
com.ecomonitoring.EventController – контролер MVC для взаємодії між Model та View
com.ecomonitoring.EcomonitoringWebView – веб-інтерфейс (View) для REST API
com.ecomonitoring.webserver.* – абстракції веб-сервера (WebServer, JavalinWebServer)
com.ecomonitoring.EcomonitoringModule – конфігураційний модуль для Guice, який впроваджує залежності
com.ecomonitoring.Main – головний клас: консольна імітація + запуск веб-сервера

Компіляція
cd ecomonitoring  
mvn clean install

Запуск
cd ecomonitoring  
mvn exec:java -Dexec.mainClass="com.ecomonitoring.Main"

Спочатку програма виконає імітацію роботи системи моніторингу, збереже подію у базу даних та запустить веб-сервер (порт може відрізнятися залежно від Codespaces).

Для перегляду даних відкрийте:
src/main/resources/public/index.html  
через розширення *Live Server* у VS Code.

Опис роботи
Програма демонструє:

Створення учасників системи (оператор, еколог)
Імітацію моніторингу та перевірки екологічних показників
Створення подій у разі перевищення ліміту
Збереження подій у базу SQLite
Роботу контролера MVC (отримання списку подій)
Веб-інтерфейс для перегляду збережених подій через REST API

База даних
Драйвер: SQLite JDBC (org.xerial:sqlite-jdbc)  
Шлях до бази: target/ecomonitoring.db  
Таблиця events:

type (TEXT) – тип події  
measure_value (REAL) – значення вимірювання  
measure_limit (REAL) – допустимий ліміт
Використання шаблону проєктування Модель-Вигляд-Контролер
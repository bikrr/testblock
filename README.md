# testblock
Приложение TestBlock создано для демонстрации инфраструктуры системы непрерывной интеграции с UI автоматизацией тестирования.

### Описание
TestBlock - Java Spring приложение со следующим основным функционалом:   
* подключение к PostgreSQL (класс JDBCPostgreSQL)
* поиск пользователей на тестовом LDAP сервере (класс ActiveDirectory)
* обращение к серверу с помощью Ajax (script.js ->класс DataController)

### Настройки приложения
application.properties  
server.port = 8172 // порт на котором будет запущено приложение  

### Запуск приложения
java -jar testblock-client-0.0.1-SNAPSHOT.war  

## Руководство пользователя
### Открыть приложение
После запуска приложение необходимо открыть в браузере  
http://localhost:8172/  
8172 - порт, который указан в настройках   
### Подключение к БД
Для подключения к базе данных необходимо нажать кнопку JDBC connect.  
Возможные сообщения:  

Сообщение | Значение
------------ | -------------
PostgreSQL JDBC Driver successfully connected | Успешное подключение к базе данных
Connection Failed | Ошибка подключения (некорректные логин, пароль , название БД) 
Please wait | Ожидайте
PostgreSQL JDBC Driver is not found. Include it in your library path | Не найден JDBC драйвер

### Получить логин и пароль пользователя (корректный для успешного тестирования)
Для получения логина пользователя необходимо нажать кнопку get user  
Поле Login заполнится значением riemann  
Поле Password заполнится значением password  

### Получить логин и пароль пользователя (некорректный для негативного тестирования)

Для получения логина пользователя необходимо нажать кнопку get user 2  
Поле Login заполнится значением gauss: password  
Поле Password заполнится значением gauss: password  

### Получить CN и e-mail пользователя из тестового LDAP ldap://ldap.forumsys.com:389 (корректный для успешного тестирования)
Для получения корректных данных пользователя необходимо:  
* Нажать кнопку get user  
* Нажать кнопку AD search  

Поле CN заполнится значением Bernhard Riemann  
Поле E-mail заполнится значением riemann@ldap.forumsys.com  

### Получить CN и e-mail пользователя из тестового LDAP ldap://ldap.forumsys.com:389 (некорректный для негативного тестирования)
Для получения некорректных данных  необходимо:  
* Нажать кнопку get user 2, либо заполнить поля Login и Password произвольными значениями  
* Нажать кнопку AD search  
Получено сообщение "[LDAP error code 49 - Invalid Credentials]"  
Поле CN не заполнено (есть баг)  
Поле E-mail не заполнено  




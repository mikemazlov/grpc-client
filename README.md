# grpc-client
Приложение SpringBoot, при старте запускает web сервер
Пример URL: http://localhost:8080/send?content=My content
При вызове url отправляет запрос gRPC серверу, передавая сообщение с полем content, уникального идентификатора (rqUID) и времени создания сообщения (rqTm)
В ответ на странице отображается ответ со статусом обратки от gRPC сервера

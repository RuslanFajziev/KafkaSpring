## Сервис ZooKeeper + Kafka + Spring

#### Отправка сообщения.

URL `POST http://localhost:8080/msg?msgId=22`

C телом JSON объекта `{"age" : 22, "name" : "vasia"}`

Ответ от сервера `{"age" : 22, "name" : "vasia"}`
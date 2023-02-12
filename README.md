# hello-world-rabbitmq
A "hello world" RabbitMQ project just to create and connect a simple producer and consumer

docker compose up

will pull rabbitmq image and will create a container.
Just run the app and it will automatically create the exchange
the queue. 

make a POST request  for example 

{
    "name":"chicken tortiya", //String
    "quantity": 4,  //int   
    "price":14  //int
}

Observe the communication to the logs.
that's it.

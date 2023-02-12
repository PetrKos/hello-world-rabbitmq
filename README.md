A "Hello World" RabbitMQ Project
This project is a simple example of how to create and connect a producer and consumer in RabbitMQ.

Running the Project
To run the project, simply execute the following command:

Copy code
docker-compose up
This will pull the RabbitMQ image and create a container. Once the app is running, it will automatically create the exchange and the queue.

Making a POST Request
You can make a POST request to the following JSON payload:

json
Copy code
{
  "name": "chicken tortiya",
  "quantity": 4,
  "price": 14
}

access rabbit mq admin 
http://localhost:15672/#/

urname and password: guest

Observe the communication in the logs to see the results. That's it!

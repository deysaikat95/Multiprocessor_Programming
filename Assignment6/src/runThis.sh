#!/bin/sh

java -cp ".:/usr/share/java/junit4.jar" queue.QueueTest LQueue 4 10
java -cp ".:/usr/share/java/junit4.jar" queue.QueueTest SLQueue 4 10

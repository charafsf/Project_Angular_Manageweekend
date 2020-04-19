#!/bin/bash

sudo docker stop some-mysql
sudo docker system prune 
sudo docker run --name some-mysql -e MYSQL_ROOT_PASSWORD=root -d mysql:8.0.18
sudo docker exec -it some-mysql /bin/bash
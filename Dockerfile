FROM maven:3.6.0

COPY wait-for-mysql.sh .
WORKDIR /app

COPY /mysql_connection /app/
RUN ls
RUN mvn clean install
RUN ls /app

WORKDIR ../app2

COPY /backend-spring /app2/
RUN mvn clean -Dmaven.test.skip=true install

WORKDIR ../

RUN ls

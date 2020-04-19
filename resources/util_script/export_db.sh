#!/bin/bash

heure=$(date +%H%M%S)
jour=$(date +%Y%m%d)
if [ -z "$1" ] 
then
    echo "Veuillez rentrer un nombre pr le nom du backup!!!"
else
    docker exec some-mysql /usr/bin/mysqldump -u root --password=root db_week_end > backup/backup$1.sql
fi

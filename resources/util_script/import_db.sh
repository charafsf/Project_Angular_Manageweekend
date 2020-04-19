#!/bin/bash

if [ -z "$1" ] 
then
    echo "Veuillez rentrer le nom du script à importer!!!"
elif [ ! -f "backup/$1" ]
then
    echo "file doesn't exist in backup folder!!"
else
    cat backup/$1 | docker exec -i some-mysql /usr/bin/mysql -u root --password=root db_week_end
fi
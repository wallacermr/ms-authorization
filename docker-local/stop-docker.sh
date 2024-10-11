#!/bin/sh
set -e

echo;echo "### Parando Imagens Docker... ###";echo
docker-compose -f docker-compose-m1.yml down

echo;echo "### Limpando volumes... ###";echo
docker volume rm docker-local_db-dev

docker volume prune -f
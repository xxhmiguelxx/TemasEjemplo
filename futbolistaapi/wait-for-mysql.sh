#!/bin/sh
# Esperar hasta que MySQL esté disponible
echo "Esperando a que MySQL esté listo..."

while ! nc -z mysql 3306; do
  sleep 1
done

echo "MySQL está listo. Iniciando la app..."
exec java -jar app.jar

FROM amazoncorretto:17-alpine

WORKDIR /app

COPY target/futbolistaapi-0.0.1-SNAPSHOT.jar app.jar
COPY wait-for-mysql.sh wait-for-mysql.sh

RUN chmod +x wait-for-mysql.sh

EXPOSE 8080

ENTRYPOINT ["./wait-for-mysql.sh"]

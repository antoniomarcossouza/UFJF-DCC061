# Utiliza uma imagem base com OpenJDK 17
FROM openjdk:17-jdk-alpine
VOLUME /tmp
# Copia o jar gerado para dentro do container
COPY target/payroll_pro-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

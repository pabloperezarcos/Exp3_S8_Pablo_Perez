# Usar una imagen base oficial de Java, por ejemplo, OpenJDK
FROM openjdk:21-jdk

# Establecer el directorio de trabajo en el contenedor
WORKDIR /app

# Copiar el archivo jar de tu proyecto al directorio de trabajo del contenedor
COPY target/exp3-s8-pablo-perez.jar /app/exp3-s8-pablo-perez.jar

# Exponer el puerto en el que se ejecuta tu aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "/app/exp3-s8-pablo-perez.jar"]

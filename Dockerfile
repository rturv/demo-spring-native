FROM registry.access.redhat.com/ubi8/openjdk-11-runtime
# Encoding
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8

# Variables de entorno
ENV SPRING_PROFILES_ACTIVE default
# Directorio aplicacion y de configuracion
RUN mkdir app && mkdir app/conf

# Fichero de configuracion
COPY src/main/resources/application.properties /app/conf/application.properties
# Ejecutable con la aplicacion
COPY target/*.jar /app/app.jar


# Puerto que expone
EXPOSE 8080
# Comando que se ejecuta una vez ejecutemos el contenedor
# por ahora sin trustore, añadirlo mas adelante.
# ENTRYPOINT [ "sh", "-c", "java -Djavax.net.ssl.trustStore=$TRUSTSTORE_FILE -Djavax.net.ssl.trustStorePassword=$TRUSTSTORE_PASSWORD -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app/app.jar --spring.config.location=/app/conf/application.properties" ]
ENTRYPOINT [ "sh", "-c", "java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar /app/app.jar --spring.config.location=/app/conf/application.properties" ]
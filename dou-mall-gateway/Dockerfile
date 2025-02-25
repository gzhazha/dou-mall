FROM openjdk:17

WORKDIR /dou-mall-gateway

ARG JAR_FILE=target/dou-mall-gateway.jar

COPY ${JAR_FILE} app.jar

EXPOSE 10001

ENV TZ=Asia/Shanghai JAVA_OPTS="-Xms128m -Xmx256m -Djava.security.egd=file:/dev/./urandom"

CMD sleep 30; java $JAVA_OPTS -jar app.jar

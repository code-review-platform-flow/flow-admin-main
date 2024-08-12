# builder image
FROM amazoncorretto:17-al2-jdk AS builder

RUN mkdir /flow-admin-main
WORKDIR /flow-admin-main

COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean bootJar

# runtime image
FROM amazoncorretto:17.0.12-al2

ENV TZ=Asia/Seoul
ENV PROFILE=${PROFILE}

RUN mkdir /flow-admin-main
WORKDIR /flow-admin-main

COPY --from=builder /flow-admin-main/build/libs/flow-admin-main-* /flow-admin-main/app.jar

CMD ["sh", "-c", " \
    java -Dspring.profiles.active=${PROFILE} \
         -jar /flow-admin-main/app.jar"]

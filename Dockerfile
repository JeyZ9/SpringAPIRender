FROM openjdk:17-jdk-slim
FROM maven:3.8.4-openjdk-17-slim

# กำหนด directory ที่เราจะใช้เก็บโค้ดของเรา
WORKDIR /SpringAPI/app

# คัดลอกไฟล์ทั้งหมดไปยัง container
COPY . .

# Build โค้ดของเรา
RUN mvn clean package -DskipTests
# RUN mvn clean package

# ตั้งค่า Environment Variables
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://jey:bGz7APVKbYDIdDUnbsaMeLJR4iuKBfy7@dpg-crhgbkjv2p9s73fkiejg-a.singapore-postgres.render.com/springstoreapi
ENV SPRING_DATASOURCE_USERNAME=jey
ENV SPRING_DATASOURCE_PASSWORD=bGz7APVKbYDIdDUnbsaMeLJR4iuKBfy7

# กำหนด port ที่เราจะใช้
EXPOSE 8080

# คำสั่งรัน Application Spring
ENTRYPOINT ["java","-jar","/SpringAPI/app/target/spring-store-api-0.0.1-SNAPSHOT.jar"]
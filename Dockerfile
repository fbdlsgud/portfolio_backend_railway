# Java 17 환경 설정
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 캐시 설정 (옵션)
COPY gradlew build.gradle settings.gradle ./
COPY gradle gradle
COPY src src

# gradlew 실행 권한 부여
RUN chmod +x gradlew

# ✅ 테스트 생략하고 빌드
RUN ./gradlew build -x test

# 실행
CMD ["java", "-jar", "build/libs/port1-0.0.1-SNAPSHOT.jar"]

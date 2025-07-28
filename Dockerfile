# 🏗️ 1단계: 빌드 단계 (Gradle + Java 21)
FROM gradle:8.14.3-jdk21 AS builder

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 캐시 최적화를 위해 설정 파일 먼저 복사
COPY settings.gradle build.gradle /app/

# 의존성 캐시 프리로드 (성능 개선용)
RUN gradle build -x test || true

# 전체 프로젝트 복사
COPY . /app

# 빌드 실행 (테스트 생략)
RUN gradle build -x test

# 🚀 2단계: 실행 단계
FROM openjdk:21-jdk-slim

# 실행 디렉토리
WORKDIR /app

# 빌드된 JAR 복사
COPY --from=builder /app/build/libs/*.jar app.jar

# 포트 노출 (Spring Boot 기본)
EXPOSE 8080

# 실행 명령어
ENTRYPOINT ["java", "-jar", "app.jar"]

# docker build --no-cache -t practice-app .
# docker run -p 8080:8080 practice-app
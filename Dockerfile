# Open jdk 17이 설치된 Alpine linux 이미지를 기반으로 함
# FROM openjdk:17-jdk-slim
# 빌드 된 jar 파일을 컨테이너 루트 디렉토리에 app.jar 파일로 복사함
# COPY build/libs/*.jar app.jar
# 컨테이너 시작히 app.jar 파일을 실행하는 명령을 설정
# ENTRYPOINT ["java","-jar","app.jar"]

##1. 빌드 스테이지
# gradle을 이미지로 가져와 빌드 스테이지를 build라는 이름으로 설정
FROM gradle:7.6.1-jdk AS build

# 컨테이너 내부 작업 디레ㄱ토리를 /app으로 설정
WORKDIR /app

#현재 디렉토리의 모든 파일과 폴더를 컨테이너의 /app으로 복사
COPY . .

#Gradle을 사용하여 프로젝트 빌드 (데몬 프로세스 사용 안함)
RUN gradle clean build --no-daemon

## 2. 실행 스테이지
FROM openjdk:17-jdk-slim
# 빌드 스테이지에서 생성 된 jar 파일을 복사
COPY --from=build /app/build/libs/*.jar ./
# jar 파일을 나열하고 grep으로 plain 포함되지 않는 줄을 선택
RUN mv $(ls *.jar | grep -v plain) app.jar
ENTRYPOINT ["java","-jar","app.jar"]

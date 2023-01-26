FROM maven:3-openjdk-11 as build

ADD . /yes
WORKDIR /yes

RUN mvn -Dmaven.test.skip=true install spring-boot:repackage -DskipTests

FROM openjdk:11

COPY --from=build  /yes/target/*.jar yes.jar

ENTRYPOINT ["java","-jar","yes.jar"]
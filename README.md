# Microservico

https://start.spring.io/

Project = Maven
Language = Java
Spring Boot = 2.7.11

Project Metadata
Group = com.empresa_xpto "Insira o nome do grupo ou da empresa ao qual o projeto pertence."
Artifact = nome_do_seu_micro_servico "Digite o nome do artefato do seu projeto. Este será o nome do arquivo JAR gerado."
Name = nome_do_seu_projeto "Insira o nome do seu projeto que pode ser o mesmo do artefato"
Description = Projeto para micro serviço client "Digite uma descrição breve do seu projeto."
Package name = com.empresa_xpto.nome_do_seu_micro_servico " Insira o nome do pacote principal do seu projeto. Geralmente, segue o padrão do nome do grupo invertido, seguido pelo nome do artefato. Por exemplo"

Packaging = jar

Versão Java = 11

----- Dependencias para projeto de micro serviço Eureka Server ---------------

Dependencies - Eureka Server - Spring Web - Lombok - Spring Boot DevTools

----- Dependencias para projeto de micro serviço Config Server ---------------

Dependencies - Config Server - Spring Web - Lombok - Spring Boot DevTools

----- Dependencias para projeto de micro serviço API Gateway Server ---------------

Dependencies - Spring Reactive Web - Config Client - Cloud LoadBalancer - Eureka Discovery Client - Gateway - Spring Boot Actuator - OpenFeign - Lombok - Spring Boot DevTools

----- Dependencias para projetos de micros serviços clients ---------------

Dependencies - Eureka Discovery Client - Config Client - Spring Boot Actuator - Spring Web - Lombok - OpenFeign - Spring Data JPA -- Opcional - Spring Boot DevTools

eureka.client.enabled=false

http://localhost:8888/client-service/profile

http://localhost:9999/client-service/profile

http://localhost:9999/actuator

http://localhost:8888/actuator/health

http://localhost:8888/actuator/info

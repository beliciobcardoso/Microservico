# Microservico

https://start.spring.io/

---

####Project: Maven
####Language: Java
####Spring Boot: 2.7.11

---

## Project Metadata

<ul>
    <li>Group: com.empresa_xpto "Insira o nome do grupo ou da empresa ao qual o projeto pertence."</li>
    <li>Artifact: nome_do_seu_micro_servico "Digite o nome do artefato do seu projeto. Este será o nome do arquivo JAR gerado."</li>
    <li>Name: nome_do_seu_projeto "Insira o nome do seu projeto que pode ser o mesmo do artefato"</li>
    <li>Description: Projeto para micro serviço client "Digite uma descrição breve do seu projeto."</li>
    <li>Package name: com.empresa_xpto.nome_do_seu_micro_servico " Insira o nome do pacote principal do seu projeto. Geralmente, segue o padrão do nome do grupo invertido, seguido pelo nome do artefato. Por exemplo"</li>
</ul>

Packaging: jar

Versão Java: 11

<ol>
    <li>Configurção para projeto de micro serviço Eureka Server</li>
        <ol>
            <li>Dependencies</li>
                <ol>
                    <li>Eureka Server</li>
                    <li>Spring Web</li>
                    <li>Lombok</li>
                    <li>Spring Boot DevTools</li>
                </ol>
        </ol>
    <li>Configurção para projeto de micro serviço Config Server</li>
        <ol>
            <li>Dependencies</li>
                <ol>
                    <li>Config Server</li>
                    <li>Spring Web</li>
                    <li>Lombok</li>
                    <li>Spring Boot DevTools</li>
                </ol>
        </ol>
    <li>Configurção para projeto de micro serviço API Gateway Server</li>
        <ol>
            <li>Dependencies</li>
                <ol>
                    <li>Spring Reactive Web</li>
                    <li>Config Client</li>
                    <li>Cloud LoadBalancer</li>
                    <li>Eureka Discovery Client</li>
                    <li>Gateway</li>
                    <li>Spring Boot Actuator</li>
                    <li>OpenFeign</li>
                    <li>Lombok</li>
                    <li>Spring Boot DevTools</li>
                </ol>
        </ol>
    <li>Configurção para projeto de micro serviço clients</li>
        <ol>
            <li>Dependencies</li>
                <ol>
                    <li>Eureka Discovery Client</li>
                    <li>Config Client</li>
                    <li>Spring Boot Actuator</li>
                    <li>Spring Web</li>
                    <li>Lombok</li>
                    <li>OpenFeign</li>
                    <li>Spring Data JPA -- Opcional</li>
                    <li>Spring Boot DevTools</li>
                </ol>
        </ol>
</ol>

http://localhost:8888/client-service/profile

http://localhost:9999/client-service/profile

http://localhost:9999/actuator

http://localhost:8888/actuator/health

http://localhost:8888/actuator/info

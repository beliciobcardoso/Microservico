# Microservico

https://start.spring.io/

## Spring Initializr

Project: Maven,
Language: Java,
Spring Boot: 2.7.11

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
                </ol>
        </ol>
    <li>Configurção para projeto de micro serviço Config Server</li>
        <ol>
            <li>Dependencies</li>
                <ol>
                    <li>Config Server</li>
                    <li>Spring Web</li>
                    <li>Eureka Discovery Client</li>
                    <li>Spring Boot Actuator</li>
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
    <li>Configurção para projeto de micro serviço Sleuth</li>
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

## Criando um conta OAuth2 no google

> Acessar o link: https://console.cloud.google.com/

> Clique em "Selecionar um projeto" e depois em "Novo projeto"

> Insira o nome do projeto e clique em "Criar"

> Acesse o menu "APIs e serviços" e no final da pagina clique em "Service Usage API"

> Clique no botão "Cria credenciais"

> Selecioner "Dados do Usuario" e em proximo. --Dados de um usuário do Google, como o endereço de e-mail ou a idade. É obrigatório ter o consentimento do usuário. Isso criará um cliente OAuth.

> Preencha as informações do seu projeto e clique em "Salvar e continuar". -- Nome do APP (Qualque coisa), E-mail do desenvolvedor.

> Criar um escopo, click em "Adicionar ou remover escopos" na janela que ira abrir encolha a opção "openid" e clique em "Atualizar" e depois em "Salvar e continuar".

> Em Id do cliente OAuth escolha a opção "Aplicativo da Web" e em "URIs de redirecionamento autorizados" insira a URL do seu micro serviço API Gateway Server + "/login/oauth2/code/google" exemplo:http://localhost:8080/login/oauth2/code/google para o teste local e clique em "Criar".

> Em seguida na 5º parte do processor, ira lhe solicitar para fazer o download das suas crendenciais. Click em "Download" e salve o arquivo em um local seguro. sera baixado um arquivo json com as informações do seu projeto.

## Exemplo:

```json
{
  "web": {
    "client_id": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.apps.googleusercontent.com",
    "project_id": "oauth-00000000000000000000000000000000000",
    "auth_uri": "https://accounts.google.com/o/oauth2/auth",
    "token_uri": "https://oauth2.googleapis.com/token",
    "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
    "client_secret": "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx",
    "redirect_uris": ["http://localhost:8080/login/oauth2/code/google"]
  }
}
```

> E não esqueça de clicar em "Concluir" para finalizar.

> Copie o ID do cliente e a Chave secreta e cole no arquivo application.yml do seu micro serviço API Gateway Server.

## Exemplo:

```yml
spring:
  security:
    oauth2:
      resourceserver:
        jwt:
          issuer-uri: https://accounts.google.com
          jwk-set-uri: https://www.googleapis.com/oauth2/v3/certs
      client:
        provider:
          google:
            token-uri: https://oauth2.googleapis.com/token
            issuer-uri: https://accounts.google.com
        registration:
          google:
            client-id: xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.apps.googleusercontent.com
            client-secret: xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
            scope: openid
            redirect-uri: 'http://localhost:8080/login/oauth2/code/google'
```

## Dependencia para OAuth2 Client

> OAuth2 Client

'''xml
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>
'''

## Circuit Breaker

> Dependencia para Circuit Breaker
> '''xml

    	<dependency>
    		<groupId>org.springframework.cloud</groupId>
    		<artifactId>spring-cloud-starter-circuitbreaker-resilience4j</artifactId>
    	</dependency>

'''

## Dependencia para Observabilidade

'''xml
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-sleuth</artifactId>
</dependency>
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-sleuth-zipkin</artifactId>
</dependency>
'''

'''shell
docker run -d -p 9411:9411 openzipkin/zipkin
'''

'''java
@Bean
public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
return new RestTemplateBuilder().build();
}

    @Bean
    public RestTemplateBuilder getRestTemplate() {
    	return new RestTemplateBuilder();
    }

'''

# EAD - API NOTIFICATION HEXAGONAL

## Sobre o projeto
Projeto Decoder EAD - Arquitetura de microservices, tem como maior
objetivo colocar em prática todos os conceitos abordados.

Cada funcionalidade da plataforma é abordada como um serviço independente, promovendo flexibilidade e isolamento de responsabilidades.

### Alguns dos conceitos abordados ao longo do projeto
`Shared Database Pattern`
`Event Driven Pattern`
`Comunicação por Coreografia`
`Authentication e Authorization com JWT`
`Observability`
`SAGA Pattern`
`Cross
Cutting`
`Event Carried State Transfer Pattern`

### Desenho da solução
![Desenho da solucao ead](imagens/projeto.png)

## Sobre a API
`notification` desempenha um papel essencial na comunicação com os usuários da plataforma educacional "EAD", seguindo os princípios da arquitetura hexagonal. Suas características distintivas incluem:

- **Envio de Notificações de Curso:** Automaticamente envia notificações aos usuários quando eles se cadastram em novos cursos.

- **Gestão de Comunicações:** Facilita o gerenciamento eficiente das comunicações com os usuários, garantindo que sejam informados sobre eventos e atualizações relevantes em tempo hábil.

- **Personalização de Mensagens:** Oferece a capacidade de personalizar mensagens de notificação, criando uma experiência mais envolvente e adaptada às necessidades individuais dos usuários.

- **Integração com Outros Microservices:** Coopera com outros microservices, como `course` e `authUser`, para sincronizar informações e fornecer notificações contextuais.

`notification`, ao adotar os conceitos da arquitetura hexagonal, contribui para a construção de uma experiência educacional coesa e altamente adaptável na plataforma EAD.

## Endpoints
`GET ALL NOTIFICATIONS BY User - http://localhost:8080/ead-notification-hexagonal/users/{user_id}/notifications`

`PUT NOTIFICATION Confirm Read - http://localhost:8080/ead-notification-hexagonal/users/{user_id}/notifications/{notification_id}`

## Tecnologias utilizadas
- Java 11
- Spring boot
- Maven
- Eureka Client
- Spring Logging
- Spring Data JPA
- Spring Security
- jjwt
- Spring AMQP
- Spring Actuator
- Spring Postgresql

## Como executar o projeto
- Pré-requisitos: Java 11
- Ter os seguinte projetos em execução:
    - Service Registry
    - Config Server
    - Api Gateway

```bash
# clonar repositório
git clone https://github.com/alinepazz/sistema-ead-microservice-api-notification-hexagonal.git

# entrar na pasta raiz do projeto

# executar o projeto
mvn spring-boot:run
```
### Autor
Aline Soares da Paz

https://www.linkedin.com/in/alinepazz/

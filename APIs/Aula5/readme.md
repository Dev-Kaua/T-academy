📚 Zoológico API REST

📝 Descrição

API REST para gerenciar um zoológico, permitindo CRUD completo em Animais, Habitats, Cuidadores, Veterinários e Alimentações. Possui endpoints de filtragem para consultas específicas e respeita regras de negócio como capacidade de habitats e associação de cuidadores aos animais.


---

👥 Participantes

Kauã Reis Rodrigues

Luis

Pedro

Brena

---

⚙ Tecnologias Utilizadas

Java 21

Spring Boot 3

Spring Data JPA

Hibernate

MySQL

Postman (para testes)

Maven



---

🏛 Entidades

1. Animal

id: Long

nome: String

espécie: String

idade: Integer

habitat: Habitat

cuidador: Cuidador


2. Habitat

id: Long

nome: String

tipo: String (terrestre, aquático, aéreo)

capacidadeMaxima: Integer


3. Cuidador

id: Long

nome: String

especialidade: String

turno: Enum (MANHA, TARDE, NOITE)


4. Veterinário

id: Long

nome: String

CRMV: String

especialidade: String


5. Alimentação

id: Long

tipoComida: String

quantidadeDiaria: Double

animal: Animal



---

🔍 Funcionalidades

CRUD

Criar: POST /entidade

Listar todos: GET /entidade

Atualizar: PUT /entidade/{id}

Deletar: DELETE /entidade/{id}


Filtros

Animal

GET /animais?especie=Leão

GET /animais?idadeMin=5&idadeMax=10

GET /animais?nomeParcial=Leo


Habitat

GET /habitats?tipo=terrestre


Cuidador

GET /cuidadores?especialidade=Répteis

GET /cuidadores?turno=MANHA


Veterinário

GET /veterinarios?especialidade=Felinos


Alimentação

GET /alimentacoes?tipoComida=Frutas

GET /alimentacoes?animalId=3




---

📊 Regras de Negócio

1. Um habitat não pode ultrapassar sua capacidade máxima de animais.


2. Cada animal deve ter pelo menos um cuidador associado.




---

🚀 Exemplos de Testes no Postman

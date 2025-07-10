## FastDoubleClickBackend
Este projeto foi desenvolvido utilizando Spring Boot, proporcionando uma API simples para interação com o front-end do [FastDoubleClickFront](https://github.com/MurilloMorgado/fast-double-click-front).

## Pré-requisitos
Certifique-se de ter o Java 17 ou superior e o Maven instalados em sua máquina para rodar este projeto.

Instalar o Java

Instalar o Maven

## Como Rodar o Projeto
### 1. Clone o Repositório
Clone este repositório para a sua máquina local:

`git clone https://github.com/MurilloMorgado/fast-double-click.git`

### 2. Instale as Dependências
Acesse o diretório do projeto e execute o comando para baixar as dependências:

`mvn clean install`


### 3. Teste a API
Com o servidor em execução, você pode fazer requisições para os seguintes endpoints:

## POST /api/tempos
Este endpoint recebe os dados de tempo e data do cronômetro e os salva em um arquivo .json.

Exemplo de corpo da requisição:

```
{
  "tempo": 00:03, // Tempo em milissegundos
  "data": "2025-07-10" // Data e hora no formato ISO 8601
}
```

GET /api/tempos
Este endpoint retorna todos os tempos salvos no arquivo .json.

```
[
  {
    "tempo": 00:03,
    "data": "2025-07-10"
  },
  {
    "tempo": 00:07,
    "data": "2025-07-10"
  }
]
```

## Estrutura do Projeto
O back-end é composto por:

Controller CronometroController: Responsável pelos endpoints para salvar e listar os tempos.

Serviço CronometroService: Lógica de negócios para salvar os tempos no arquivo .json e recuperá-los.

Arquivo de dados: Os tempos são armazenados em um arquivo .json localizado no diretório src/main/resources/data.

## Considerações Técnicas
O banco de dados H2 está configurado, mas não foi utilizado, pois o foco do desafio foi em salvar os dados diretamente em um arquivo .json.

O formato de armazenamento é simples e adequado para fins de demonstração ou desenvolvimento local.

# api_consulta_credito

## A Api consulta informações de crédito consiste em entregar informações aliquota , calculos , datas e etc ...

## O projeto foi construído utilizando as tecnologias e bibliotecas citadas abaixo . 

* Java 11 
* Spring Boot 3.x
* Spring Data
* Jackson
* Lombok
* ModelMapper
* Docker 
* Postgresql


## Instruções para o Deploy da Aplicação : 

#### Será necessário dar o start no arquivo docker-compose.yml para baixar as imagens do postgresql , segue abaixo um exemplo do script : 
* docker compose --up 

#### Na aplicação é incluso um arquivo chamado data.sql , onde contém instruções via query para a inclusao de dados na tabela .

#### Após a configuração , é necessário dar o start pela ide ou por linha de comando para subir o contexto do spring e a aplicação estará no ar.


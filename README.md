# Mini-Projeto I – Servidor Web

## Descrição
Implemente um servidor de páginas web estáticas, utilizando sockets TCP/IP. O servidor conterá, em apenas uma pasta pública, arquivos do tipo mime text/html e text/plain. Este servidor deverá retornar o contéudo dos arquivos procurados por aplicações clientes, que as requisitarem. Para isso, um protocolo de mensagem deverá ser implementado. Se o arquivo existir no servidor, este deverá enviar uma mensagem de status 200 e, em seguida, transferir o contéudo do arquivo para o cliente. Caso contrário, o servidor retornará o status 400, o qual define que o arquivo não foi encontrado no servidor. 
O servidor deverá funcionar de forma a atender as requisições de multiusuários, simultaneamente. 
## A Aplicação Cliente 
Desenvolva uma aplicação cliente, para o servidor descrito acima, que permita, através de um terminal shell, realizar a busca de um arquivo através de uma URI, obedecendo a seguinte sintaxe: 
```
[host]:[port]/[file_name]
```
### Onde:
host : host do servidor

port : porta a qual o servidor web encontra-se em execução

file_name : nome do arquivo procurado

Exemplo de uma requisição possível: 
```
192.168.1.212:6500/index.html
```
### Na aplicação clinte deverão ser tratadas questões como:

* Extrair da URI as informações para conexão com o servidor;
* Infomar uma mensagem ao usuário, caso não consiga conexão com o servidor;
* Se o servidor retornou o status 200, exibir o contéudo do arquivo buscado no próprio terminal. Caso contrário, o status seja 400, informe ao usuário uma mensagem de arquivo não encontrado no servidor.

### Observações:
* Equipes com no máximo DOIS integrantes;
* Entrega e Defesa: 08/05/2018
# ADN_Api


Requisistos:

Java 8
Srping boot
IDE (Sts)
Maven
PostgreSql
Postman


Instalacion:

Clonar repositorio git clone https://github.com/Janel-Molina/ADN_Api.git
instalar PostgreSql, crear base de datos ADN
Instalar IDE(Sts)
Instalar Maven
Instalar Postman (prueba de servicios)
Importar proyecto como proyecto maven en IDE (puerto 8080)


Peticion /clon/  valida si el adn es amigo o u clon atraves de peticion http post que recibice una json con cadenas de caracteres.
“adn”:["WSYEWW","EWWYYY","EYWSSY","WSYWEY","WESSYY","YEEEES"]
http://localhost:8080/clon/ 

Peticion /estadisticas valida las estadisticas de los registros almacenados de adn atraves de peticion http get
http://localhost:8080/estadisticas
{“contador_clon_adn”:40,“contador_amigos_adn”:100,“promedio”:0.4}

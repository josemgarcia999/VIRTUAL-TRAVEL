# VISUAL-TRAVEL
## Formacion Back-End. Ejercicio Final
![Imagen](https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/bosonit.png)


Visual-Travel es un ejercicio en el que aplicaremos los conceptos aprendidos durante
la formacion de Java para realizar una aplicacion que simule una agencia de viajes de autobus.

- Descripcion
- Tecnologias utilizadas
- Funcionamiento


## Descripcion
Una agencia de autobuses que se encuentra en Vitoria realiza viajes para los siguientes destinos:
- Valencia
- Madrid
- Barcelona
- Bilbao

Las posibles hora de salida de los autobuses son:
- 8
- 12
- 16
- 20


Existiran principalmente dos tipos de back: BackEmpresa y BackWeb

- Backweb: Será el servidor que recibirá las peticiones del front donde se realizan las reservas. En nuestro caso, usaremos PostMan para realizar las peticiones.
- BackEmpresa: Será el servidor de la aplicación instalada en la empresa. Se comunicará con BackWeb pero tamboén podrá recibir reservas externas. Será el encargado de realizar la confirmacion de la reserva mediante el envío de un correo electronico.


Cada BackWeb tendrá su propia BBDD independiente. Lo mismo ocurrirá con BackEmpresa.

## Tecnologías utilizadas

<img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/springboot.png" width="150"> Implementar toda la lógica de la aplicación.


<img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/kafka.png" width="150"> Realizar comunicación asíncrona entre los diferentes Backs de la aplicación.


<img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/eureka.png" width="150"> Balanceador de carga para distribuir las peticiones entre los diferentes BackWebs


<img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/docker.png" width="150"> Exportar la aplicación y gestionar todos los servicios de cara al exterior.






## Funcionamiento
En primer lugar, para iniciar la aplicación lo que haremos será descargar el proyecto y ejecutar el archivo docker-compose.yml para generar los contenedores correspondientes y arrancar la aplicación.
Para ello, en la ruta de la raiz del proyecto, pondremos el siguiente comando: 
```sh
docker-compose up -d
```

Para realizar pruebas he adjuntado una colección de postman con los endpoints para interactuar con la aplicación. Bastará con importarla en postman y lanzar la aplicación y comenzar a trabajar con ella.

## Análisis de código
En esta sección voy a especificar la distribución del código y dar una breve explicación sobre cada módulo.
Inicialmente distinguimos cuatro paquetes:
- BackEmpresa: Se corresponde con el back asociado a la empresa de viajes. Tendrá su propia base de datos independiente y se encargará de realizar la confirmación de una reserva, tanto como si es aceptada como si no. Además tendrá un tópico asociado para actualizar las bases de datos de los backwebs que estén conectados, con reservas añadidas a backempresa que tengan una fecha superior a la fecha actual.
- BackWeb: Cada backweb será una instancia de este paquete. Se encargará principalmente de realizar reservas y de comunicarlas a los demás backwebs y a backempresa mediante otro tópico para sincronizar las bases de datos de todos. Cada backweb tendrá su propia base de datos independiente.
- BusBalancer: Balanceador de carga para distribuir las diferentes webs.
- EurekaBus: Configuración del servidor de eureka para gestionar la realización del balanceo de carga.


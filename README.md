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






## Manual de usuario
En primer lugar, para iniciar la aplicación lo que haremos será descargar el proyecto y ejecutar el archivo docker-compose.yml para generar los contenedores correspondientes y arrancar la aplicación.(requiere tener docker instalado)
Para ello, en la ruta de la raiz del proyecto, pondremos el siguiente comando: 
```sh
docker-compose up -d
```
Tras ejecutar este comando, en la app de docker nos encontraremos esto:
<img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/contenedores.png"> 
Como se puede observar, se crean los contenedores para las base de datos de cada back, kafka para la mensajería asíncrona, eureka para el balanceo de carga junto al gateway y las instancias de los diferentes back, tanto webs como empresa.

Después de instalar correctamente la aplicación en docker, podemos empezar a realizar pruebas de la misma. Para ello, he adjuntado una colección de postman con los endpoints implementados, que voy a explicar a continuación.

<img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/postman.png">

Como podemos observar, principalmente dividimos la colección en dos grandes grupos. BackWeb y BackEmpresa. En primer lugar voy a explicar lo relacionado con BackWeb.
<img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/principalWeb.png">
Para todos los backwebs son los mismos endpoints pero en mi caso, voy a explicarlos para "Reserva Web 8083" puesto que es el que se corresponde con el balanceador de carga y este se encargará de alternar entre las dos webs que tenemos en la aplicación
- **RealizarReserva:** La url es:*www.localhost:8083/api/web/reservas*. Se encargará de realizar una reserva, requerirá una ReservaInputDto por un body cuyo formato es el siguiente: <img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/reservainputdto.png">. Hay que tener en cuenta las restricciones de hora y de ciudades disponibles ya que si no, no se hará correctamente la reserva.
- **consultarReservaDisponible:** La url es: *www.localhost:8083/api/web/reservasDisponibles*. Con este endpoint lo que haremos será listar aquellas reservas que han sido aceptadas.
- **obtenerCapacidadViaje:** La url es: *www.localhost:8083/api/web/reservasDisponibles/capacidad*. Se encarga de obtener el número de plazas disponibles de un autobús concreto.
- **obtenerTodasReservas:** La url es: *www.localhost:8083/api/web/*. Devuelve todas las reservas, ya sean aceptadas o canceladas porque el autobús esté lleno.
- **borrarReserva(*):** La url es: *www.localhost:8083/api/web/reservas/{id}* Borra la reserva correspondiente al id pasado por la parte variable del path.
- **borrarAutobus(*)** La url es: *www.localhost:8083/api/web/reservasDisponibles/{id}* Borra el autobús correspondiente a ese id.

**NOTA:** Aunque estén implementados, yo nos los he utilizado puesto que la funcionalidad que he implementado consiste en que cuando borre una reserva desde backempresa, se borren en los backwebs en caso de que se encuentre en su base de datos. Están hechos para comprobar que la implementación estaba correcta.

## Análisis de código
En esta sección voy a especificar la distribución del código y dar una breve explicación sobre cada módulo.
Inicialmente distinguimos cuatro paquetes:
- BackEmpresa: Se corresponde con el back asociado a la empresa de viajes. Tendrá su propia base de datos independiente y se encargará de realizar la confirmación de una reserva, tanto como si es aceptada como si no. Además tendrá un tópico asociado para actualizar las bases de datos de los backwebs que estén conectados, con reservas añadidas a backempresa que tengan una fecha superior a la fecha actual. 
<img src="https://github.com/josemgarcia999/VIRTUAL-TRAVEL/blob/main/media/contenidobackempresa.png" align="center" width="300">
BackEmpresa está compuesto por cuatro entidades: 


- BackWeb: Cada backweb será una instancia de este paquete. Se encargará principalmente de realizar reservas y de comunicarlas a los demás backwebs y a backempresa mediante otro tópico para sincronizar las bases de datos de todos. Cada backweb tendrá su propia base de datos independiente.
- BusBalancer: Balanceador de carga para distribuir las diferentes webs.
- EurekaBus: Configuración del servidor de eureka para gestionar la realización del balanceo de carga.


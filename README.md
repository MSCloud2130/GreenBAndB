# GreenBnB

- [Instalación](#heading)
  * [MongoDB](#sub-heading-mongodb)
  * [Eureka Server](#sub-heading-eureka)
  * [Products](#sub-heading-billing)
  * [Users](#sub-heading-users)
  * [Billing](#sub-heading-billing)
- [Cliente Postman](#heading-1)
  * [Servidores](#sub-heading-1)
    + [Operaciones](#sub-sub-heading-1)
  * [Cliente pruebas](#sub-heading-2)

  <a name="heading">Instalación</a>
  Instalación de los servidores/servicios junto con el servidor Eureka para el balanceo de carga.
   - [ ]  Clonar el repositorio

      ```bash
      git clone git@github.com:MSCloud2130/GreenBAndB.git
      ```
      
  <a name="sub-heading-mongodb"></a>
  ### MongoDB
  Instalar MongoDB usando Docker de la siguiente manera. 
```bash
docker run -it -p 8081:8081 --rm --name mongotest mongo:latest

```
**Recuerde actualizar sus application.properties en todos los proyectos en ./{project_base_src}/main/resources/application.properties**

<a name="sub-heading-eureka"></a>
### Eureka Server
  - [ ]  Moverse a la carpeta ***eurekaserver***

      ```bash
      cd eurekaserver
      ```

  - [ ]  Compilar aplicacion y ejecutar Eureka Server

      ```bash
      mvn clean install
	  mvn spring-boot:run
      ```

  - [ ]  Probar el servidor con el navegador o postman

      La ruta base es GET -  [http://localhost:8080/greenbnb/](http://localhost:8080/greenbnb para obtener todos los paseos

      Otras rutas son:

      - DELETE - [http://localhost:8080/myapp/travel/](http://localhost:8080/myapp/travel/){idPaseo}: para eliminar un paseo
      - PUT - [http://localhost:8080/myapp/travel/](http://localhost:8080/myapp/travel/){idPaseo}?paseoOrigin={nuevoOrigen}&paseoDest={nuevoDestino}
      - POST -  [http://localhost:8080/myapp/travel/](http://localhost:8080/myapp/travel/) crear un paseo con el body:

          ```bash
          {
            "name":"nombre del paseo (String)",
            "origin":"origen del paseo (String)",
            "destination":"destino del paseo (String)",
            "date":"fecha del paseo (String formato yyyy-mm-dd",
            "id":"identificador del paseo (int)"
          }
          ```

      Todos los datos serán peristidos en una base MongoDB

 <a name="sub-heading-soap"></a>
  ### Correr Servicio SOAP
  - [ ]  Moverse a la carpeta ***./products/SoapServiceProducts***

    ```bash
    cd ./products/SoapServiceProducts 
    ```
  - [ ]  Correr los goals de mvn y ejecutar el servicio

    ```bash
    mvn clean install
	mvn spring-boot:run
    ```

 <a name="sub-heading-products"></a>
  ### Correr Wrapper Servicio SOAP
  - [ ]  Moverse al directorio ***./products/SoapServiceProducts***

    ```bash
    cd ./products/RestWrapperProducts 
    ```
  - [ ]  Ejecutar los goals de mvn y ejecutar el servicio

    ```bash
    mvn clean install
	mvn spring-boot:run
    ```

<a name="sub-heading-users"></a>
### Ejecutar Servicio de Usuarios
  - [ ]  Moverse al directorio ***./users***

    ```bash
    cd ./users 
    ```
  - [ ]  Ejecutar los goals de mvn y ejecutar el servicio

    ```bash
    mvn clean install
	mvn spring-boot:run
    ```
  
 <a name="sub-heading-billing"></a>
### Ejecutar Servicio de Facturación
  - [ ]  Moverse al directorio ***./billing***

    ```bash
    cd ./billing 
    ```
  - [ ]  Ejecutar los goals de mvn y ejecutar el servicio

    ```bash
    mvn clean install
	mvn spring-boot:run
    ```
  
  <a name="heading-1">Cliente Postman</a>
  ## Cliente Postman
  Instalar Postman desde [https://www.postman.com/](https://www.postman.com/) y ejecutarlo en la misma máquina en la que se está ejecutando.
#### Creación de Cliente
- Ruta para crear un cliente 
```bash
 
POST  http://localhost:8185/clients
 
```
Estructura JSON esperada como body en la petición: 

```bash
 {
 "username": "string",
 "firstName": "string",
 "lastName": "string",
 "email": "string",
 "password": "string",
 "age": 0,
 "photo": "string" 
 }
```
	
#### Creación de Proveedor 
 - Ruta para crear un proveedor
 ```bash
 
 POST  http://localhost:8185/suppliers 
```
Estructura JSON esperada como body en la petición: 
```bash
 {
 "username": "string",
 "firstName": "string",
 "lastName": "string",
 "email": "string",
 "password": "string",
 "age": 0,
 "photo": "string" 
 }
```
#### Autenticación de Clientes y Proveedores 
 - Ruta para crear una sesión para cliente 
```bash
POST localhost:8185/sessions?username={username}&password={password}
```

 - Ruta para crear una sesion para proveedor 
```bash
POST localhost:8185/sessions?username={supplieruser}&password={password}
```  
  #### Obtener Clientes y Proveedores 
 - Ruta para obtener clientes 
```bash
 GET localhost:8185/clients
```  
 - Ruta para obtener proveedores
 ```bash
GET localhost:8185/suppliers
```  
 #### Consultar Galeria de Servicios
 - Ruta para obtener todos los servicios
 ```bash
GET localhost:8181/service
```  
 - Ruta para obtener un servicio por su Id
 ```bash
GET localhost:8181/{serviceId}
```  
 - Ruta para obtener todos los servicios de un proveedor mediante su id
 ```bash
GET localhost:8181/service/suppliers/{supplierId}
```  
 - Ruta para obtener un servicio por su nombre
 ```bash
GET localhost:8181/service/name/{serviceName}
```  

 

# GreenBnB

- [Instalación](#heading)
  * [MongoDB](#sub-heading-mongodb)
  * [Eureka Server](#sub-heading-eureka)
  * [Products](#sub-heading-products)
  * [Users](#sub-heading-users)
  * [Billing](#sub-heading-billing)
- [Ejecución](#heading-1)
  * [Servidores](#sub-heading-1)
    + [Operaciones](#sub-sub-heading-1)
  * [Cliente pruebas](#sub-heading-2)

  <a name="heading"></a>
  Instalación de los servidores/servicios junto con el servidor Eureka para el balanceo de carga.
   - [ ]  Clonar el repositorio

      ```bash
      git clone git@github.com:MSCloud2130/GreenBAndB.git
      ```
      
  <a name="sub-heading-mongodb"></a>
  ### Eureka Server
  
  <a name="sub-heading-eureka"></a>
  ### Eureka Server
  - [ ]  Moverse a la carpeta ***eurekaserver***

      ```bash
      cd eurekaserver
      ```

  - [ ]  Correr el servidor

      ```bash
      mvn clean install
      ```

  - [ ]  Probar el servidor con el navegador o postman

      La ruta base es GET -  [http://localhost:8080/myapp/travel/](http://localhost:8080/myapp/travel/) para obtener todos los paseos

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

 <a name="sub-heading-products"></a>
  ### Cliente Java
  - [ ]  Moverse a la carpeta ***products/SoapServiceProducts***

    ```bash
    cd products/SoapServiceProducts 
    ```
  - [ ]  Moverse a la carpeta ***products/SoapServiceProducts***
  - [ ]  Correr el cliente

    ```bash
    mvn clean install exec:java
    ```
  - [ ]  Seguir los pasos del menú
  
  <a name="sub-heading-client-mobile"></a>
  ### Cliente Móvil
  Instalar las dependencias globales

  #### NodeJS:

  - Para MacOS:
    - Instalar [https://brew.sh](https://brew.sh/)
    - `brew install node@14`
  - Para windows -- Seguir las instrucciones en [https://nodejs.dev](https://nodejs.dev/)
  - Para Linux
    - Arch: yay -S nodejs-lts-fermium
    - Ubuntu: sudo apt install nodejs

  #### Expo-cli

  Luego de instalar node

  - `sudo npm install -g expo-cli`
  - [ ]  Moverse a la carpeta ***client-rn***

    ```bash
    cd Punto1/client-rn/ 
    ```

  - [ ]  Instalar las dependencias del proyecto

    ```bash
    npm install
    ```

  - [ ]  Correr el proyecto

    ```bash
    expo start --no-dev --minify
    ```

  - [ ]  Abrir el simulador de iOS
  - [ ]  En el proceso de expo tocar la tecla ***i***

  #### Si se desea correr en dispositivos android

  Instalar **Ngrok**

  - Seguir las instrucciones en [https://ngrok.com/download](https://ngrok.com/download)
  - Alternativamente `sudo npm install -g ngrok`
  - [ ]  Moverse a la carpeta ***server***

    ```bash
    cd Punto1/server/
    ```

  - [ ]  Crear el tunel

    ```bash
    ngrok http 8080
    ```

    - Genera un link del tipo [http://99fb-190-27-49-167.ngrok.io](http://99fb-190-27-49-167.ngrok.io/)
  - [ ]  Abrir el proyecto **client-rn**
  - [ ]  Abrir el archivo **/src/api/jersery.js**
  - [ ]  Reemplazar la línea: `baseURL: 'http://localhost:8080/myapp/travel'` por: `baseURL: '{tunel creado por ngrok}'`
  - [ ]  Correr el proyecto

    ```bash
    expo start --no-dev --minify
    ```

  - [ ]  Abrir el simulador de Android
  - [ ]  En el proceso de expo tocar la tecla ***a***


  <a name="heading-1"></a>
  ## Parte 2 - Spring Cloud

  <a name="sub-heading-1"></a>
  ### Servidor Eureka
  - [ ]  Clonar el repositorio
      ```bash
      git clone https://github.com/dcortesantonio/Taller-2-Microservicios-y-Cloud.git
      ```
  - [ ]  Moverse a la carpeta ***eurekaserver*** en la carpeta  ***Punto2***
      ```bash
      cd /Punto2/eurekaserver
      ```
  - [ ]  Correr el servidor
      ```bash
      mvn clean install
      mvn spring-boot:run
      ```
      <a name="sub-sub-heading-1"></a>
      #### Calculadora y Operaciones  
      Se deben correr cada una de las proyectos de las operaciones, y el proyecto calculadora.

      - [ ]  Correr dos instancias del proyecto sumador, en el puerto 9001 y 9002:
          ```bash
          cd /Punto2/sumador
          mvn clean install
          SERVER_PORT=9001 mvn spring-boot:run &
          SERVER_PORT=9002 mvn spring-boot:run &
          ```

      - [ ]  Correr dos instancias del proyecto sumador, en el puerto 9003 y 9004:
          ```bash
          cd /Punto2/restador
          mvn clean install
          SERVER_PORT=9003 mvn spring-boot:run &
          SERVER_PORT=9004 mvn spring-boot:run &
          ```
      - [ ]  Correr dos instancias del proyecto restador, en el puerto 9003 y 9004:
          ```bash
          cd /Punto2/restador
          mvn clean install
          SERVER_PORT=9003 mvn spring-boot:run &
          SERVER_PORT=9004 mvn spring-boot:run &
          ```
      - [ ]  Correr dos instancias del proyecto multiplicador, en el puerto 9005 y 9006:
          ```bash
          cd /Punto2/multiplicador
          mvn clean install
          SERVER_PORT=9005 mvn spring-boot:run &
          SERVER_PORT=9006 mvn spring-boot:run &
          ```          
      - [ ]  Correr dos instancias del proyecto divisor, en el puerto 9007 y 9008:
          ```bash
          cd /Punto2/divisor
          mvn clean install
          SERVER_PORT=9007 mvn spring-boot:run &
          SERVER_PORT=9008 mvn spring-boot:run &
          ```        
      - [ ]  Correr el proyecto calculator:
          ```bash
          cd /Punto2/calculator
          mvn clean install
          mvn spring-boot:run &
          ```                   

<a name="sub-heading-2"></a>
  #### Postman  
  Probar el servidor con el navegador o postman:

  - Ruta realizar una suma:  - http://localhost:8888/calculadora/suma?a=(varA)&b=(varB)&user=(varUser)/

  - Ruta realizar una resta:  - http://localhost:8888/calculadora/resta?a=(varA)&b=(varB)&user=(varUser)/

  - Ruta realizar una multiplicación:  - http://localhost:8888/calculadora/multip?a=(varA)&b=(varB)&user=(varUser)/

  - Ruta realizar una división:  - http://localhost:8888/calculadora/div?a=(varA)&b=(varB)&user=(varUser)/
    - (varA) : Se refiere al primer número al cual se le realizará la operación.
    - (varB) : Se refiere al segundo número al cual se le realizará la operación.
    - (varUser) : Se refiere a una cadena de texto la cual representa un usuario.

  - Ruta para consultar el historial de utilización de cada operación:  - http://localhost:8888/calculadora/invocations/

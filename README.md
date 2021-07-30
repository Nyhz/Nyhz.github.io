# Addicted!

Proyecto Web **Java EE** contra una BDD **SQLITE** con un CMS para gestionar a los diferentes usuarios.

## Tecnología
- Maven 4.0.0
- Java 8
- Java Servlet Api 3.1.0
- JSP 2.2
- JSTL 1.2
- Bootstrap 5.0.0
- FontAwesome 5.15.3

Para ver mas detalles sobre las depencias (jars) de este proyecto mirar el [pom.xml](https://github.com/Nyhz/Nyhz.github.io/blob/master/pom.xml)

## Instalación del proyecto

Abrir eclipse y usar la opción de **Import > Existing Maven Project**
Seleccionar la carpeta donde se ha bajado el proyecto para que encuentre el fichero **pom.xml**
Esperar unos segundos a que configure el proyecto

## Configuración de la BDD

La base de datos es el fichero **webfinal.db**

Para realizar la conexión a la BDD debemos cambiar el siguiente fichero **src/main/java/com/elorrieta/proyectofinal/connectionhelper**
Solo debemos cambiar la siguiente variable con la ruta de la BDD. 

`
private static final String DIRECCION_BBDD = "jdbc:sqlite:C:\\nueva\\ruta\\webfinal.db";
`

## Ejecutar Proyecto

Al ser un proyecto web necesitamos un servidor de aplicaciones, en nuestro caso recomendamos **Apache Tomcat 8.5**.

Podemos navegar por la pantalla inicial y disponer de todos los datos. Si queremos entrar al perfil o al panel de control necesitaremos estar logeados.
Tenemos dos roles diferentes de usuario.
- Administrador -> user: admin / password: admin
![panel_control]( panelcontrol.JPG?raw=true)
- Usuario normal -> user: user01 / password: user01
![perfil]( perfil.JPG?raw=true)

## Estructura Clases del proyecto

Interesante consultar la documentacion **JavaDoc API** disponible para el usuario administrador en la barra de navegación.

Model Vista Controlador

- **vista** puedes encontrar las JSPs, css, imagenes, js en `src/main/webapp`
- **modelo** Los DAOs se encargan de conectar Java con la bbdd son los encargados de las consultas SQL `src/main/java/com/elorrieta/proyectofinal/modelo`
- **controlador** Controladores o Servlets `src/main/java/com/elorrieta/proyectofinal/controladores`

![estructura proyecto]( estructura.JPG?raw=true)

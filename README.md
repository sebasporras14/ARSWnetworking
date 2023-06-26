# INTRODUCTION TO JAVA, MVN, AND GIT: LOC Counting

Este proyecto busca solucionar el ejercicio dado de escribir un servidor web que soporte multiples solicitudes seguidas(no concurrentes). El servidor web debera retornar los archivos solicitados incluyendo paginas html, imagenes y archivos .js

## Diseño

### Diagrama de clases 

![class diagram](https://github.com/sebasporras14/ARSWloc/blob/master/images/clases.png)


## Corriendo el proyecto

Una vez clonado el proyecto y generado el jar con los siguientes comandos:

~~~
git clone https://github.com/sebasporras14/ARSWnetworking.git
~~~
~~~
mvn package
~~~

se puede ejecutar con:

~~~
java -cp "./target/classes" edu.escuelaing.arsw.app.networking.HttpServer
~~~
una vez aparezca "Listo para recibir", en su navegador ingrese:

~~~
Http://LocalHost:35000/"el archivo html, imagen o js"
~~~

### prueba HTML

~~~
Http://LocalHost:35000/index.html"
~~~

Se obtiene:

![prueba HTML](https://github.com/sebasporras14/ARSWloc/blob/master/images/clases.png)

### prueba JPG o PNG

~~~
Http://LocalHost:35000/img.jpg
~~~
ó
~~~
Http://LocalHost:35000/img2.png
~~~

Se obtiene:

![Prueba imagen](https://github.com/sebasporras14/ARSWloc/blob/master/images/clases.png)

### prueba .JS

~~~
Http://LocalHost:35000/prueba.js"
~~~

Se obtiene:

![Prueba javaScript](https://github.com/sebasporras14/ARSWloc/blob/master/images/clases.png)


## Construido con 
* [Maven](https://maven.apache.org/) - Dependency Management
* [java](https://rometools.github.io/rome/) - Used to generate RSS Feeds


## Autor

* **Sebastian Porras**

### Fecha

06/25/2023 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

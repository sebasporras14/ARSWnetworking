# Web Server

Este proyecto busca solucionar el ejercicio dado de escribir un servidor web que soporte múltiples solicitudes seguidas(no concurrentes). El servidor web deberá retornar los archivos solicitados, incluyendo páginas HTML, imágenes y archivos .js.

## Diseño

### Diagrama de clases 

![class diagram](https://github.com/sebasporras14/ARSWnetworking/blob/master/imagenes/clases.png)


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

![prueba HTML](https://github.com/sebasporras14/ARSWnetworking/blob/master/imagenes/pruebahtml.jpg)

### prueba JPG o PNG

~~~
Http://LocalHost:35000/img.jpg
~~~
ó
~~~
Http://LocalHost:35000/img2.png
~~~

Se obtiene:

![Prueba imagen](https://github.com/sebasporras14/ARSWnetworking/blob/master/imagenes/pruebaimg.jpg)
![Prueba imagen](https://github.com/sebasporras14/ARSWnetworking/blob/master/imagenes/pruebaimg2.png)

### prueba .JS

~~~
Http://LocalHost:35000/prueba.js"
~~~

Se obtiene:

![Prueba javaScript](![Prueba imagen](https://github.com/sebasporras14/ARSWnetworking/blob/master/imagenes/pruebajs.jpg))


## Construido con 
* [Maven](https://maven.apache.org/) - Dependency Management
* [java](https://rometools.github.io/rome/) - Used to generate RSS Feeds


## Autor

* **Sebastian Porras**

### Fecha

06/25/2023 

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

package edu.escuelaing.arsw.app.networking;

import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.*;

public class HttpServer {
    
    /** 
     * metodo principal que determina el puerto por el que se hara la conexion y mientras haya una solicitud invocara al metodo createReponse.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String inputLine;
            boolean firstReadLine = true;
            String request = "";
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received: " + inputLine);
                if (firstReadLine == true) {
                    request = inputLine;
                    firstReadLine = false;
                }
                if (!in.ready()) {
                    break;
                }
            }
            createResponse(request, out, clientSocket.getOutputStream());
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    
    /** 
     * este metodo selecciona lo requerido de la solicitud para obtener la direccion completa del archivo el cual se necesita retornar en el browser. Este hara las acciones indicadas con 
     * los flujos de bytes de acuerdo al tipo de archivo que se solicite. 
     * @param request String compuesto por la request generada al realizar la solicitud en el buscador
     * @param out es un PrintWriter que te permite escribir datos en el flujo de salida del socket del cliente
     * @param outv2 flujo de salida de bytes
     * @throws IOException
     */
    public static void createResponse(String request, PrintWriter out, OutputStream outv2) throws IOException {
        System.out.println("request to interpret: " + request);
        if (request.equals("")) {
            return;
        }
        String[] tokenizedRquest = request.split(" ");
        String path = tokenizedRquest[1];

        Path file = Paths.get("./src/main/java/edu/escuelaing/arsw/app/www" + path);
        if (path.contains(".jpg") || path.contains(".png")) {
            try {
                Path imagePath = Paths.get("./src/main/java/edu/escuelaing/arsw/app/www" + path);
                byte[] imageBytes = Files.readAllBytes(imagePath);
                String defaultHeader = "HTTP/1.1 200 OK\r\n"
                        + "content-Type: image/jpg\r\n"
                        + "content-Length: " + imageBytes.length + "\r\n"
                        + "\r\n";
                outv2.write(defaultHeader.getBytes());
                outv2.write(imageBytes);
            } catch (IOException e) {
                System.out.println(e);
            }
        }else if (path.contains(".js")) {
            try {
                Path jsFile = Paths.get("./src/main/java/edu/escuelaing/arsw/app/www" + path);
                String Content = new String(Files.readAllBytes(jsFile), Charset.forName("UTF-8"));

                String defaultHeader = "HTTP/1.1 200 OK\r\n" + "content-Type: application/javascript\r\n" + "\r\n";
                out.println(defaultHeader);
                out.println(Content);
            } catch (IOException e) {
                System.out.println(e);
            }
        }else if (path.contains(".html")) {
            Charset charset = Charset.forName("UTF-8");
            String defaultHeader = "HTTP/1.1 200 OK\r\n"
                    + "content-Type: text/html\r\n"
                    + "\r\n";
            out.println(defaultHeader);
            try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    out.println(line);
                }
            } catch (IOException x) {
                System.out.println(x);
            }
        }

    }

}

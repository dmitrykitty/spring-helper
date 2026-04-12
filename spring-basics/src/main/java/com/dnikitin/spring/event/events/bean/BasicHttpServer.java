package com.dnikitin.spring.event.events.bean;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;

@Component
public class BasicHttpServer {

    private final Restaurant restaurant;
    public BasicHttpServer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @PostConstruct
    public void startServer() {
        start();
    }

    private void start(){
        try{
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
            server.createContext("/order", processOrderHandler());
            server.start();

            System.out.println("Server is running on port 8080");

        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    private HttpHandler processOrderHandler(){
        return exchange -> {
            if("POST".equals(exchange.getRequestMethod())){
                InputStream requestBody = exchange.getRequestBody();
                byte[] requestBodyBytes = requestBody.readAllBytes();
                String order =  new String(requestBodyBytes);
                String substring = order.substring(3, order.length() - 2);

                System.out.println("Received Order from Request: " + substring);

                restaurant.placeOrder(substring);

                String response = "Order received";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream os = exchange.getResponseBody();
                os.write(response.getBytes());
                os.close();
            } else {
                exchange.sendResponseHeaders(405, -1);
            }
        };
    }


}

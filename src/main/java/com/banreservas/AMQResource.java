package com.banreservas;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/amq")
public class AMQResource {

    @Inject
    AMQMessagingApplication application;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

    @POST
    @Path("/cola")
    public void enviarMensaje(String mensaje){
        System.out.println("Se envia mensaje "+mensaje);
        application.enviarMensaje(mensaje);
    }

    @POST
    @Path("/topico")
    public void enviarMensajeTopico(String mensaje){
        System.out.println("Se envia mensaje a topico "+mensaje);
        application.enviarMensajeTopico(mensaje);
    }
}

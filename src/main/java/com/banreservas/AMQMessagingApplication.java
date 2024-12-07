package com.banreservas;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AMQMessagingApplication {

    
    Emitter<String> emitter;

    
    Emitter<String> emitterTopic;

    
    public void enviarMensaje(String message) {
        emitter.send(message);
    }

    /**
     * Consume the uppercase channel (in-memory) and print the messages.
     **/
   
    public void leerMensaje(String word) {
        System.out.println(">> " + word);
    }

   
    public void leerMensajeTopico(String mensaje) {
        System.out.println("Mensaje desde topico >> " + mensaje);
    }

    public void enviarMensajeTopico(String mensaje){
        emitterTopic.send(mensaje);
    }
}

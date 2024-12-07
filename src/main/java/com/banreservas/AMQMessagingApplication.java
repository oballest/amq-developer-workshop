package com.banreservas;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AMQMessagingApplication {

    @Inject
    @Channel("user12-cola-out")
    Emitter<String> emitter;

    @Inject
    @Channel("user12-topico-out")
    Emitter<String> emitterTopic;

    
    public void enviarMensaje(String message) {
        emitter.send(message);
    }

    /**
     * Consume the uppercase channel (in-memory) and print the messages.
     **/
    @Incoming("user12-cola")
    public void leerMensaje(String word) {
        System.out.println(">> " + word);
    }

    @Incoming("user12-topico")
    public void leerMensajeTopico(String mensaje) {
        System.out.println("Mensaje desde topico >> " + mensaje);
    }

    public void enviarMensajeTopico(String mensaje){
        emitterTopic.send(mensaje);
    }
}

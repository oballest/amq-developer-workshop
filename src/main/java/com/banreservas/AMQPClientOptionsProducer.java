package com.banreservas;

import io.smallrye.common.annotation.Identifier;
import io.vertx.amqp.AmqpClientOptions;
import io.vertx.core.net.PemTrustOptions;
import jakarta.enterprise.inject.Produces;

public class AMQPClientOptionsProducer {
    @Produces
    @Identifier("amq-tls-config")
    public AmqpClientOptions getNamedOptions() {
        
        PemTrustOptions trust = new PemTrustOptions().addCertPath("/home/user/tls/broker.pem");
        AmqpClientOptions options = new AmqpClientOptions().setPemTrustOptions(trust);
        
        return options;
    } 
}

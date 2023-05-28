package com.example.apigateway;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Calendar;
import java.util.logging.Logger;

@Component
public class Weatherfilter extends AbstractGatewayFilterFactory<Weatherfilter.Config> {

   private static Logger log = Logger.getLogger(LogFilter.class.getName());

    public Weatherfilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            //Filtro prévio à invocação do serviço real associado ao gateway
            log.info("Path requested: " + exchange.getRequest().getPath());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                //Filtro posterior à invocação do serviço real associado ao gateway
                log.info("Time response: " + Calendar.getInstance().getTime());
            }));
        };
    }

    public static class Config {
        // Put the configuration properties
    }
}

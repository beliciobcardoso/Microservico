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
            log.info("Chain filter weather: " + chain.filter(exchange).toString());
            log.info("Headers weather: " + exchange.getRequest().getHeaders());
            log.info("Token weather: " + exchange.getRequest().getHeaders().getFirst("Authorization"));
            log.info("Get ID weather: " + exchange.getRequest().getId());
            log.info("Get Cookies weather: " + exchange.getRequest().getCookies());
            log.info("Get URI  weather: " + exchange.getRequest().getURI());
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                //Filtro posterior à invocação do serviço real associado ao gateway
                log.info("Time response weather: " + Calendar.getInstance().getTime());
            }));
        };
    }

    public static class Config {
        // Put the configuration properties
    }
}

package com.mrflorez.gatewaycloud.config;

import com.mrflorez.gatewaycloud.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

@Component
public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

    @Autowired
    private RouteValidator routeValidator;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if(routeValidator.isSecured.test(exchange.getRequest())){
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw new RuntimeException("Mission authorization header");
                }

                String auth = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(!Objects.isNull(auth) &&  auth.startsWith("Bearer ")){
                    auth = auth.substring(7);
                }
                try{
                    //REST CALL TO AUTH SERVICE
                    jwtUtil.validateToken(auth);
                    exchange
                            .getRequest()
                            .mutate()
                            .header("x-username", jwtUtil.extractUsername(auth))
                            .build();
                    //restTemplate.getForObject(String.format("http://USER-SERVICE/auth/validate?token=%s", auth), String.class);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    throw new RuntimeException("un authorize");
                }
            }
            return chain.filter(exchange);
        });
    }


    public static class Config{


    }
}

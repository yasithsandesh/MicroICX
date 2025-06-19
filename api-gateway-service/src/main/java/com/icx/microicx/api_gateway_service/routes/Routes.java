package com.icx.microicx.api_gateway_service.routes;


import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

    //Material Service
    @Bean
    public RouterFunction<ServerResponse> materialServiceRoute() {
        return GatewayRouterFunctions.route("material_service")
                .route(RequestPredicates.path("api/v1/material/**"), HandlerFunctions.http("http://localhost:4040"))
                .build();
    }

    //Stock Service
    @Bean
    public RouterFunction<ServerResponse> stockServiceRoute() {
        return  GatewayRouterFunctions.route("stock_service")
                .route(RequestPredicates.path("api/v1/stock/**"), HandlerFunctions.http("http://localhost:4080"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> stockServiceWearehouseRoute() {
        return  GatewayRouterFunctions.route("stock_service")
                .route(RequestPredicates.path("api/v1/warehouse/**"), HandlerFunctions.http("http://localhost:4080"))
                .build();
    }

    //Admin Service
    @Bean
    public RouterFunction<ServerResponse> adminServiceRoute() {
        return GatewayRouterFunctions.route("admin_service")
                .route(
                        RequestPredicates.path("api/v1/admin/**"),
                        //HandlerFunctions.http("http://localhost:4060")
                        req -> HandlerFunctions.forward("http://localhost:4060").handle(req)
                ).build();
    }

}

package org.example;


public class ServiceRouteConfiguration {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", r -> r.host("**.baeldung.com")
                        .and()
                        .path("/baeldung")
                        .uri("http://baeldung.com"))
                .route(r -> r.host("**.baeldung.com")
                        .and()
                        .path("/myOtherRouting")
                        .filters(f -> f.prefixPath("/myPrefix"))
                        .uri("http://othersite.com")
                        .id("myOtherID"))
                .build();
    }
}

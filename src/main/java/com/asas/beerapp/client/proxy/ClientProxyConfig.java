package com.asas.beerapp.client.proxy;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** Documentation for RestEasy Client API:
 * https://docs.jboss.org/resteasy/docs/3.0-beta-3/userguide/html/RESTEasy_Client_Framework.html **/

@Configuration
public class ClientProxyConfig {

//    @Value("${resteasy.reviews.api.url}")
//    private String reviewsEndpointUrl;
//
//    @Bean
//    public BeerReviewResource getBeerReviewResource() {
//        // Network communication between the client and server is handled by HttpClient from the Apache HttpComponents.
//        // by default SingleClientConnManager, which manages a single socket = serially invocations on a single thread
//        ResteasyClient client = (ResteasyClient) ResteasyClientBuilder.newClient();
//        // WebTarget represents a distinct URL from which you can invoke requests on.
//        ResteasyWebTarget target = client.target(beersEndpointUrl);
//        // UserResourceV1 is an Interface defining the http requests (based on JAX-RS annotations) to invoke on a remote RESTful web services.
//        // (BeerResourceSpringMVC is the remote RESTful web service, is based on mvc @RequestMapping annotations.)
//        BeerReviewResource proxy = target.proxy(BeerReviewResource.class);
//        return proxy;
//    }

    @Value("${resteasy.beers.api.url}")
    private String beersEndpointUrl;

    @Bean
    public BeerResource getBeerResource() {
        // Network communication between the client and server is handled by HttpClient from the Apache HttpComponents.
        // by default SingleClientConnManager, which manages a single socket = serially invocations on a single thread
        ResteasyClient client = (ResteasyClient) ResteasyClientBuilder.newClient();
        // WebTarget represents a distinct URL from which you can invoke requests on.
        ResteasyWebTarget target = client.target(beersEndpointUrl);
        // BeerResource is an Interface defining the http requests (based on JAX-RS annotations) to invoke on a remote RESTful web services.
        // (BeerResourceSpringMVC is the remote RESTful web service, is based on mvc @RequestMapping annotations.)
        BeerResource proxy = target.proxy(BeerResource.class);
        return proxy;
    }
}

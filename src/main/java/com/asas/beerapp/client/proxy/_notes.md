

Documentation for RestEasy Client API:
* https://docs.jboss.org/resteasy/docs/3.0-beta-3/userguide/html/RESTEasy_Client_Framework.html

The Resteasy Proxy Framework:
* Is the mirror of the API we want to consume.
* Instead of using JAX-RS annotations to map an incoming request to your RESTful Web Service method,
    the client framework builds an HTTP request that it uses to invoke on a remote RESTful Web Service.
* This remote service does not have to be a JAX-RS service and can be any web resource that accepts HTTP requests.
    ( e.g. BeerResourceSpringMVC is using @RequestMapping from mvc annotations instead of JAX-RS API)

Writing interfaces:
* Resteasy has a client proxy framework that allows you to use JAX-RS annotations to invoke on a remote HTTP resource.
  The way it works is that you write a Java interface and use JAX-RS annotations on methods and the interface.
* The invoked method gets translated to an HTTP request based on how you annotated the method and posted to the server.    
* return the response body = the object that was serializes in response.
  e.g. com.asas.beerapp.resource.BeerResourceSpringMVC.fetchBeer returns ResponseEntity<?> where ? = Beer,
  so com.asas.beerapp.client.proxy.BeerResource.fetchBeer must return Beer
* if not interested only in response body:
    - return javax.ws.rs.core.Response.Status (enumeration)
    - return javax.ws.rs.core.Response (everything)
    
Usage:
* Used for Integration Tests.
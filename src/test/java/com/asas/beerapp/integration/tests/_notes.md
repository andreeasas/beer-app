

Integration Test:
* simulates Client -> Resource -> Service -> Dao -> DB
* test that the endpoints work properly together
* @SpringBootTest sets the environment.

HTTP requests invocation:
* HTTP requests are invoked based on the Resteasy Client API
 (with Target url {@link ClientProxyConfig}  and Interface with requests to invoke {one interface per resource})
package hibernate.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("sampleService")
public class SampleService {

public SampleService() {

}

@GET
@Path("getService")
@Produces("application/txt")
public String getService() {
String message = "Hello ! This is a message from REST service";
return message;
}

}
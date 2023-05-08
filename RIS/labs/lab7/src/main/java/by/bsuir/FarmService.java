package by.bsuir;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.File;
import java.net.URL;
//результат работы программы - XML_Screen.png
@Path("/farm")
public class FarmService {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public Response getHospitals() {
        ClassLoader classLoader = FarmService.class.getClassLoader();
        URL resource = classLoader.getResource("Farm.xml");
        assert resource != null;
        File file = new File(resource.getFile());
        Response.ResponseBuilder response = Response.ok(file);
        return response.build();
    }
}

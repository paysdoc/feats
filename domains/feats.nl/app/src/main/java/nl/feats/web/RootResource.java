package nl.feats.web;

import com.sun.jersey.api.json.JSONWithPadding;
import nl.feats.domain.Dummy;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Root Resource: returns links to usable resources
 * User: martin
 * Date: 2/22/13
 * Time: 1:43 PM
 */
@Component
@Path("/")
public class RootResource {

    @GET
    @Produces("application/json")
    public JSONWithPadding getLinks(@QueryParam("callback") String callback) {
        return new JSONWithPadding(new Dummy(), callback);
    }
}

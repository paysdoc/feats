package nl.feats.web;

import com.sun.jersey.api.json.JSONWithPadding;
import nl.feats.domain.Play;
import nl.feats.domain.TheatreCompany;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * Resource to view add and change information about the play
 * User: martin
 * Date: 2/22/13
 * Time: 1:40 PM
 */
@Path("/performances")
public class PlayPerformanceResource {

    @GET
    @Path("/")
    @Produces("application/json")
    public JSONWithPadding getPerformance(@QueryParam("callback") String callback) {
        return new JSONWithPadding(getPerformances(), callback);
    }

    private TheatreCompany[] getPerformances() {
        return new TheatreCompany[] {getNamingBru(), getPanto4Feats()};
    }

    private TheatreCompany getNamingBru() {
        Play play = new Play();
        play.setName("Naming of the bru");
        play.setAuthor("Willem Skuddiespeer");
        play.setCopyright(true);
        play.setCopyrightFullPerformance(false);
        play.setDuration(46);
        play.setOriginalScript(false);
        play.setPublisher("Publiseermymaar");

        TheatreCompany company = new TheatreCompany();
        company.setName("The Imbeciles");
        company.setMaleCast(2);
        company.setFemaleCast(1);
        company.setJuvenileCast(true);
        company.setWrittenAdjudication(true);
        company.setPlay(play);
        return company;
    }

    private TheatreCompany getPanto4Feats() {
        Play play = new Play();
        play.setName("a FEATS panto");
        play.setAuthor("Vera Fawny");
        play.setCopyright(false);
        play.setDuration(39);
        play.setOriginalScript(true);
        play.setQualifiesAsBOS(true);

        TheatreCompany company = new TheatreCompany();
        company.setName("Funnybone");
        company.setMaleCast(23);
        company.setFemaleCast(14);
        company.setJuvenileCast(false);
        company.setWrittenAdjudication(true);
        company.setPlay(play);
        return company;
    }
}

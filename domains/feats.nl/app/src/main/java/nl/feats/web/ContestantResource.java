package nl.feats.web;

import com.sun.jersey.api.json.JSONWithPadding;
import nl.feats.domain.Contestant;
import nl.feats.domain.ContestantRepository;
import nl.feats.domain.Play;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Resource to view add and change information about the play
 * User: martin
 * Date: 2/22/13
 * Time: 1:40 PM
 */
@Component
@Path("/contestants")
public class ContestantResource {

    private final ContestantRepository repo;

    @Inject
    public ContestantResource(ContestantRepository repository) {
        this.repo = repository;
    }

    @PUT
    @Consumes("application/json")
    public void addContestant(Contestant contestant) {
        repo.save(contestant);
    }

    @POST
    @Consumes("application/json")
    public void updateContestant(Contestant contestant) {
        repo.save(contestant);
    }

    @DELETE
    @Consumes("application/json")
    public void deleteContestant(Contestant contestant) {
        repo.delete(contestant);
    }

    @GET
    @Produces("application/json")
    public JSONWithPadding getContestants(@QueryParam("callback") String callback) {
        return new JSONWithPadding(repo.findAll(), callback);

    }

    private Contestant[] getContestants() {
        return new Contestant[] {getNamingBru(), getPanto4Feats()};
    }

    private Contestant getNamingBru() {
        Play play = new Play();
        play.setName("Naming of the bru");
        play.setAuthor("Willem Skuddiespeer");
        play.setCopyright(true);
        play.setCopyrightFullPerformance(false);
        play.setDuration(46);
        play.setOriginalScript(false);
        play.setPublisher("Publiseermymaar");

        Contestant company = new Contestant();
        company.setName("The Imbeciles");
        company.setMaleCast(2);
        company.setFemaleCast(1);
        company.setJuvenileCastMale(true);
        company.setWrittenAdjudication(true);
        company.setPlay(play);
        return company;
    }

    private Contestant getPanto4Feats() {
        Play play = new Play();
        play.setName("a FEATS panto");
        play.setAuthor("Vera Fawny");
        play.setCopyright(false);
        play.setDuration(39);
        play.setOriginalScript(true);
        play.setQualifiesAsBOS(true);

        Contestant company = new Contestant();
        company.setName("Funnybone");
        company.setMaleCast(23);
        company.setFemaleCast(14);
        company.setJuvenileCastMale(false);
        company.setWrittenAdjudication(true);
        company.setPlay(play);
        return company;
    }
}

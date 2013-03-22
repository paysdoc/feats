package nl.feats.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * Domain object for a theatre company
 * User: martin
 * Date: 2/22/13
 * Time: 11:25 PM
 */
@Data
@Document
public class Contestant {

    /**
     * the id
     */
    @Id
    private String id;

    /**
     * name of the company
     */
    @NotNull(message = "Please fill in the nema of the theatre company")
    private String name;

    /**
     * the play to be performed
     */
    private Play play;

    /**
     * number of male cast members
     */
    private int maleCast;

    /**
     * number of female cast members
     */
    private int femaleCast;

    /**
     * are there any cast members under the age of 18?
     */
    private boolean juvenileCastMale;

    /**
     * are there any cast members under the age of 18?
     */
    private boolean juvenileCastFemale;

    /**
     * Would the company like to get a written adjudication?
     */
    private boolean writtenAdjudication;

}

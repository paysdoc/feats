package nl.feats.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

/**
 * Domain object for a theatre company
 * User: martin
 * Date: 2/22/13
 * Time: 11:25 PM
 */
@Data public class Contestant {
    /**
     * name of the company
     */
    @NotNull
    private String name;

    /**
     * the play to be performed
     */
    @NotNull
    @DBRef
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
    private boolean juvenileCast;

    /**
     * Would the company like to get a written adjudication?
     */
    private boolean writtenAdjudication;

}

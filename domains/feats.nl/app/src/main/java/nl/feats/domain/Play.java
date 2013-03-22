package nl.feats.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Domain object for a play
 * User: martin
 * Date: 2/22/13
 * Time: 11:17 PM
 */
@Data
public class Play {

    /**
     * The name of the play
     */
    @NotNull(message = "Please state the name of the play")
    private String name;

    /**
     * the author
     */
    @NotNull(message = "Please fill in the name of the author")
    private String author;

    /**
     * Does the play have copyright restrictions?
     */
    @NotNull(message = "Please state whether the play has copyright")
    private Boolean copyright;

    /**
     * If the play has copyright restrictions, will the whole play be performed?
     */
    private Boolean copyrightFullPerformance;

    /**
     * the publisher og the play
     */
    private String publisher;

    /**
     * Is this play an original script?
     */
    @NotNull(message = "Please state whether the play is an original script")
    private Boolean originalScript;

    /**
     * If this play is an original script, will it qualify as "Best Original Script" candidate?
     */
    private Boolean qualifiesAsBOS;

    /**
     * duration of the play (in minutes)
     */
    @NotNull(message = "Please fill in the duration of the play")
    private Integer duration;

    /**
     * Synopsis of the play
     */
    @Min(100)
    @Max(150)
    private String synopsis;

    /**
     * Can the company provide copies of the play
     */
    private Boolean provideCopies;

}

package nl.feats.domain;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Domain object for a play
 * User: martin
 * Date: 2/22/13
 * Time: 11:17 PM
 */
@Data public class Play {

    /**
     * The name of the play
     */
    @NotNull
    private String name;

    /**
     * the author
     */
    @NotNull
    private String author;

    /**
     * Does the play have copyright restrictions?
     */
    @NotNull
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
    @NotNull
    private Boolean originalScript;

    /**
     * If this play is an original script, will it qualify as "Best Original Script" candidate?
     */
    private Boolean qualifiesAsBOS;

    /**
     * duration of the play (in minutes)
     */
    @NotNull
    private Integer duration;

}

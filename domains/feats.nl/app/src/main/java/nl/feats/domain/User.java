package nl.feats.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

import javax.validation.constraints.NotNull;

/**
 * User object
 * User: martin
 * Date: 3/2/13
 * Time: 7:50 PM
 */
@Data
public class User {
    /**
     * name of the user
     */
    @NotNull
    private String name;

    /**
     * user's first name  (optional because user can be an organisation)
     */
    private String firstNames;

    /**
     * user's email address
     */
    @NotNull
    private String emailAddress;

    /**
     * user's password
     */
    @NotNull
    private String password;

    /**
     * User's group
     */
    private String group;

    /**
     * The theatre company that the user belongs to
     */
    @DBRef
    private Contestant company;

}

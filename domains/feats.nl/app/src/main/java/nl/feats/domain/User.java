package nl.feats.domain;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;

/**
 * User object
 * User: martin
 * Date: 3/2/13
 * Time: 7:50 PM
 */
@Data
@Document
public class User {

    /**
     * The id
     */
    @Id
    private ObjectId _id;

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
     * User's role
     */
    @NotNull
    private String role;

}

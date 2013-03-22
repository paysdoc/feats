package nl.feats.domain;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Stage management information
 * User: martin
 * Date: 3/10/13
 * Time: 9:17 PM
 */
@Data
@Document
public class StageManagement {

    @Data
    public static class PhoneNumbers {

        @Pattern(regexp = "^[\\+\\s\\d]*$")
        private String daytime;

        @Pattern(regexp = "^[\\+\\s\\d]*$")
        private String evening;

        @Pattern(regexp = "^[\\+\\s\\d]*$")
        private String mobile;
    }

    /**
     * The id
     */
    @Id
    private String Id;

    /**
     * The contestant who provided this stage management information
     */
    @DBRef
    private Contestant contestant;

    /**
     * name of stage manager
     */
    @NotNull(message = "Please fill in the stage manager's name")
    private String SMName;

    /**
     * email address of stage manager
     */
    @Email
    @NotNull(message = "Please fill in the stage manager's email address")
    private String SMEmail;

    /**
     * Stage manager's phone number(s)
     */
    @NotNull(message = "Please fill in at least one phone number for the stage manager")
    private PhoneNumbers phoneNumbers;

    /**
     * Does the play have any scene changes
     */
    private Boolean sceneChanges;

    /**
     * image location of scene sketches
     */
    private String[] imageRefPerScene;

    /**
     * Does the play require open front of house curtains
     */
    private Boolean OpenFOHCurtains;

    /**
     * Does the play require a rear black curtain
     */
    private Boolean rearBlackCurtain;

    /**
     * Does the play require a cyclorama
     */
    private Boolean cyclorama;

    /**
     * Does the play require any objects that need to fly
     */
    private Boolean fly;

    /**
     * weight of flyable object (iff applicable)
     */
    private Integer flyObjectWeight;

    /**
     * size of flyable object (if applicable)
     */
    private Integer flyObjectSize;

    /**
     * Does the play require any special equipment
     */
    private Boolean specialEquipment;

    /**
     * Does the play need a specialist to handle special equipment (if applicable)
     */
    private Boolean specialEquipmentSpecialist;

    /**
     * Does the play require a theatres rostra
     */
    private Boolean rostra;

    /**
     * rostra height (if applicable)
     */
    private Integer rostraHeight;

    /**
     * rostra area (if applicable
     */
    private Integer rostraArea;

}

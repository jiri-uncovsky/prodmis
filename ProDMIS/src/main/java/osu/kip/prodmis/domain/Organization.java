package osu.kip.prodmis.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.util.Calendar;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Organization {

    /**
     */
    private String name;

    /**
     */
    private String address_street;

    /**
     */
    private String address_city;

    /**
     */
    private String address_country;

    /**
     */
    private String address_postcode;

    /**
     */
    private String description;

    /**
     */
    private Boolean active;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar create_time;
}

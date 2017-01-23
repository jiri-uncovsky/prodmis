package osu.kip.prodmis.domain;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Organization {

    /**
     */
	@Column(name = "name")
	private String name;

    /**
     */
	@Column(name = "address_street")
    private String addressStreet;

    /**
     */
	@Column(name = "address_city")
    private String addressCity;

    /**
     */
	@Column(name = "address_country")
    private String addressCountry;

    /**
     */
	@Column(name = "address_postcode")
    private String addressPostcode;

    /**
     */
	@Column(name = "description")
    private String description;

    /**
     */
	@Column(name = "active")
    private Boolean active;

    /**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
	@Column(name = "create_time")
    private Calendar createTime;
    
    
    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Set<Product> products = new HashSet<Product>();
    
    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organization")
    private Set<UserLogin> userLogins = new HashSet<UserLogin>();
    
    
    
}

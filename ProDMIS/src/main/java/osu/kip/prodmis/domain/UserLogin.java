package osu.kip.prodmis.domain;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity
public class UserLogin {

    /**
     */
	@Column(name = "username")
    private String username;
	
    /**
     */
	@Column(name = "password")
    private String password;

	
	/**
	 */
	@Column(name ="firstname")
	private String name;
	
	
	/**
	 */
	@Column(name ="surname")
	private String surname;
	
	/**
	 */
	@Column(name ="email")
	private String email;
	
	
	/**
	 */
	@Column(name ="admin")
	private Boolean admin;
	
	/**
     */
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(style = "M-")
    private Calendar create_time;
	
	
	
    /**
	 */
    @ManyToOne
	@JoinColumn(name ="organization")
	private Organization organization;
	
}

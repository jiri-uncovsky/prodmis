package osu.kip.prodmis.domain;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Product {

    /**
     */
	@Column(name = "code")
    private String code;
	
	
	/**
     */
	@Column(name = "name")
    private String name;
	
	
	/**
     */
	@Column(name = "description")
    private String description;
		
	
	/**
     */
	@Column(name = "archived")
    private Boolean archived;
	

	/**
     */
	@Column(name = "organization")
	@ManyToOne	
    private Organization organization;

	
	/**
     */
	@Column(name = "product_manager")
	@ManyToOne
    private UserLogin productManager;

		
}

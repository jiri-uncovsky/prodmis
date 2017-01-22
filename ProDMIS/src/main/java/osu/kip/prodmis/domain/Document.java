package osu.kip.prodmis.domain;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity
public class Document {
	
	/**
     */
	@Column(name = "name")
    private String name;
	

	
	/**
     */
	@Column(name = "type")
    private String type;
	
	/**
     */
	@Column(name = "description")
    private String description;
	
	
	/**
     */
	@Column(name = "product")
	@ManyToOne	
    private Product product;
		
	
	/**
     */
	@Column(name = "created_by")
	@ManyToOne	
    private UserLogin createdBy;
	
	
}

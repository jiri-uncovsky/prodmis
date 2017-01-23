package osu.kip.prodmis.domain;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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
	@ManyToOne
	@JoinColumn(name = "organization")
	private Organization organization;

	
	/**
     */
	@ManyToOne
	@JoinColumn(name = "product_manager")
    private UserLogin productManager;
	
	
    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Set<Document> documents = new HashSet<Document>();

		
}

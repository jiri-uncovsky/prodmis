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
	@ManyToOne	
	@JoinColumn(name = "product")
    private Product product;
		
	
	/**
     */
	@ManyToOne	
	@JoinColumn(name = "created_by")
	private UserLogin createdBy;
	
	   /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "document")
    private Set<DocumentRevision> revisions = new HashSet<DocumentRevision>();

	
	
}

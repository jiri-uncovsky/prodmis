package osu.kip.prodmis.domain;

import javax.persistence.Column;
import javax.persistence.ManyToOne;

import org.springframework.roo.addon.javabean.annotations.RooJavaBean;
import org.springframework.roo.addon.javabean.annotations.RooToString;
import org.springframework.roo.addon.jpa.annotations.entity.RooJpaEntity;

@RooJavaBean
@RooToString
@RooJpaEntity
public class DocumentRevision {

	/**
	 */
	@Column(name = "rev_version")
	private String revisionVersion;

	/**
	 */
	@Column(name = "comment")
	private String comment;

	/**
	 */
	@Column(name = "state")
	private String state;

	/**
	 */
	@Column(name = "file_name")
	private String fileName;
	
	/**
	 */
	@Column(name = "file_path")
	private String filePath;
		
	/**
	 */
	@Column(name = "created_by")
	@ManyToOne
	private UserLogin createdBy;

	/**
	 */
	@Column(name = "document")
	@ManyToOne
	private Document document;

}

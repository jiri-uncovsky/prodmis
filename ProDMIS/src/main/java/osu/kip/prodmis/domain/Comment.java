package osu.kip.prodmis.domain;

import java.util.Calendar;

import javax.persistence.Column;
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
public class Comment {

	/**
	*/
	@Column(name = "subject")
	private String subject;

	/**
	 */
	@Column(name = "text")
	private String text;

	/**
	 */
	@Column(name = "quoted_text")
	private String quoted_text;

	/**
	 */
	@Column(name = "user_login")
	@ManyToOne
	private UserLogin user_login;

	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	@Column(name = "created")
	private Calendar created;

	/**
	 */
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	@Column(name = "last_update")
	private Calendar lastUpdate;

	/**
	 */
	@Column(name = "reply_to")
	@ManyToOne
	private Comment replyTo;

}

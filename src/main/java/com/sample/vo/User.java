/**
 * 
 */
package com.sample.vo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 604242745
 */

@Entity
@Table(name="USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private long id;

	@Column(name="USER_NAME", nullable=false)
	private String userName;
	
	@Column(name="PASSWORD", nullable=false)
	private String password;
	
	@Embedded
	private Name name;
	
	@Column(name="BIRTH_DATE")
	private Date birthDate;
	
	/**
	 * Default Contructor
	 */
	public User() {
		super();
	}

	/**
	 * @param id
	 * @param userName
	 * @param password
	 * @param name
	 * @param birthDate
	 */
	public User(long id, String userName, String password, Name name, Date birthDate) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}

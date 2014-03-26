/**
 * 
 */
package com.sample.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author 604242745
 *
 */
@Embeddable
public class Name {

	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	/**
	 */
	public Name() {
		super();
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}

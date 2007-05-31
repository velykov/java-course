package net.azib.java.students.t960644.homework;

import java.util.Date;

/**
 * Athlete
 * 
 * @author Lembit
 */
public class Athlete {
	private String name;
	private Date born;
	private String countryCode;
	private Integer id;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the born
	 */
	public Date getBorn() {
		return born;
	}

	/**
	 * @param born
	 *            the born to set
	 */
	public void setBorn(Date born) {
		this.born = born;
	}

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 *            the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
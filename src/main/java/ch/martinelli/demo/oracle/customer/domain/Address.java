package ch.martinelli.demo.oracle.customer.domain;

import jakarta.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
	@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", initialValue = 1000)
	private Integer id;

	@SuppressWarnings("unused")
	@Version
	private long version;

	private String street;

	private String postalCode;

	private String city;

	// <editor-fold desc="Getters and Setters">
	public Integer getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	// </editor-fold>

}

package ch.martinelli.demo.oracle.customer.domain;

import jakarta.persistence.*;

@Entity
public class Firm {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "firm_seq")
	@SequenceGenerator(name = "firm_seq", sequenceName = "firm_seq", initialValue = 1000)
	private Integer id;

	@SuppressWarnings("unused")
	@Version
	private long version;

	private String name;

	@ManyToOne
	private Address address;

	// <editor-fold desc="Getters and Setters">
	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	// </editor-fold>

}

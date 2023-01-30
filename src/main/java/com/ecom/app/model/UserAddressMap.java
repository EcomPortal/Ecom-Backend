package com.ecom.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_address_map")
public class UserAddressMap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@JoinColumn(name = "city_id")
	private City city;

	@OneToOne
	@JoinColumn(name = "state_id")
	private State state;

	@OneToOne
	@JoinColumn(name = "user_id")
	private UserData user;

	@Column(name = "address")
	private String address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public UserData getUser() {
		return user;
	}

	public void setUser(UserData user) {
		this.user = user;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserAddressMap(Long id, City city, State state, UserData user, String address) {
		super();
		this.id = id;
		this.city = city;
		this.state = state;
		this.user = user;
		this.address = address;
	}

	public UserAddressMap() {
		super();
		// TODO Auto-generated constructor stub
	}

}

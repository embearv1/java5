package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Account implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id; 
	private String username;
	private String password;
	private String name;
	private String email;
	private boolean is_admin;
	private boolean active;
	
	@OneToMany(mappedBy = "user")
	private List<History> listHis;
	
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Account(int id, String username, String password, String name, String email, boolean is_admin,
			boolean active, List<History> listHis) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.is_admin = is_admin;
		this.active = active;
		this.listHis = listHis;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isIs_admin() {
		return is_admin;
	}
	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
	public List<History> getListHis() {
		return listHis;
	}
	public void setListHis(List<History> listHis) {
		this.listHis = listHis;
	}
	
	
	

}

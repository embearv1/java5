package com.poly.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "type_video")
public class Type_Video implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;

	@Column(name = "is_active")
	private boolean active;

	@OneToMany(mappedBy = "type")
	private List<Video> listVideo = new ArrayList<>();

//	public Type_Video() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//	public Type_Video(int id, String name, boolean active, List<Video> listVideo) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.active = active;
//		this.listVideo = listVideo;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public boolean isActive() {
//		return active;
//	}
//
//	public void setActive(boolean active) {
//		this.active = active;
//	}
//
//	public static long getSerialversionuid() {
//		return serialVersionUID;
//	}
//
//	public List<Video> getListVideo() {
//		return listVideo;
//	}
//
//	public void setListVideo(List<Video> listVideo) {
//		this.listVideo = listVideo;
//	}

}

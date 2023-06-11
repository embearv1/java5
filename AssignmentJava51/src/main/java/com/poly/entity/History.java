package com.poly.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class History implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id; 
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private Account user;
	
	@ManyToOne
	@JoinColumn(name="id_video")
	private Video video;
	
	private Date view_date;
	private boolean is_liked;
	private Date liked_date;
	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	public History(int id, Account user, Video video, Date view_date, boolean is_liked, Date liked_date) {
		super();
		this.id = id;
		this.user = user;
		this.video = video;
		this.view_date = view_date;
		this.is_liked = is_liked;
		this.liked_date = liked_date;
	}
	
	
	
	public History(Account user, Video video, Date view_date, boolean is_liked, Date liked_date) {
		super();
		this.user = user;
		this.video = video;
		this.view_date = view_date;
		this.is_liked = is_liked;
		this.liked_date = liked_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Account getUser() {
		return user;
	}
	public void setUser(Account user) {
		this.user = user;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Date getView_date() {
		return view_date;
	}
	public void setView_date(Date view_date) {
		this.view_date = view_date;
	}
	public boolean isIs_liked() {
		return is_liked;
	}
	public void setIs_liked(boolean is_liked) {
		this.is_liked = is_liked;
	}
	public Date getLiked_date() {
		return liked_date;
	}
	public void setLiked_date(Date liked_date) {
		this.liked_date = liked_date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

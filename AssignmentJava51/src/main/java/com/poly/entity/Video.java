package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
public class Video implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;

	private String title;
	private String href;
	private String poster;
	private int views;
	private int likes;
	private int shares;
	private String description;
	private boolean active;
	
	@ManyToOne
	@JoinColumn(name = "id_type")
	private Type_Video type;
	
	@OneToMany(mappedBy = "video")
	private List<History> listHis;
	
	public Video() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Video(int id, String title, String href, String poster, int views, int likes, int shares, String description,
			boolean active) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.views = views;
		this.likes = likes;
		this.shares = shares;
		this.description = description;
		this.active = active;
	}
	
	
	
	public Video(int id, String title, String href, String poster, int views, int likes, int shares, String description,
			boolean active, Type_Video type, List<History> listHis) {
		super();
		this.id = id;
		this.title = title;
		this.href = href;
		this.poster = poster;
		this.views = views;
		this.likes = likes;
		this.shares = shares;
		this.description = description;
		this.active = active;
		this.type = type;
		this.listHis = listHis;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Type_Video getType() {
		return type;
	}
	public void setType(Type_Video type) {
		this.type = type;
	}
	public List<History> getListHis() {
		return listHis;
	}
	public void setListHis(List<History> listHis) {
		this.listHis = listHis;
	}
	
	
	
	
	
	
}

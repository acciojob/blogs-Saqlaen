package com.driver.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;



@Entity
public class Blog{

    @Id 
    @GeneratedValue( strategy = GenerationType.AUTO  )
    private int id;
    private String title;
    private String content;

    private Date pubDate;

    @ManyToOne
    @JoinColumn
    private User user;

    @OneToMany( mappedBy = "blog", cascade = CascadeType.ALL )
    List<Image> imageList;

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPubDate() {
		return pubDate;
	}

	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Image> getImageList() {
		return imageList;
	}

	public void setImageList(List<Image> imageList) {
		this.imageList = imageList;
	}

	public Blog(String title, String content, Date pubDate) {
		super();
		this.title = title;
		this.content = content;
		this.pubDate = pubDate;
	}

	public Blog() {
		// TODO Auto-generated constructor stub
	}


}

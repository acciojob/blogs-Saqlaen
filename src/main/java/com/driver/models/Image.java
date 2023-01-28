package com.driver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Image {
    
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private int id;
	
	private String description;
	
	private String dimensions;
	
	@ManyToOne
	@JoinColumn
	private Blog blog;

	public Image() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDimensions() {
		return dimensions;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}

	public Image(String description, String dimensions) {
		super();
		this.description = description;
		this.dimensions = dimensions;
	}
	
	


}
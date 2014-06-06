package com.hugelist.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "classification", schema = "hugelist@cassandra_hugelist")
public class Classification implements java.io.Serializable {
	
	private static final long serialVersionUID = 3L;
	
	@Id
	@Column(name = "classificationid")
	private String id;
	
	@Column(name = "classificationname")
	private String name;

	@Column(name = "classificationattribute")
	private String attribute;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classification")
	private Set<ClassItem> classItems;
    
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "categoryid")
//	private Category category;
	
	public Classification() {
	}

	public Classification(String id, String classGroupId, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Classification(String id, String classGroupId, String name,
			Set<ClassItem> classItems) {
		super();
		this.id = id;
		this.name = name;
		this.classItems = classItems;
	}

	public Set<ClassItem> getClassItems() {
		return this.classItems;
	}

	public void setClassItems(Set<ClassItem> classItems) {
		this.classItems = classItems;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}

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
@Table(name = "category", schema = "hugelist@cassandra_hugelist")
public class Category implements java.io.Serializable {
	private static final long serialVersionUID = 3L;
	
	@Id
	@Column(name = "categoryid")
	private String id;
	
	@Column(name = "categoryname")
	private String name;
	
	@Column(name = "accountid")
	private String accountId;
	
	@Column(name = "accountname")
	private String accountName;
	
	@Column(name = "categoryattribute")
	private String attribute;
	
	@Column(name = "latestversion")
	private int latestVersion;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "classification")
	private Set<Classification> classifications;
    
	public Category() {
	}

	public Category(String name, int latestVersion) {
		this.name = name;
		this.latestVersion = latestVersion;
	}

	public Category(String id, String name, String accountId,
			Integer latestVersion, Set<Classification> classifications) {
		super();
		this.id = id;
		this.name = name;
		this.accountId = accountId;
		this.latestVersion = latestVersion;
		this.classifications = classifications;
	}

	public Category(String id, String accountId, String name,
			int latestVersion) {
		super();
		this.id = id;
		this.accountId = accountId;
		this.name = name;
		this.latestVersion = latestVersion;
	}

	public Set<Classification> getClassifications() {
		return this.classifications;
	}

	public void setClassifications(Set<Classification> classifications) {
		this.classifications = classifications;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAttribute() {
		return this.attribute;
	}

	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLatestVersion() {
		return this.latestVersion;
	}

	public void setLatestVersion(int latestVersion) {
		this.latestVersion = latestVersion;
	}
}

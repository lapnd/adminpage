package com.hugelist.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manager", schema = "hugelist@cassandra_hugelist")
public class Manager implements java.io.Serializable  {
    private static final long serialVersionUID = 3L;

    @Id
    @Column(name = "id")
    private String id;
  
    @Column(name = "aid")
    private String aid;
  
    @Column(name = "username")
    private String userName;
    
    @Column(name = "displayname")
    private String displayName;

    @Column(name = "pass")
    private String pass;

    @Column(name = "token1")
    private String token;

    @Column(name = "isactive")
    private Boolean isActive;
    
    @Column(name = "isadmin")
    private Boolean isAdmin;

    @Column(name = "sessionexpired")
    private Date sessionExpired ;

    @Column(name = "challengekey")
    private String challengeKey;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @Column(name = "categories")
    private Set<String> categories;
   
    public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
    
    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Date getSessionExpired() {
        return sessionExpired;
    }

    public void setSessionExpired(Date sessionExpired) {
        this.sessionExpired = sessionExpired;
    }

    public String getChallengeKey() {
        return challengeKey;
    }

    public void setChallengeKey(String challengeKey) {
        this.challengeKey = challengeKey;
    }

    /*
CREATE TABLE manager (
  id text,
  aid text,
  username text,
  pass text,
  token1 text, 
  isactive boolean,
  isadmin boolean,
  challengekey text,
  createdate text,
  sessionexpired timestamp, 
  categories set<text>,
  PRIMARY KEY (id)
) WITH
  bloom_filter_fp_chance=0.010000 AND
  caching='KEYS_ONLY' AND
  comment='' AND
  dclocal_read_repair_chance=0.000000 AND
  gc_grace_seconds=864000 AND
  index_interval=128 AND
  read_repair_chance=0.100000 AND
  replicate_on_write='true' AND
  populate_io_cache_on_flush='false' AND
  default_time_to_live=0 AND 
  speculative_retry='99.0PERCENTILE' AND
  memtable_flush_period_in_ms=0 AND
  compaction={'class': 'SizeTieredCompactionStrategy'} AND
  compression={'sstable_compression': 'LZ4Compressor'}; 
  
  CREATE CUSTOM INDEX manager_usename_index ON "manager"(username) USING 'com.tuplejump.stargate.cas.PerColIndex';
  CREATE CUSTOM INDEX manager_aid_index ON "manager"(aid) USING 'com.tuplejump.stargate.cas.PerColIndex';
  CREATE CUSTOM INDEX manager_token_index ON "manager"(token1) USING 'com.tuplejump.stargate.cas.PerColIndex';
   */
}

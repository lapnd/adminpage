package com.hugelist.client.entities;

public class WAccount {
	
	String derivaName;
	private String AID;
	private String token;
	private boolean isAdmin;

	public WAccount(String derivaName, String aID, String token, boolean isAdmin) {
		super();
		this.derivaName = derivaName;
		AID = aID;
		this.token = token;
		this.isAdmin = isAdmin;
	}

	public String getDerivaName() {
		return derivaName;
	}

	public void setDerivaName(String derivaName) {
		this.derivaName = derivaName;
	}

	public String getAID() {
		return AID;
	}

	public void setAID(String aID) {
		AID = aID;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof WAccount))return false;
	    WAccount account = (WAccount) other;
	    if(this.derivaName != null && account.getDerivaName() != null && 
				this.derivaName.equals(account.getDerivaName())){
			return true;
		}
		return false; 
	}

	@Override
	public int hashCode() {
		return this.derivaName.hashCode();//for using when comparing 2 Accounts (use in map (ConnectionManager))
		//		return super.hashCode();
	}
}
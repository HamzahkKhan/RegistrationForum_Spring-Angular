package com.demo.registration.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_info")
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Users_InfoEntity {
	
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    
    @OneToOne (cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UsersEntity usersEntity;
    
    @Column(name = "dob")
    private String dob;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "nationality")
    private String nationality;
    
    @Column(name = "phonenumber")
    private String phonenumber;
    
    
    public void setUsersEntity(UsersEntity usersEntity) {
    	this.usersEntity = usersEntity;
    }
    
    public UsersEntity getUserEntity() {
    	return usersEntity;
    }
    

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
    
	 @Override
	    public String toString() {
	        return "User_info [id= " + id + ", "
	        		+ "Dob=" + dob + ", "
	        		+ "USER_ID" + usersEntity
	        		+ "Address=" + address + ","
	        		+ "Nationality = " + nationality + ","
	        		+ "Number = " + phonenumber +
	        		"]";
	    }
    
    
}

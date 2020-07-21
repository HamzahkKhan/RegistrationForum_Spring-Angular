package com.demo.registration.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "users")
public class UsersEntity {
	
	    @Id 
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    @Column(name = "user_Name")
	    private String username;

	    @Column(name = "user_Email")
	    private String useremail;

	    @Column(name = "user_Password")
	    private String userpassword;

	    public void setId(long id) {
	        this.id = id;
	    }

	    public void setUsername(String username) {
	        this.username = username;
	    }

	    public void setUseremail(String useremail) {
	        this.useremail = useremail;
	    }

	    public void setUserpassword(String userpassword) {
	        this.userpassword = userpassword;
	    }

	    public long getId() {
	        return id;
	    }

	    public String getUsername() {
	        return username;
	    }

	    public String getUseremail() {
	        return useremail;
	    }

	    public String getUserpassword() {
	        return userpassword;
	    }
	    
	    @Override
	    public String toString() {
	        return "RegistrationEntity [id=" + id + ", username=" + username + 
	                ", useremail=" + useremail + ", userpassword=" + userpassword   + "]";
	    }

}

package com.demo.registration.model;


public class User_UserInfoEntity { 
	
        private String username;

	    private String useremail;

	    private String userpassword;
	    
	    private String dob;
	    
        private String address;
	    
	    private String nationality;
	    
	    private String phonenumber;
	    
	    
	    public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getUseremail() {
			return useremail;
		}

		public void setUseremail(String useremail) {
			this.useremail = useremail;
		}

		public String getUserpassword() {
			return userpassword;
		}

		public void setUserpassword(String userpassword) {
			this.userpassword = userpassword;
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
	        return "InfoEntity "
	        		+ "[username=" + username + 
	                ", useremail=" + useremail + 
	                ", userpassword=" + userpassword + 
	                "Dob=" + dob + ", "+ 
	                "Address=" + address + "," + 
	                "Nationality = " + nationality + ","+ 
	                "Number = " + phonenumber +
	        		"]";
	    }
    

}

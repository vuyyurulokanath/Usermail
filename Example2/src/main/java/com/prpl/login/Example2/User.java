package com.prpl.login.Example2;

public class User 
{
	String id;
	String email;
	String name;
	String picture;
	String gender;
	String locale;


public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getEmail() {

return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getPicture() {
return picture;
}

public void setPicture(String picture) {
this.picture = picture;
}

public String getGender() {
return gender;
}

public void setGender(String gender) {
this.gender = gender;
}

public String getLocale() {
return locale;
}

public void setLocale(String locale) {
this.locale = locale;
}

@Override
public String toString() {
	return "User [id=" + id + ", email=" + email + ", name=" + name + ", picture=" + picture + ", gender=" + gender
			+ ", locale=" + locale + "]";
}

}
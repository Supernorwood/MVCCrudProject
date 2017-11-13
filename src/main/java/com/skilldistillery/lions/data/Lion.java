package com.skilldistillery.lions.data;

public class Lion {
	
	private int id;
	private String name;
	private String gender;
	private String imageUrl;
	
	public Lion() {
	}
	
	public Lion(int id, String name, String gender, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.imageUrl = imageUrl;
	}
	public Lion(int id, String name, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "Giraffe [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lion other = (Lion) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}

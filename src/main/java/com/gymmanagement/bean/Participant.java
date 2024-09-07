package com.gymmanagement.bean;

public class Participant {
	private int id;
    private String name;
    private int age;
    private String email;
    private int batchId;
    // Constructors, Getters, and Setters
    public Participant(String name, int age, String email, int batchId) {
    	 this.name = name;
         this.age = age;
         this.email = email;
         this.batchId = batchId;
    }

    public Participant(int id, String name, int age, String email, int batchId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.batchId = batchId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
	public String toString() {
		return "Participant [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", batchId=" + batchId
				+ "]";
	}
    
}

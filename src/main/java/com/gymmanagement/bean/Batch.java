package com.gymmanagement.bean;

public class Batch {
	 private int id;
	    private String batchName;
	    private String batchTime;
	    private int maxParticipants;
	    // Constructors, Getters, and Setters
	    public Batch(String batchName, String batchTime, int maxParticipants) {
	        this.batchName = batchName;
	        this.batchTime = batchTime;
	        this.maxParticipants = maxParticipants;

	    }

	    public Batch(int id, String batchName, String batchTime, int maxParticipants) {
	        this.id = id;
	        this.batchName = batchName;
	        this.batchTime = batchTime;
	        this.maxParticipants = maxParticipants;
	    }

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getBatchName() {
			return batchName;
		}

		public void setBatchName(String batchName) {
			this.batchName = batchName;
		}

		public String getBatchTime() {
			return batchTime;
		}

		public void setBatchTime(String batchTime) {
			this.batchTime = batchTime;
		}

		public int getMaxParticipants() {
			return maxParticipants;
		}

		public void setMaxParticipants(int maxParticipants) {
			this.maxParticipants = maxParticipants;
		}
	    
	    
}

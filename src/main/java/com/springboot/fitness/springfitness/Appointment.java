package com.springboot.fitness.springfitness;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appointment {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer appID;
	private String trainerName;
	private boolean physioRequired;
	private String packageName;
	private int amount;
	private String username;
	private String userEmail;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public boolean isPhysioRequired() {
		return physioRequired;
	}

	public void setPhysioRequired(boolean physioRequired) {
		this.physioRequired = physioRequired;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Integer getAppID() {
		return appID;
	}

	public void setAppID(Integer appID) {
		this.appID = appID;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	@Override
	public String toString() {
		return "Appointment [appID=" + appID + ", trainerName=" + trainerName + ", physioRequired=" + physioRequired
				+ ", packageName=" + packageName + ", amount=" + amount + ", username=" + username + ", userEmail="
				+ userEmail + "]";
	}

}

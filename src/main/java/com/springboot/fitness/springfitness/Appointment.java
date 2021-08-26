package com.springboot.fitness.springfitness;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
public class Appointment {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer appID;
	@NotBlank(message = "Trainer name cannot be blank")
	private String trainerName;
	private boolean physioRequired;
	@NotBlank(message = "package name cannot be blank")
	private String packageName;
	private int amount;
	@ManyToOne
	@JsonIgnore
	private User user;
}

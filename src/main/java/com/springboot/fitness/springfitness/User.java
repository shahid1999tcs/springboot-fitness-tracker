package com.springboot.fitness.springfitness;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer ID;
	private String firstName;
	private String lastName;
	private int age;
	private String address;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID")
	private Set<Appointment> appointments;
}

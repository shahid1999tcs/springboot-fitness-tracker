package com.springboot.fitness.springfitness;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AppointmentController {
	
	@Autowired
	IAppointmentRepository repo;
	
	@PostMapping("/app")
	public void saveuser(@RequestBody Appointment appointment) {

		repo.save(appointment);
		System.out.println(appointment.getUsername());
		
	}
	
	@GetMapping("/app")
	public Iterable<Appointment> getAppointments(){
		Iterable<Appointment> apps = repo.findAll();
		return apps;
	}
	
}

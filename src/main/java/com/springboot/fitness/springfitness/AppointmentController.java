package com.springboot.fitness.springfitness;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {

	@Autowired
	IAppointmentRepository repo;

	@PostMapping("/app")
	public void saveuser(@Valid @RequestBody Appointment appointment) {

		if (appointment.getUsername() == null || appointment.getUsername().length() <= 5) {
			System.out.println("Username should exist and be less than 5 characters");
			throw new RuntimeException("What are you doing!!!!"); 
			//REST OF THE VALIDATION IS DONE THROUGH SPRING BECAUSE OF @VALID AND OTHER
			//ANNOTATIONS IN THE APPOINTMENT.JAVA CLASS
		}

		repo.save(appointment);

	}

	@GetMapping("/app")
	public Iterable<Appointment> getAppointments() {
		Iterable<Appointment> apps = repo.findAll();
		return apps;
	}
	
	@GetMapping("/app/{id}")
	public Appointment getAppointment(@PathVariable("id") Integer id) throws IdNotFoundException {
		Optional<Appointment> app = repo.findById(id);
		if(app.isEmpty()) {
			throw new IdNotFoundException("This appointment doesnt exist");
		}
		return app.get();
	}
	
	@PutMapping("/app/{id}")
	public void updateAppointment(@PathVariable("id") Integer id,@RequestBody Appointment app) {
		Appointment appFromDb = repo.findById(id).get();
		if(StringUtils.hasText(app.getTrainerName())) {
			appFromDb.setTrainerName(app.getTrainerName());
		}
		if(StringUtils.hasText(app.getPackageName())) {
			appFromDb.setPackageName(app.getPackageName());
		}
		if(app.getAmount()!= 0 ) {
			appFromDb.setAmount(app.getAmount());
		}
		repo.save(appFromDb);
	}	

	@ExceptionHandler(value = { RuntimeException.class })
	public ResponseEntity<Appointment> exception(RuntimeException runtime) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(value = { IdNotFoundException.class })
	public ResponseEntity<Appointment> exception2(IdNotFoundException idNotFound) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}

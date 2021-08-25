package com.springboot.fitness.springfitness;

public class UserNameInvalidException extends RuntimeException{
	public UserNameInvalidException(String msg) {
		super(msg);
	}
}

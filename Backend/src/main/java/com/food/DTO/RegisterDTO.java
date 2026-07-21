package com.food.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
	
	@NotBlank(message="Name is required")
	private String name;
	
	@NotBlank(message="Email is required")
	@Email(message="Enter valid email")
	private String email;
	

@Size(min=6,message="Password must be at least 6 characters")
	private String password;

@Pattern(regexp="^[0-9]{10}$",
         message="Enter valid phone number")
	private String phone;
	private String accountType;
	private String address;
	private String city;
}

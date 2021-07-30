package com.service.db.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User{
    @GeneratedValue
	@Id
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
	private String phonenumber;

}
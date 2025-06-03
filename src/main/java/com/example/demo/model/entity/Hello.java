package com.example.demo.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
	public class Hello {
	    @Id @GeneratedValue
	    private Long id;
	    private String title;
	    private String status;
	}

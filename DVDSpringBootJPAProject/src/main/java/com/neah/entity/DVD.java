package com.neah.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class DVD {
	
	@Id
	//@Column(name = "DVDId")
	private int DVDId; 
	
	//@Column(name = "DVD Title")
	private String title;
	
	//@Column(name = "Release Date")
	private  LocalDate releaseDate;
	
	//@Column(name = "Director Surname")
	private String directorName;
	
	//@Column(name = "Age Rating")
	private String ageRating;	
	
	//@Column(name = "Duartion in hours")
	private double duration;

}

package com.neah.service;

import java.util.Collection;

import com.neah.entity.DVD;


public interface DVDService {
	
	boolean addDVD(DVD dvd);

//	DVD searchDVD(int id);
	
	Collection<DVD> getAllDVDs();
	
	DVD searchDVDById(int id);
	
	//updating a book information 
	boolean updateDVD(int id);
	
	boolean deleteDVD(int id);


}

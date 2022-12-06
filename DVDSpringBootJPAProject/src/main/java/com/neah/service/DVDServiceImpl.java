package com.neah.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neah.entity.DVD;
import com.neah.persistence.DVDDao;

@Component("service")
public class DVDServiceImpl implements DVDService{
	
	@Autowired
	private DVDDao dvdDao;
	

	public DVDServiceImpl(DVDDao dvdDao) {
		super();
		this.dvdDao = dvdDao;
	}

	@Override
	public boolean addDVD(DVD dvd) {
		if(searchDVDById(dvd.getDVDId())== null){
			dvdDao.save(dvd);
			return true;
		}
		return false;
	}

//	@Override
//	public DVD searchDVD(int id) {
//		return dvdDao.findById(id).orElse(null);
//	}

	@Override
	public Collection<DVD> getAllDVDs() {
		return dvdDao.findAll();
	}

	@Override
	public DVD searchDVDById(int id) {
		// TODO Auto-generated method stub
		return dvdDao.findById(id).orElse(null);
	}

	@Override
	public boolean updateDVD(int id) {
		
		DVD dvd = searchDVDById(id);
		if(dvd!=null) {
			//dvd.setDVDId(dvd.getDVDId());
			dvd.setTitle(dvd.getTitle());
			dvd.setReleaseDate(dvd.getReleaseDate());
			dvd.setDirectorName(dvd.getDirectorName());
			dvd.setAgeRating(dvd.getAgeRating());	
			dvd.setDuration(dvd.getDuration());
			//we use save as the dao does not know what update means	
			dvdDao.save(dvd);
			return true;
		}return false;
		

	}
	

	@Override
	public boolean deleteDVD(int id) {
		if (searchDVDById(id) != null) {
			dvdDao.deleteById(id);
			return true;
		}
		return false;
	}


}

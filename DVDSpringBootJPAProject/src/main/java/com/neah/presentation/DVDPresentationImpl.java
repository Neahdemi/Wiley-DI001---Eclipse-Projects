package com.neah.presentation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Collection;
import java.util.Date;
import java.util.Scanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neah.service.DVDService;
import com.neah.entity.*;

@Component("presentation")
public class DVDPresentationImpl implements DVDPresentation{
	
	@Autowired
	private DVDService dvdService;
	

	public DVDPresentationImpl(DVDService dvdService) {
		super();
		this.dvdService = dvdService;
	}
	
    public void setDVDService(DVDService dvdService) {
        this.dvdService = dvdService;
    }

	@Override
	public void showMenu() {
		System.out.println("===========================");
		System.out.println("DVD Library");
		System.out.println("1. List All DVD's");
		System.out.println("2. Search DVD By ID");
		System.out.println("3. Add New DVD");
		System.out.println("4. Delete DVD");
		System.out.println("5. Edit DVD");
		System.out.println("6. Exit");
		System.out.println("============================");
		
	}

	@Override
	public void performMenu(int choice) {
		Scanner scanner=new Scanner(System.in);
		
		switch (choice) {
		case 1:
			Collection<DVD> dvds=dvdService.getAllDVDs();
			for(DVD dvd:dvds) {
				System.out.println(dvd);
			}
			break;
		case 2:
			System.out.println("Enter DVD ID : ");
			int id=scanner.nextInt();
			DVD dvd=dvdService.searchDVDById(id);
			if(dvd!=null)
				System.out.println(dvd);
			else
				System.out.println("DVD with id "+id+" doesnot exist");
			break;
		case 3:
			DVD newDVD=new DVD();
			
			System.out.println("Enter DVD ID : ");
			newDVD.setDVDId(scanner.nextInt());
			System.out.println("Enter DVD Title : ");
			newDVD.setTitle(scanner.next());
			System.out.println("Enter DVD Release Date (dd-Mon-yyyy) : ");
			DateTimeFormatter df=new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("d-MMM-yyyy")).toFormatter();
			newDVD.setReleaseDate(LocalDate.parse(scanner.next(),df));
			System.out.println("Enter Director Surname : ");
			newDVD.setDirectorName(scanner.next());
			System.out.println("Enter Age Rating : ");
			newDVD.setAgeRating(scanner.next());
			System.out.println("Enter Duration : ");
			newDVD.setDuration(scanner.nextDouble());
			
			
			if(dvdService.addDVD(newDVD))
				System.out.println("DVD Record Saved");
			else
				System.out.println("DVD with id "+newDVD.getDVDId()+" already exist, so cannot add it as a new DVD!");
			
			break;
		case 4:
			System.out.println("Enter DVD ID : ");
			int dvdId=scanner.nextInt();
			if(dvdService.deleteDVD(dvdId))
				System.out.println("DVD with id "+dvdId+" deleted");
			else
				System.out.println("DVD with id "+dvdId+" does not exist");
			break;
		case 5:
			
			System.out.println("Please enter DVD ID of DVD information to update : ");
			int dvdid = scanner.nextInt();
			System.out.println("Enter new DVD Title : ");
			String title = scanner.next();
			System.out.println("Enter new DVD Release Date (dd-Mon-yyyy) : ");
			DateTimeFormatter dtf=new DateTimeFormatterBuilder().parseCaseInsensitive().append(DateTimeFormatter.ofPattern("d-MMM-yyyy")).toFormatter();
			LocalDate date = LocalDate.parse(scanner.next(),dtf);
			System.out.println("Enter new Director Surname : ");
			String name = scanner.next();
			System.out.println("Enter new Age Rating : ");
			String age = scanner.next();
			System.out.println("Enter Duration : ");
			Double duration = scanner.nextDouble();
			
			if(dvdService.updateDVD(dvdid))
				System.out.println("DVD information updated successfully");
			else {
				System.out.println("DVD ID " + dvdid + " does not exist");
					}

			break;
		case 6:
			System.out.println("Thanks for using DVD Library");
			System.exit(0);
		default:
			System.out.println("Invalid Choice!");
			break;
		}

	}

}



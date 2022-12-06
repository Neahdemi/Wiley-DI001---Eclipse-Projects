package com.neah.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neah.entity.DVD;

@Repository
public interface DVDDao extends JpaRepository<DVD, Integer>  {

}

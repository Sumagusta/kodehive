package com.kodehive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kodehive.model.MahasiswaModel;

public interface MahasiswaRepository extends JpaRepository<MahasiswaModel, String>{
	
	@Query("SELECT P FROM MahasiswaModel P WHERE kd_mhs = ?1")
	MahasiswaModel cariKodeMhs(String kd_mhs);
	
}

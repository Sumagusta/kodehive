package com.kodehive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodehive.model.MahasiswaProfileModel;
import com.kodehive.repository.MahaiswaProfileRepository;

@Service
public class MahasiswaProfileService {

	@Autowired
	private MahaiswaProfileRepository mahasiswaProfileRepository;
	
	public List<MahasiswaProfileModel> searchProfileAll(){
		return this.mahasiswaProfileRepository.findAll();
	}
	
	public void simpan(MahasiswaProfileModel mahasiswaProfileModel) {
		this.mahasiswaProfileRepository.save(mahasiswaProfileModel);
	}
	
}

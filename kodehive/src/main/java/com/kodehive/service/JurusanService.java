package com.kodehive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.model.JurusanModel;
import com.kodehive.repository.JurusanRepository;

@Service
@Transactional
public class JurusanService {

	@Autowired
	private JurusanRepository jurusanRepository;

	public List<JurusanModel> readJurusan() {
		return this.jurusanRepository.findAll();
	}

	public void saveJurusan(JurusanModel jurusanModel) {
		this.jurusanRepository.save(jurusanModel);
	}
}

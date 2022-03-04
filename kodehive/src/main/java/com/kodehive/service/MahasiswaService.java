package com.kodehive.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kodehive.model.MahasiswaModel;
import com.kodehive.repository.MahasiswaRepository;

@Service
@Transactional
public class MahasiswaService {

	@Autowired
	MahasiswaRepository mahasiswaRepository;
	
	public void save(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.save(mahasiswaModel);
	}
	
	public void update(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.save(mahasiswaModel);	
	}
	
	public MahasiswaModel cariPrimaryKey(String kd_mhs) {
		return this.mahasiswaRepository.cariKodeMhs(kd_mhs);
	}

	public void delete(MahasiswaModel mahasiswaModel) {
		mahasiswaRepository.delete(mahasiswaModel);
	}
	
	public List<MahasiswaModel> bacaData() {
		return this.mahasiswaRepository.findAll();
	}
	
	public Page<MahasiswaModel> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize); // Pageable merupakan interface, implements pageRequest. Dalam springboot pageNo secara default dimulai dari 0, sedangkan pada PageRequest dimulai dari 1, jadi kurangkan 1 supaya menjadi 0 dan dapat terbaca springboot
		return this.mahasiswaRepository.findAll(pageable);
	}
	
}

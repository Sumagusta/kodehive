package com.kodehive.controller.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.kodehive.model.MahasiswaModel;
import com.kodehive.repository.MahasiswaRepository;
import com.kodehive.service.MahasiswaService;

@RestController
public class MahasiswaApi {

	@Autowired
	private MahasiswaService mahasiswaService;
	
	@Autowired
	private MahasiswaRepository mahasiswaRepository;
	
	@PostMapping("/api/mahasiswa/post")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Map<String, Object> post(@RequestBody MahasiswaModel mahasiswaModel){
		
		this.mahasiswaService.save(mahasiswaModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Pesan", "Data berhasil di simpan");
		map.put("success", Boolean.TRUE);
		
		return map;
	}
	
	@GetMapping("/api/mahasiswa/get")
	@ResponseStatus(code = HttpStatus.OK)
	public List<MahasiswaModel> get(){
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = this.mahasiswaService.bacaData();
		return mahasiswaModelList;
	}
	
	@PutMapping("/api/mahasiswa/put")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Map<String, Object> put(@RequestBody MahasiswaModel mahasiswaModel){
		
		this.mahasiswaService.update(mahasiswaModel);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Pesan", "Data berhasil diubah");
		map.put("success", Boolean.TRUE);
		
		return map;
	}
	
	@DeleteMapping("/api/mahasiswa/delete/{kd_mhs}")
	@ResponseStatus(code = HttpStatus.GONE)
	public Map<String, Object> deleteApi(@PathVariable String kd_mhs){
		
		this.mahasiswaService.delete(this.mahasiswaRepository.cariKodeMhs(kd_mhs));
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Pesan", "Data berhasil dihapus");
		map.put("success", Boolean.TRUE);
		return map;
	}
	
}

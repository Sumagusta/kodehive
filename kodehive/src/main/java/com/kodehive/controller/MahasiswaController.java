package com.kodehive.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.model.JurusanModel;
import com.kodehive.model.MahasiswaProfileModel;
import com.kodehive.model.MahasiswaModel;
import com.kodehive.repository.MahasiswaRepository;
import com.kodehive.service.JurusanService;
import com.kodehive.service.MahasiswaProfileService;
import com.kodehive.service.MahasiswaService;

@Controller
public class MahasiswaController {

	@Autowired
	private MahasiswaService mahasiswaService;
	
	@Autowired
	private JurusanService jurusanService;
	
	@Autowired
	private MahasiswaProfileService profileService;

	@RequestMapping("/mahasiswa")
	public String home() {
		String html = "/mahasiswa/home";
		return html;
	}

	@RequestMapping("/mahasiswa/add")
	public String addMahasiswa(Model model) {
		this.bacaJurusan(model);
		this.bacaProfile(model);
		
		String html = "mahasiswa/add";
		return html;
	}

	@RequestMapping("/mahasiswa/create")
	public String create(HttpServletRequest request) {
		String kodeMahasiswa = request.getParameter("kodeMahasiswa");
		String namaMahasiswa = request.getParameter("namaMahasiswa");
		String alamat = request.getParameter("alamat");
		String jenisKelamin = request.getParameter("jk");
		String status = request.getParameter("status");
		String jurusan = request.getParameter("jurusan");

		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel.setKd_mhs(kodeMahasiswa);
		mahasiswaModel.setNm_mhs(namaMahasiswa);
		mahasiswaModel.setJk(jenisKelamin);
		mahasiswaModel.setAlamat(alamat);
		mahasiswaModel.setStatus(status);
		mahasiswaModel.setKodeJurusan(jurusan);

		this.mahasiswaService.save(mahasiswaModel);

		String html = "/mahasiswa/home";
		return html;
	}

	@RequestMapping("/mahasiswa/list")
	public String bacaData(Model model) {

		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = this.mahasiswaService.bacaData();

		model.addAttribute("bingkisanBacaData", mahasiswaModelList);

		String html = "/mahasiswa/list";
		return html;

	}

	@RequestMapping("/mahasiswa/edit")
	public String edit(HttpServletRequest request, Model model) {
		String kodeMahasiswa = request.getParameter("kd_mhs");

		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.cariPrimaryKey(kodeMahasiswa);
		this.bacaJurusan(model);

		model.addAttribute("bingkisanEdit", mahasiswaModel);

		String html = "/mahasiswa/edit";
		return html;

	}

	@RequestMapping("/mahasiswa/update")
	public String update(HttpServletRequest request) {
		String kodeMahasiswa = request.getParameter("kodeMahasiswa");
		String namaMahasiswa = request.getParameter("namaMahasiswa");
		String alamat = request.getParameter("alamat");
		String jenisKelamin = request.getParameter("jk");
		String status = request.getParameter("status");
		String jurusan = request.getParameter("jurusan");

		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel.setKd_mhs(kodeMahasiswa);
		mahasiswaModel.setNm_mhs(namaMahasiswa);
		mahasiswaModel.setJk(jenisKelamin);
		mahasiswaModel.setAlamat(alamat);
		mahasiswaModel.setStatus(status);
		mahasiswaModel.setKodeJurusan(jurusan);

		this.mahasiswaService.update(mahasiswaModel);

		String html = "/mahasiswa/home";
		return html;
	}

	@RequestMapping("/mahasiswa/remove")
	public String remove(HttpServletRequest request, Model model) {
		String kodeMahasiswa = request.getParameter("kd_mhs");

		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.cariPrimaryKey(kodeMahasiswa);

		model.addAttribute("bingkisanDelete", mahasiswaModel);

		String html = "/mahasiswa/remove";
		return html;

	}

	@RequestMapping("/mahasiswa/delete")
	public String delete(HttpServletRequest request, Model model) {
		String kodeMahasiswa = request.getParameter("kodeMahasiswa");

		MahasiswaModel mahasiswaModel = new MahasiswaModel();
		mahasiswaModel = this.mahasiswaService.cariPrimaryKey(kodeMahasiswa);
		
		this.mahasiswaService.delete(mahasiswaModel);
		this.bacaData(model);
		
		String html = "/mahasiswa/home";
		return html;
	}

	@RequestMapping("/mahasiswa/jurusan")
	public void bacaJurusan(Model model) {
		List<JurusanModel> jurusanModelList = new ArrayList<>();
		jurusanModelList = this.jurusanService.readJurusan();
		
		model.addAttribute("jurusanModelList", jurusanModelList);
	}
	
	@RequestMapping("/mahasiswa/profile")
	public void bacaProfile(Model model) {
		List<MahasiswaProfileModel> profileModelList = new ArrayList<>();
		profileModelList = this.profileService.searchProfileAll();
		
		model.addAttribute("profileModelList", profileModelList);
	}
	
	
	
}

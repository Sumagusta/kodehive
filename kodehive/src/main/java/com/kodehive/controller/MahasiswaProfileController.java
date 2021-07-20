package com.kodehive.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kodehive.model.MahasiswaModel;
import com.kodehive.model.MahasiswaProfileModel;
import com.kodehive.service.MahasiswaProfileService;
import com.kodehive.service.MahasiswaService;

@Controller
@RequestMapping("/profile")
public class MahasiswaProfileController {

	@Autowired
	private MahasiswaProfileService mahasiswaProfileService;
	
	@Autowired
	private MahasiswaService mahasiswaService;

	@RequestMapping("/home")
	public String home() {
		String html = "/profile/home";
		return html;
	}

	@RequestMapping("/add")
	public String addProfile(Model model) {
		this.bacaMahasiswa(model);
		
		String html = "/profile/add";
		return html;
	}

	@RequestMapping("/list")
	public String bacaData(Model model) {
		List<MahasiswaProfileModel> mahasiswaProfileModelList = new ArrayList<MahasiswaProfileModel>();
		mahasiswaProfileModelList = this.mahasiswaProfileService.searchProfileAll();

		model.addAttribute("mahasiswaProfileModelList", mahasiswaProfileModelList);

		String html = "/profile/list";
		return html;
	}
	
	@RequestMapping("/create")
	public String createProfile(HttpServletRequest request, Model model) {
		int idProfile = Integer.valueOf(request.getParameter("idProfile"));
		String namaMahasiswa = request.getParameter("namaMahasiswa");
		String nomorHp = request.getParameter("nomorHp");
		String email = request.getParameter("email");
		
		MahasiswaProfileModel mahasiswaProfileModel = new MahasiswaProfileModel();
		mahasiswaProfileModel.setIdProfile(idProfile);	
		mahasiswaProfileModel.setNomorHP(nomorHp);	
		mahasiswaProfileModel.setKd_mhs(namaMahasiswa);
		mahasiswaProfileModel.setEmail(email);
		
		this.mahasiswaProfileService.simpan(mahasiswaProfileModel);
		
		return "/profile/home";
	}
	
	@RequestMapping("/mahasiswa")
	public void bacaMahasiswa(Model model){
		List<MahasiswaModel> mahasiswaModelList = new ArrayList<MahasiswaModel>();
		mahasiswaModelList = this.mahasiswaService.bacaData();
		
		model.addAttribute("mahasiswaModelList", mahasiswaModelList);
	}
}

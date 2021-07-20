package com.kodehive.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Mahasiswa_Profile")
public class MahasiswaProfileModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_Profile")
	private int idProfile;
	private String nomorHP;
	private String email;
	
	@Column(name="kd_mhs")
	private String kd_mhs;
	
	@ManyToOne
	@JoinColumn(name="kd_mhs", insertable=false, updatable=false)
	private MahasiswaModel mahasiswaModel;
	
	public String getKd_mhs() {
		return kd_mhs;
	}
	public void setKd_mhs(String kd_mhs) {
		this.kd_mhs = kd_mhs;
	}
	public MahasiswaModel getMahasiswaModel() {
		return mahasiswaModel;
	}
	public void setMahasiswaModel(MahasiswaModel mahasiswaModel) {
		this.mahasiswaModel = mahasiswaModel;
	}
	public int getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}
	public String getNomorHP() {
		return nomorHP;
	}
	public void setNomorHP(String nomorHP) {
		this.nomorHP = nomorHP;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}

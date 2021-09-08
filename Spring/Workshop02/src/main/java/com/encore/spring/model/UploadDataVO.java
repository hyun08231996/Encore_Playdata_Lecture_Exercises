package com.encore.spring.model;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

/*
 * 파일 업로드 폼을 잘 보고 만들어야 한다
 */
public class UploadDataVO {
	private String userName;
	private List<MultipartFile> uploadFile; //uploadFile이름으로 해야지만 파일 정보를 담을 수 있다.
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<MultipartFile> getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(List<MultipartFile> uploadFile) {
		this.uploadFile = uploadFile;
	}
	

	
	
}

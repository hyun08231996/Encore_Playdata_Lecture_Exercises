package com.encore.pms.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.encore.pms.dto.Phone;
import com.encore.pms.service.IPhoneService;

@RestController
public class PhoneRestController {
	
	@Autowired
	private IPhoneService iPhoneService;
	
	/*
	 * 1. 모든 폰 정보 리턴
	 * 2. 특정 num에 해당하는 폰 리턴
	 * 3. 폰 추가하기
	 * 4. 폰 수정하기
	 * 5. 여러개의 폰 삭제하기
	 * 
	 * RestService API 사용해서 직접 작성
	 * --> Post Man으로 값 일일이 넣어서 확인
	 */
	
	@GetMapping("phone")
	public ResponseEntity<List<Phone>> getAllPhone(){
		try {
			List<Phone> phones = iPhoneService.select();
			return new ResponseEntity<List<Phone>>(phones,HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<List<Phone>>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("phone/{num}")
	public ResponseEntity<Phone> getPhoneByNum(@PathVariable String num){
		try {
			Phone phone = new Phone();
			phone.setNum(num);
			Phone selected = iPhoneService.select(phone);
			
			return new ResponseEntity<Phone>(selected,HttpStatus.OK);
			
		}catch(RuntimeException e) {
			return new ResponseEntity<Phone>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PostMapping("phone")
	public ResponseEntity<Phone> insertPhone(@RequestBody Phone phone){
		try {
			int result = iPhoneService.insert(phone);
			return new ResponseEntity<Phone>(HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<Phone>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@PutMapping("phone")
	public ResponseEntity<Phone> updatePhone(@RequestBody Phone phone) throws Exception{
		boolean check = iPhoneService.update(phone);
		
		if(!check) {
			System.out.println(new ResponseEntity<Phone>(HttpStatus.NO_CONTENT));
			return new ResponseEntity<Phone>(HttpStatus.NO_CONTENT);
		}
		else return new ResponseEntity<Phone>(HttpStatus.OK);
	}
	
	@DeleteMapping("phone/{num}")
	public ResponseEntity<List<Phone>> deletePhone(@PathVariable String[] num){
		try {
//			for(int i=0;i<num.length;i++) {
//				System.out.println(num[i]);
//			}
			List<String> list = Arrays.asList(num);
			//System.out.println(list);
			int result = iPhoneService.delete(list);
			return new ResponseEntity<List<Phone>>(HttpStatus.OK);
		}catch(Exception e) {
			System.out.println(new ResponseEntity<List<Phone>>(HttpStatus.NO_CONTENT));
			return new ResponseEntity<List<Phone>>(HttpStatus.NO_CONTENT);
		}
	}
}

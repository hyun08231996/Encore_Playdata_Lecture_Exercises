package com.encore.emp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.emp.domain.DepartmentDto;
import com.encore.emp.domain.EmployeeDto;
import com.encore.emp.service.EmpService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/*
 * 1. findAllEmployees  : 모든 사원의 정보를 반환한다
 * 2. getEmployeesTotal : 모든 사원의 총 인원수를 반환한다.
 * 3. findEmployeeById  : 사원아이디로 사원의 정보를 찾는다
 * 4. findLikeEmployees : 특정한 이름이 들어간 사원을 찾는다
 * 5. findEmployeesByManagerId : 특정한 매니저에 소속된 사원들을 찾는다
 * 6. addEmployee       : 특정한 사원을 추가한다
 * 7. updateEmployee    : 사원의 정보를 수정한다
 * 8. deleteEmployee    : 해당 사원의 정보를 삭제한다
 * 
 * --> PostMan Tool을 사용해서 로직들이 잘 작성되었는지 확인.
 */

@RestController
@RequestMapping("api")
@CrossOrigin(origins= {"*"}, maxAge= 6000)
@Api(tags= {"Encore HRM"})
public class EmployeeController {

	@Autowired
	private EmpService service;
	
	@ApiOperation(value="모든 사원의 정보를 반환한다", response=List.class)
	@GetMapping("findAllEmployees")
	public ResponseEntity<List<EmployeeDto>> findAllEmployees(Model model) throws Exception{
		List<EmployeeDto> emps = service.findAllEmployees();
		
		//model.addAttribute("list", emps);
		
		if(emps.isEmpty()) return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
	
	@ApiOperation(value="모든 사원의 총 인원수를 반환한다", response=Integer.class)
	@GetMapping("getEmployeesTotal")
	public ResponseEntity<Integer> getEmployeesTotal() throws Exception{
		int total = service.getEmployeesTotal();
		
		if(total==0) return new ResponseEntity<Integer>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<Integer>(total, HttpStatus.OK);
	}
	
	@ApiOperation(value="사원아이디로 사원의 정보를 찾는다", response=EmployeeDto.class)
	@GetMapping("findEmployeeById/{id}")
	public ResponseEntity<EmployeeDto> findEmployeeById(@PathVariable int id) throws Exception{
		EmployeeDto emp = service.findEmployeeById(id);
		
		if(emp==null) return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<EmployeeDto>(emp, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 이름이 들어간 사원을 찾는다", response=List.class)
	@GetMapping("findLikeEmployees/{name}")
	public ResponseEntity<List<EmployeeDto>> findLikeEmployees(@PathVariable String name) throws Exception{
		List<EmployeeDto> emps = service.findLikeEmployees(name);
		//System.out.println(emps);
		
		if(emps.isEmpty()) return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 매니저에 소속된 사원들을 찾는다", response=List.class)
	@GetMapping("findEmployeesByManagerId/{mgrId}")
	public ResponseEntity<List<EmployeeDto>> findEmployeesByManagerId(@PathVariable int mgrId) throws Exception{
		List<EmployeeDto> emps = service.findEmployeesByManagerId(mgrId);
		
		if(emps.isEmpty()) return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<EmployeeDto>>(emps, HttpStatus.OK);
	}
	
	@ApiOperation(value="특정한 사원을 추가한다", response=EmployeeDto.class)
	@PostMapping("addEmployee")
	public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto emp) throws Exception{
		
		service.addEmployee(emp);
		return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
			
	}
	
	@ApiOperation(value="사원의 정보를 수정한다", response=EmployeeDto.class)
	@PutMapping("updateEmployee")
	public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto emp) throws Exception{
		boolean check = service.updateEmployee(emp);
		
		if(!check) return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
	}
	
	@ApiOperation(value="해당 사원의 정보를 삭제한다", response=EmployeeDto.class)
	@DeleteMapping("deleteEmployee/{id}")
	public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable int id) throws Exception{
		boolean check = service.deleteEmployee(id);
		
		if(!check) return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<EmployeeDto>(HttpStatus.OK);
	}
	
	//추가
	@ApiOperation(value="사원의 부서정보를 받아온다.", response=Integer.class)
	@GetMapping("/findAllDepartments")
	public ResponseEntity findAllDepartments() {
	   try {
	      List<DepartmentDto> depts = service.findAllDepartments();
	      return new ResponseEntity(depts, HttpStatus.OK);
	   }catch (Exception e) {
	      return new ResponseEntity(HttpStatus.NO_CONTENT);
	   }
	}
	
	//추가...findAllTitles
	@ApiOperation(value="사원의 직책정보를 받아온다.", response=List.class)
	@GetMapping("/findAllTitles")
	public ResponseEntity findAllTitles() {
	   try {
	      List<EmployeeDto> emps = service.findAllTitles();
	      return new ResponseEntity(emps, HttpStatus.OK);
	   }catch (Exception e) {
	      return new ResponseEntity(HttpStatus.NO_CONTENT);
	   }
	}
	
}

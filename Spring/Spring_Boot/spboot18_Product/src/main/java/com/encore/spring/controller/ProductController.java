package com.encore.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("api")
@CrossOrigin(origins= {"*"}, maxAge= 6000)
@Api(tags= {"Encore HRM"})
public class ProductController {

	@Autowired
	private MyProductService myProductService;
	
	@ApiOperation(value="제품을 추가한다", response=MyProduct.class)
	@PostMapping("addProduct")
	public ResponseEntity<MyProduct> addProduct(@RequestBody MyProduct pvo) throws Exception{
		boolean check = myProductService.addProduct(pvo);

		if(!check) return new ResponseEntity<MyProduct>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<MyProduct>(HttpStatus.OK);
	}
	
	@ApiOperation(value="제품을 이름 또는 메이커로 검색한다", response=List.class)
	@GetMapping("searchProducts/{command}/{word}")
	public ResponseEntity<List<MyProduct>>  searchProducts
	(@PathVariable String command, @PathVariable String word) throws Exception{

		List<MyProduct> list = null;
		
		try{
			if(command.equals("getProductsByName")) {
				list = myProductService.getProductsByName(word);
			} else if(command.equals("getProductsByMaker")) {
				list = myProductService.getProductsByMaker(word);
			}
			return new ResponseEntity<List<MyProduct>>(list,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<List<MyProduct>>(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value="모든 제품을 검색한다", response=List.class)
	@GetMapping("searchAllProducts")
	public ResponseEntity<List<MyProduct>> searchAllProducts() throws Exception{
		List<MyProduct> list = myProductService.getProductList();
		
		if(list.isEmpty()) return new ResponseEntity<List<MyProduct>>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<List<MyProduct>>(list,HttpStatus.OK);
	}
	
	@ApiOperation(value="제품을 수정한다", response=MyProduct.class)
	@PutMapping("updateProduct")
	public ResponseEntity<MyProduct> updateProduct(@RequestBody MyProduct pvo) throws Exception{
		boolean check = myProductService.updateProduct(pvo);

		if(!check) return new ResponseEntity<MyProduct>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<MyProduct>(HttpStatus.OK);
	}
	
	@ApiOperation(value="제품을 삭제한다", response=MyProduct.class)
	@DeleteMapping("deleteProduct/{id}")
	public ResponseEntity<MyProduct> deleteProduct(@PathVariable int id) throws Exception{
		boolean check = myProductService.deleteProduct(id);

		if(!check) return new ResponseEntity<MyProduct>(HttpStatus.NO_CONTENT);
		else return new ResponseEntity<MyProduct>(HttpStatus.OK);
	}
}

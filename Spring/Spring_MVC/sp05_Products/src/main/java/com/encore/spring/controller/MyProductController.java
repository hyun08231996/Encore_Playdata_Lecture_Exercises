package com.encore.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.domain.MyProduct;
import com.encore.spring.model.MyProductService;

@Controller
public class MyProductController {

	@Autowired
	private MyProductService myProductService;
	
//	@RequestMapping(value="myProduct.do",method=RequestMethod.POST)
	@RequestMapping("myProduct.do")
	public ModelAndView insert(MyProduct pvo) throws Exception{
		myProductService.addProduct(pvo);
		System.out.println(pvo+" 추가 완료!");

		List<MyProduct> list = myProductService.getProductList();
		return new ModelAndView("productList", "list", list);
	}
	
//	@RequestMapping("idSearch.do")
//	public ModelAndView idSearch(String id) throws Exception{
//		Product product = productService.getProduct(Integer.parseInt(id));
//
//		return new ModelAndView("WEB-INF/views/idSearch.jsp", "product", product);
//	}
//	
//	@RequestMapping("nameSearch.do")
//	public ModelAndView nameSearch(String name) throws Exception{
//		List<Product> nameList = productService.getProductsByName(name);
//
//		return new ModelAndView("WEB-INF/views/nameSearchList.jsp", "nameList", nameList);
//	}
//	
//	@RequestMapping("makerSearch.do")
//	public ModelAndView makerSearch(String maker) throws Exception{
//		List<Product> makerList = productService.getProductsByMaker(maker);
//
//		return new ModelAndView("WEB-INF/views/makerSearchList.jsp", "makerList", makerList);
//	}
	
//	@RequestMapping("mySearch.do")
//	public ModelAndView getProducts(String word, String choice) throws Exception{
//		Map map = new HashMap();
//		
//		map.put("choice",choice);
//		map.put("word",word);
//		
//		List<Product> list = productService.searchProduct(map);
//	
//		return new ModelAndView("WEB-INF/views/productList.jsp", "list", list);
//	}
	
	@RequestMapping("mySearch.do")
	public ModelAndView getProducts(String word, String choice) throws Exception{
		String viewName = "";
		List<MyProduct> list = null;
		
		if(choice.equals("id")) {
			MyProduct product = myProductService.getProduct(Integer.parseInt(word));
			return new ModelAndView("idSearch", "product", product);
		} else if(choice.equals("name")) {
			list = myProductService.getProductsByName(word);
		} else if(choice.equals("maker")) {
			list = myProductService.getProductsByMaker(word);
		}
		
		return new ModelAndView("productList", "list", list);
	}
	
	@RequestMapping("myProductUpdate.do")
	public ModelAndView update(MyProduct pvo) throws Exception{
		myProductService.updateProduct(pvo);

		List<MyProduct> list = myProductService.getProductList();
		return new ModelAndView("productList", "list", list);
	}
	
	@RequestMapping("myProductDelete.do")
	public ModelAndView delete(String id) throws Exception{
		myProductService.deleteProduct(Integer.parseInt(id));

		List<MyProduct> list = myProductService.getProductList();
		return new ModelAndView("productList", "list", list);
	}
}

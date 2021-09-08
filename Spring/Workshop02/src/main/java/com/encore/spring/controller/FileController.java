package com.encore.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.model.UploadDataVO;

@Controller
public class FileController {
	
	@RequestMapping("multifileupload.do")
	public ModelAndView multifileupload(HttpServletRequest request, UploadDataVO vo) throws Exception{
		// 1. 업로드된 파일의 정보를 가지고 있는 MultipartFile을 하나 받아온다... vo에서
		List<MultipartFile> mFileList = vo.getUploadFile();
		System.out.println("mFileList :: "+mFileList);
		//String[] nameList = new String[mFileList.size()];
		List<String> nameList = new ArrayList<String>();
		
		//int count = 0;
		for(MultipartFile mFile : mFileList) {
			/*
			 * 2. 업로드된 파일이 있다면
			 * 	     파일의 사이즈
			 *    업로드한 파일의 이름
			 *    업로드한 파일의 파라미터명?
			 */
			if((mFile.isEmpty())!=true) {//업로드된 파일이 있다면
				System.out.println("파일의 사이즈 :: "+mFile.getSize());
				System.out.println("업로드된 파일명 :: "+ mFile.getOriginalFilename());
				System.out.println("파일의 파라미터명 :: "+mFile.getName());
			}
			
			// 3. 업로드한 ㅍ파일을 지정한 경로에다 copy해서 이동시킴.../upload/copy해온 파일이 저장됨
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println("ROOT :: "+root);
			String path = root+"\\upload\\";
			
			// 4. File객체 생성...mFile.transferTo()
			File copyFile = new File(path+mFile.getOriginalFilename());
			mFile.transferTo(copyFile); // 업로드한 파일의 카피본이 해당경로에 저장된다...이동한다
			System.out.println("path :: "+path);
			
			//nameList[count++] = mFile.getOriginalFilename();
			nameList.add(mFile.getOriginalFilename());
		}
		
		
		return new ModelAndView("upload_result","uploadfiles",nameList);
	}
	
	@RequestMapping("multifileupload2.do")
	public ModelAndView multifileupload2(MultipartHttpServletRequest mRequest, HttpServletRequest request) throws Exception{
		// 1. 업로드된 파일의 정보를 가지고 있는 MultipartFile을 하나 받아온다... MultipartHttpServletRequest통해서
		List<MultipartFile> mFileList = mRequest.getFiles("file");
		System.out.println("mFileList :: "+mFileList);
		String[] nameList = new String[mFileList.size()];
		
		int count = 0;
		for(MultipartFile mFile : mFileList) {
			/*
			 * 2. 업로드된 파일이 있다면
			 * 	     파일의 사이즈
			 *    업로드한 파일의 이름
			 *    업로드한 파일의 파라미터명?
			 */
			if((mFile.isEmpty())!=true) {//업로드된 파일이 있다면
				System.out.println("파일의 사이즈 :: "+mFile.getSize());
				System.out.println("업로드된 파일명 :: "+ mFile.getOriginalFilename());
				System.out.println("파일의 파라미터명 :: "+mFile.getName());
			}
			
			// 3. 업로드한 ㅍ파일을 지정한 경로에다 copy해서 이동시킴.../upload/copy해온 파일이 저장됨
			String root = request.getSession().getServletContext().getRealPath("/");
			System.out.println("ROOT :: "+root);
			String path = root+"\\upload\\";
			
			// 4. File객체 생성...mFile.transferTo()
			File copyFile = new File(path+mFile.getOriginalFilename());
			mFile.transferTo(copyFile); // 업로드한 파일의 카피본이 해당경로에 저장된다...이동한다
			System.out.println("path :: "+path);
			
			nameList[count++] = mFile.getOriginalFilename();
		}
		
		
		return new ModelAndView("upload_result","uploadfiles",nameList);
	}
		
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(HttpServletRequest request, String filename) throws Exception{
		System.out.println("filename :: "+filename);
		String root = request.getSession().getServletContext().getRealPath("/");
		String path = root+"\\upload\\";
		
		HashMap map = new HashMap();
		map.put("path",path);
		return new ModelAndView("downloadView",map);
	}
}

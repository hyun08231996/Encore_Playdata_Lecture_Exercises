package com.encore.spring.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.encore.spring.Board;
import com.encore.spring.BoardService;
import com.encore.spring.UploadDataVO;


@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@RequestMapping("boardInput.do")
	public ModelAndView boardInput() {		
		System.out.println("boardInput.do method in");
		//게시판 입력폼인 board/boardInsert.jsp로 결과 페이지 연결한다.
		return new ModelAndView("boardInsertPage");
	}

	@RequestMapping("boardInsert.do")
	public ModelAndView boardInsert(Board board, HttpServletRequest request, UploadDataVO vo)
			throws Exception {		
		// 1. 업로드된 파일의 정보를 가지고 있는 MultipartFile을 하나 받아온다... vo에서
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("mFile :: "+mFile);
		
		//2. 업로드된 파일이 있다면
//		if((mFile.isEmpty())!=true) {//업로드된 파일이 있다면
//			System.out.println("파일의 사이즈 :: "+mFile.getSize());
//			System.out.println("업로드된 파일명 :: "+ mFile.getOriginalFilename());
//			System.out.println("파일의 파라미터명 :: "+mFile.getName());
//		}
		
		// 3. 업로드한 ㅍ파일을 지정한 경로에다 copy해서 이동시킴.../upload/copy해온 파일이 저장됨
		String root = request.getSession().getServletContext().getRealPath("/");
		System.out.println("ROOT :: "+root);
		String path = root+"\\upload\\";
		
		// 4. File객체 생성...mFile.transferTo()
		
		try {
			if((mFile.getOriginalFilename().isEmpty())!=true) {
				File copyFile = new File(path+mFile.getOriginalFilename());
				mFile.transferTo(copyFile); // 업로드한 파일의 카피본이 해당경로에 저장된다...이동한다
				System.out.println("path :: "+path);
				board.setFilename(mFile.getOriginalFilename());
			}
			//throw new Exception("test");
			
			boardService.insert(board);
			
			return new ModelAndView("redirect:boardList.do");
		}catch(Exception e) {
			System.out.println(e);
			return new ModelAndView("errorPage","msg","게시글 저장 중 오류 발생!!");
		}
		
	}

	@RequestMapping("boardList.do")
	public ModelAndView boardList() throws Exception {
		System.out.println("boardList.do method in");
		
		try {
			List<Board> list = boardService.selectAll();
			return new ModelAndView("boardList","list",list);
		}catch(Exception e) {
			System.out.println(e);
			return new ModelAndView("errorPage","msg","게시판 리스트 불러오는 중 오류 발생!!");
		}
		
		
	}

	@RequestMapping("boardDetail.do")
	public ModelAndView boardDetail(String no) throws Exception {
		System.out.println("boardDetail.do method in");	
		
		try {
			Board board = boardService.selectOne(Integer.parseInt(no));
			return new ModelAndView("boardDetail","vo",board);
		}catch(Exception e) {
			System.out.println(e);
			return new ModelAndView("errorPage","msg","게시판 디테일 불러오는 중 오류 발생!!");
		}
		
	}
	
	@RequestMapping("fileDown.do")
	public ModelAndView filedown(HttpServletRequest request, String filename) throws Exception{
		System.out.println("filename :: "+filename);
		try {
			String root = request.getSession().getServletContext().getRealPath("/");
			String path = root+"\\upload\\";
			HashMap map = new HashMap();
			map.put("path",path);
			return new ModelAndView("downloadView",map);
		}catch(Exception e) {
			System.out.println(e);
			return new ModelAndView("errorPage","msg","파일 다운로드 중 오류 발생!!");
		}
		
	}
}

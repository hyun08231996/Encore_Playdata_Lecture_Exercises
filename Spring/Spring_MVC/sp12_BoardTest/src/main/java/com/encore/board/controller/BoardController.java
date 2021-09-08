package com.encore.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.encore.board.domain.BoardVO;
import com.encore.board.domain.MemberVO;
import com.encore.board.model.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("write.do")
	public String write(BoardVO bvo, HttpSession session, Model model) throws Exception{
		MemberVO mvo = (MemberVO) session.getAttribute("mvo");
		if(session.getAttribute("mvo")==null) { //로그인 상태가 아니다..
			return "redirect:index.jsp";
		}
		
		bvo.setMemberVO(mvo);
		model.addAttribute("bvo", bvo);
		boardService.write(bvo);
		
		return "board/show_content";
	}
	
	@RequestMapping("list.do")
	public String showList(Model model) throws Exception{
		List<BoardVO> list = null;
		try {
			list = boardService.getBoardList();
			//System.out.println(list);
			model.addAttribute("list", list);
			return "board/list";
		}catch(Exception e) {
			return "Error";
		}
		
		
	}
	
	@RequestMapping("showContent.do")
	public String showContent(Model model, HttpServletRequest request) throws Exception{
		int no = Integer.parseInt(request.getParameter("no"));
		BoardVO rvo = null;
		//System.out.println(no);
		try {
			rvo = (BoardVO) boardService.showContent(no);

			model.addAttribute("bvo", rvo);
			return "board/show_content";
		}catch(Exception e) {
			return "Error";
		}
		
		
	}
	
	@RequestMapping("delete.do")
	public String delete(Model model, HttpServletRequest request) throws Exception{
		int no = Integer.parseInt(request.getParameter("no"));
		//System.out.println(no);
		try {
			boardService.delete(no);
			return "redirect:list.do";
		}catch(Exception e) {
			return "Error";
		}
	}
	
	@RequestMapping("updateView.do")
	public String update(HttpServletRequest request, Model model) throws Exception{
		
		try {
			int no = Integer.parseInt(request.getParameter("no"));
			BoardVO rvo = boardService.showContent(no);
			
			model.addAttribute("bvo", rvo);
			
			return "board/update";
		}catch(Exception e) {
			return "Error";
		}
		
		
	}
	
	@RequestMapping("updateBoard.do")
	public String updateBoard(BoardVO bvo) throws Exception{
		
		boardService.update(bvo);
		
		return "redirect:list.do";
	}
}

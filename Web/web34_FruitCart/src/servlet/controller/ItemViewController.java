package servlet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.Item;
import com.encore.model.ItemDao;

public class ItemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemNumber = Integer.valueOf(request.getParameter("itemNumber"));
		
		ItemDao.getInstance().updateRecordCount(itemNumber);
		Item item = ItemDao.getInstance().getItem(itemNumber);
		
		
		//오늘본 상품정보를 쿠키에 저장하는 로직을 추가...
		// 1) 쿠키생성("key", "value")  2) 쿠키 저장 시간을 24시간으로 지정 setMaxAge()  3) 정보가 저장된 쿠키를 클라이언트로 보냄
		
		Cookie cookie = new Cookie("fruitshop"+itemNumber, item.getUrl()); //1) key값은 unique해야한다
		cookie.setMaxAge(24*60*60); //2)
		response.addCookie(cookie);
		
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}

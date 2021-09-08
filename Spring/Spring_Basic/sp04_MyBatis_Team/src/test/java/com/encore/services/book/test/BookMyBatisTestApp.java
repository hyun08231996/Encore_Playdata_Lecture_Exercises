package com.encore.services.book.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.encore.services.book.BookService;
import com.encore.services.domain.Book;


/*
 * FactoryService를 모듈화 시켜놓고 그걸 호출하는 구조
 * 최종 테스트 버전. 이걸로 하삼 팀작업할때
 * */
public class BookMyBatisTestApp {
	public static void main(String[] args) throws Exception{
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/config/bookservice.xml"	 }
									                                                    );
		//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
		BookService bookService = (BookService)context.getBean("myBatisBookServiceImpl");
		
		Book book = new Book(25000, "05","BookC","만화", "한국", "2021-01-18", "출판사", "작가B", "원", "꿀잼");		
		
		
//		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
//		System.out.println(":: 1. add(INSERT)  ? ");
//		bookService.bookAdd(book);
//		
//		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
//		book = bookService.getBook("05");
//		System.out.println(":: 2. get(SELECT)  ? "+book);
//		
//		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
//		book.setPrice(27000);
//		System.out.println(":: 3. update(UPDATE)  ? ");
//		bookService.bookUpdate(book);
//		
//		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
//		book = bookService.getBook("05");
//		System.out.println(":: 4. get(SELECT)  ? "+book);
//
//		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
//		//==> BookService 에는 bookDelete가 없으므로, DAO에서 직접 호출 Test
//		BookDAO bookDAO = (BookDAO)context.getBean("myBatisBookDAOImpl");
//		System.out.println(":: 5. remove(DELETE)  ? "+ bookDAO.bookDelete("05"));
//		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		System.out.println(":: 6. all Book(SELECT)  ? ");
		List<Book> list = bookService.getBookList(new Book());
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
//		//1. User10.addUser Test  :: users table age/grade/redDate 입력값 확인할것 : OK 
//		System.out.println(":: 1. addBook(INSERT)  ? "
//													+ session.insert("bookMapper.bookAdd",vo)); //1
//													  session.commit();
//		//2. User10.getUser Test :: 주몽 inert 확인 
//		System.out.println(":: 2. getBook(SELECT)  ? ");
//		System.out.println(":: "+session.selectOne("bookMapper.getBook",vo.getIsbn()) );
//		
//		
//		//3. User10.uadateUser Test  :: users table age/redDate 입력값 확인할것 : OK
//		//                                                    :: 주몽 ==> 온달 수정
//		vo.setTitle("BOOKE");
//		System.out.println(":: 3. update(UPDATE)  ? "
//													+ session.update("bookMapper.bookUpdate",vo));//1
//											  		  session.commit();
//		 
//		//4. User10.getUserList Test  :: Dynamic Query 확인 id=user04/name=온달 검색
//		System.out.println(":: 4. getBookList(SELECT)  ? ");
//		TestUtil.printList( (List)session.selectList("bookMapper.getBookList",vo) );
//		
//		//5. User10.removeUser Test
//		System.out.println(":: 5. mybookMapper.removeUser (DELETE)  ? "
//								+session.delete("bookMapper.bookDelete",vo.getTitle()) );//1
//								 session.commit();
//		
//		//6. User10.getUserList Test  :: Dynamic Query 확인 id=user04/name=온달 검색
//		System.out.println(":: 6. getBookList(SELECT)  ? ");
//		System.out.println(vo);
//		TestUtil.printList((List) session.selectList("bookMapper.getBookList",vo) ); //이때 위의 기능 리턴타입이 0인걸 확인하자
//	
//		//7. User10.getUserList Test  :: Dynamic Query 확인 id=null/name=null 인경우
//		vo.setIsbn(null);
//		vo.setTitle(null);
//		System.out.println(":: 7. getBookList(SELECT)  ? ");
//		TestUtil.printList( (List) session.selectList("bookMapper.getBookList",vo) );
//		
//		########## 30000원 보다 작은 가격의 책 검색 ############
//		TestUtil.printList( (List) session.selectList("bookMapper.priceList",30000) );
//		########## 30000원 보다 큰 가격의 책 검색 ############
//		TestUtil.printList( (List) session.selectList("bookMapper.priceList2",30000) );
//		########## 출판사 기준으로 책 찾기 #####################
//		TestUtil.printList( (List) session.selectList("bookMapper.getBookPublisher","출판사") );
//		########## 작가 기준으로 책 찾기 ####################
//		TestUtil.printList( (List) session.selectList("bookMapper.getBookAuthor","작가B") );
		
//		session.insert("bookMapper.bookAdd", vo);
//		session.commit();	//DML일떄는 반드시 commit 해줘야 한다.
//		
//		session.close();
//		
//		System.out.println(vo.getTitle()+"책 등록 성공!");
		
//		System.out.println("==================Get All Books========================");
//		// Get List
//		List<MyBook> list = session.selectList("bookMapper.bookList");
//		System.out.println(list);
//		
//		System.out.println("\n==================Get One Book========================");
//		// Get One book
//		MyBook myBook = session.selectOne("bookMapper.bookOne", "1");		
//		System.out.println("One book! "+ Book);
//		
//		System.out.println("\n==================Update========================");
//		// Update
//        session.update("bookMapper.bookUpdate", vo);
//        session.commit();
////        session.close();
//        System.out.println(vo.getTitle()+"책 수정 성공!");
//		
//		
//		System.out.println("\n==================Delete========================");
//		// Delete
//        session.delete("bookMapper.bookDelete", "1");
//        session.commit();
//        session.close();
//        System.out.println("책 삭제 성공!");
		
	}
}

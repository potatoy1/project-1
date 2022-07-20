package group3.borrow;

import java.util.List;

import group3.BookManagementSystemApplication;
import group3.join.JoinMemberVO;


public class BorrowController {

	  private static BorrowController instance = new BorrowController();
	    public static BorrowController getInstance() {
	        return instance;
	    }
	  
	   private BorrowController() {}
	   
	   private BorrowService service = BorrowService.getInstance();

	   private JoinMemberVO session = BookManagementSystemApplication.getSession();

	    public List<BorrowVO> findAll() {
	        return service.findAll(session.getMemId());
	    }
	 //대여
	   public int borrBook(int bookNum) {
		   if (session.getMemDiv().equals("대전")) {
			   return service.borrBook2(session.getMemId(), bookNum);
		   } else {
			   return service.borrBook(session.getMemId(), bookNum);
		   }
	   }
		public int bookSelect(int num) {
			return service.borrowSelect(num);
		}
	//반납	    
	  public int returnBook(int deleteNum) {
		  return service.returnBook(deleteNum);
	  }

	  public int borrowRentSelect(int bookNum) {
          return service.borrowRentSelect(bookNum);
       }
	// 연장
	  public int extendBook(int extendNum) {
		  return service.extendBook(extendNum);
	  }
	//연체
	  public List<BorrowVO> overduelist() {
	       return service.overduelist(session.getMemId());
	    }
}

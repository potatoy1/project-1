package group3.borrow;

import java.util.List;

import group3.sign.SignController;



public class BorrowService {

	private static BorrowService instance = new BorrowService();
    public static BorrowService getInstance() {
        return instance;
    }
    
    private BorrowService() {}

    private BorrowDAO dao = BorrowDAO.getInstance();

    public List<BorrowVO> findAll(String memtId) {
        return dao.findAll(memtId);
    }
    

	
    // 대여
	public int borrBook(String memId, int bookNum) {
        BorrowVO borrowVO = dao.searchBook(bookNum);
        if (borrowVO == null) {
           return dao.borrBook(memId, bookNum);
       } else {
          return 0;
       }
     }	
	public int borrowSelect(int num) {
		return dao.borrowSelect(num);
	}
	public int borrBook2(String memId, int bookNum) {
        BorrowVO borrowVO = dao.searchBook(bookNum);
        if (borrowVO == null) {
           return dao.borrBook2(memId, bookNum);
       } else {
          return 0;
       }
     }	
	//반납	
	public int returnBook(int deleteNum) {
		return dao.returnBook(deleteNum);
	}
    public int borrowRentSelect(int bookNum) {
        return dao.borrowRentSelect(bookNum);
    }
    //연장
	public int extendBook(int extendBook) {
		return dao.extendBook(extendBook);
	}
	//연체
	public List<BorrowVO> overduelist(String memtId) {
        return dao.overduelist(memtId);
    }
    
}

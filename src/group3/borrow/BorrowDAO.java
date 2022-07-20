package group3.borrow;


import group3.BookManagementSystemApplication;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class BorrowDAO {

	private static BorrowDAO instance = new BorrowDAO();
    public static BorrowDAO getInstance() {
        return instance;
    }
    
    private BorrowDAO() {   	
    }
    
    private JdbcTemplate template = BookManagementSystemApplication.getTemplate();
	
    public List<BorrowVO> findAll(String memId) {
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT A.MEM_ID, B.BOOK_NUM, C.BOOK_TT, C.ATH ,B.BORR_DATE, B.BORR_END_DATE");
        builder.append(" FROM  MEM A ");
        builder.append("  INNER JOIN BORR B");
        builder.append("  ON (A.MEM_ID =B.MEM_ID)");        
        builder.append("  INNER JOIN BOOK C");
        builder.append("  ON (B.BOOK_NUM=C.BOOK_NUM)");
        builder.append(" WHERE A.MEM_ID = ?");
        builder.append(" ORDER BY B.BORR_DATE, B.BORR_END_DATE");
        
        return template.query(builder.toString(), new BeanPropertyRowMapper<>(BorrowVO.class), memId);
    }
    // 대여
    public int borrBook(String memId, int bookNum) {
		return template.update("INSERT INTO BORR(MEM_ID, BOOK_NUM, BORR_EXTE_CNT, BORR_END_DATE, BORR_DATE) VALUES(?, ? ,3 ,sysdate + 5, sysdate)", memId, bookNum);
    }
    public int borrBook2(String memId, int bookNum) {
		return template.update("INSERT INTO BORR(MEM_ID, BOOK_NUM, BORR_EXTE_CNT, BORR_END_DATE, BORR_DATE) VALUES(?, ? ,3 ,sysdate + 10, sysdate)", memId, bookNum);
    }
    public int borrowSelect(int bookNum) { // 대여 시 도서현황(ASCERTAIN) 대출중
    	return template.update("UPDATE BOOK SET ASCERTAIN= '대출중' WHERE BOOK_NUM = ?", bookNum);
    }

    public BorrowVO searchBook(int bookNum) {
    	return DataAccessUtils.singleResult(template.query("SELECT MEM_ID, BOOK_NUM, BORR_EXTE_CNT, BORR_END_DATE, BORR_DATE, BORR_OVE_DATE FROM BORR WHERE BOOK_NUM = ?", new BeanPropertyRowMapper<>(BorrowVO.class), bookNum)); 
    }
    //반납
    public int returnBook(int deleteNum) {
    	return template.update("DELETE FROM BORR WHERE BOOK_NUM = ? ", deleteNum);
    }
    public int borrowRentSelect(int bookNum) { // 대여 시 도서현황(ASCERTAIN) 대출가능
    	return template.update("UPDATE BOOK SET ASCERTAIN= '대출가능' WHERE BOOK_NUM = ?", bookNum);
    }
    //연장
	public int extendBook(int extend) {
		return template.update("UPDATE BORR SET BORR_END_DATE = BORR_END_DATE +7, BORR_EXTE_CNT = BORR_EXTE_CNT -1 WHERE BOOK_NUM = ? AND BORR_EXTE_CNT > 0", extend);
	}
	//연체
	public List<BorrowVO> overduelist(String memId) { // 대전아닐시
        StringBuilder builder = new StringBuilder();
        builder.append(" SELECT MEM_ID , BOOK_NUM , BORR_EXTE_CNT , BORR_END_DATE , BORR_DATE , BORR_OVE_DATE ");
        builder.append(" FROM BORR ");
        builder.append("  WHERE BORR_OVE_DATE>0 AND MEM_ID = ?");
        
        return template.query(builder.toString(), new BeanPropertyRowMapper<>(BorrowVO.class), memId);
	}
}

package group3.sign;



import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import group3.BookManagementSystemApplication;
import group3.join.JoinMemberVO;

public class SignDAO {
	 private static SignDAO instance = new SignDAO();
	    public static SignDAO getInstance() {
	        return instance;
	    }
	    private SignDAO() {}

	    private JdbcTemplate template = BookManagementSystemApplication.getTemplate();

	    public JoinMemberVO findUser(JoinMemberVO vo) {
	        try {
	            return template.queryForObject("SELECT MEM_ID, PW, MEM_NM, ADDR, EMAIL, PH, MEM_DIV FROM MEM WHERE MEM_ID = ? AND PW = ?", new BeanPropertyRowMapper<>(JoinMemberVO.class), vo.getMemId(), vo.getPw());
	        } catch (DataAccessException e) {
	            return null;
	        }
	    }
	   
	    public int listupdate(String userId) {
	    	return template.update("UPDATE BORR SET BORR_OVE_DATE = TO_DATE(SYSDATE) - TO_DATE(BORR_END_DATE) WHERE MEM_ID = ?", userId);
	    }
}

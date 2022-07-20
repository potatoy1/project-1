package group3.borrow;

import java.time.LocalDate;
import java.util.Objects;

public class BorrowVO {

	private String memId; // 회원아이디
	private int bookNum; // 도서 순서번호
	private int borrExteCnt; // 대출연장횟수
	private LocalDate borrEndDate; // 대출종료일
	private LocalDate borrDate; // 대출시작일
	private String borrOveDate; // 연체일자
	private String bookTt;
	private String ath;
	
	public BorrowVO() {
	}
	
	public BorrowVO(String memId, int bookNum) {
		this.memId = memId;
		this.bookNum = bookNum;
	}

	public BorrowVO(String memId, int bookNum, int borrExteCnt, LocalDate borrEndDate, LocalDate borrDate,
			String borrOveDate, String bookTt, String ath) {
		
		this.memId = memId;
		this.bookNum = bookNum;
		this.borrExteCnt = borrExteCnt;
		this.borrEndDate = borrEndDate;
		this.borrDate = borrDate;
		this.borrOveDate = borrOveDate;
		this.bookTt = bookTt;
		this.ath = ath;
	}
	public String getMemId() {
		return memId;
	}
	
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	public int getBookNum() {
		return bookNum;
	}
	
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public int getBorrExteCnt() {
		return borrExteCnt;
	}
	
	public void setBorrExteCnt(int borrExteCnt) {
		this.borrExteCnt = borrExteCnt;
	}
	public LocalDate getBorrEndDate() {
		return borrEndDate;
	}

	public void setBorrEndDate(LocalDate borrEndDate) {
		this.borrEndDate = borrEndDate;
	}
	public LocalDate getBorrDate() {
		return borrDate;
	}

	public void setBorrDate(LocalDate borrDate) {
		this.borrDate = borrDate;
	}
	public String getBorrOveDate() {
		return borrOveDate;
	}

	public void setBorrOveDate(String borrOveDate) {
		this.borrOveDate = borrOveDate;
	}

	public String getBookTt() {
		return bookTt;
	}

	public void setBookTt(String bookTt) {
		this.bookTt = bookTt;
	}
	public String getAth() {
		return ath;
	}

	public void setAth(String ath) {
		this.ath = ath;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BorrowVO [");
		if (memId != null)
			builder.append("memId=").append(memId).append(", ");
		builder.append("bookNum=").append(bookNum).append(", borrExteCnt=").append(borrExteCnt).append(", ");
		if (borrEndDate != null)
			builder.append("borrEndDate=").append(borrEndDate).append(", ");
		if (borrDate != null)
			builder.append("borrDate=").append(borrDate).append(", ");
		if (borrOveDate != null)
			builder.append("borrOveDate=").append(borrOveDate).append(", ");
		if (bookTt != null)
			builder.append("bookTt=").append(bookTt).append(", ");
		if (ath != null)
			builder.append("ath=").append(ath);
		builder.append("]");
		return builder.toString();
	}
	

}

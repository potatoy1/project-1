package group3;

import group3.book.BookController;
import group3.common.HomeMenu;
import group3.borrow.BorrowController;
import group3.common.MenuNotFoundException;
import group3.join.JoinController;
import group3.sign.SignController;

public class Home {
	
	    private JoinController joinController = JoinController.getInstance();
	    private BookController bookController = BookController.getInstance();
	    private SignController signController = SignController.getInstance();
	    private BorrowController borrowController = BorrowController.getInstance();

	    private BookManagementSystemView view = BookManagementSystemView.getInstance();

	    public void initialize() throws Exception {
	        home(view.init());
	    }
	    private void home(int number) throws Exception {
	        loop:
	        while (true) {
	            try {
	                HomeMenu menu = HomeMenu.findMenu(number);
	                System.out.print(menu.getMenuString());
	                switch (menu) {
	                    case HOME:
	                    case MYPAGE:
	                    case BORR:
	                    case MEMBER:
	                    case MEMBER_MODIFY_INFO:
	                    case BORR_SELECT:
	                    	number = view.getMenu();
	                    	break;
	                    case JOIN:
	                        number = view.join(joinController);
	                        break;
	                    case LOGIN:
	                        number = view.login(signController);
	                        break;
	                    case LOGOUT:
	                        number = signController.signOut();
	                        break;
	                    case BORR_LIST:
	                    	number = view.borrow(borrowController);
	                        break;
	                    case BOOK_SEARCH:
	                           number = view.searchbook1(bookController);
	                           break;
	                    case SEARCH:
	                        number = view.searchBook(bookController);
	                        break;
	                 
	                    case MEMBER_INFO:
	                        number = view.getMemberInfo(joinController);
	                        break;
	                    case MODIFY_NAME:
	                    case MODIFY_ADDRESS:
	                    case MODIFY_PHONE:
	                    case MODIFY_PW:
	                    case MODIFY_EMAIL:	
	                        number = view.modifyInfo(joinController, menu);
	                        break;
	                    case MEMBER_DELETE:
	                    	number = view.deleteMember(joinController, null, null, menu);
	                    	break;
	                    case BORR_RETURN:
	                    	number = view.returnBook(borrowController, number, menu);
	                    	break;
	                    case BORR_NUMBER:
	                          number = view.borrBook(borrowController, number, menu);	            
	                          break;
	                    case BORR_EXTE:
	                    	number = view.extendBook(borrowController, number, menu);
	                    	break;
	                    case OVERDUE_LIST:
	                    	number = view.overduelist(borrowController);
	                    	break;
	                    case QUIT:
	                        break loop;
	                }
	            } catch (MenuNotFoundException e) {
	                System.out.println(e.getMessage());
	                System.out.print(HomeMenu.HOME.getMenuString());
	            }
	            System.out.println();
	        }
	    }
	}
	
	


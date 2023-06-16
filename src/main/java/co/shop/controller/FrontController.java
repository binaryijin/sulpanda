package co.shop.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.board.command.AjaxSetReple;
import co.shop.board.command.BoardDelete;
import co.shop.board.command.BoardEdit;
import co.shop.board.command.BoardInsert;
import co.shop.board.command.BoardList;
import co.shop.board.command.BoardSearch;
import co.shop.board.command.BoardSelect;
import co.shop.board.command.BoardUpdate;
import co.shop.board.command.BoardWrite;
import co.shop.board.command.ManagerBoard;
import co.shop.board.command.ManagerReple;
import co.shop.board.command.AjaxSetReple;
import co.shop.cart.command.AjaxCartDelete;
import co.shop.cart.command.AjaxCountMinus;
import co.shop.cart.command.AjaxCountPlus;
import co.shop.cart.command.CartInsert;
import co.shop.cart.command.CartList;
import co.shop.cart.command.cart;
import co.shop.common.Command;
import co.shop.main.command.MainCommand;
import co.shop.member.command.AjaxCheckId;
import co.shop.member.command.AjaxMemberDelete;
import co.shop.member.command.MemberUpdate;
import co.shop.member.command.AjaxSearchPw;
import co.shop.member.command.ForgetId;
import co.shop.member.command.ForgetPw;
import co.shop.member.command.Login;
import co.shop.member.command.Logout;
import co.shop.member.command.ManagerUpdateMember;
import co.shop.member.command.MemberInsert;
import co.shop.member.command.MemberLogin;
import co.shop.product.command.ProductModify;
import co.shop.product.command.ProductSelect;
import co.shop.product.command.ProductTraditional;
import co.shop.product.command.ProductWine;
import co.shop.product.command.SearchProduct;
import co.shop.reple.command.AjaxRepleDelete;


import co.shop.product.command.Product;
import co.shop.product.command.ProductBeer;
import co.shop.product.command.ProductInsert;
import co.shop.product.command.ProductInsertForm;
import co.shop.product.command.ProductList;
import co.shop.product.command.ProductList1;
import co.shop.product.command.ProductModify;
import co.shop.product.command.ProductSelect;
import co.shop.product.command.ProductTraditional;
import co.shop.product.command.ProductWine;
import co.shop.reple.command.AjaxRepleDelete;
import co.shop.social.command.AjaxCheckAge;
import co.shop.social.command.NaverCallback;
import co.shop.social.command.NaverLogin;
import co.shop.social.command.SocialLogin;
import co.shop.user.command.ManagerPage;
import co.shop.user.command.UserPage;
import co.shop.userpage.command.UserEditInfo;
import co.shop.userpage.command.UserInfoDeletePass;
import co.shop.userpage.command.UserInfoUpdate;
import co.shop.userpage.command.UserOrderList;



/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();      
    /**
     * @see HttpServlet#HttpServlet()
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/login.do", new Login());
		map.put("/cart.do", new cart());
		map.put("/socialLogin.do", new SocialLogin());
		map.put("/ajaxCheckAge.do", new AjaxCheckAge());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/forgetPw.do", new ForgetPw());
		map.put("/ajaxSearchPw.do", new AjaxSearchPw());
		map.put("/boardList.do", new BoardList());
		map.put("/boardSearch.do", new BoardSearch());
		map.put("/boardWrite.do", new BoardWrite());
		map.put("/boardInsert.do", new BoardInsert());
		map.put("/boardSelect.do", new BoardSelect());
		map.put("/boardEdit.do", new BoardEdit());
		map.put("/boardUpdate.do", new BoardUpdate());
		map.put("/boardDelete.do", new BoardDelete());
		map.put("/forgetId.do", new ForgetId());
		map.put("/logout.do", new Logout());
		
		map.put("/naverLogin.do", new NaverLogin());
		map.put("/naverCallback.do", new NaverCallback());
		map.put("/memberInsert.do", new MemberInsert());
		map.put("/ajaxCheckId.do", new AjaxCheckId());
		map.put("/userpage.do", new UserPage());
		map.put("/managerpage.do",new ManagerPage());
		map.put("/productModify.do", new ProductModify());
		map.put("/product.do", new Product()); //전체상품페이지XXXXXX
		map.put("/productInsertForm.do", new ProductInsertForm()); //제품 등록 폼 호출
		map.put("/productInsert.do", new ProductInsert()); //제품 등록
		map.put("/userorderlist.do", new UserOrderList());
		map.put("/userInfoDeletePass.do", new UserInfoDeletePass()); //유저 정보 삭제(비번창)

		
		map.put("/cartList.do", new CartList());
		map.put("/productList.do", new ProductList()); //전체상품 리스트
		map.put("/productSelect.do", new ProductSelect()); //상품 상세조회

		map.put("/productWine.do", new ProductWine()); //상품 리스트 -와인
		map.put("/productTraditional.do", new ProductTraditional()); //상품 리스트 -전통주
		map.put("/productBeer.do", new ProductBeer()); //상품 리스트 -맥주

		map.put("/searchProduct.do", new SearchProduct());


		map.put("/ajaxRepleDelete.do", new AjaxRepleDelete());
		
		//관리자 페이지
		map.put("/managerBoard.do", new ManagerBoard());
		map.put("/managerReple.do", new ManagerReple());
		map.put("/ajaxSetReple.do", new AjaxSetReple());
		map.put("/userEditInfo.do", new UserEditInfo());
		map.put("/memberUpdate.do", new UserInfoUpdate());
		map.put("/productList1.do", new ProductList1()); //관리자의 전체상품 리스트

		
		//관리자 페이지(이슬)
		map.put("/managerUpdateMember.do", new ManagerUpdateMember());
		map.put("/ajaxMemberDelete.do", new AjaxMemberDelete());
		map.put("/memberUpdate.do", new MemberUpdate());
		
		//카트
		map.put("/ajaxCountMinus.do", new AjaxCountMinus());
		map.put("/ajaxCountPlus.do", new AjaxCountPlus());
		map.put("/ajaxCartDelete.do", new AjaxCartDelete());
		map.put("/cartInsert.do", new CartInsert());

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri= request.getRequestURI();
		String contextPath = request.getContextPath();
		String page = uri.substring(contextPath.length());
		Command command = map.get(page);
		String viewPage = command.exec(request, response);
		
		if(!viewPage.equals("boardList.do?page=1") && !viewPage.endsWith(".do") && !viewPage.contains("naver") && !viewPage.contains("socialLogin.do")) {
			if(viewPage.startsWith("Ajax:")) {
				response.setContentType("text/html; charset = UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			if(viewPage.equals("member/Login")|| viewPage.equals("member/forgetPw")) {
				viewPage = "WEB-INF/views/" + viewPage + ".jsp";
			} else {
				viewPage = viewPage + ".tiles";
				
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage);
		}
	}
	

}
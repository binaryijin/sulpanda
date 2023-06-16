package co.shop.cart.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.shop.cart.service.CartService;
import co.shop.cart.service.CartVO;
import co.shop.cart.serviceImpl.CartServiceImpl;
import co.shop.common.Command;

public class CartList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		CartService CS = new CartServiceImpl();
		List<CartVO> carts = new ArrayList<>();
		carts = CS.cartSelectList();
		
		request.setAttribute("carts", carts);
		return "cart/cartList";
	}

}

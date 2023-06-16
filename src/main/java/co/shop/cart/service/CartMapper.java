package co.shop.cart.service;

import java.util.List;

public interface CartMapper {
	
	List<CartVO> cartSelectList(CartVO vo);
	CartVO cartSelect(CartVO vo);
	int cartInsert(CartVO vo);
	int cartUpdate(CartVO vo);
	int cartMinus(CartVO vo);
	int cartPlus(CartVO vo);
	int cartDelete(CartVO vo);
}

package co.shop.cart.service;

import java.util.List;

public interface CartMapper {
	
	List<CartVO> cartSelectList();
	CartVO cartSelect(CartVO vo);
	int cartInsert(CartVO vo);
	int cartUpdate(CartVO vo);
	int cartDelete(CartVO vo);
}

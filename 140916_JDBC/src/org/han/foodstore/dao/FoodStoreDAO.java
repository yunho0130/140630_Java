package org.han.foodstore.dao;

import org.han.vo.StoreVO;

public interface FoodStoreDAO {
	
	public void create (StoreVO vo)throws Exception;
	
	public StoreVO read(Integer sno)throws Exception;

	public void update(StoreVO vo)throws Exception;

	public void delete(Integer sno)throws Exception;
	
	// �������̽��� implement �ϴ� ���, �׻� �׽�Ʈ �ڵ带 �Բ� ����� ������ ���� ��. 

}
package org.han.foodstore.test;

import static org.junit.Assert.fail;

import org.han.foodstore.dao.FoodStoreDAO;
import org.han.foodstore.dao.FoodStoreDAOImpl;
import org.han.vo.StoreVO;
import org.junit.Before;
import org.junit.Test;

public class FoodStoreDAOTest {
	
	FoodStoreDAO dao;

	@Before
	public void setUp() throws Exception {
		dao = new FoodStoreDAOImpl();
	}

	@Test
	public void testInsert() {
		try{
			StoreVO vo = new StoreVO();
				vo.setSname("����쵿");
				vo.setAddr("���� �߱�....");
				vo.setKeyword("�쵿");
				vo.setSdesc("�� ���� ��ٷ��� ��");
				
				dao.create(vo);
				
		}catch(Exception e){
			fail(e.getMessage());
		}
	}

	@Test
	public void testSelect() {
		StoreVO vo = new StoreVO();
		
		try {
			System.out.println(dao.read(4).toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		
		try {
			dao.delete(3);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	
	@Test
	public void testUpdate() {
		try{
			StoreVO vo = new StoreVO();
				vo.setSname("���õ��");
				vo.setAddr("���� �߱� ������...");
				vo.setKeyword("���");
				vo.setTel("02-1000-1000");
				vo.setSdesc("��� �� �� 1500��");
				vo.setSno(3);
				dao.update(vo);
					
		}catch(Exception e){
			fail(e.getMessage());
		}
	}
	

	
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}

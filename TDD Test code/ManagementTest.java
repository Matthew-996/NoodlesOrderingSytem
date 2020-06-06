import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ManagementTest {

	@Test
	void test() {
		Ramen ramen = new Ramen();
		
		for(int count=0;count!=ramen.getSoup().length;count++)
			assertEquals(1,(ramen.getSoup()[count]));
		
		for(int count=0;count!=ramen.getNoodles().length;count++)
			assertEquals(1,(ramen.getNoodles()[count]));
		
		for(int count=0;count!=ramen.getSpringOnion().length;count++)
			assertEquals(1,(ramen.getSpringOnion()[count]));
		
		for(int count=0;count!=ramen.getNori().length;count++)
			assertEquals(1,(ramen.getNori()[count]));
		
		for(int count=0;count!=ramen.getChashu().length;count++)
			assertEquals(1,(ramen.getChashu()[count]));
		
		for(int count=0;count!=ramen.getBoiledEgg().length;count++)
			assertEquals(1,(ramen.getBoiledEgg()[count]));
		
		for(int count=0;count!=ramen.getSpiciness().length;count++)
			assertEquals(1,(ramen.getSpiciness()[count]));
		
		assertEquals(1,ramen.getExtraBoiledEggPrice());
		assertEquals(1,ramen.getExtraBoiledEgg());
		
		assertEquals(1,ramen.getBambooShootsPrice());
		assertEquals(1,ramen.getBambooShoots());
		
		assertEquals(1,ramen.getExtraChashu());
		assertEquals(1,ramen.getExtraChashuPrice());
		
		assertEquals(1,ramen.getExtraNori());
		assertEquals(1,ramen.getExtraNoriPrice());
		
		ramen = ManagementControl.RamenRead();
		
		ManagementControl mm = new ManagementControl();
		
		mm.setExtraBoiledEggPrice(ramen, 3);
		mm.setExtraChashuPrice(ramen, 2);
		mm.setExtraNoriPrice(ramen, 4);
		mm.setBambooShootsPrice(ramen, 8);
		
		ManagementControl.RamenWrite(ramen);
		ramen = ManagementControl.RamenRead();
	}

}

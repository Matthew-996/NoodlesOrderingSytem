import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void test() {
		CustomerControl cc = new CustomerControl();
		Ticket ticket1 = cc.createTicket();
		ticket1.setSoupChoice(1);
		ticket1.setNoodlesChoice(2);
		ticket1.setSpringOnionChoice(2);
		ticket1.setNoriChoice(1);
		ticket1.setChashuChoice(1);
		ticket1.setBoiledEggChoice(0);
		ticket1.setSpicinessChoice(2);
		ticket1.setExtraNoriChoice(1);
		ticket1.setExtraBoiledEggChoice(0);
		ticket1.setBambooShootsChoice(0);
		ticket1.setExtraChashuChoice(1);
		
		assertEquals(1, cc.getSoupChoice(ticket1));
		assertEquals(2, cc.getNoodlesChoice(ticket1));
		assertEquals(2, cc.getSpringOnionChoice(ticket1));
		assertEquals(1, cc.getNoriChoice(ticket1));
		assertEquals(1, cc.getChashuChoice(ticket1));
		assertEquals(0, cc.getBoiledEggChoice(ticket1));
		assertEquals(2, cc.getSpicinessChoice(ticket1));
		assertEquals(1, cc.getExtraNoriChoice(ticket1));
		assertEquals(0, cc.getExtraBoiledEggChoice(ticket1));
		assertEquals(0, cc.getBambooShootsChoice(ticket1));
		assertEquals(1, cc.getExtraChashuChoice(ticket1));
		cc.generateTicket(ticket1);
	}

}

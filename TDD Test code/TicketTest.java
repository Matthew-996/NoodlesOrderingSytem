import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicketTest {

	@Test
	void test() {
		Ticket ticket = new Ticket(1, 1, 1, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0);
		assertEquals(1, ticket.getSoupChoice());
		assertEquals(1, ticket.getNoodlesChoice());
		assertEquals(1, ticket.getSpringOnionChoice());
		assertEquals(1, ticket.getNoriChoice());
		assertEquals(1, ticket.getChashuChoice());
		assertEquals(1, ticket.getBoiledEggChoice());
		assertEquals(1, ticket.getSpicinessChoice());
		assertEquals(1, ticket.getExtraNoriChoice());
		assertEquals(1, ticket.getExtraBoiledEggChoice());
		assertEquals(1, ticket.getBambooShootsChoice());
		assertEquals(1, ticket.getExtraChashuChoice());
	}

}

package de.itagile.judp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Test;

public class IntegrationTest {

	private static final int PORT = 8123;
	private static final String EXPECTED = "expected";
	private final JudpReceiver receiver = new JudpReceiver(PORT);
	private final JudpSender sender = new JudpSender("127.0.0.1", PORT);

	@Test
	public void receivesWithDefaultPacketSize() throws Exception {
		sender.send(EXPECTED);

		assertEquals(EXPECTED, receiver.receive());
	}

	@Test
	public void receivesNotFullStringWhenPacketSizeTooSmall() throws Exception {
		sender.send(EXPECTED);

		assertFalse(EXPECTED.equals(receiver.receive(2)));
	}

	@After
	public void closeSockets() {
		receiver.close();
		sender.close();
	}
}
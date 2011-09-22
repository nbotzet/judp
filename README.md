Java UDP
========

This library provides a helpful abstraction over Java's built in UDP handling.


See the IntegrationTest for Usage:
<pre>
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
</pre>
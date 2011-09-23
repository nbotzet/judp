package de.itagile.judp;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class JudpSender extends Judp {
	private final InetAddress addressSendTo;
	private final int serverPort;

	public JudpSender(String ip, int serverPort) {
		super(DatagramSocketFactory.create());
		this.serverPort = serverPort;
		this.addressSendTo = createAdress(ip);
		
	}

	public void send(String sendText) throws Exception {
		byte[] sendBytes = sendText.getBytes();
		DatagramPacket packet = new DatagramPacket(sendBytes, sendBytes.length, addressSendTo, serverPort);
		getSocket().send(packet);
	}
	
	private InetAddress createAdress(String ip) {
		try {
			 return InetAddress.getByName(ip);
		} catch (java.net.UnknownHostException e) {
			throw new UnknownHostException(e);
		}
	}
}
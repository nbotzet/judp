package de.itagile.judp;

import java.net.DatagramPacket;
import java.net.InetAddress;

public class JudpSender extends Judp {
	private InetAddress addressSendTo;
	private int serverPort;

	public JudpSender(String ip, int serverPort) {
		super(DatagramSocketFactory.create());
		this.serverPort = serverPort;
		try {
			this.addressSendTo = InetAddress.getByName(ip);
		} catch (java.net.UnknownHostException e) {
			throw new UnknownHostException(e);
		}
	}

	public void send(String sendText) throws Exception {
		byte[] sendBytes = sendText.getBytes();
		getSocket().send(
				new DatagramPacket(sendBytes, sendBytes.length, addressSendTo,
						serverPort));
	}
}
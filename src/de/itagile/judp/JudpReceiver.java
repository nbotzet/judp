package de.itagile.judp;

import java.io.IOException;
import java.net.DatagramPacket;

public class JudpReceiver extends Judp {

	public JudpReceiver(int clientPort) {
		super(DatagramSocketFactory.create(clientPort));
	}

	public void setTimeout(int timeout) throws java.net.SocketException {
		getSocket().setSoTimeout(timeout);
	}

	public String receive() throws Exception {
		return receive(512);
	}

	public String receive(int packetSize) throws IOException {
		byte[] receiceData = new byte[packetSize];
		DatagramPacket datagramPacket = new DatagramPacket(receiceData,
				receiceData.length);
		getSocket().receive(datagramPacket);
		return new String(datagramPacket.getData(), 0, datagramPacket
				.getLength());
	}
}
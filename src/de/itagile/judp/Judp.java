package de.itagile.judp;

import java.net.DatagramSocket;

public class Judp {

	private final DatagramSocket socket;

	public Judp(DatagramSocket socket) {
		this.socket = socket;
	}

	public DatagramSocket getSocket() {
		return socket;
	}
	
	public void close() {
		socket.close();
	}
}
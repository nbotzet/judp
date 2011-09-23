package de.itagile.judp;

import java.net.DatagramSocket;

public class Judp {

	private final DatagramSocket socket;

	public Judp(DatagramSocket socket) {
		this.socket = socket;
	}

	public void close() {
		socket.close();
	}
	
	protected DatagramSocket getSocket() {
		return socket;
	}
}
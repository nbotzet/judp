package de.itagile.judp;

import java.net.DatagramSocket;

public class DatagramSocketFactory {

	public static DatagramSocket create() {
		try {
			return new DatagramSocket();
		} catch (java.net.SocketException e) {
			throw new SocketException(e);
		}
	}
	
	public static DatagramSocket create(int port) {
		try {
			return new DatagramSocket(port);
		} catch (java.net.SocketException e) {
			throw new SocketException(e);
		}
	}
}
package de.itagile.judp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Judp {
	private InetAddress ip;
	private int serverPort;
	private DatagramSocket serverSocket;
	private DatagramSocket clientSocket;

	public static void main(String[] args) throws Exception {
		Judp updServer = new Judp();
		updServer.start(InetAddress.getByName(args[0]), (int) new Integer(
				args[1]), (int) new Integer(args[2]));
		System.out.println(updServer.receive());
	}

	public void start(InetAddress ip, int serverPort, int clientPort)
			throws Exception {
		this.ip = ip;
		this.serverPort = serverPort;
		serverSocket = new DatagramSocket();
		clientSocket = new DatagramSocket(clientPort);
		clientSocket.setSoTimeout(2000);
	}

	public void send(String sendText) throws Exception {
		byte[] sendBytes = sendText.getBytes();
		serverSocket.send(new DatagramPacket(sendBytes, sendBytes.length, ip,
				serverPort));
	}

	public String receive() throws Exception {
		byte[] receiceData = new byte[512];
		DatagramPacket datagramPacket = new DatagramPacket(receiceData,
				receiceData.length);
		clientSocket.receive(datagramPacket);
		return new String(datagramPacket.getData(), 0, datagramPacket
				.getLength());
	}
}
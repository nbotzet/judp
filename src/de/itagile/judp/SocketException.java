package de.itagile.judp;

public class SocketException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SocketException(java.net.SocketException e) {
		super(e);
	}
}

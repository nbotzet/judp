package de.itagile.judp;

public class UnknownHostException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnknownHostException(java.net.UnknownHostException e) {
		super(e);
	}
}
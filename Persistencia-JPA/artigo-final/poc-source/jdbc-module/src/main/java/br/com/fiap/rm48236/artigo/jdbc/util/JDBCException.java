package br.com.fiap.rm48236.artigo.jdbc.util;

public class JDBCException extends Exception {

	private static final long serialVersionUID = 9096090504560041599L;

	public JDBCException() {
		super();
	}

	public JDBCException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JDBCException(String message, Throwable cause) {
		super(message, cause);
	}

	public JDBCException(String message) {
		super(message);
	}

	public JDBCException(Throwable cause) {
		super(cause);
	}
	
}

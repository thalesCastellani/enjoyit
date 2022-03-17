package br.com.enjoyit.exception;

public class TelefoneInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7472745451500858896L;
	
	public TelefoneInvalidoException() {
		super("Telefone inv�lido! Digite novamente");
	}
	
	
	public TelefoneInvalidoException(String msg) {
		super(msg);
	}
	
}

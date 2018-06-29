package Exceptions;

public class CategoriaNaoInformadaException extends Exception{
	public CategoriaNaoInformadaException() { super(); }
	  public CategoriaNaoInformadaException(String message) { super(message); }
	  public CategoriaNaoInformadaException(String message, Throwable cause) { super(message, cause); }
	  public CategoriaNaoInformadaException(Throwable cause) { super(cause); }

}

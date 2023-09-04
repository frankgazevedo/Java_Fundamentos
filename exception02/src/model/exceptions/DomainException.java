package exception02.model.exceptions;

/*
 * RuntimeException: NÃO obriga o tratamento da exceção - não é necessário utilizar blocos try-catch.
 * 
 * Exception: obriga o tratamento da exceção - é necessário utilizar blocos try-catch.
 */
public class DomainException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public DomainException (String msg) {
		super(msg);
	}

}
package exception;
 

public class PageNotFound extends RuntimeException { 
 
	private static final long serialVersionUID = -131611535130185771L; 

	public PageNotFound(String message) {		
		super(message);		
	}	
	
	@Override
	public String getMessage() {		
		return super.getMessage();		
	} 
 
}

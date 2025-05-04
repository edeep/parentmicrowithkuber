package com.pradeep.kubernetes.micro.webappservice.exception;

public class CustomResourceNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomResourceNotFoundException(String message) {
        super(message);
    }
}

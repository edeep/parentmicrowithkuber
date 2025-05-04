package com.pradeep.kubernetes.micro.webappservice.exception;

public class ErrorResponse {
    private String message;
    private int status;

    // Constructor, Getters, Setters
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

    // Getters and setters
}

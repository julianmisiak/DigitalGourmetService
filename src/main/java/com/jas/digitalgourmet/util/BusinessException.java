package com.jas.digitalgourmet.util;

import java.util.Collection;

public class BusinessException extends RuntimeException {
	private static final long serialVersionUID = -1712644474509926278L;
	private Integer codigoError;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Integer code, String menssage) {
		super(menssage);
		this.codigoError = code;
	}

	public BusinessException(String message, Exception exception) {
		super(message, exception);
	}

	public BusinessException(DefinedErrors error) {
		this(error.getErrorCode(), error.getErrorMessage());
	}

	public static void assertNotEmpty(Collection<?> objects, DefinedErrors error) {
		if (objects.isEmpty()) {
			throw new BusinessException(error.getErrorCode(), error.getErrorMessage());
		}
	}

	public Integer getCodigoError() {
		return codigoError;
	}
}

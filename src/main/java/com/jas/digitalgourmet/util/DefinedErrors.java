package com.jas.digitalgourmet.util;

public enum DefinedErrors {

	ERROR_TIPO_1 {
		@Override
		public Integer getErrorCode() {
			return 100;
		}

		@Override
		public String getErrorMessage() {
			return "Descripción Error Tipo 1";
		}
	},
	
	ERROR_TIPO_2 {
		@Override
		public Integer getErrorCode() {
			return 101;
		}

		@Override
		public String getErrorMessage() {
			return "Descripción Error Tipo 2";
		}
	};

	public abstract Integer getErrorCode();

	public abstract String getErrorMessage();

}

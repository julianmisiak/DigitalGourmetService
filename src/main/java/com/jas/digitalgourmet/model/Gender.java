package com.jas.digitalgourmet.model;

public enum Gender {
	MALE {
		@Override
		public String toBusinessString() {
			return "Masculino";
		}
	},

	FEMALE {
		@Override
		public String toBusinessString() {
			return "Femenino";
		}
	};

	public abstract String toBusinessString();
}

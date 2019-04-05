package com.jas.digitalgourmet.util;


public enum DefinedErrors {

    PARSED_DATE {
        @Override
        public Integer getErrorCode() {
            return 100;
        }

        @Override
        public String getErrorMessage() {
            return "Error al parsear la fecha";
        }
    },
    SORTEOS_NO_ENCONTRADOS {
        @Override
        public Integer getErrorCode() {
            return 101;
        }

        @Override
        public String getErrorMessage() {
            return "No se encontraron sorteos";
        }
    };


    public abstract Integer getErrorCode();
    public abstract String getErrorMessage();

}

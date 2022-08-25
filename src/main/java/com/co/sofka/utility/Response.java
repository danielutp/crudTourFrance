package com.co.sofka.utility;

public class Response {

    /**
     * Indica de si existe un error o no en la respuesta del API
     */
    public Boolean error;

    /**
     * Mensaje del API cuando es utilizada
     */
    public String message;

    /**
     * Información del API cuando es necesario
     */
    public Object data;


    public Response() {
        error = false;
        message = "";
        data = null;
    }


    public void restart() {
        error = false;
        message = "";
        data = null;
    }
}

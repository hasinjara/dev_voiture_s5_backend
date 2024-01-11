package com.demo.voiture.models;

public class Retour {

    String error;
    String message;
    Object data;

    public Retour(String error, String message, Object data) {
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public Retour(Object data)  {
        try {
            this.data = data;
            this.error = "aucun";
            this.message = "Reussi";
        }catch (Exception e) {
            this.data = null;
            this.error = e.getMessage();
            this.message = "Echoue";
        }

    }

//    public Retour(Object data, String message)  {
//        try {
//            this.data = data;
//            this.error = "aucun";
//            this.message = message;
//        }catch (Exception e) {
//            this.data = null;
//            this.error = e.getMessage();
//            this.message = "Echoue";
//        }
//
//    }

    public Retour(String error, Object data) {
        this.error = error;
        this.data = data;
        this.message = "Failed";
    }

    public Retour() {
    }

    public String getError() {
        return error;
    }

    public void seterror(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

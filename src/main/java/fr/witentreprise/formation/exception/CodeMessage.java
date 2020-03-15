package fr.witentreprise.formation.exception;

public enum CodeMessage {

    //Formation
    XAA("XAA", "Formation is not valid"),
    XAB("XAB", "Formation'id is not valid"),
    XAC("XAC", "Formation name does'nt exist"),
    XAD("XAC", "Formation date does'nt exist"),
    XAE("XAE", "Formation with this name and same date already exist"),
    XAF("XAF", "Formation created");
    //Person

    private String code;
    private String message;


    CodeMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

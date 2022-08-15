package org.ioc.models;

public class XmlParser {
    private String login, hashCod;
    public XmlParser(String login, String hashCod){
        this.login = login;
        this.hashCod = hashCod;
    }

    public String getLogin() {

        return login;
    }

    public String getHashCod() {
        return hashCod;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHashCod(String hashCod) {
        this.hashCod = hashCod;
    }
}

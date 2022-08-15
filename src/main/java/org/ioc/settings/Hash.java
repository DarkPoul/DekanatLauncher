package org.ioc.settings;

public class Hash {
    static int HashText;

    public Hash(int hashText){
        HashText = hashText;
    }

    public static int getHashText() {
        String hash = "Alfa_0.0.2";
        HashText = hash.hashCode();
        return HashText;
    }
}

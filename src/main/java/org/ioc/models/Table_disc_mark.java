package org.ioc.models;

public class Table_disc_mark {
    String disc, sem, hh, zal,ekz,kr,kp,rgr;
    public Table_disc_mark(String disc, String sem, String hh, String zal, String ekz, String kr, String kp, String rgr){
        this.disc = disc;
        this.sem = sem;
        this.hh = hh;
        this.zal = zal;
        this.ekz = ekz;
        this.kr = kr;
        this.kp = kp;
        this.rgr = rgr;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public String getHh() {
        return hh;
    }

    public void setHh(String hh) {
        this.hh = hh;
    }

    public String getZal() {
        return zal;
    }

    public void setZal(String zal) {
        this.zal = zal;
    }

    public String getEkz() {
        return ekz;
    }

    public void setEkz(String ekz) {
        this.ekz = ekz;
    }

    public String getKr() {
        return kr;
    }

    public void setKr(String kr) {
        this.kr = kr;
    }

    public String getKp() {
        return kp;
    }

    public void setKp(String kp) {
        this.kp = kp;
    }

    public String getRgr() {
        return rgr;
    }

    public void setRgr(String rgr) {
        this.rgr = rgr;
    }
}

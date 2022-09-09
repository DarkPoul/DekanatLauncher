package org.ioc.models;

import javafx.scene.control.TextField;

import java.util.Objects;

public class Table_disc_mark {
    String disc, sem;
    TextField hh, zal,ekz,kr,kp,rgr;
    public Table_disc_mark(String disc, String sem, TextField hh, TextField zal, TextField ekz, TextField kr, TextField kp, TextField rgr){
        this.disc = disc;
        this.sem = sem;
        this.hh = hh;
        if (Objects.equals(zal.getText(), "false")){
            zal.setEditable(false);
        } else this.zal = zal;
        if (Objects.equals(ekz.getText(), "false")){
            ekz.setEditable(false);
        }else this.ekz = ekz;
        if (Objects.equals(kr.getText(), "false")){
            kr.setEditable(false);
        } else this.kr = kr;
        if (Objects.equals(kp.getText(), "false")){
            kp.setEditable(false);
        } else this.kp = kp;
        if (Objects.equals(rgr.getText(), "false")){
            rgr.setEditable(false);
        } else this.rgr = rgr;

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

    public TextField getHh() {
        return hh;
    }

    public void setHh(TextField hh) {
        this.hh = hh;
    }

    public TextField getZal() {
        return zal;
    }

    public void setZal(TextField zal) {
        this.zal = zal;
    }

    public TextField getEkz() {
        return ekz;
    }

    public void setEkz(TextField ekz) {
        this.ekz = ekz;
    }

    public TextField getKr() {
        return kr;
    }

    public void setKr(TextField kr) {
        this.kr = kr;
    }

    public TextField getKp() {
        return kp;
    }

    public void setKp(TextField kp) {
        this.kp = kp;
    }

    public TextField getRgr() {
        return rgr;
    }

    public void setRgr(TextField rgr) {
        this.rgr = rgr;
    }
}

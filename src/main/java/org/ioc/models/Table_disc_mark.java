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
        this.zal = zal;
        if (Objects.equals(this.zal.getText(), "false")){
            this.zal.setText("");
        } else this.zal = zal;
        this.ekz = ekz;
        if (Objects.equals(this.ekz.getText(), "false")){
            this.ekz.setText("");
        } else this.ekz = ekz;
        this.kr = kr;
        if (Objects.equals(this.kr.getText(), "false")){
            this.kr.setText("");
        } else this.kr = kr;
        this.kp = kp;
        if (Objects.equals(this.kp.getText(), "false")){
            this.kp.setText("");
        } else this.kp = kp;
        this.rgr = rgr;
        if (Objects.equals(this.rgr.getText(), "false")){
            this.rgr.setText("");
        }else this.rgr = rgr;
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

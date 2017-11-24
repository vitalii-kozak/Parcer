package domain;

import java.util.Date;

public class Currency {
    private int code;
    private String txt;
    private double exchangeRate;
    private String cc;
    private Date exchangeDate;

    public Currency(int code, String txt, double exchangeRate, String cc, Date exchangeDate) {
        this.code = code;
        this.txt = txt;
        this.exchangeRate = exchangeRate;
        this.cc = cc;
        this.exchangeDate = exchangeDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Date getExchangeDate() {
        return exchangeDate;
    }

    public void setExchangeDate(Date exchangeDate) {
        this.exchangeDate = exchangeDate;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "code=" + code +
                ", txt='" + txt + '\'' +
                ", exchangeRate=" + exchangeRate +
                ", cc='" + cc + '\'' +
                ", exchangeDate=" + exchangeDate +
                '}';
    }
}

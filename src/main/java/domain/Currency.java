package domain;

import com.google.gson.annotations.SerializedName;

import java.util.Date;


public class Currency {
    @SerializedName("r030")
    private int code;
    @SerializedName("txt")
    private String txt;
    @SerializedName("rate")
    private double exchangeRate;
    @SerializedName("cc")
    private String cc;
    @SerializedName("exchangedate")
    private Date exchangeDate;

    public Currency() {
        this.code = 0;
        this.txt = "";
        this.exchangeRate = 0.0;
        this.cc = "";
        this.exchangeDate = null;
    }

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

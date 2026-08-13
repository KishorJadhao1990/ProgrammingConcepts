package com.eao.usecases.all;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class JavaBigDecimalObject {

public static void main(String[] args) {
        
        List<TaxScore> taxScores = new ArrayList<>();
        taxScores.add(new TaxScore("kishorjadhao", "1991990",
                "IN", "xebia", 0.307, 2021));
        taxScores.add(new TaxScore("kishorJadhao1", "1991990",
                "VN", "Fix", 0.66, 2021));
        taxScores.add(new TaxScore("kishorJadhao2", "1991990",
                "US", "Galaxy", 0.704, 2021));

        BigInteger unscaledValue = taxScores.stream()
                .map(TaxScore::getScore).map(BigDecimal::valueOf)
                .reduce(BigDecimal.ZERO, BigDecimal::add).unscaledValue();
        System.out.println("unscaledValue: "+ unscaledValue);

        BigDecimal sum = BigDecimal.valueOf(unscaledValue.intValue() / 12.0);

        BigInteger unscaledValue1 = sum.unscaledValue();
        System.out.println("unscaledValue1: "+ unscaledValue1);

        int intValue = sum.intValue();
        System.out.println("intValue: "+ intValue);

        int precision = sum.precision();
        System.out.println("precision: "+ precision);

        BigDecimal abs = sum.abs();
        System.out.println("abs: "+ abs);

        BigDecimal movePointLeft = sum.movePointLeft(2);
        System.out.println("movePointLeft by 2: "+ movePointLeft);

        BigDecimal movePointRight = sum.movePointRight(3);
        System.out.println("movePointRight by 2: "+ movePointRight);

        int scale = sum.scale();
        System.out.println("scale: "+ scale);
        BigDecimal tensPow = BigDecimal.valueOf(10).pow(scale);
        System.out.println("tensPow: "+ tensPow);

        BigDecimal unscaledInt = sum.multiply(tensPow);
        System.out.println("unscaledInt: "+ unscaledInt);

        sum = sum.add(BigDecimal.valueOf(0.25));
        BigDecimal roundOff = sum.round(MathContext.UNLIMITED);
        System.out.println("roundOff: "+ roundOff);
        BigDecimal roundOff1 = sum.round(MathContext.DECIMAL32);
        System.out.println("roundOff1: "+ roundOff1);
        BigDecimal roundOff2 = sum.round(MathContext.DECIMAL64);
        System.out.println("roundOff2: "+ roundOff2);
        BigDecimal roundOffCeil = sum.setScale(0, RoundingMode.CEILING);
        System.out.println("roundOffCeil: "+ roundOffCeil);
        BigDecimal roundOffFloor = sum.setScale(0, RoundingMode.FLOOR);
        System.out.println("roundOffFloor: "+ roundOffFloor);
        BigDecimal roundOffDown = sum.setScale(0, RoundingMode.HALF_DOWN);
        System.out.println("roundOffDown: "+ roundOffDown);
        BigDecimal roundOffUp = sum.setScale(0, RoundingMode.HALF_UP);
        System.out.println("roundOffUp: "+ roundOffUp);
        BigDecimal roundOffEven = sum.setScale(0, RoundingMode.HALF_EVEN);
        System.out.println("roundOffEven: "+ roundOffEven);
    }

//    public static void main(String[] args) {
//
//        List<Invoice> invoices = Arrays.asList(
//                new Invoice("I1001", BigDecimal.valueOf(9.99), BigDecimal.valueOf(1)),
//                new Invoice("I1002", BigDecimal.valueOf(19.99), BigDecimal.valueOf(1.5)),
//                new Invoice("I1003", BigDecimal.valueOf(4.888), BigDecimal.valueOf(2)),
//                new Invoice("I1004", BigDecimal.valueOf(4.99), BigDecimal.valueOf(5)),
//                new Invoice("I1005", BigDecimal.valueOf(.5), BigDecimal.valueOf(2.3))
//        );
//
//        BigDecimal sum = invoices.stream()
//                .map(x -> x.getQty().multiply(x.getPrice()))    // map
//                .reduce(BigDecimal.ZERO, BigDecimal::add);      // reduce
//
//        System.out.println(sum);    // 75.851
//        System.out.println(sum.setScale(2, RoundingMode.HALF_UP));  // 75.85
//
//    }

}

class Invoice {

    String invoiceNo;
    BigDecimal price;
    BigDecimal qty;

    public Invoice(String invoiceNo, BigDecimal price, BigDecimal qty) {
        this.invoiceNo = invoiceNo;
        this.price = price;
        this.qty = qty;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }
}

class TaxScore {
    private String fullName;
    private String dob;
    private String orgAddress;
    private String orgName;
    private Double score;
    private Integer year;

    public TaxScore(String fullName, String dob, String orgAddress,
                    String orgName, Double score, Integer year) {
        this.fullName = fullName;
        this.dob = dob;
        this.orgAddress = orgAddress;
        this.orgName = orgName;
        this.score = score;
        this.year = year;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOrgAddress() {
        return orgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        this.orgAddress = orgAddress;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
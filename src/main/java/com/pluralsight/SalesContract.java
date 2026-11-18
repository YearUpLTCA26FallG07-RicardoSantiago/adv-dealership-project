package com.pluralsight;

import com.dealership.Vehicle;

import java.math.BigDecimal;

public class SalesContract extends Contract {

    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.finance = finance;
    }

    public boolean isFinance() {
        return finance;
    }

    @Override
    public BigDecimal getTotalPrice() {

        //process to calculate taxes and fees to original vehicle price

        BigDecimal vehiclePrice = getVehicleSold().getPrice();

        BigDecimal salesTax = vehiclePrice.multiply(new BigDecimal("0.05"));

        BigDecimal recordingFee = new BigDecimal("100");

        BigDecimal processingFee;

        if (vehiclePrice.compareTo(new BigDecimal("10000")) <0) {
            processingFee = new BigDecimal("295");
        }
        else {
            processingFee = new BigDecimal("495");
        }

        //add taxes and fees to the price of the vehicle
        BigDecimal totalPrice = vehiclePrice.add(salesTax).add(recordingFee).add(processingFee);

        return totalPrice;
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        return null;
    }
}

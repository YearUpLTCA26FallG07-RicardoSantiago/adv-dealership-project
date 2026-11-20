package com.pluralsight;

import com.dealership.Vehicle;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LeaseContract extends Contract {

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
    }

    @Override
    public BigDecimal getTotalPrice() {

        BigDecimal vehiclePrice = getVehicleSold().getPrice();

        BigDecimal endingValue = vehiclePrice.multiply(new BigDecimal("0.5"));

        BigDecimal leaseFee = vehiclePrice.multiply(new BigDecimal("0.07"));

        BigDecimal totalPrice = vehiclePrice.subtract(endingValue).add(leaseFee);

        return totalPrice;
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        BigDecimal totalprice = getTotalPrice();

        BigDecimal interestAmount = totalprice.multiply(new BigDecimal("0.04"));

        BigDecimal amountFinanced = totalprice.add(interestAmount);

        BigDecimal monthlyPayment = amountFinanced.divide(new BigDecimal("36"), 2, RoundingMode.HALF_UP);

        return monthlyPayment;
    }
}

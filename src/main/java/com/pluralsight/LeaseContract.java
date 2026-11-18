package com.pluralsight;

import com.dealership.Vehicle;

import java.math.BigDecimal;

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
        return null;
    }
}

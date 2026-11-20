package com.pluralsight;

import com.dealership.Dealership;
import com.dealership.Vehicle;

import java.io.BufferedReader;
import java.io.FileReader;

public class ContractFileManager {

    public Contract getContract(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/contracts.csv"));

            //Reading the file and naming the parts
            String contractname = reader.readLine();

            String[] contractinfo = contractname.split("\\|");

            String date = contractinfo[0];
            String customerName = contractinfo[1];
            String customerEmail = contractinfo[2];
            Vehicle vehicleSold = contractinfo[3];



            //Stating dealership object
            Contract contract = new Contract(date,customerName,customerEmail,vehicleSold);

            //Reading the Vehicles
            String line;
}

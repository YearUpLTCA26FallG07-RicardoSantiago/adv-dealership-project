package com.dealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class DealershipFileManager {


    //Reader for inventory file
    public Dealership getDealership(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inventory.csv"));

            //Reading the file and naming the parts
            String dealershipname = reader.readLine();

            String[] dealershipinfo = dealershipname.split("\\|");

            String name = dealershipinfo[0];
            String address= dealershipinfo[1];
            String phone = dealershipinfo[2];

            //Stating dealership object
            Dealership dealership = new Dealership(name,address,phone);

            //Reading the Vehicles
            String line;

            while ((line = reader.readLine()) !=null) {
                String[] car = line.split("\\|");

                int vin = Integer.parseInt(car[0]);
                int year = Integer.parseInt(car[1]);
                String make = car[2];
                String model = car[3];
                String type = car[4];
                String color = car[5];
                int odometer = Integer.parseInt(car[6]);
                BigDecimal price = new BigDecimal(car[7]);

                //Stating the vehicle object
                Vehicle vehicle = new Vehicle(vin,year,make,model,type,color,odometer,price);

                //Adding the vehicle object into the dealership object
                dealership.addVehicle(vehicle);
            }
            reader.close();
            return dealership;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveDealership(Dealership dealership) {
         // implementing the writer
        try { BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/inventory.csv"));

         // block to write to dealership and add new vehicle to csv file
         writer.write(dealership.getName()+"|"+dealership.getAddress()+"|"+dealership.getPhone());

         writer.newLine();

         for (Vehicle vehicle : dealership.getAllVehicles()) {
             writer.write(
                     vehicle.getVin() + "|" +
                             vehicle.getYear() + "|" +
                             vehicle.getMake() + "|" +
                             vehicle.getModel() + "|" +
                             vehicle.getVehicleType() + "|" +
                             vehicle.getColor() + "|" +
                             vehicle.getOdometer() + "|" +
                             vehicle.getPrice());
             writer.newLine();
         }
             writer.close();
        } catch (IOException e) {e.printStackTrace(); }

    }
}
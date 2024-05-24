/**
 *NAME : MUHAMMAD AKHMAL(2022870756), NIK YUSUF(2022606254), MUHAMMAD SYAFIQ(2022831866), 
 *       RIZALIFF NABIL (2022451146)
 *PROJECT : FRESH CAR WASH
 *FILE : CARWASH (APPS)
 *DATE START : 25/12/2023    DATE END :  19/01/2024            
 */

import java.util.*;
public class carWashApps
{
    public static void main(String args[]){
        
        Scanner inputT = new Scanner(System.in);
        Scanner inputN = new Scanner(System.in);
        
        //declaring size of an array
        int size = 3;
        Vehicle v[] = new Vehicle[size];
        
        //greting
        System.out.println("***** WELCOME TO FRESH CAR WASH *****");
        System.out.println("\n+------------------------------------------+");
        System.out.println("|      SERVICE TYPE      |      PRICE      |");
        System.out.println("+------------------------------------------+");
        System.out.println("|     Standard (S)       |     RM 10.00    |");
        System.out.println("+------------------------------------------+");
        System.out.println("|     Premium (P)        |     RM 13.70    |");
        System.out.println("+------------------------------------------+");
        System.out.println("|     Vacuum (V)         |     RM 5.80     |");
        System.out.println("+------------------------------------------+");
        System.out.println("|     Full Cleaning (F)  |     RM 14.50    |");
        System.out.println("+------------------------------------------+");
        
        //input from the user base on size mention
        System.out.println("\n+-------------------------------------------------------+");
        System.out.println("|                Input Customer Details:-               |");
        System.out.println("+-------------------------------------------------------+");
        for(int i=0;i<size;i++){
            System.out.print(" Enter Plate Number: ");
            String plateNum = inputT.nextLine();
            System.out.print(" Enter Customer Name: ");
            String custName = inputT.nextLine();
            System.out.print(" Enter Customer Phone: ");
            String custPhone = inputT.nextLine();
            
            System.out.print(" Enter Vehicle Type [Sedan/MPV/SUV/Hatchback/Sport/4X4]: ");
            String vehicleType = inputT.nextLine();
            System.out.print(" Enter Service Type [S/P/V/F]: ");
            char serviceType = inputT.next().charAt(0);
            System.out.print(" Do You Have Membership? [true/false] : ");
            boolean membership = inputT.nextBoolean();
            inputT.nextLine(); // *ADDED : Consume the newline character 
            
            System.out.println("+-------------------------------------------------------+");
            v[i] = new Vehicle(plateNum,vehicleType,serviceType,membership,custName,custPhone);
        }
        
        // 3. UPDATE customer phone number name 
        System.out.println("+-------------------------------------------------------+");
        System.out.println("|                 Update Customer Phone :-              | ");
        System.out.println("+-------------------------------------------------------+");
        System.out.print(" Enter customer name: ");
        String upCust = inputT.nextLine();
        System.out.print(" Enter phone number: ");
        String upNum = inputT.nextLine();
        System.out.println("+-------------------------------------------------------+");
        
        int indexup = -1;
        for(int i=0;i<size;i++){
            if(v[i].getCustName().trim().equalsIgnoreCase(upCust.trim())){
                indexup = i;
                v[i].setCustPhone(upNum);
                System.out.println("+-------------------------------------------------------+");
                System.out.println("|                  Updated Succesful!                   |");
                System.out.println("+-------------------------------------------------------+");
                System.out.println(v[i].toString());
                System.out.println("+-------------------------------------------------------+");
            }
        }
        if(indexup==-1){
            System.out.println("\n\n+-------------------------------------------------------+");
            System.out.println("|             Customer name does not exist              |");
            System.out.println("+-------------------------------------------------------+");
        }
    
        // 4. DISPLAY toString ALL DATA
        System.out.println("\n\n+-------------------------------------------------------+");
        System.out.println("|                 All Customer Details:-                |");
        System.out.println("+-------------------------------------------------------+");
        for(int i=0;i<size;i++){
            System.out.println(v[i].toString());
            System.out.println("---------------------------------------------------------");
        }
        
        // 2. REMOVE BASED ON PLATE STARTS WITH C
        int indexRemove = -1;
        for(int i=0; i<size; i++){
            if(v[i].getPlateNum().substring(0,1).equalsIgnoreCase("C")){
                indexRemove=i;
                size--;
                for(int j = indexRemove; j<size; j++){
                    v[j] = v[j+1];
                }
            }
        }
        if(indexRemove !=-1){
            System.out.println("\n\n+--------------------------------------------------------------+");
            System.out.println("|    All The Number Plate Starts With 'C' Has Been Deleted!:-  |");
            System.out.println("+--------------------------------------------------------------+");  
        }
        
        //counting vehicle according to their types
        int countMPV=0, countSUV=0, countHatch=0, countSedan=0, count4X4=0, countSport=0;
        for(int i=0;i<size;i++){
            if(v[i].getVehicleType().equalsIgnoreCase("MPV")){
                countMPV++;
            }
            else if(v[i].getVehicleType().equalsIgnoreCase("Hatchback")){
                countHatch++;
            }
            else if(v[i].getVehicleType().equalsIgnoreCase("SUV")){
                countSUV++;
            }
            else if(v[i].getVehicleType().equalsIgnoreCase("Sedan")){
                countSedan++;
            }
            else if(v[i].getVehicleType().equalsIgnoreCase("4X4")){
                count4X4++;
            }
            else if(v[i].getVehicleType().equalsIgnoreCase("Sport")){
                countSport++;
            }
        }
        System.out.println("\n\n+-------------------------------------------------------+");
        System.out.println("|                   Car count by Type:-                 |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println(" Hatchback: "+countHatch);
        System.out.println(" Sedan    : "+countSedan);
        System.out.println(" MPV      : "+countMPV);
        System.out.println(" SUV      : "+countSUV);
        System.out.println(" 4X4      : "+count4X4);
        System.out.println(" Sport Car: "+countSport);
        System.out.println("+-------------------------------------------------------+");
        
        //calculate payment for each customer and display
        System.out.println("\n\n+-------------------------------------------------------+");
        System.out.println("|               Payment for each customer:-             |");
        System.out.println("+-------------------------------------------------------+");
        double payment=0;
        for(int i=0;i<size;i++){
            System.out.println(" Customer Name: "+v[i].getCustName());
            System.out.println(" Price: "+v[i].calcService(v[i].getMembership()));
            System.out.println("---------------------------------------------------------");
        }
        
        //calculate total sales
        double sumSales=0;
        for(int i=0;i<size;i++){
            sumSales = sumSales + v[i].calcService(v[i].getMembership());
        }
        System.out.println("\n\n+-------------------------------------------------------+");
        System.out.println("|                 Total Sales Carwash                   |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("                      RM " + sumSales);
        System.out.println("+-------------------------------------------------------+");
        
        //calculate average sales on that day
        double avg=0;
        avg = sumSales/size;
        System.out.println("\n\n+-------------------------------------------------------+");
        System.out.println("|                  Average Sales Carwash                |");
        System.out.println("+-------------------------------------------------------+");
        System.out.println("                      RM "+avg);
        System.out.println("+-------------------------------------------------------+");
        
        //Implement Bubble Sort (sort data according to num plate ascending)
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (v[j].getPlateNum().compareTo(v[j + 1].getPlateNum()) > 0) {
                    // Swap if needed
                    Vehicle temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
        
        // Display sorted data
        System.out.println("\n\n+-------------------------------------------------------+");
        System.out.println("|           Sorted Data based on Number Plate           |");
        System.out.println("+-------------------------------------------------------+");
        for (int i = 0; i < size; i++) {
            System.out.println(v[i].toString());
            System.out.println("+-------------------------------------------------------+");
        }
        
        //Display data according to vehicle type (sorting)
        System.out.println("\n\n+-------------------------------------------------------+");
        System.out.print(" Display the data according to vehicle type (sorting) : ");
        String type = inputT.nextLine();
        System.out.println("+-------------------------------------------------------+");
        
        System.out.println("   The Details of Customer That Using Car " + type + ":- ");
        System.out.println("+-------------------------------------------------------+");
        for(int i=0;i<size;i++){
            if(v[i].getVehicleType().equalsIgnoreCase(type)){
                System.out.println(v[i].toString());
                System.out.println("+-------------------------------------------------------+");
            }
        }
        
        //searching details of customer name that user enter
        System.out.println("\n\n+-------------------------------------------------------+");
        System.out.print(" Enter customer that you want to find (searching) : ");
        String search = inputT.nextLine().trim();  //avoid white spaces
        System.out.println("---------------------------------------------------------");
        
        boolean found = false;
        Vehicle index = null;
        for(int i=0;i<size;i++){
            if(v[i].getCustName().trim().equalsIgnoreCase(search.trim())){
                found = true;
                index = v[i];
                break;
            }
        }
        if(found==true){
            System.out.println("|Customer is Found!                                     |");
            System.out.println("---------------------------------------------------------");
            System.out.println(index.toString());
            System.out.println("+-------------------------------------------------------+");
        }
        else{
            System.out.println(" Sorry,the customer that you're looking is not in our record!");
            System.out.println("+-------------------------------------------------------+");
        }
        
        //end of program (draft v2.1)
    }
}
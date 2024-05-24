/**
 *NAME : MUHAMMAD AKHMAL(2022870756), NIK YUSUF(2022606254), MUHAMMAD SYAFIQ(2022831866), 
 *       RIZALIFF NABIL (2022451146)
 *PROJECT : FRESH CAR WASH
 *FILE : VEHICLE (CLASS)
 *DATE START : 25/12/2023    DATE END :  19/01/2024            
 */

public class Vehicle
{
    //decalring attributes
    private String plateNum;
    private String vehicleType;
    private char serviceType;
    private boolean membership;
    private String custName;
    private String custPhone;
    
    //default constructor
    public Vehicle(){
        plateNum = "unknown";
        vehicleType = "unknown";
        serviceType = 0;
        membership = false;
        custName = "unknown";
        custPhone = " ";
    }
    
    //normal constructor
    public Vehicle(String plateNum, String vType, char sType, boolean member, String custName, String custPhone){
        this.plateNum = plateNum;
        this.vehicleType = vType;
        this.serviceType = sType;
        this.membership = member;
        this.custName=custName;
        this.custPhone=custPhone;
    }
    
    //mutator
    public void setPlateNum(String plateNum) { this.plateNum = plateNum; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public void setServiceType(char serviceType) { this.serviceType = serviceType; }
    public void setMembership(boolean membership) { this.membership = membership; }
    public void setCustName(String custName) { this.custName=custName; }
    public void setCustPhone(String custPhone) { this.custPhone=custPhone; }
    
    //accessor
    public String getPlateNum() { return plateNum; }
    public String getVehicleType() { return vehicleType; }
    public char getServiceType() { return serviceType; }
    public boolean getMembership() {  return membership; }
    public String getCustName() { return custName; }
    public String getCustPhone() { return custPhone; }
    
    //processor
         //method overriding
    public double calcService(){
        double total=0;
        if(serviceType == 'S' || serviceType =='s')
            total = 10.00;
        else if(serviceType == 'P' || serviceType =='p')
            total = 13.70;
        else if(serviceType == 'V' || serviceType =='v')
            total = 5.80;
        else if(serviceType == 'F' || serviceType =='f')
            total = 14.50;
            
        return total;
    }
    
    public double calcService(boolean membership){
        double totDisc = 0;
        if(membership == true)
            totDisc = calcService() - (calcService() * 0.1);
        else
            totDisc = calcService();
        return totDisc;
    }
    
    //printer method
    public String toString(){
        String member;
        
        if(membership == true)
            member = "Active Membership";
        else
            member = "Non Active Membership";
        
        return(" Plate Number: "+plateNum+
               "\n Customer Name: "+custName+
               "\n Customer Phone: "+custPhone+
               "\n Vehicle Type: "+vehicleType+
               "\n ServiceType: "+serviceType+
               "\n Membership Status: "+member);
    }
}
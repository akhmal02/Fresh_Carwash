/**
 *NAME : MUHAMMAD AKHMAL(2022870756), NIK YUSUF(2022606254), MUHAMMAD SYAFIQ(2022831866), 
 *       RIZALIFF NABIL (2022451146)
 *PROJECT : FRESH CAR WASH
 *FILE : CARWASHAPP
 *VERSION: V2.3
 *UPDATE: 16/1/2024
 *DATE START : 25/12/2023    DATE END :  19/01/2024            
 */
#include <stdio.h>
#include <string.h>
#include <stdbool.h>

// Defining the Vehicle struct
struct Vehicle {
	char plateNum[8];
	char vehicleType[10];
    char serviceType;
    char membership;
    char custName[20];
	char custPhone[11];
	
};

// Function prototypes
void display(struct Vehicle);
float calcService(char serviceType);
float calcPrice(char membership, char serviceType);
float calcTotalSales(struct Vehicle v[], int size);
float calcAverageSales(struct Vehicle v[], int size);
void bubbleSortCars(struct Vehicle v[], int size);
int searchByName(struct Vehicle v[], int size, const char *nameToSearch);


int main() 
{
    int size = 2;
    struct Vehicle v[size];
    int i;
	
	//greeting
    printf("***** WELCOME TO FRESH CAR WASH *****\n");
    printf("\n+------------------------------------------+\n");
    printf("|      TYPE SERVICE      |      PRICE      |\n");
    printf("+------------------------------------------+\n");
    printf("|     Standard (S)       |     RM 10.00    |\n");
    printf("+------------------------------------------+\n");
    printf("|     Premium (P)        |     RM 13.70    |\n");
    printf("+------------------------------------------+\n");
    printf("|     Vacuum (V)         |     RM 5.80     |\n");
    printf("+------------------------------------------+\n");
    printf("|     Full Cleaning (F)  |     RM 14.50    |\n");
    printf("+------------------------------------------+\n");
	
	//User Input Data
	printf("+-------------------------------------------------------+");
	printf("\n|                Input Customer Details:-               |");
	printf("\n+-------------------------------------------------------+");
    for (i = 0; i < size; i++) 
	{
    	printf("\nEnter Plate Number: ");
        scanf("%s", v[i].plateNum);
    	
        printf("Enter Customer Name: ");
        scanf(" %[^\n]", v[i].custName);
        
        printf("Enter Customer Phone: ");
        scanf(" %[^\n]", v[i].custPhone);

        printf("Enter Vehicle Type [Hatchback/Sedan/Sport/MPV/SUV/4X4] : ");
        scanf("%s", v[i].vehicleType);

        printf("Enter Service Type [S/P/V/F] : ");
        scanf(" %c", &v[i].serviceType);

        printf("Do You Have Membership? [Y/N] : ");
        scanf(" %c", &v[i].membership);
        
        printf("+-------------------------------------------------------+");
    }
    
    //Update Customer Phone Number by Name
    char upName[20];
    char upPhone[11];
    printf("\n\n+-------------------------------------------------------+");
    printf("\n|                Update Customer Phone:-                |");
    printf("\n+-------------------------------------------------------+\n");
    printf("Enter Customer Name: ");
    scanf(" %[^\n]", upName);
        
    printf("Enter Customer Phone: ");
    scanf(" %[^\n]", upPhone);
    printf("+-------------------------------------------------------+");
    int indexUpdate=-1;
    for (i = 0; i < size; i++)
    {
    	if(strcasecmp(v[i].custName, upName) == 0)
    	{
    		indexUpdate=i;
    		strcpy(v[i].custPhone, upPhone);
    		printf("\n\n+-------------------------------------------------------+");
    		printf("\n|                    Updated Succesful!                 |");
    		printf("\n+-------------------------------------------------------+");
    		display(v[i]);
    		printf("\n+-------------------------------------------------------+");
		}
	}
	
	if(indexUpdate==-1)
	{
		printf("\n\n+-------------------------------------------------------+");
    	printf("\n|             Customer name does not exist              |");
    	printf("\n+-------------------------------------------------------+");
	}
    
    //4. Display All Data
    printf("\n\n+-------------------------------------------------------+");
    printf("\n|                All Customer Details:-                 |");
    printf("\n+-------------------------------------------------------+");
    for (i = 0; i < size; i++)
    {
    	display(v[i]);
    	printf("\n---------------------------------------------------------");
	}
	
    //Remove Vehicles With Plate Number That Starts With C
    int indexRemove=-1;
    
    for (i = 0; i < size; i++)
    {
    	if(v[i].plateNum[0] == 'c' || v[i].plateNum[0] == 'C') 
    	{
    		indexRemove=i;
    		size--;
    		int j;
    		for (j = indexRemove; j < size; j++)
				v[j]=v[j+1];	//for the indexRemove and above, shift element to left
			i--;
    	}
	}
	
	if(indexRemove!=-1)
	{
		printf("\n\n+-------------------------------------------------------+");
	    printf("\n|    Removed Vehicles With Plate Number That Start C:-  |");
	    printf("\n+-------------------------------------------------------+");
	}

	//Count Cars Based On Vehicle Type
    int hatchbackCount = 0, sedanCount = 0, mpvCount = 0, suvCount = 0, x4Count = 0, sportCarCount = 0;
    for (i = 0; i < size; i++) {
        if (strcasecmp(v[i].vehicleType, "hatchback") == 0)
            hatchbackCount++;
        else if (strcasecmp(v[i].vehicleType, "sedan") == 0)
            sedanCount++;
        else if (strcasecmp(v[i].vehicleType, "sport") == 0)
            sportCarCount++;
        else if (strcasecmp(v[i].vehicleType, "mpv") == 0)
            mpvCount++;
        else if (strcasecmp(v[i].vehicleType, "suv") == 0)
            suvCount++;
        else if (strcasecmp(v[i].vehicleType, "4x4") == 0)
            x4Count++;
    }

	printf("\n\n+-------------------------------------------------------+");
	printf("\n|            Car Count Of Each Vehicle Type:-           |");
	printf("\n+-------------------------------------------------------+");
    printf("\nHatchback: %d", hatchbackCount);
    printf("\nSedan    : %d", sedanCount);
    printf("\nSport Car: %d", sportCarCount);
    printf("\nMPV      : %d", mpvCount);
    printf("\nSUV      : %d", suvCount);
    printf("\n4x4      : %d", x4Count);

    // Calculate payment for each customer and display by calling the function
    printf("\n\n+-------------------------------------------------------+");
    printf("\n|               Payment For Each Customer:-             |");
    printf("\n+-------------------------------------------------------+");
    float payment;
    for (i = 0; i < size; i++) 
	{
        payment = calcPrice(v[i].membership, v[i].serviceType);
    	printf("\nCustomer Name: %s", v[i].custName);
		printf("\nPrice: %.2f", payment);
		printf("\n---------------------------------------------------------");
    }
    
    //Calculate total sales
    float totalSales=calcTotalSales(v, size);
    printf("\n\n+-------------------------------------------------------+");
    printf("\n|                 Total Sales Carwash                   |");
    printf("\n+-------------------------------------------------------+");
    printf("\n                      RM %.2f",totalSales);
    printf("\n+-------------------------------------------------------+");
    
    //Calculate average sales on a day
    float averageSales=calcAverageSales(v, size);
    printf("\n\n+-------------------------------------------------------+");
    printf("\n|                  Average Sales Carwash                |");
    printf("\n+-------------------------------------------------------+");
    printf("\n                      RM %.2f",averageSales);
    printf("\n+-------------------------------------------------------+");
    
    
	//sort data based on plate number based in ascending order
	bubbleSortCars(v, size);
	
	//display sorted data
	printf("\n\n+-------------------------------------------------------+");
    printf("\n|          Sorted Data based on Number Plate            |");
    printf("\n+-------------------------------------------------------+");
    for(i = 0;i<size;i++)
    {
    	display(v[i]);
    	printf("\n---------------------------------------------------------");
	}
	
	// Display the details of customers using the specified vehicle type (sorting)
    printf("\n\n+-------------------------------------------------------+");
    printf("\n  Display customers that using vehicle type : ");
    char type[20];
    scanf("%s", type);
    printf("\n+-------------------------------------------------------+");
    printf("\n|  The Details of Customer That Using Car %s :-  ", type);
    printf("\n+-------------------------------------------------------+");
    int indexDetail=-1;
    for (i = 0; i < size; i++) 
	{
        if (strcasecmp(type, v[i].vehicleType) == 0)
        {
        	indexDetail=i;
        	display(v[i]);
        	printf("\n+-------------------------------------------------------+");
        }
    }

    if(indexDetail==-1)
    {
    	printf("\n\n+-------------------------------------------------------+");
    	printf("\n|      There is no customer use that vehicle type       |");
    	printf("\n+-------------------------------------------------------+");
	}
    
    //Searching based on customer name
    char nameToSearch[50];
    printf("\n\n+-------------------------------------------------------+");
    printf("\n  Enter customer name that you want to find : ");
    scanf(" %[^\n]", nameToSearch);
	printf("---------------------------------------------------------");
	
	// Display search result
    int found = searchByName(v, size, nameToSearch);
    if (found != -1) {
        printf("\n|Customer is Found!                                     |", nameToSearch);
        printf("\n---------------------------------------------------------");
        display(v[found]);
        printf("\n+-------------------------------------------------------+");
    } 
	else {
        printf("\nSorry,the customer that you're looking for is not in our record!");
    	printf("\n+-------------------------------------------------------+");
	}

    return 0;
}

void display(struct Vehicle car) 
{
	char member[10];
	
    printf("\nPlate Number: %s", car.plateNum);
    printf("\nCustomer Name: %s", car.custName);
	printf("\nCustomer Phone: %s", car.custPhone);
    printf("\nVehicle Type: %s", car.vehicleType);
    printf("\nService Type: %c", car.serviceType);
    
    if(car.membership=='y' || car.membership=='Y')
    	strcpy(member, "Active Membership");
    else
    	strcpy(member, "Non Active Membership");
    
    printf("\nMembership Status: %s", member);
}

float calcService(char serviceType) {
    float price;
    
    if(serviceType=='s' || serviceType=='S')
    	price=10.00;
    else if(serviceType=='p' || serviceType=='P')
    	price=13.70;
    else if(serviceType=='v' || serviceType=='V')
    	price=5.80;
    else if(serviceType=='f' || serviceType=='F')
    	price=14.50;
    		
    return price;
}

float calcPrice(char membership, char serviceType) {
    float totDisc = 0;
    if(membership == 'y' || membership == 'Y')
        totDisc = calcService(serviceType) - (calcService(serviceType) * 0.1);
    else
        totDisc = calcService(serviceType);
    return totDisc;
}

float calcTotalSales(struct Vehicle v[], int SIZE)
{
	int i;
	float totalSales=0;
	for (i = 0; i < SIZE; i++)
	{
		totalSales=totalSales+calcPrice(v[i].membership, v[i].serviceType);
	}
	return totalSales;
}

float calcAverageSales(struct Vehicle v[], int SIZE)
{
	float averageSales=0;
	float totalSales = calcTotalSales(v, SIZE);
	averageSales = totalSales/SIZE;
	
	return averageSales;
}

void bubbleSortCars(struct Vehicle v[], int size) 
{
	int i, j;
    for (i = 0; i < size - 1; i++) {
        for (j = 0; j < size - i - 1; j++) 
		{
            if (strcasecmp(v[j].plateNum, v[j + 1].plateNum) > 0) 
			{
                struct Vehicle temp = v[j];
                v[j] = v[j + 1];
                v[j + 1] = temp;
            }
        }
    }
}

int searchByName(struct Vehicle v[], int size, const char *nameToSearch) 
{
    int i;
    for (i = 0; i < size; i++) 
	{
        if (strcasecmp(v[i].custName, nameToSearch) == 0) 
		{
            return i;
        }   
    }
    return -1; 
}


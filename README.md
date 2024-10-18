## Overview

This project implements a car parking system in Java that can accommodate different types of vehicles and supports a configurable cost strategy. The system provides functionalities to initialize the parking lot, add vehicle details, remove vehicles, and check the availability of vehicle spaces. The system also supports a flat cost structure based on vehicle types.


## Functionalities
Initialize the Parking Lot: Configure the parking lot with a specified number of floors and spaces per floor for each vehicle type.
Add Vehicle: Add vehicle details to the parking lot, including vehicle type, registration number, color, and any other necessary attributes.
Remove Vehicle: Remove a vehicle from the parking lot based on the registration number or parking slot number.
Check Availability: Check the availability of vehicle spaces on a specific floor for a given vehicle type.
Generate Token: Generate a token ID for each vehicle added to the parking lot.
Calculate Parking Fee: Calculate the total parking fee based on the duration of parking and vehicle type.
     
## Cost Structure

Bike: ₹10 per hour
Car/Jeep: ₹20 per hour
Bus/Truck: ₹30 per hour
                    
## Use Cases

Initialize Parking Lot: Initialize the parking lot with a specific number of floors and vehicle spaces per floor for each vehicle type.
Add Vehicle: Enter vehicle details with a timestamp value and generate a token ID for each vehicle.
Remove Vehicle: Use the token ID to remove the vehicle from the parking lot and calculate the parking fee based on the duration.
Check Availability: Check if there are available spaces for a given vehicle type on a specific floor.
Full Capacity Handling: When the parking lot is full, the system should throw an error and display an appropriate message.

## Classes

ParkingLot: Represents the parking lot and manages vehicle spaces.
Vehicle: Represents a vehicle with attributes such as vehicle type, registration number, color, and any other necessary attributes.
Floor: Represents a floor in the parking lot with attributes like floor number, capacity for each vehicle type, and vehicle spaces.
VehicleSpace: Represents a vehicle space with attributes such as space number, availability, vehicle type, and any other necessary attributes.
CostStrategy: Represents the cost strategy for parking, allowing for varying costs based on the vehicle type and supporting different currencies.

## Main Class Methods

init(): Initializes the parking lot with the given number of floors and vehicle spaces per floor for each vehicle type.
addVehicle(): Adds a vehicle of the specified type with the given registration number and color to the parking lot.
removeVehicle(): Removes the vehicle with the specified registration number from the parking lot.
checkAvailability(): Checks the availability of vehicle spaces on the specified floor for the given vehicle type.

## Usage

1. Initialize the Parking Lot:

2. Add Vehicle:

3. Remove Vehicle:

4. Check Availability:

5. Handle Full Capacity:


## Testing

Test the code with multiple scenarios and edge cases to ensure the system works as expected. Include scenarios such as adding vehicles until the lot is full, removing vehicles, and checking for availability on different floors.

## Project Structure

src
com.parking
Main.java: Main class to demonstrate the usage of the parking lot and its methods.
ParkingLot.java: Class representing the parking lot.
Vehicle.java: Class representing a vehicle.
Floor.java: Class representing a floor in the parking lot.
VehicleSpace.java: Class representing a vehicle space.
CostStrategy.java: Class representing the cost strategy for parking.
exceptions
NoSpaceAvailableException.java: Exception for no available space.
WrongDetailException.java: Exception for incorrect vehicle details.

## Dependencies

Java SE Development Kit (JDK) 8 or higher

## How to Run

Clone the repository.
Open the project in your preferred IDE.
Compile and run the Main.java class.
Follow the console prompts to initialize the parking lot, add vehicles, remove vehicles, and check availability.

## Notes

Ensure that all vehicle details are entered correctly.
Handle exceptions appropriately to provide meaningful feedback to the user.

## License

This project is licensed under the MIT License.

## Created BY 
Name: Abhishek Sharma
Email:abhisam7007871@gmail.com

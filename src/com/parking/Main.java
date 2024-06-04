
package com.parking;

import java.util.Scanner;

import com.parking.exception.NoSpaceAvailableException;
import com.parking.exception.WrongDetailException;
import com.parking.service.ParkingService;
import com.parking.service.ParkingServiceImp;
import com.parking.vehicle.ParkedVehicle;
import com.parking.vehicle.Vehicle;
import com.parking.vehicle.VehicleType;

public class Main {
	private static ParkingService parkingService;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("< HEllO, Welcome to Our Parking Space>");
		System.out.println();

		// Initialize the parking lot
		initializeParkingLot(sc);

		while (true) {
			System.out.println("<-------------------------------------------------------->");
			System.out.println(" select an option:");
			System.out.println("1. Check availability of Vehicles2 ");
			System.out.println("2. Add vehicle to the parking");
			System.out.println("3. Remove Vehicle from the parking");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				checkAvailability(sc);

				break;
			case 2:

				addVehicle(sc);
				break;
			case 3:
				removeVehicle(sc);
				break;
			case 4:
				System.out.println("Thank you for using the Parking Lot System!");
				sc.close();
				System.exit(0);
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}

	private static void initializeParkingLot(Scanner sc) {
		System.out.print("Enter the number of floors: ");
		int totalFloors = sc.nextInt();
		System.out.print("Enter the number of spaces per floor Per VehicleType: ");
		int capacityPerFloor = sc.nextInt();
		parkingService = new ParkingServiceImp(totalFloors, capacityPerFloor);
		System.out.println("<******************************************************************->");
		System.out.println("Parking lot initialized with " + totalFloors + " floors and " + capacityPerFloor
				+ " spaces per floor.");
		System.out.println();
	}

	private static void addVehicle(Scanner scanner) {
		System.out.println("<******************************************************************->");
		try {
			System.out.print("Enter the vehicle registration number: ");
			String registrationNumber = scanner.nextLine();
			System.out.print("Enter the vehicle (CAR, BUS, TRUCK, BIKE): ");
			String input = scanner.nextLine().toUpperCase();

			// Validate vehicle type
			if (!isValidVehicleType(input)) {
				throw new IllegalArgumentException("Invalid vehicle type. Please enter a valid vehicle type.");
			}

			VehicleType vehicleType = VehicleType.valueOf(input);
			System.out.println("Selected vehicle type: " + vehicleType);
			Vehicle vehicle = new Vehicle(registrationNumber, vehicleType);

			System.out.print("Enter the floor Number: ");
			int floorNumber = scanner.nextInt();

			System.out.print("Enter the space Number: ");
			int spaceNumber = scanner.nextInt();

			parkingService.parkVehicle(floorNumber, spaceNumber, vehicle);

			System.out.println("Vehicle added successfully.");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// e.printStackTrace();
		}
	}

	private static boolean isValidVehicleType(String input) {
		for (VehicleType type : VehicleType.values()) {
			if (type.name().equals(input)) {
				return true;
			}
		}
		return false;
	}

	private static void checkAvailability(Scanner scanner) {
		System.out.println("<******************************************************************->");
		try {
			System.out.print("Enter the vehicle type (CAR, BUS, TRUCK, BIKE): ");
			String input = scanner.nextLine().toUpperCase();

			// Validate vehicle type
			if (!isValidVehicleType(input)) {
				throw new IllegalArgumentException("Invalid vehicle type. Please enter a valid vehicle type.");
			}

			VehicleType vehicleType = VehicleType.valueOf(input);
			System.out.println("Selected vehicle type: " + vehicleType);

			parkingService.checkAvailability(vehicleType);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (NoSpaceAvailableException e) {
			System.out.println(e.getMessage());
		}
	}

	private static void removeVehicle(Scanner sc) {
		System.out.println("<******************************************************************->");
		System.out.print("Enter the token Number: ");
		int tokenNumber = sc.nextInt();

		try {
			ParkedVehicle parkedVehicle = parkingService.getParkedVehicleDetail(tokenNumber);
			parkingService.removeVehicle(parkedVehicle);
			System.out.println("<******************************************************************->");
			System.out.println("The cost of parking of your vehicle is :-> " + parkingService.checkCost(parkedVehicle)
					+ " rupees");
			System.out.println("<******************************************************************->");

		} catch (WrongDetailException e) {
			System.out.println(e.getMessage());
		}

	}

}

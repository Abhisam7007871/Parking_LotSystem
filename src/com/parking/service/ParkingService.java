package com.parking.service;

import com.parking.exception.NoSpaceAvailableException;
import com.parking.exception.WrongDetailException;
import com.parking.vehicle.ParkedVehicle;
import com.parking.vehicle.Vehicle;
import com.parking.vehicle.VehicleType;

public interface ParkingService {
	
	
	/**
	 * 
	 * @param tokenId
	 * @return it will return the ParkedVehicle
	 * @throws WrongDetailException
	 */
	public ParkedVehicle getParkedVehicleDetail(int tokenId) throws WrongDetailException;
       
	/**
	 * 
	 * @param floorNumber
	 * @param spaceNumber
	 * @param vehicle
	 * @return it will return the String 
	 * @throws WrongDetailException
	 * @throws NoSpaceAvailableException
	 */
	public String parkVehicle(int floorNumber, int spaceNumber, Vehicle vehicle)
			throws WrongDetailException, NoSpaceAvailableException;
    
	
	/**
	 * 
	 * @param parkedVehicle
	 * @return it will return the String output
	 */
	public String removeVehicle(ParkedVehicle parkedVehicle);
	
	
	

	/**
	 * 
	 * @param type
	 * @return it will return that is space available or not
	 * @throws NoSpaceAvailableException
	 */
	public boolean checkAvailability(VehicleType type) throws NoSpaceAvailableException;

	/**
	 * 
	 * @param parkedVehicle
	 * @return it will return the cost of parking
	 */
	public int checkCost(ParkedVehicle parkedVehicle);
    
	
	/**
	 * This method will create space for Every VehicleType on total Floor
	 * @param totalFloor
	 * @param spacePerFloorPerVehicle
	 */
	public void initializeParking(int totalFloor, int spacePerFloorPerVehicle);

}

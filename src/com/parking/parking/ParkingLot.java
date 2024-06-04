package com.parking.parking;

import java.util.HashMap;
import java.util.Map;

import com.parking.cost.CostStrategy;
import com.parking.vehicle.Vehicle;
import com.parking.vehicle.VehicleSpace;
import com.parking.vehicle.VehicleType;

public class ParkingLot {

	private int totalFloors;
	private int spacesPerFloorPerVehicle;
	private Map<Integer, Floor> floors;

	public ParkingLot(int totalFloors, int spacesPerFloorPerVehicle) {
		super();
		this.totalFloors = totalFloors;
		this.spacesPerFloorPerVehicle = spacesPerFloorPerVehicle;
		this.floors = new HashMap<>();
		initializeFloors();
	}
    private void initializeFloors() {
    	for (int i = 1; i <= totalFloors; i++) {
            Map<VehicleType, Integer> capacity = new HashMap<>();
            capacity.put(VehicleType.CAR, spacesPerFloorPerVehicle);
            capacity.put(VehicleType.BIKE, spacesPerFloorPerVehicle);
            capacity.put(VehicleType.TRUCK, spacesPerFloorPerVehicle);
            capacity.put(VehicleType.BUS, spacesPerFloorPerVehicle);
            floors.put(i, new Floor(i, capacity));
        }
    }
	public int getTotalFloors() {
		return totalFloors;
	}
	public void setTotalFloors(int totalFloors) {
		this.totalFloors = totalFloors;
	}
	public int getSpacesPerFloorPerVehicle() {
		return spacesPerFloorPerVehicle;
	}
	public void setSpacesPerFloorPerVehicle(int spacesPerFloorPerVehicle) {
		this.spacesPerFloorPerVehicle = spacesPerFloorPerVehicle;
	}
	public Map<Integer, Floor> getFloors() {
		return floors;
	}
	public void setFloors(Map<Integer, Floor> floors) {
		this.floors = floors;
	}
    

}

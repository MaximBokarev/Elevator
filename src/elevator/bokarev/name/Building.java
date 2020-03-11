package elevator.bokarev.name;

import java.util.ArrayList;
import java.util.List;

public class Building {

	private Elevator elevator;
	private List<Floor> floors;
	private int floorNumber;

	public Building(int minFloorNumber, int maxFloorNumber) {
		elevator = new Elevator();
		floorNumber = Utils.random(minFloorNumber, maxFloorNumber);
		floors = new ArrayList<>();

		floors.add(null);
		for (int i = 1; i <= floorNumber; i++) {
			floors.add(new Floor(i, floorNumber));
		}
	}

	public Elevator getElevator() {
		return elevator;
	}

	public Floor getFloor(int i) {
		return floors.get(i);
	}

	public int getFloorNumber() {
		return floorNumber;
	}

}

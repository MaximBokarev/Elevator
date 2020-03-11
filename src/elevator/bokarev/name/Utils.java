package elevator.bokarev.name;

import java.util.List;
import java.util.Random;

public class Utils {
	private static Random random = new Random();

	public static int random(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}

	public static void print(Building building) {
		String result = "";
		List<Person> passengers = building.getElevator().getPassengers();
		int currentFloor = building.getElevator().getCurrentFloor();

		char direction = '^';
		if (building.getElevator().getDirection() == Direction.DOWN) {
			direction = 'v';
		}

		for (int i = building.getFloorNumber(); i > 0; i--) {
			Floor floor = building.getFloor(i);
			boolean isCurrentFloor = floor.getNumber() == currentFloor;

			String passengersView = "";
			for (int j = 0; j < 5; j++) {
				if (isCurrentFloor && j < passengers.size()) {
					passengersView += format(passengers.get(j).getTargetFloor()) + " ";
				} else if (isCurrentFloor){
					passengersView += "-- ";
				} else {
					passengersView += "   ";
				}
			}
			
			if (isCurrentFloor) {
				passengersView = direction + " " + passengersView;
			} else {
				passengersView = "  " + passengersView;
			}

			
			String floorView = "";
			for (Person p : floor.getQueue()) {
				floorView += format(p.getTargetFloor()) + "[" + format(p.getPrevTargetFloor()) + "] ";
			}
			
			result += format(floor.getNumber()) + " | " + passengersView + " | " + floorView + "\n";

		}
		result += "-----------------------+";
		System.out.println(result);
	}

	private static String format(int number) {
		if (number > 9) {
			return number + "";
		} else {
			return number + " ";
		}
	}
}

package elevator.bokarev.name;

import java.util.List;

public class App {

	public static void main(String[] args) throws InterruptedException {
		Building building = new Building(5, 20);
		Utils.print(building);
		
		//------------------

		Elevator elevator = building.getElevator();
		int currentFloor = 0;

		while(true) {
			currentFloor = elevator.elevate();
			List<Person> out = elevator.unload();
			List<Person> in = building.getFloor(currentFloor).getQueue();
			List<Person> entered = elevator.tryEnter(in);
						
			in.removeAll(entered);
			in.addAll(out);

			for (Person person : out) {
				person.assignTargetFloor(building.getFloorNumber());
			}
			
			Utils.print(building);
			Thread.sleep(1000);
		}
	}

}

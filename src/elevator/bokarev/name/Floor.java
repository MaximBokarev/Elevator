package elevator.bokarev.name;

import java.util.ArrayList;
import java.util.List;

public class Floor {

	private List<Person> queue;
	private int maxFloorNumber;
	private int number;

	public Floor(int number, int maxFloorNumber) {
		this.maxFloorNumber = maxFloorNumber;
		this.number = number;
		this.queue = new ArrayList<>();
		int personsCount = Utils.random(0, 10);
		for (int i = 0; i < personsCount; i++) {
			Person person = new Person(this.number);
			person.assignTargetFloor(this.maxFloorNumber);
			queue.add(person);
		}
	}

	public List<Person> getQueue() {
		return queue;
	}

	public int getNumber() {
		return number;
	}

}

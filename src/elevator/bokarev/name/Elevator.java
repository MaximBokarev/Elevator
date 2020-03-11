package elevator.bokarev.name;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
	private List<Person> passengers;
	private final int CAPACITY = 5;
	private int maxFloor;
	private int minFloor;
	private int currentFloor;
	private Direction direction;

	public Elevator() {
		passengers = new ArrayList<>(CAPACITY);
		direction = Direction.UP;
		minFloor = 1;
		maxFloor = minFloor + 1;
		currentFloor = minFloor - 1;
	}

	public int elevate() {
		int result = currentFloor;

		if (direction == Direction.UP) {
			result = ++currentFloor;
			if (result == maxFloor) {
				direction = Direction.DOWN;
			}
		} else {
			result = --currentFloor;
			if (result == minFloor) {
				direction = Direction.UP;
			}
		}

		return result;
	}

	private boolean tryLoad(Person person) {
		boolean result = false;
		if (hasMoreSpace()) {
			int targetFloor = person.getTargetFloor();
			if ((direction == Direction.UP && targetFloor > currentFloor) || (direction == Direction.DOWN && targetFloor < currentFloor)) {
				passengers.add(person);
				recalculateMaxFloor(person.getTargetFloor());
				result = true;
			}
		} 
		return result;
	}
	
	public List<Person> tryEnter(List<Person> persons) {
		List<Person> entered = new ArrayList<>(CAPACITY);
		for (Person person : persons) {
			if (tryLoad(person)) {
				entered.add(person);
			}
		}
		return entered;
		
	}

	public List<Person> unload() {
		List<Person> persons = new ArrayList<>(CAPACITY);
		for (Person person : passengers) {
			if (person.isTargetFloor(currentFloor)) {
				persons.add(person);
			}
		}
		passengers.removeAll(persons);
		return persons;
	}

	private boolean hasMoreSpace() {
		return passengers.size() < CAPACITY;
	}

	private void recalculateMaxFloor(int floor) {
		if (maxFloor < floor) {
			maxFloor = floor;
		}
	}

	public Direction getDirection() {
		return direction;
	}

	public int getCurrentFloor() {
		return currentFloor;
	}

	public List<Person> getPassengers() {
		return passengers;
	}

}

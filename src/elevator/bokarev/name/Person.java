package elevator.bokarev.name;

public class Person {
	private int targetFloor;
	private int prevTargetFloor;

	public Person(int currentFloor) {
		targetFloor = currentFloor;
		prevTargetFloor = targetFloor;
	}

	public boolean isTargetFloor(int number) {
		return targetFloor == number;
	}
	
	public int getTargetFloor() {
		return targetFloor;
	}

	public int getPrevTargetFloor() {
		return prevTargetFloor;
	}

	public void assignTargetFloor(int max) {
		int newTargetFloor = Utils.random(1, max);
		while (newTargetFloor == targetFloor) {
			newTargetFloor = Utils.random(1, max);
		}
		prevTargetFloor = targetFloor;
		targetFloor = newTargetFloor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + targetFloor;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (targetFloor != other.targetFloor)
			return false;
		return true;
	}

}

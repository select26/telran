package dto;

import java.io.Serializable;

public class Car implements Serializable{

	private String regNumber;
	private String color;
	private State state 		= State.EXCELLENT;
	private String modelName;
	private boolean inUse 		= false;
	private boolean flRemoverd	= false;

	public Car() {
		super();
	}

	public Car(String regNumber, String color, String modelName) {
		super();
		this.regNumber = regNumber;
		this.color = color;
		this.modelName = modelName;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public String getColor() {
		return color;
	}

	public State getState() {
		return state;
	}

	public boolean isInUse() {
		return inUse;
	}

	public boolean isFlRemoverd() {
		return flRemoverd;
	}

	@Override
	public String toString() {
		return "Car [regNumber=" + regNumber + ", color=" + color + ", state=" + state + ", inUse=" + inUse
				+ ", flRemoverd=" + flRemoverd + "]";
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	public void setFlRemoverd(boolean flRemoverd) {
		this.flRemoverd = flRemoverd;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + (flRemoverd ? 1231 : 1237);
		result = prime * result + (inUse ? 1231 : 1237);
		result = prime * result + ((regNumber == null) ? 0 : regNumber.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Car other = (Car) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (flRemoverd != other.flRemoverd)
			return false;
		if (inUse != other.inUse)
			return false;
		if (regNumber == null) {
			if (other.regNumber != null)
				return false;
		} else if (!regNumber.equals(other.regNumber))
			return false;
		if (state != other.state)
			return false;
		return true;
	}

}

package in.shashwatanand.datascience;

public class CarRecord {
	public final Float mpg;
	public final Integer numberOfCylinders;
	public final Float displacement;
	public final Float weight;

	public CarRecord(Float mpg, Integer numberOfCylinders, Float displacement, Float weight) {
		super();
		this.mpg = mpg;
		this.numberOfCylinders = numberOfCylinders;
		this.displacement = displacement;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "CarRecord [mpg=" + mpg + ", numberOfCylinders=" + numberOfCylinders + ", displacement=" + displacement
				+ ", weight=" + weight + "]";
	}
}

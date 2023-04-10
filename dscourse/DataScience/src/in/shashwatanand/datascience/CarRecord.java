package in.shashwatanand.datascience;

public class CarRecord {
	public final Float mpg;
	public final Integer numberOfCylinders;
	public final Float displacement;
	public final Float weight;
	public final Integer year;

	public CarRecord(Float mpg, Integer numberOfCylinders, Float displacement, Float weight, Integer year) {
		super();
		this.mpg = mpg;
		this.numberOfCylinders = numberOfCylinders;
		this.displacement = displacement;
		this.weight = weight;
		this.year = year;
	}

	@Override
	public String toString() {
		return "CarRecord [mpg=" + mpg + ", numberOfCylinders=" + numberOfCylinders + ", displacement=" + displacement
				+ ", weight=" + weight + ", year=" + year + "]";
	}
}

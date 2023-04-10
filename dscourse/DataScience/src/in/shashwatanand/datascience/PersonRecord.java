package in.shashwatanand.datascience;

public class PersonRecord {
	public final Integer age;
	public final String eploymentStatus;
	public final String eduation;

	public PersonRecord(Integer age, String eploymentStatus, String eduation) {
		super();
		this.age = age;
		this.eploymentStatus = eploymentStatus;
		this.eduation = eduation;
	}

	@Override
	public String toString() {
		return "PersonRecord [age=" + age + ", eploymentStatus=" + eploymentStatus + ", eduation=" + eduation + "]";
	}

}

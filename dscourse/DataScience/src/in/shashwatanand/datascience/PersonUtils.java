package in.shashwatanand.datascience;

public class PersonUtils {
	public static String getFirstName(Person person) {
		return person.getName().split(" ")[0];
	}
}

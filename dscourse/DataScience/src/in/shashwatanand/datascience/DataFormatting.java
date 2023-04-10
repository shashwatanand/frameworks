package in.shashwatanand.datascience;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

public class DataFormatting {
	private static class Person {
		private final Integer id;
		private final String name;
		private final Boolean likesPizza;
		
		public Person(Integer id, String name, Boolean likesPizza) {
			super();
			this.id = id;
			this.name = name;
			this.likesPizza = likesPizza;
		}

		public Integer getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public Boolean getLikesPizza() {
			return likesPizza;
		}
	}
	
	private static class PersonUtils {
		public static String getFirstName(Person person) {
			return person.getName().split(" ")[0];
		}
	}
	
	public static void main(String[] args) {
		// Univariate arrays
		String[] names = { "Shashwat Anand", "Shubhangi Sinha", "Akash Anand", "Shirolly Anand" };
		Integer[] ids = {123, 234, 345, 456};
		Boolean[] likesPizza = {false, true, true, false};
		
		// Multivariate arrays
		Integer[] person1 = {123, 0, 1994, 4, 3};
		Integer[] person2 = {234, 1, 1940, 8, 4};
		
		//Matrices
		double[][] peopleData = {
				{123, 0, 1994, 4, 3},
				{234, 1, 1940, 8, 4}
		};
		
		RealMatrix matrix = new Array2DRowRealMatrix(peopleData);
		
		// Data Objects
		List<Person> peopleList = new ArrayList<>();
		peopleList.add(new Person(123, "Shashwat Anand", true));
		peopleList.add(new Person(234, "Shubhangi Sinha", false));
		peopleList.add(new Person(345, "Akash Anand", true));
		peopleList.add(new Person(456, "Shirolly Anand", false));
	}
}

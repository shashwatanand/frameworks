package in.shashwatanand.datascience;

import java.util.List;
import java.util.stream.Collectors;

public class TextLoading {
	public static void main(String[] args) {
		List<String> peopleDataLines = TextLoader.getLines("adult-sample.data");
		List<PersonRecord> people = peopleDataLines.stream()
				.map((line) -> PersonRecordUtil.parsePerson(line))
				.collect(Collectors.toList());
		people.forEach(System.out::println);
		
		List<String> autoDataLines = TextLoader.getLines("auto-mpg.data");
		List<CarRecord> cars = autoDataLines.stream()
				.map((line) -> CarRecordUtil.parseCar(line))
				.collect(Collectors.toList());
		cars.forEach(System.out::println);
	}
}

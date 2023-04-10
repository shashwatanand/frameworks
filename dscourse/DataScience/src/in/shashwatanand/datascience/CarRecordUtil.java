package in.shashwatanand.datascience;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarRecordUtil {
	public static CarRecord parseCar(String dataString) {
		List<String> fields = new ArrayList<>(Arrays.asList(dataString.split("\\s+")));

		try {
			Float mpg = Float.parseFloat(fields.get(0).trim());
			Integer numberOfCylinders = Integer.parseInt(fields.get(1).trim());
			Float displacement = Float.parseFloat(fields.get(2).trim());
			Float weight = Float.parseFloat(fields.get(4).trim());
			Integer year = Integer.parseInt(fields.get(6).trim());

			return new CarRecord(mpg, numberOfCylinders, displacement, weight, year);
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
			return null;
		}
	}

	public static Float getAvergeMpg(List<CarRecord> cars) {
		Float sum = 0f;
		for (CarRecord carRecord : cars) {
			sum += carRecord.mpg;
		}
		return sum / cars.size();
	}
}

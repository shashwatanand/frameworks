package in.shashwatanand.datascience;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVRecord;

public class CSVLoading {
	public static void main(String[] args) {
		List<CSVRecord> records = CSVLoader.parseCSV("Groceries_dataset.csv");
		List<GroceryRecord> groceriesRecords = records.stream()
				.map((record) -> GroceryRecordUtil.parseGroceryRecord(record))
				.collect(Collectors.toList());
		groceriesRecords.forEach(System.out::println);
		
		Map<String, List<GroceryRecord>> recordsByMemberNumber = GroceryRecordUtil
				.groupGroceryRecordByMemberNumber(groceriesRecords);

		System.out.println(recordsByMemberNumber);
	}
}

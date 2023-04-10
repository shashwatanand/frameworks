package in.shashwatanand.datascience;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVRecord;

public class GroceryRecordUtil {
	public static GroceryRecord parseGroceryRecord(CSVRecord record) {
		try {
			String memberNumber = record.get("Member_number");
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(record.get("Date"));
			String itemDescription = record.get("itemDescription");
			return new GroceryRecord(memberNumber, date, itemDescription);
		}catch (Exception e) {
			System.out.println("Execption : " + e);
			return null;
		}
	}

	public static Map<String, List<GroceryRecord>> groupGroceryRecordByMemberNumber(
			List<GroceryRecord> groceriesRecords) {
		List<String> allMemberNumber = new ArrayList<>(groceriesRecords.stream()
				.map((record) -> record.memberNumber)
				.collect(Collectors.toSet()));
		
		Map<String, List<GroceryRecord>> groceryRecordByMember = new HashMap<>();
		for (String memberNumber : allMemberNumber) {
			List<GroceryRecord> memberRecords = groceriesRecords.stream()
					.filter((grocery) -> grocery.memberNumber == memberNumber)
					.collect(Collectors.toList());
			groceryRecordByMember.put(memberNumber, memberRecords);
		}
		return groceryRecordByMember;
	}
}

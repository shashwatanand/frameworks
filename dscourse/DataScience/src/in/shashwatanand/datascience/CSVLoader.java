package in.shashwatanand.datascience;

import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class CSVLoader {
	public static List<CSVRecord> parseCSV(String fileName) {
		List<CSVRecord> records = new ArrayList<>();
		try {
			Reader reader = new FileReader(fileName);
			Iterable<CSVRecord> recordsIterable = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);
			for (CSVRecord csvRecord : recordsIterable) {
				records.add(csvRecord);
			}
		} catch (Exception e) {
			System.out.println("Exception e : " + e);
		}
		return records;
	}
}

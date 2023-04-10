package in.shashwatanand.datascience;

import java.util.Date;

public class GroceryRecord {
	public final String memberNumber;
	public final Date date;
	public final String itemDesciption;

	public GroceryRecord(String memberNumber, Date date, String itemDesciption) {
		super();
		this.memberNumber = memberNumber;
		this.date = date;
		this.itemDesciption = itemDesciption;
	}

	@Override
	public String toString() {
		return "GroceryRecord [memberNumber=" + memberNumber + ", date=" + date + ", itemDesciption=" + itemDesciption
				+ "]";
	}

}

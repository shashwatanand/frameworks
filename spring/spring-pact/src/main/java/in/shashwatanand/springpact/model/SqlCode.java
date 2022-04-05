package in.shashwatanand.springpact.model;

public class SqlCode {
	private String statement;

	public SqlCode(String statement) {
		super();
		this.statement = statement;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}
}

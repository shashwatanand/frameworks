package in.shashwatanand.datascience;

public class Person {
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

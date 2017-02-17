package account;

public class Account {

	
	private Integer id;
	
	private String name;
	
	private Integer money;

	
	public Account() {
		
	}
	
	public Account(Integer money){
		this.money=money;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money
				+ "]";
	}

	
	
	
	
	
}

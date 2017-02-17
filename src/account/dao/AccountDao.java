package account.dao;

public interface AccountDao {
	//创建一个转出的方法
	public void addMoney(String out,Integer money);
	
	//创建一个转入的方法
	public void reduceMoney(String in,Integer money);
}

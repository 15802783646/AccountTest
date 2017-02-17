package account.daoImpl;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import account.Account;
import account.AccountBankException;
import account.dao.AccountDao;

@Repository
public class AccountDaoImpl implements AccountDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	//创建一个得到绑定线程的session方法
	private  Session getSession(){
		return	sessionFactory.getCurrentSession();
		
	}


	@Override//转入的方法
	public void addMoney(String inName, Integer money) {
		
		String hql="update Account set money = money+ ? where name = ?";
		getSession().createQuery(hql).setInteger(0, money).setString(1, inName).executeUpdate();

	}

	@Override//转出的方法
	public void reduceMoney(String outName, Integer money) {
		//为转出的钱加入约束，如果余额不足，则发生异常。
		String hql=" from Account where name = ?";
		
		Account account=(Account) getSession().createQuery(hql).setString(0, outName).uniqueResult();
		if(	account.getMoney()<money){
			throw new AccountBankException("余额不足");
		}
		
		
		String hql2="update Account set money = money -? where name =?";
		getSession().createQuery(hql2).setInteger(0, money).setString(1, outName).executeUpdate();
		
	}

}

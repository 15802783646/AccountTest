package account.ServiceImpl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import account.dao.AccountDao;
import account.service.AccountService;

@Transactional  //注入事物
@Service		//表示是service层
public class AccountServiceImpl implements AccountService {
	
	//注入dao层对象
	@Autowired
	private AccountDao accountDao;

	@Override
	public void bankaccount(String out, String in, Integer money) {
		
		accountDao.reduceMoney(out, money);
		accountDao.addMoney(in, money);
		
		
	}

}

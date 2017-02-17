package accountTest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import account.service.AccountService;

public class TestAccount {

	private ApplicationContext ctx=null;
	
	private AccountService accountService=null;
	
	{
		ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		 accountService=ctx.getBean(AccountService.class);
	}
	
	@Test
	public void test(){
		
		accountService.bankaccount("aaa", "bbb", 200);
	}
	
	
}

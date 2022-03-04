package solid;

import java.math.BigDecimal;

/* Liskov's Substitution Principle: Derived types must be completely 
 * substitutable for their base types.
 */

/* The following commented-out structure of classes violate LSP. */

//abstract class Account {
//	abstract protected void deposit(BigDecimal amount);
//	abstract protected void withdraw(BigDecimal amount);
//}
//
//class FixedTermDepositAccount extends Account {
//	
//    @Override
//    protected void deposit(BigDecimal amount) {
//    	System.out.println(amount + " deposited to Fixed term deposit account");
//    }
//
//	@Override 
//	protected void withdraw(BigDecimal amount) {
//		throw new UnsupportedOperationException("Withdrawals are not supported by FixedTermDepositAccount!!");
//	}
//
//}
//
//class CurrentAccount extends Account {
//
//	@Override
//	protected void deposit(BigDecimal amount) {
//		// some implementation
//		
//	}
//
//	@Override
//	protected void withdraw(BigDecimal amount) {
//		// some implementation
//		
//	}
//	
//}
//
//class SavingsAccount extends Account {
//
//	@Override
//	protected void deposit(BigDecimal amount) {
//		// some implementation
//		
//	}
//
//	@Override
//	protected void withdraw(BigDecimal amount) {
//		// some implementation
//		
//	}
//	
//}
//
//class BankingAppWithdrawalService {
//    private Account account;
//
//    public BankingAppWithdrawalService(Account account) {
//        this.account = account;
//    }
//
//    public void withdraw(BigDecimal amount) {
//        account.withdraw(amount);
//    }
//}
//
//Account myFixedTermDepositAccount = new FixedTermDepositAccount();
//myFixedTermDepositAccount.deposit(new BigDecimal(1000.00));
//
//BankingAppWithdrawalService withdrawalService = new BankingAppWithdrawalService(myFixedTermDepositAccount);
//withdrawalService.withdraw(new BigDecimal(100.00)); // crashes with error

/* The following implementation fixes LSP violation */
abstract class Account {
	abstract void deposit(BigDecimal amount);
}

abstract class WithdrawableAccount extends Account {

	protected abstract void deposit(BigDecimal amount);

	protected abstract void withdraw(BigDecimal amount);

}

class FixedTermDepositAccount extends Account {

	@Override
	protected void deposit(BigDecimal amount) {
		System.out.println(amount + " deposited to Fixed term deposit account");
	}

}

class CurrentAccount extends WithdrawableAccount {

	@Override
	protected void deposit(BigDecimal amount) {
		System.out.println(amount + " deposited to Current Account");
	}

	@Override
	protected void withdraw(BigDecimal amount) {
		System.out.println(amount + " withdrawn from Current Account");
	}

}

class SavingsAccount extends WithdrawableAccount {

	@Override
	protected void deposit(BigDecimal amount) {
		System.out.println(amount + " deposited to Savings Account");
	}

	@Override
	protected void withdraw(BigDecimal amount) {
		System.out.println(amount + " withdrawn from Savings Account");
	}

}

class BankingAppWithdrawalService {
	private WithdrawableAccount account; // WithdrawableAccount instead of Account

	public BankingAppWithdrawalService(WithdrawableAccount account) {
		this.account = account;
	}

	public void withdraw(BigDecimal amount) {
		account.withdraw(amount);
	}
}

public class LiskovSubstitutionPrinciple {

	public static void main(String[] args) {
		WithdrawableAccount currentAccount = new CurrentAccount();
		WithdrawableAccount savingsAccount = new SavingsAccount();

		BankingAppWithdrawalService bankService1 = 
				new BankingAppWithdrawalService(savingsAccount);
		BankingAppWithdrawalService bankService2 = 
				new BankingAppWithdrawalService(currentAccount);

		bankService1.withdraw(new BigDecimal("1000.00"));
		bankService2.withdraw(new BigDecimal("500.00"));

//		The following line will now be invalid
//		BankingAppWithdrawalService bankService3 = 
//				new BankingAppWithdrawalService(new FixedTermDepositAccount());

	}
}

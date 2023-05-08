package Quiz1;

public class CheckingAccount extends BankAccount{

// Pranav Yalamala & Yashvardhan Sharma
// I pledge my honor that I have abided by the Steven's Honor system.

private int transactions;

public CheckingAccount(double initialBalance){
    super(initialBalance);
    transactions = 0;
}

public void withdraw(double amount){
    if(amount <= this.getBalance()){
        super.withdraw(amount);
        transactions += 1;
    }
    else{
        super.withdraw(amount);
    }
}

public void deposit(double amount){
    super.deposit(amount);
    transactions += 1;
}

public void transfer(double amount, BankAccount destination){
    if(amount <= this.getBalance()){
        super.transfer(amount, destination);
        transactions += 1;
    }
    else{
        super.transfer(amount, destination);
    }
}

    
}

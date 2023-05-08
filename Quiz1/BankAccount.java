package Quiz1;

public class BankAccount {
// Pranav Yalamala & Yashvardhan Sharma
// I pledge my honor that I have abided by the Steven's Honor system.

private double balance;


public BankAccount(){
    balance = 0;
}

public BankAccount(double initialBalance){
    balance = initialBalance;
}

public void deposit(double amount){
    balance += amount;
}

public void withdraw(double amount){
    if(amount <= balance){
        balance -= amount;
    }
    else{
        System.out.println("Balance is insufficient.");
    }
}

public double getBalance(){
    return balance;
}

public void transfer(double amount, BankAccount destination){
    if(amount <= balance){
        this.withdraw(amount);
        destination.deposit(amount);
    }
    else{
        System.out.println("Balance is insufficient.");
    }
}



    
}

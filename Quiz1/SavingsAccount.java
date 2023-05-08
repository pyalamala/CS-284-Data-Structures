package Quiz1;

public class SavingsAccount extends BankAccount{

// Pranav Yalamala & Yashvardhan Sharma
// I pledge my honor that I have abided by the Steven's Honor system.

private double rate;

public SavingsAccount(double rate){
    super();
    this.rate = rate;
}

public void addInterest(){
    super.deposit(rate * this.getBalance());
}
    
}

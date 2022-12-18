package core;

public class Treasury {
    int balance = 1000;
    Champion ch;

    public int getBalance() {
        return balance;
    }
//    public void deductBalance(){
//        balance -= ch.entryFee;
//    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

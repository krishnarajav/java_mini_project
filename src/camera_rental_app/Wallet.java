package camera_rental_app;
 
public class Wallet {
 
    private double balance = 0;
 
    public void addAmount(double amt) {
        balance += amt;
    }
 
    public void deduct(double amt) {
        if (balance < amt)
            throw new RuntimeException("INSUFFICIENT WALLET AMOUNT");
        balance -= amt;
    }
 
    public double getBalance() {
        return balance;
    }
}
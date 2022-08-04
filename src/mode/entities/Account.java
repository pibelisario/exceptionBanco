package mode.entities;

import model.exceptions.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withDrawLimit;

    public Account(){}


    public Account(Integer number, String holder, Double balance, Double withDrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withDrawLimit = withDrawLimit;
    }


    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithDrownLimit() {
        return withDrawLimit;
    }

    public void deposit(Double amount){
        balance += amount;
    }

    public void whithDrawn(Double amount) throws DomainException {
        validateWithdraw(amount);
        balance -= amount;
    }

    public void validateWithdraw(double amount) throws DomainException {
        if (amount > withDrawLimit){
            throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
        }

        if (amount > balance){
            throw new DomainException("Withdraw error: Not enough balance");
        }
    }
}

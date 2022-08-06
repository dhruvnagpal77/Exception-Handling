package com.package3.CustomExceptions;

// Creating our own custom Exception

public class ExceptionHandlingRunner5 {

    public static void main(String[] args) {
        Amount amount1 = new Amount("USD", 10);
        Amount amount2 = new Amount("EUR", 20);
        try {
            amount1.addAmount(amount2);
        } catch (CurrencyDontMatchException e) {
            e.printStackTrace();
        }
        System.out.println(amount1);
    }

}

class Amount {
    String currency;
    int value;

    public Amount(String currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    // We don't want user to add 2 different types of currencies
    void addAmount (Amount that) throws  CurrencyDontMatchException{
        if (!this.currency.equals(that.currency)) {
            // Since we are throwing an Exception which also includes Checked Exception,
            // we forced to throw or handle it(In this case we are throwing it to calling method).
            throw new CurrencyDontMatchException("Currency don't match " + this.currency + " & " + that.currency);
        }
        this.value = this.value + that.value;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}

class CurrencyDontMatchException extends Exception {
    public CurrencyDontMatchException(String msg) {
        super(msg);
    }

}
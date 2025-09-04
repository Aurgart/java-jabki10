package user_exceptions;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(){
        super("Баланс недостаточен");
    }
}

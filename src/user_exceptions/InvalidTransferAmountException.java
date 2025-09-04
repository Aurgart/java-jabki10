package user_exceptions;

public class InvalidTransferAmountException extends Exception{
    public InvalidTransferAmountException() {
        super("Сумма операции не может быть меньше нуля");
    }
}

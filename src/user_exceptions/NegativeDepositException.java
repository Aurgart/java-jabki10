package user_exceptions;

public class NegativeDepositException extends Exception {
    public NegativeDepositException() {
        super("Сумма операции по депозиту не может быть меньше нуля.");
    }
}

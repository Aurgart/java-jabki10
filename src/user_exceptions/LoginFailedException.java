package user_exceptions;

public class LoginFailedException extends Exception {
    public LoginFailedException() {
        super("Неверные данные для логина ");
    }
}

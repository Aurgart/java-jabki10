package user_exceptions;

public class InvalidRatingException extends Exception {
    public InvalidRatingException() {
        super("Рейтинг выходит за пределы от 1 до 5");
    }
}

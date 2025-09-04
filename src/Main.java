import user_exceptions.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    // логины для теста
    static HashMap<String, String> logins = new HashMap<>();
    // продукты
    static List<Item> itemList = new ArrayList<>();

    public static void main(String[] args) {
        // Задание 1
        System.out.println("Задание 1");
        System.out.println(safeDivide(27, 3));
        System.out.println(safeDivide(20, 0));
        // Задание 2
        System.out.println("Задание 2");
        System.out.println(checkString("test") ? "не пустая" : "пустая строка");
        System.out.println(checkString("   ") ? "не пустая" : "пустая строка");
        //
        System.out.println("Задание 3");
        List<String> lst = new ArrayList<>();
        lst.add("5");
        lst.add("3");
        lst.add("ttt");
        lst.add("2");
        List<Integer> lstInt = strToInt(lst);
        System.out.println(lstInt);
        //
        System.out.println("Задание 4");
        System.out.println(setAge(45));
        System.out.println(setAge(-1));
        //
        System.out.println("Задание 5");
        System.out.println("Проверяется в тесте.");
        //
        System.out.println("Задание 6");
        System.out.println("Проверяется в тесте.");
        //
        System.out.println("Задание 7");
        String path = "test";
        System.out.println(readFile(path));
        path = "C:\\Users\\ilemeshev\\IdeaProjects\\java-jabki10\\testfile.txt";
        System.out.println(readFile(path));

        //
        System.out.println("Задание 8");
        System.out.println("Проверяется в тесте.");
        //
        System.out.println("Задание 9");
        System.out.println("Проверяется в тесте.");
        //
        System.out.println("Задание 10");
        System.out.println("Проверяется в тесте.");
    }
    /*
     1. Безопасное деление
        Напишите метод safeDivide(int a, int b), который возвращает a / b. Если b == 0, перехватите исключение и выведите сообщение: "Деление на ноль запрещено".
     */

    /**
     * Безопасное деление, учитывает что параметр может быть ноль
     *
     * @param a - что делим
     * @param b - на что делим
     * @return - результат деления.
     */
    public static Double safeDivide(int a, int b) {
        try {
            if (b == 0) {
                throw new IllegalArgumentException("b = 0");
            }
            return (double) a / b;
        } catch (IllegalArgumentException e) {
            System.out.println("В математике нельзя делить на ноль, ибо ответ бессмысленнен");
            return null;
        }
    }
    /*
      2. Проверка строки
      Напишите метод, который принимает строку и выбрасывает IllegalArgumentException, если строка пуста или состоит только из пробелов.
    */

    /**
     * Проверка строки на пустоту.
     *
     * @param str - строка для проверки
     * @return - результат
     */
    public static boolean checkString(String str) {
        try {
            if (str == null || str.isBlank()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return false;
        }
        return true;
    }

    /*
        3. Преобразование строки в число
        Дан список строк List.of("10", "abc", "5"). Преобразуйте его в список чисел, перехватывая NumberFormatException.
        Ошибки не должны останавливать выполнение.
     */

    /**
     * Преобразования строк к числам
     *
     * @param strList - список строк
     * @return - список чисел
     */
    public static List<Integer> strToInt(List<String> strList) {
        List<Integer> resList = new ArrayList<>();
        for (String str : strList) {
            try {
                Integer i = Integer.parseInt(str);
                resList.add(i);
            } catch (NumberFormatException e) {
                System.out.println(str + " не число");
            }
        }
        return resList;
    }

    /*
        4. Простая валидация возраста
        Метод setAge(int age) должен выбрасывать IllegalArgumentException, если возраст меньше нуля. Обработайте исключение и выведите сообщение.
    */
    public static String setAge(int age) {
        try {
            if (age < 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            return "Возраст не может быть меньше нуля!";
        }
        return "Возраст жертвы: " + age;
    }
    /*
        5. Собственное исключение: депозит
        Создайте исключение NegativeDepositException, и метод deposit(double amount), который выбрасывает это исключение при отрицательном значении.
        Обработайте его в main.
     */

    /**
     * Внесение на депозит
     *
     * @param amount - сумма внесения
     * @throws NegativeDepositException - исключение если сумма отрицательная
     */
    public static void deposit(double amount) throws NegativeDepositException {
        if (amount < 0) {
            throw new NegativeDepositException();
        }
        System.out.println("Сумма: " + amount + " внесена на депозит.");
    }

    /*
    8. Система логина
        Создайте метод login(String username, String password), в котором логин и пароль проверяются на корректность.
        Если один из них не совпадает — выбрасывается LoginFailedException. Исключение должно наследоваться от Exception.
    */
    public static boolean login(String username, String password) throws LoginFailedException {
        if (username == null || username.isBlank() || password.isBlank() || password == null) {
            throw new LoginFailedException();
        }
        if (logins.get(username) != password) {
            throw new LoginFailedException();
        }
        return true;
    }
    /*
        6. Поиск товара по коду
        Реализуйте метод getItem(String code). Если код не найден в карте товаров, выбросите ItemNotFoundException, унаследованное от RuntimeException.
        Продемонстрируйте поведение в main.
     */

    /**
     * Получает предмет из списка
     *
     * @param code - код товара
     * @return - товар
     * @throws ItemNotFoundException - если товара нет исключение.
     */
    public static Item getItem(String code) throws ItemNotFoundException {
        //Item result = new Item();
        for (Item i : itemList) {
            if (i.getItemCode() == code) {
                return i;
            }
        }
        throw new ItemNotFoundException();
    }

    /*
        10. Сервис оценки товара
        Реализуйте метод rateProduct(int rating), который:
            принимает значение от 1 до 5
            выбрасывает InvalidRatingException (checked), если значение вне диапазона
            сохраняет рейтинг в списке, если всё хорошо
            также перехватывает NumberFormatException, если рейтинг пришёл в виде строки, но содержит нечисловое значение
     */

    /**
     * Оценивает товар из списка
     *
     * @param rating - новый рейтинг
     * @param code   - код товара который оцениваем
     * @throws InvalidRatingException - исключение если рейтинг мимо.
     */
    public static void rateProduct(String rating, String code) throws InvalidRatingException {
        int rate = 0;
        try {
            rate = Integer.parseInt(rating);
        } catch (NumberFormatException e) {
            System.out.println("Рейтинг товара не численный.");
            return;
        }
        if (rate > 5 || rate < 1) {
            throw new InvalidRatingException();
        }
        for (Item i : itemList) {
            if (i.getItemCode() == code) {
                i.setRating(rate);
            }
        }
    }

    /*
     9. Банковский перевод с валидацией
        Метод transfer(fromAccount, toAccount, amount):
            выбрасывает InvalidTransferAmountException, если сумма <= 0
            выбрасывает InsufficientBalanceException, если баланс отправителя меньше суммы
            содержит try-catch в main
    */

    /**
     * Перенос бабла из одного кармана в другой
     *
     * @param fromAcc - откуда
     * @param toAcc   - куда
     * @param summ    - сколько
     * @throws InvalidTransferAmountException - сумма меньше нуля
     * @throws InsufficientBalanceException   - тут нехватает
     */
    public static void transfer(Account fromAcc, Account toAcc, double summ) throws InvalidTransferAmountException, InsufficientBalanceException {
        if (summ <= 0) {
            throw new InvalidTransferAmountException();
        }
        if (fromAcc.getBalance() > summ) {
            fromAcc.withdraw(summ);
            toAcc.deposit(summ);
        } else {
            throw new InsufficientBalanceException();
        }
    }
    /*
    7. Чтение из файла
    Реализуйте метод readFile(String path), который читает текстовый файл и возвращает список строк.
    Используйте BufferedReader, перехватите IOException, выведите сообщение об ошибке.
    */

    /**
     * Читает файл
     *
     * @param path - откуда
     * @return - список строк
     */
    public static List<String> readFile(String path) {
        List<String> fileStr = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String buff;
            while ((buff = reader.readLine()) != null) {
                fileStr.add(buff);
            }
        } catch (IOException e) {
            fileStr.add(e.getLocalizedMessage());
            return fileStr;
        }
        return fileStr;
    }
}
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import user_exceptions.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    // Задание 5
    @Test
    public void testDeposit() throws NegativeDepositException {
        Main.deposit(1500);
        NegativeDepositException newExcp = assertThrows(NegativeDepositException.class, () -> Main.deposit(-10));
        assertTrue(newExcp.getMessage().contains("Сумма операции по депозиту не может быть меньше нуля."));
    }

    // Задание 6
    @Test
    public void testGetItem() throws ItemNotFoundException {
        Main.itemList.add(new Item("Тапки мажора", "tapok"));
        Main.itemList.add(new Item("Вода нарзан", "water"));
        Main.itemList.add(new Item("Балтика 9", "pivko"));
        assertEquals(Main.getItem("pivko").getItemName(), "Балтика 9");
        ItemNotFoundException newExcp = assertThrows(ItemNotFoundException.class, () -> Main.getItem("eda"));
        assertTrue(newExcp.getMessage().contains("Нет такого товара"));
    }

    // Задание 10
    @Test
    public void testRateProduct() throws InvalidRatingException {
        Main.itemList.add(new Item("Тапки мажора", "tapok"));
        Main.itemList.add(new Item("Вода нарзан", 5, "water", 90));
        Main.itemList.add(new Item("Балтика 9", 3, "pivko", 120));
        Main.rateProduct("4", "tapok");
        assertEquals(Main.getItem("tapok").getRating(), 4);
        InvalidRatingException newExcp = assertThrows(InvalidRatingException.class, () -> Main.rateProduct("6", "tapok"));
        assertTrue(newExcp.getMessage().contains("Рейтинг выходит за пределы"));
    }

    // Задание 9
    @Test
    public void testBalance() throws InvalidTransferAmountException, InsufficientBalanceException {
        Account acc1 = new Account("12-45-6749", 5000);
        Account acc2 = new Account("78-45-7504", 2000);
        acc1.getInfo();
        acc2.getInfo();
        InvalidTransferAmountException newExcpAm = assertThrows(InvalidTransferAmountException.class, () -> Main.transfer(acc1, acc2, -300));
        assertTrue(newExcpAm.getMessage().contains("Сумма операции"));
        InsufficientBalanceException newExcpBal = assertThrows(InsufficientBalanceException.class, () -> Main.transfer(acc2, acc1, 3000));
        assertTrue(newExcpBal.getMessage().contains("Баланс недостаточен"));
        Main.transfer(acc1, acc2, 400);
        acc1.getInfo();
        acc2.getInfo();
    }

    // Задание 8
    @Test
    public void testLogin() throws LoginFailedException {
        Main.logins.put("lops", "12344-sd");
        Main.logins.put("potc", "password");
        LoginFailedException newExcpAm = assertThrows(LoginFailedException.class, () -> Main.login("lops", "4545"));
        newExcpAm = assertThrows(LoginFailedException.class, () -> Main.login("potc", ""));
        assertTrue(Main.login("potc", "password"));
    }
}
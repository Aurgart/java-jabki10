public class Account {
    private String accNum;
    private double balance;

    public Account(String num) {
        this.accNum = num;
        this.balance = 0;
    }

    public Account(String num, double summ) {
        this.accNum = num;
        if (summ > 0) {
            this.balance = summ;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return this.balance;
    }

    /**
     * Снять деньги
     *
     * @param sum - сумма снятия
     */
    public void withdraw(double sum) {
        if (sum > 0 && balance - sum >= 0) {
            this.balance -= sum;
        }
    }

    /**
     * Внести деньги
     *
     * @param sum - сумма внесения.
     */
    public void deposit(double sum) {
        if (sum > 0) {
            this.balance += sum;
        }
    }

    /**
     * вывести информацию.
     */
    public void getInfo() {
        System.out.println("Счет номер: " + this.accNum + " сумма на счете:" + this.balance);
    }
}

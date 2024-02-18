public class Account {
    private final String firstName;
    private final String lastName;
    private BigDecimal balance;
    private static int uid = 0;
    private final PhoneNumber phoneNumber;
    private final int id;

    public Account(String firstName, String lastName, PhoneNumber phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.balance = BigDecimal.ZERO;
        uid++;
        this.id = uid;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal newBalance) {
        this.balance = newBalance;
    }

    public int getID() {
        return this.id;
    }

    public PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public void depositMoney(BigDecimal depositAmount) {
        this.balance = this.balance.add(depositAmount);
        System.out.println("You have deposited " + depositAmount + " to your account." + 
                "\n" + "Balance is now: " + this.balance);
    }

    public void withdrawal(BigDecimal withdrawalAmount) throws NegativeAmountException {
        if (withdrawalAmount.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeAmountException("Withdrawal amount cannot be negative.");
        }
        if (this.balance.compareTo(withdrawalAmount) < 0) {
            System.out.println("You don't have enough funds.");
        } else {
            this.balance = this.balance.subtract(withdrawalAmount);
            System.out.println("You have withdrawn " + withdrawalAmount + " from your account." + 
                    "\n" + "Balance is now: " + this.balance);
        }
    }

    public void moneyTransfer(Account toAccount, BigDecimal amountToTransfer) throws NegativeAmountException, UnknownAccountException {
        if (amountToTransfer.compareTo(BigDecimal.ZERO) < 0) {
            throw new NegativeAmountException("Transfer amount cannot be negative.");
        }
       

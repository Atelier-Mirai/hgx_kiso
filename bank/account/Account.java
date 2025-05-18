package bank.account;
import bank.holder.Holder;

/**
 * 口座クラス
 * 
 * このクラスは、銀行口座の情報を管理します。
 * 口座名義人、口座番号、残高の情報を保持し、入出金の操作を行います。
 * 
 * @author アトリヱ未來
 * @version 1.0
 */
public class Account {
    /** 口座名義人 */
    private Holder holder;
    /** 口座番号 */
    private String number;
    /** 残高 */
    protected int balance;
    /** 利子計算クラス */
    protected InterestCalculator interestCalculator;

    /**
     * コンストラクタ
     * 
     * @param holder   口座名義人
     * @param number   口座番号
     * @param balance  初期残高
     * @param interestCalculator 利子計算を行うための計算機
     */
    public Account(Holder holder, String number, int balance, InterestCalculator interestCalculator) {
        this.holder = holder;
        this.number = number;
        this.balance = balance;
        this.interestCalculator = interestCalculator;
    }

    /**
     * 口座名義人を取得します
     * 
     * @return 口座名義人
     */
    public Holder getHolder() {
        return holder;
    }

    /**
     * 口座番号を取得します
     * 
     * @return 口座番号
     */
    public String getNumber() {
        return number;
    }

    /**
     * 現在の残高に対する利子を計算します
     * 
     * @return 計算された利子（円単位）
     * @see InterestCalculator
     */
    public int getInterest() {
        return interestCalculator.getInterest(balance);
    }

    /**
     * 残高を取得します
     * 
     * @return 現在の残高（円単位）
     */
    public int getBalance() {
        return balance;
    }

    /**
     * 入金処理を行います
     * 
     * @param amount 入金額（円単位）
     * @throws IllegalArgumentException 入金額が負の場合
     */
    public void deposit(int amount) {
        this.balance += amount;
    }

    /**
     * 残高を設定します
     * 
     * @param balance 新しい残高（円単位）
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * 出金処理を行います
     * 
     * @param amount 出金額
     * @throws IllegalArgumentException 残高が不足していて出金できない場合
     */
    public void withdraw(int amount) {
        if (this.balance < amount) {
            throw new IllegalArgumentException("残高が不足しています");
        }
        this.balance -= amount;
        // 口座名義人の返金額を加算
        System.out.println("返金額: " + this.holder.getCashBackAmount(amount));
        this.balance += this.holder.getCashBackAmount(amount);
    }
}

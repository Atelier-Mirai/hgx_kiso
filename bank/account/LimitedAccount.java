package bank.account;
import bank.holder.Holder;

/**
 * 限度額付き口座クラス
 * 
 * このクラスは、入金額に上限を設定できる口座を実装します。
 * Accountクラスを継承し、入金処理時に預け入れ限度額をチェックします。
 * 
 * @author アトリヱ未來
 * @version 1.0
 */
public class LimitedAccount extends Account {
    /**
     * 預け入れ限度額
     * 
     * この口座に入金できる最大金額を表します。
     */
    private int fullAmount;

    /**
     * コンストラクタ
     * 
     * @param holder   口座名義人
     * @param number   口座番号
     * @param balance  初期残高
     * @param fullAmount 預け入れ限度額
     * @param interestCalculator 利子計算クラス
     */
    public LimitedAccount(Holder holder, String number, int balance, int fullAmount, InterestCalculator interestCalculator) {
        // 親クラスのコンストラクタを呼び出し
        super(holder, number, balance, interestCalculator);
        // 預け入れ限度額を設定
        this.fullAmount = fullAmount;
    }

    /**
     * 入金処理を行います
     * 
     * @param amount 入金額
     * @throws IllegalArgumentException 入金額が負の場合
     * @throws IllegalArgumentException 預け入れ限度額を超える場合
     */
    @Override
    public void deposit(int amount) {
        // if (this.balance + amount <= this.fullAmount) {
        // 預け入れ後の残高が限度額を超えないかチェック
        if (this.getBalance() + amount > this.fullAmount) {
            throw new IllegalArgumentException("預け入れ限度額を超過するため、入金できません");
        }
        // 親クラスのdepositメソッドを呼び出し
        super.deposit(amount);
    }

    /**
     * 入金上限額を取得します
     * 
     * @return 入金上限額（円単位）
     */
    public int getFullAmountCondition() {
        return this.fullAmount - this.getBalance();
    }
}
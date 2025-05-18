package bank.account;

/**
 * 階層制利子計算クラス
 * 
 * このクラスは、金額に応じて異なる利子を計算するための実装クラスです。
 * 階層制の利子計算方法は以下の通りです：
 * - 10,000円未満：利子なし
 * - 10,000円以上100,000円未満：1,000円
 * - 100,000円以上：10,000円
 * 
 * @author アトリヱ未來
 * @version 1.0
 */
/**
 * 階層型金利計算機のデフォルトコンストラクタ
 * 
 * このコンストラクタは、階層型の金利計算機を作成します。
 * 計算方法は以下の通りです：
 * - 10,000円未満：0円
 * - 10,000円以上100,000円未満：1,000円
 * - 100,000円以上：10,000円
 */
public class TieredInterestCalculator implements InterestCalculator {
    /**
     * 階層型金利計算機のデフォルトコンストラクタ
     */
    public TieredInterestCalculator() {
    }
    /**
     * 金額に応じた階層制の利子を計算します
     * 
     * @param amount 利子を計算する対象の金額（円単位）
     * @return 計算された利子（円単位）
     * @see InterestCalculator
     */
    public int getInterest(int amount) {
        if (amount < 10000) {
            return 0;
        } else if (10000 <= amount && amount < 100000) {
            return 1000;
        } else {
            return 10000;
        }
    }
}

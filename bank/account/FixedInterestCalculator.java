package bank.account;

/**
 * 固定利子計算クラス
 * 
 * このクラスは、固定金利（5%）で利子を計算するための実装クラスです。
 * 入力された金額に対して5%の利子を計算します。
 * 
 * @author アトリヱ未來
 * @version 1.0
 */
/**
 * 固定金利計算機のデフォルトコンストラクタ
 * 
 * このコンストラクタは、5%の固定金利を使用する計算機を作成します。
 */
public class FixedInterestCalculator implements InterestCalculator {
    /**
     * 固定金利計算機のデフォルトコンストラクタ
     */
    public FixedInterestCalculator() {
    }
    /**
     * 固定金利（5%）
     */
    private static final int INTEREST_RATE = 5;
    /**
     * 固定金利（5%）で利子を計算します
     * 
     * @param amount 利子を計算する対象の金額（円単位）
     * @return 計算された利子（円単位）
     */
    public int getInterest(int amount) {
        return (int)(amount * INTEREST_RATE / 100);
    }
}

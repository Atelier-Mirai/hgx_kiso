package bank.account;

/**
 * 利子計算インターフェース
 * 
 * このインターフェースは、口座の利子計算を行うための規約を定義します。
 * 具体的な利子の計算方法は、実装クラスで定義されます。
 * 
 * @author アトリヱ未來
 * @version 1.0
 */
public interface InterestCalculator {
    /**
     * 指定された金額に対する利子を計算します
     * 
     * @param amount 利子を計算する対象の金額（円単位）
     * @return 計算された利子（円単位）
     */
    int getInterest(int amount);
}

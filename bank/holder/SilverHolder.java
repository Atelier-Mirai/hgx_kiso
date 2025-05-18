package bank.holder;

/**
 * シルバー口座名義人クラス
 * 
 * このクラスは、シルバー会員の口座名義人を実装します。
 * 会員ランクに応じたキャッシュバック機能を提供します。
 * 
 * @author アトリヱ未來
 * @version 1.0
 */
public class SilverHolder extends Holder {
    /**
     * コンストラクタ
     * 
     * @param name    口座名義人の名前
     * @param address 口座名義人の住所
     */
    public SilverHolder(String name, String address) {
        super(name, address);
    }

    /**
     * キャッシュバック金額を計算します
     * 
     * シルバー会員の場合、取引金額の2%をキャッシュバックします。
     * 
     * @param amount 取引金額
     * @return キャッシュバック金額（円単位）
     */
    @Override
    public int getCashBackAmount(int amount) {
        // 2%返金
        return (int)(amount * 0.02);
    }
}

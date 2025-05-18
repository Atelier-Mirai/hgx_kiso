package bank.holder;

/**
 * ブロンズ口座名義人クラス
 * 
 * このクラスは、ブロンズ会員の口座名義人を実装します。
 * 会員ランクに応じたキャッシュバック機能を提供します。
 * 
 * @author アトリヱ未來
 * @version 1.0
 */
public class BronzeHolder extends Holder {
    /**
     * コンストラクタ
     * 
     * @param name    口座名義人の名前
     * @param address 口座名義人の住所
     */
    public BronzeHolder(String name, String address) {
        super(name, address);
    }

    /**
     * キャッシュバック金額を計算します
     * 
     * ブロンズ会員の場合、取引金額の1%をキャッシュバックします。
     * 
     * @param amount 取引金額
     * @return キャッシュバック金額（円単位）
     */
    @Override
    public int getCashBackAmount(int amount) {
        // 1%返金
        return (int)(amount * 0.01);
    }
}

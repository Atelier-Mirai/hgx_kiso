package bank.holder;

/**
 * 口座名義人クラス
 * 
 * このクラスは、口座の名義人情報を管理します。
 * 名前と住所の情報を保持し、これらの値の取得と設定を行います。
 * 
 * @author アトリヱ未來
 * @version 1.0
 */
public abstract class Holder {
    /**
     * 口座名義人の名前
     * 
     * 日本語表記の名前を保持します。
     */
    private String name;
    
    /**
     * 口座名義人の住所
     * 
     * 日本の住所表記を保持します。
     */
    private String address;

    /**
     * コンストラクタ
     * 
     * @param name    口座名義人の名前
     * @param address 口座名義人の住所
     */
    public Holder(String name, String address) {
        this.name    = name;
        this.address = address;
    }

    /**
     * 名前を取得します
     * 
     * @return 口座名義人の名前
     */
    public String getName() {
        return name;
    }

    /**
     * 住所を取得します
     * 
     * @return 口座名義人の住所
     */
    public String getAddress() {
        return address;
    }

    /**
     * 名前を設定します
     * 
     * @param name 新しい名前（日本語表記）
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 住所を設定します
     * 
     * @param address 新しい住所（日本語表記）
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * キャッシュバック額を計算します
     * 
     * @param amount キャッシュバックを計算する対象の金額（円単位）
     * @return 計算されたキャッシュバック額（円単位）
     */
    public abstract int getCashBackAmount(int amount);
}

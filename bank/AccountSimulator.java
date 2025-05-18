package bank;

import bank.account.Account;
import bank.account.LimitedAccount;
import bank.account.FixedInterestCalculator;
import bank.account.TieredInterestCalculator;
import bank.holder.Holder;
import bank.holder.BronzeHolder;
import bank.holder.SilverHolder;

import java.util.ArrayList;

/**
 * 口座管理システムのメインクラス
 * 
 * このクラスは、銀行口座管理システムの動作をデモンストレーションします。
 * 口座の作成、入金、出金、口座名義人の変更などの操作を実行します。
 * <p>
 * システムの構造は以下の図の通りです：
 * </p>
 *
 * <p>
 * <img src="doc-files/class-diagram.svg" alt="クラス図" width="100%" height
 * ="auto">
 * </p>
 * 
 * <p>
 * クラスの詳細：
 * </p>
 * 
 * <ul>
 * <li>{@link AccountSimulator} - メインクラス</li>
 * <li>{@link Account} - 基本的な口座機能を提供</li>
 * <li>{@link LimitedAccount} - 入金額に上限を設定できる特殊な口座</li>
 * <li>{@link Holder} - 口座名義人情報を管理</li>
 * <li>{@link BronzeHolder} - ブロンズ会員の口座名義人</li>
 * <li>{@link SilverHolder} - シルバー会員の口座名義人</li>
 * <li>{@link FixedInterestCalculator} - 固定金利（5%）で利子を計算</li>
 * <li>{@link TieredInterestCalculator} - 階層制の利子を計算</li>
 * </ul>
 * 
 * @author アトリヱ未来
 * @version 1.0
 */
public class AccountSimulator {
    /**
     * デフォルトコンストラクタ
     * 
     * このコンストラクタは、デフォルトで生成されます。
     */
    public AccountSimulator() {
    }
    /**
     * メインメソッド
     * 
     * このメソッドは、口座管理システムの動作をデモンストレーションします。
     * 
     * @param args コマンドライン引数（使用しない）
     * 
     * <p>デモンストレーションの内容：</p>
     * 
     * <ol>
     * <li>口座の作成と初期設定</li>
     * <li>入金処理の実行</li>
     * <li>出金処理の実行</li>
     * <li>口座名義人情報の変更</li>
     * <li>入金限度額付き口座の動作確認</li>
     * <li>会員ランク別のキャッシュバックの確認</li>
     * </ol>
     */
    public static void main(String[] args) {
        // 利子計算クラス
        var fixedInterest  = new FixedInterestCalculator();
        var tieredInterest = new TieredInterestCalculator();

        // 口座名義人
        var holder = new BronzeHolder("山田太郎", "東京都");
        // 口座番号
        String accountNumber = "1234567";
        // 残高
        int balance        = 1000;
        var account        = new Account(holder, accountNumber, balance, fixedInterest);
        // 入金額
        int deposit  = 500;
        int withdraw = 200;

        // 入金
        account.deposit(deposit);
        // 出金
        account.withdraw(withdraw);
        System.out.println("口座名義人の名前: " + account.getHolder().getName());
        System.out.println("口座名義人の住所: " + account.getHolder().getAddress());
        System.out.println("口座番号:       " + account.getNumber());
        System.out.println("残高:          " + account.getBalance());
        System.out.println("利子:          " + account.getInterest());

        // もう一つ別の口座を作成
        var account2 = new Account(holder, "7654321", 2000, new TieredInterestCalculator());
        System.out.println("口座名義人の名前: " + account2.getHolder().getName());
        System.out.println("口座名義人の住所: " + account2.getHolder().getAddress());
        System.out.println("口座番号:       " + account2.getNumber());
        System.out.println("残高:          " + account2.getBalance());

        // 口座名義人の氏名を変更
        account.getHolder().setName("田中 太郎");
        System.out.println("口座名義人の名前: " + account.getHolder().getName());
        System.out.println("口座名義人の名前: " + account2.getHolder().getName());

        // 口座名義人の住所を変更
        account.getHolder().setAddress("大阪府");
        System.out.println("口座名義人の住所: " + account.getHolder().getAddress());
        System.out.println("口座名義人の住所: " + account2.getHolder().getAddress());

        // LimitedAccountの使用
        var limitedAccount = new LimitedAccount(holder, "1234567", 1000, 5000, tieredInterest);
        System.out.println("口座名義人の名前: " + limitedAccount.getHolder().getName());
        System.out.println("口座名義人の住所: " + limitedAccount.getHolder().getAddress());
        System.out.println("口座番号:       " + limitedAccount.getNumber());
        System.out.println("残高:          " + limitedAccount.getBalance());
        System.out.println("利子:          " + limitedAccount.getInterest());

        // 預け入れ限度額を超過するため、入金できません
        try {
            limitedAccount.deposit(6000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        // ArrayListの活用例
        ArrayList<Holder> holderList = new ArrayList<>();
        holderList.add(new BronzeHolder("山田 太郎", "東京都"));
        holderList.add(new SilverHolder("田中 次郎", "大阪府"));

        for (var h : holderList) {
            System.out.println(h.getName());
            System.out.println(h.getAddress());
        }
    }
}

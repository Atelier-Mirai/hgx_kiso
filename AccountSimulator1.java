public class AccountSimulator1 {
    public static void main(String[] args) {
        // 口座名義人
        String owner = "山田太郎";
        // 残高
        int balance   = 1000;
        // 入金額
        int deposit   = 500;
        int withdraw  = 200;
        balance += deposit;
        balance -= withdraw;
        System.out.println("口座名義人: " + owner);
        System.out.println("残高: " + balance);

        // Accountクラスを使用したコード
        // var account = new Account();
        // 口座名義人を設定
        // account.setOwner(owner);
        // 初期残高を設定
        // account.setBalance(balance);
        
        // コンストラクタを使用して口座を作成
        var account = new Account(owner, balance);
        // 入金
        account.deposit(deposit);
        // 出金
        account.withdraw(withdraw);
        System.out.println("口座名義人: " + account.getOwner());
        System.out.println("残高: " + account.getBalance());
    }

    // Accountクラス
    static class Account {
        // 口座名義人
        private String owner;
        // 残高
        private int balance;

        // コンストラクタ
        public Account(String owner, int balance) {
            this.owner   = owner;
            this.balance = balance;
        }

        // 口座名義人を設定
        public void setOwner(String owner) {
            this.owner = owner;
        }
        // 口座名義人を取得
        public String getOwner() {
            return owner;
        }
        // 残高を設定
        public void setBalance(int balance) {
            this.balance = balance;
        }
        // 残高を取得
        public int getBalance() {
            return balance;
        }
        // 入金
        public void deposit(int amount) {
            balance += amount;
        }
        // 出金
        public void withdraw(int amount) {
            if (balance < amount) {
                System.out.println("残高が不足しています");
                return;
            }
            balance -= amount;
        }
    }
}
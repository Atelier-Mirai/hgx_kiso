public class CompanyRe {
    public static void main(String[] args) {
        // グループ企業名を表示する
        System.out.println("[グループ企業情報]");
        String com = "株式会社Java";
        // 元のコード
        System.out.println(com + "テクノロジー");
        System.out.println(com + "システム");
        System.out.println(com + "コンサルティング");

        // 改良版コード
        String[] suffixes = {"テクノロジー", "システム", "コンサルティング"};
        for (String suffix : suffixes) {
            System.out.println(com + suffix);
        }

        // String.formatを使用したコード
        suffixes = new String[] {"テクノロジー", "システム", "コンサルティング"};
        for (String suffix : suffixes) {
            System.out.println(String.format("%s%s", com, suffix));
        }
    }
}
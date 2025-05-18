public class NumberFormatError {
    public static void main(String[] args) {
        try {
            // 実行時引数を数値に変換
            int number = Integer.parseInt(args[0]);
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println("数値ではありません");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("引数がありません");
        } finally {
            System.out.println("プログラムを終了します");
        }
    }
}

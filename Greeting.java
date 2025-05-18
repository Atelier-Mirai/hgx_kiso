public class Greeting {
    public static void main(String[] args) {
        System.out.println("おはようございます");
        System.out.println("こんにちは");
        System.out.println("こんばんは");
        System.out.println("おやすみなさい");

        int time = 20;
        if (time < 12) {
            System.out.println("おはようございます");
        } else if (time < 17) {
            System.out.println("こんにちは");
        } else if (time < 23) {
            System.out.println("こんばんは");
        } else {
            System.out.println("おやすみなさい");
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("こんにちは " + i + "回");
        }
    }
}
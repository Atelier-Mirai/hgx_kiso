public class Switch {
    public static void main(String[] args) {
        int day = 2;
        
        // 従来のswitch文
        switch (day) {
            case 0:
                System.out.println("月曜日");
                break;
            case 1:
                System.out.println("火曜日");
                break;
            case 2:
                System.out.println("水曜日");
                break;
            case 3:
                System.out.println("木曜日");
                break;
            case 4:
                System.out.println("金曜日");
                break;
            case 5:
                System.out.println("土曜日");
                break;
            case 6:
                System.out.println("日曜日");
                break;
            default:
                System.out.println("0~6の数字を入力してください");
                break;
        }

        // アロー記法を使用したswitch式
        String dayOfWeek = switch (day) {
            case 0 -> "月曜日";
            case 1 -> "火曜日";
            case 2 -> "水曜日";
            case 3 -> "木曜日";
            case 4 -> "金曜日";
            case 5 -> "土曜日";
            case 6 -> "日曜日";
            default -> "0~6の数字を入力してください";
        };
        System.out.println(dayOfWeek);
    }
}

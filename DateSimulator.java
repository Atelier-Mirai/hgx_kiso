import java.time.LocalDateTime;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateSimulator {
    public static void main(String[] args) {
        // フォーマッターの定義
        var formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 (E) HH時mm分ss秒", Locale.JAPAN);
        var dateOnlyFormatter = DateTimeFormatter.ofPattern("GGGGy年M月d日", Locale.JAPAN);
        var dateTimeFormatter = DateTimeFormatter.ofPattern("GGGGy年M月d日 (E) H時m分s秒", Locale.JAPAN);

        // 現在の日時を表示
        System.out.println("=== 現在の日時 ===");
        LocalDateTime now = LocalDateTime.now();
        JapaneseDate nowJapanese = JapaneseDate.from(now);
        System.out.println("グレゴリオ暦: " + now.format(formatter));
        System.out.println("和暦（日付のみ）: " + nowJapanese.format(dateOnlyFormatter));
        System.out.println("和暦（日時）: " + nowJapanese.atTime(now.toLocalTime()).format(dateTimeFormatter));
        
        // 2000年12月31日 23:59:59 を指定
        System.out.println("\n=== 2000年12月31日 23:59:59 ===");
        LocalDateTime y2k = LocalDateTime.of(2000, 12, 31, 23, 59, 59);
        JapaneseDate y2kJapanese = JapaneseDate.from(y2k);
        
        System.out.println("グレゴリオ暦: " + y2k.format(formatter));
        System.out.println("和暦（日付のみ）: " + y2kJapanese.format(dateOnlyFormatter));
        System.out.println("和暦（日時）: " + y2kJapanese.atTime(y2k.toLocalTime()).format(dateTimeFormatter));
        
        // 生まれてからの経過年数・月数を計算
        java.time.Period lifePeriod = java.time.Period.between(
            y2k.toLocalDate(), 
            now.toLocalDate()
        );
        long lifeTotalMonths = lifePeriod.toTotalMonths();
        long lifeYears = lifeTotalMonths / 12;
        long lifeMonths = lifeTotalMonths % 12;
        
        // 日数も計算（時間は考慮しない）
        long lifeDays = java.time.temporal.ChronoUnit.DAYS.between(
            y2k.toLocalDate(),
            now.toLocalDate()
        );
        
        System.out.println("\n=== 生まれてからの期間 ===");
        System.out.println(String.format("%d年 %dヶ月", lifeYears, lifeMonths));
        System.out.println("総日数: " + lifeDays + "日");
        System.out.println("総時間: " + (lifeDays * 24) + "時間");
        
        // 明日の日付を表示
        System.out.println("\n=== 明日の日付 ===");
        LocalDateTime tomorrow = now.plusDays(1);
        JapaneseDate tomorrowJapanese = JapaneseDate.from(tomorrow);
        System.out.println("グレゴリオ暦: " + tomorrow.format(formatter));
        System.out.println("和暦（日付のみ）: " + tomorrowJapanese.format(dateOnlyFormatter));
        System.out.println("和暦（日時）: " + tomorrowJapanese.atTime(tomorrow.toLocalTime()).format(dateTimeFormatter));
        
        // 来月の1日を表示
        System.out.println("\n=== 来月の1日 ===");
        LocalDateTime firstDayNextMonth = now.plusMonths(1).withDayOfMonth(1);
        JapaneseDate firstDayNextMonthJapanese = JapaneseDate.from(firstDayNextMonth);
        System.out.println("グレゴリオ暦: " + firstDayNextMonth.format(formatter));
        System.out.println("和暦（日付のみ）: " + firstDayNextMonthJapanese.format(dateOnlyFormatter));
        System.out.println("和暦（日時）: " + firstDayNextMonthJapanese.atTime(firstDayNextMonth.toLocalTime()).format(dateTimeFormatter));
        
        // タイムスタンプ（ミリ秒）
        System.out.println("\n=== タイムスタンプ ===");
        System.out.println("現在: " + System.currentTimeMillis() + " ミリ秒");
        System.out.println("2000年末: " + y2k.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli() + " ミリ秒");
        System.out.println("明日の0時: " + tomorrow.toLocalDate().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli() + " ミリ秒");
        System.out.println("来月1日0時: " + firstDayNextMonth.toLocalDate().atStartOfDay(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli() + " ミリ秒");
    }
}

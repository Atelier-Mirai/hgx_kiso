public class Score {
    public static void main(String[] args) {
        // 元のコード
        int score0 = 85;
        int score1 = 90;
        int score2 = 75;
        int score3 = 65;
        int score4 = 55;
        int totalScore = score0 + score1 + score2 + score3 + score4;
        double averageScore = totalScore / 5.0;
        System.out.println("合計点: " + totalScore);
        System.out.println("平均点: " + averageScore);

        // 配列を使用したコード
        int[] scores = {85, 90, 75, 65, 55};
        totalScore = 0;
        
        // スコアの合計を計算
        for (int score : scores) {
            totalScore += score;
        }
        
        // 平均点を計算
        averageScore = (double) totalScore / scores.length;
        
        // 結果を表示
        System.out.println("合計点: " + totalScore);
        System.out.println("平均点: " + averageScore);
    }
}

package tennis;

public interface ScoreBuilder {
    boolean isAcceptable(int pointsPlayer1, int pointsPlayer2);

    String getScore(int pointsPlayer1, int pointsPlayer2);
}

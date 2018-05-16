package tennis;

public class ScoreBuilderNormal implements ScoreBuilder {
    @Override
    public boolean isAcceptable(int pointsPlayer1, int pointsPlayer2) {
        return true;
    }

    @Override
    public String getScore(int pointsPlayer1, int pointsPlayer2) {
        return getScorePlayer(pointsPlayer1) + " - " + getScorePlayer(pointsPlayer2);
    }

    private String getScorePlayer(int pointsPlayer) {
        return SCORE_FROM_POINTS[pointsPlayer];
    }

    private static final String[] SCORE_FROM_POINTS = { "LOVE", "FIFTEEN", "THIRTY", "FORTY" };
}

package tennis;

public class ScoreBuilderDeuce implements ScoreBuilder {
    @Override
    public boolean isAcceptable(int pointsPlayer1, int pointsPlayer2) {
        return (pointsPlayer1 >= 3 && pointsPlayer2 >=  3) && (pointsPlayer1 == pointsPlayer2);
    }

    @Override
    public String getScore(int pointsPlayer1, int pointsPlayer2) {
        return "DEUCE";
    }
}

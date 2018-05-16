package tennis;

public class ScoreBuilderAdvantage implements ScoreBuilder {
    @Override
    public boolean isAcceptable(int pointsPlayer1, int pointsPlayer2) {
        return (pointsPlayer1 >= 3 && pointsPlayer2 >=  3) && (pointsPlayer2 > pointsPlayer1);
    }

    @Override
    public String getScore(int pointsPlayer1, int pointsPlayer2) {
        if (pointsPlayer2 > pointsPlayer1) {
            return "Advantage player 2";
        }
        throw new UnsupportedOperationException("Not implemented yet !");
    }
}

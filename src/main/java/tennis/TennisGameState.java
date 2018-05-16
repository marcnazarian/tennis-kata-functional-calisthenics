package tennis;

import java.util.List;

import static java.util.Arrays.asList;

public class TennisGameState {

    private final int pointsPlayer1;
    private final int pointsPlayer2;

    TennisGameState() {
        this(0,0);
    }

    private TennisGameState(int pointsPlayer1, int pointsPlayer2) {
        this.pointsPlayer1 = pointsPlayer1;
        this.pointsPlayer2 = pointsPlayer2;
    }

    public boolean notFinished() {
        return !isFinished();
    }

    private boolean isFinished() {
        return (pointsPlayer1 >= 4 || pointsPlayer2 >= 4) && Math.abs(pointsPlayer1-pointsPlayer2) > 1;
    }

    public String winner() {
        return pointsPlayer1 > pointsPlayer2 ? "Player 1" : "Player 2";
    }

    /*

    Code initial de la méthode "currentScore" avec des "if"

    public String currentScore() {
        if (pointsPlayer1 >= 3 && pointsPlayer2 >=  3) {
            if (pointsPlayer1 == pointsPlayer2) {
                return "DEUCE";
            }
            if (pointsPlayer2 > pointsPlayer1) {
                return "Advantage player 2";
            }
        }
        return getScorePlayer(pointsPlayer1) + " - " + getScorePlayer(pointsPlayer2);
    }
    */

    private List<ScoreBuilder> builders = asList(new ScoreBuilderDeuce(), new ScoreBuilderAdvantage(), new ScoreBuilderNormal());

    public String currentScore() {
        return builders
                .stream()
                .filter(b -> b.isAcceptable(pointsPlayer1, pointsPlayer2))
                .findFirst()
                .get()
                .getScore(pointsPlayer1, pointsPlayer2);
    }



    public TennisGameState computeNextScore(String pointWinner) {
        return new TennisGameState(this.pointsPlayer1+(pointWinner.equals("1") ? 1 : 0), this.pointsPlayer2+(pointWinner.equals("2") ? 1 : 0));
    }


}

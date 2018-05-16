package tennis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TennisGame {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TennisGameState state = new TennisGameState();

        while (state.notFinished()) {
            System.out.println("score:" + state.currentScore());
            System.out.println("winner?");
            String winner = br.readLine();

            state = state.computeNextScore(winner);
        }

        System.out.println("Winner is:" + state.winner());

    }

}

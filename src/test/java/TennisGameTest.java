import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest {

    @Test
    public void initial_score_should_be_love_love() {
        TennisGameState state = new TennisGameState();
        assertThat(state.currentScore()).isEqualTo("LOVE - LOVE");
    }

    @Test
    public void score_should_be_fifteen_love_when_first_player_won_first_point() {
        TennisGameState state = new TennisGameState();
        TennisGameState nextState = state.computeNextScore("1");
        assertThat(nextState.currentScore()).isEqualTo("FIFTEEN - LOVE");
    }

    @Test
    public void score_should_be_fifteen_fifteen_when_both_players_won_one_point() {
        TennisGameState state = new TennisGameState();
        TennisGameState nextState = state.computeNextScore("1").computeNextScore("2");
        assertThat(nextState.currentScore()).isEqualTo("FIFTEEN - FIFTEEN");
    }
}
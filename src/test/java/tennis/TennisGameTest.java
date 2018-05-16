package tennis;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TennisGameTest {

    private TennisGameState state = new TennisGameState();

    // Initial state

    @Test
    public void initial_score_should_be_love_love() {
        assertThat(state.notFinished()).isTrue();
        assertThat(state.currentScore()).isEqualTo("LOVE - LOVE");
    }

    // Some other scores

    @Test
    public void score_should_be_fifteen_love_when_first_player_won_first_point() {
        TennisGameState nextState = state
                .computeNextScore("1");
        assertThat(nextState.notFinished()).isTrue();
        assertThat(nextState.currentScore()).isEqualTo("FIFTEEN - LOVE");
    }

    @Test
    public void score_should_be_fifteen_fifteen_when_both_players_won_one_point() {
        TennisGameState nextState = state
                .computeNextScore("1")
                .computeNextScore("2");
        assertThat(nextState.notFinished()).isTrue();
        assertThat(nextState.currentScore()).isEqualTo("FIFTEEN - FIFTEEN");
    }

    @Test
    public void score_should_be_thirty_fifteen() {
        TennisGameState nextState = state
                .computeNextScore("1")
                .computeNextScore("1")
                .computeNextScore("2");
        assertThat(nextState.notFinished()).isTrue();
        assertThat(nextState.currentScore()).isEqualTo("THIRTY - FIFTEEN");
    }

    @Test
    public void score_should_be_thirty_forty() {
        TennisGameState nextState = state
                .computeNextScore("1")
                .computeNextScore("1")
                .computeNextScore("2")
                .computeNextScore("2")
                .computeNextScore("2");
        assertThat(nextState.notFinished()).isTrue();
        assertThat(nextState.currentScore()).isEqualTo("THIRTY - FORTY");
    }

    // Deuce and avantages

    @Test
    public void score_should_be_deuce_case_1() {
        TennisGameState nextState = state
                .computeNextScore("1")
                .computeNextScore("1")
                .computeNextScore("1")
                .computeNextScore("2")
                .computeNextScore("2")
                .computeNextScore("2");
        assertThat(nextState.notFinished()).isTrue();
        assertThat(nextState.currentScore()).isEqualTo("DEUCE");
    }

    @Test
    public void score_should_be_advantage_player_2() {
        TennisGameState nextState = state
                .computeNextScore("1")
                .computeNextScore("1")
                .computeNextScore("1")
                .computeNextScore("2")
                .computeNextScore("2")
                .computeNextScore("2")
                .computeNextScore("2");
        assertThat(nextState.notFinished()).isTrue();
        assertThat(nextState.currentScore()).isEqualTo("Advantage player 2");
    }

    // Finished

    @Test
    public void game_should_be_finished_for_player_1() {
        TennisGameState nextState = state
                .computeNextScore("1")
                .computeNextScore("1")
                .computeNextScore("1")
                .computeNextScore("1");
        assertThat(nextState.notFinished()).isFalse();
        assertThat(nextState.winner()).isEqualTo("Player 1");
    }

    @Test
    public void game_should_be_finished_for_player_2() {
        TennisGameState nextState = state
                .computeNextScore("2")
                .computeNextScore("2")
                .computeNextScore("2")
                .computeNextScore("2");
        assertThat(nextState.notFinished()).isFalse();
        assertThat(nextState.winner()).isEqualTo("Player 2");
    }

    @Test
    public void game_should_be_finished_for_player_1_after_some_deuce_situations() {
        TennisGameState nextState = state
                .computeNextScore("1")  // 15 - 0
                .computeNextScore("2")  // 15 - 15
                .computeNextScore("1")  // 30 - 15
                .computeNextScore("2")  // 30 - 30
                .computeNextScore("1")  // 40 - 30
                .computeNextScore("2")  // 40 - 40
                .computeNextScore("1")  // Advantage Player 1
                .computeNextScore("2")  // 40 - 40
                .computeNextScore("1")  // Advantage Player 1
                .computeNextScore("1"); // Player 1 won

        assertThat(nextState.notFinished()).isFalse();
        assertThat(nextState.winner()).isEqualTo("Player 1");
    }
}

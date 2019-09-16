package tdd;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TennisScoringTest {

    @Test
    public void initialScoring() {
        TennisScoring game = new TennisScoring(0, 0);

        assertThat(game.announcement(), is("love love"));
    }


    @Test
    public void winningAPoint() {
        TennisScoring game = new TennisScoring(0,0);

        game.playerOneWinAPoint(); //1 0
        assertThat(game.announcement(), is("fifteen love"));

        game.playerOneWinAPoint(); //2 0
        assertThat(game.announcement(), is("thirty love"));

        game.playerOneWinAPoint(); //3 0
        assertThat(game.announcement(), is("forty love"));

        game.playerTwoWinAPoint(); //3 1
        assertThat(game.announcement(), is("forty fifteen"));

        game.playerTwoWinAPoint(); //3 2
        assertThat(game.announcement(), is("forty thirty"));

        game.playerTwoWinAPoint(); //3 3
        assertThat(game.announcement(), is("deuce"));

        game.playerOneWinAPoint(); //4 3
        assertThat(game.announcement(), is("advantage forty"));

        game.playerOneWinAPoint(); //5 3
        assertThat(game.announcement(), is("first player won"));

    }
}

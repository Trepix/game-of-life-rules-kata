package io.trepix.golrules;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.trepix.golrules.State.ALIVE;
import static io.trepix.golrules.State.DEAD;

public class BoardTest {

    private static final State[] ORIGINAL_BOARD_STATES = new State[]{
        DEAD, DEAD, DEAD,
        ALIVE, ALIVE, ALIVE,
        DEAD, ALIVE, ALIVE
    };

    @Test
    public void givenABoard_WhenNextGenerationIsCalled_ShouldChange() {
        Board originalBoard = createBoard(ORIGINAL_BOARD_STATES);
        Board board = createBoard(ORIGINAL_BOARD_STATES);

        Board expectedNextGenerationBoard = createBoard(new State[]{
                DEAD, ALIVE, DEAD,
                ALIVE, DEAD, ALIVE,
                ALIVE, DEAD, ALIVE
        });
        Board actualNextGenerationBoard = board.applyGameOfLifeRules();

        Assert.assertEquals(expectedNextGenerationBoard, actualNextGenerationBoard);
        Assert.assertEquals(originalBoard, board);
    }

    private Board createBoard(State[] states) {
        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                State state = states[i * 3 + j];
                cells.add(new Cell(new Position(i, j), state));
            }
        }
        return new Board(cells);
    }
}

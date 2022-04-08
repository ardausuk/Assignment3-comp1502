package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Puzzle;

class PuzzleTest {

    @Test
    void PuzzleTes() {
        Puzzle PuzzleTes = new Puzzle("4325092354", "Kaka", "Massa", 32.6, 15, 21, "T");
        String testPuzzle = PuzzleTes.toString();
        assertEquals("Puzzle [SN=4325092354, name=Kaka, brand=Massa, price=32.6, availableCount=15, ageAppropraite=21, puzzleType=T]",
                testPuzzle);
    }

}
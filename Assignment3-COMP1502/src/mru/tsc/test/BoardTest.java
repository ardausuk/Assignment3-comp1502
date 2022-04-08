package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import mru.tsc.model.BoardGame;
class BoardTest {

    @Test
    void BoardGameTest() {
        BoardGame BoardGameTest = new BoardGame("9873456789", "Rajan", "Raj", 60.6, 5, 15, "2-10", "Munima, Adam");
        String testBG = BoardGameTest.toString();
        assertEquals("BoardGame [SN=9873456789, name=Rajan, brand=Raj, price=60.6, availableCount=5, ageAppropraite=15, players=2-10, designers=Munima, Adam]",
                testBG);
    }

}
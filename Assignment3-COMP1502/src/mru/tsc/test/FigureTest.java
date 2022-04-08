package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import mru.tsc.model.Figure;

class FigureTest {

    @Test
    void FigureTes() {
        Figure FigureTes = new Figure("0986789388", "Jack", "Has", 20.3, 10, 13, "Action");
        String testF = FigureTes.toString();
        assertEquals("Figure [SN=0986789388, name=Jack, brand=Has, price=20.3, availableCount=10, ageAppropraite=13, classification=A]",
                testF);

    }

}
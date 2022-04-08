package mru.tsc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import mru.tsc.model.Animal;


class AnimalTest{



   
    @Test
    void TestAnimal() {
        Animal animalTest = new Animal("2269096904", "Dog", "Arda", 44.5, 10, 5, "Leather", "L");
        String testA = animalTest.toString();
        assertEquals(
                "Animal [SN=2269096904, name=Dog, brand=Arda, price=44.5, availableCount=10, ageAppropraite=5, Material=Leather, size=L]",
                testA);
    }
}
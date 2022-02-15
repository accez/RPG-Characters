package com.company.Character;

import com.company.Character.CharacterClasses.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    Mage mage = new Mage("test", HeroType.MAGE, MainPrimaryAttribute.INTELLIGENCE);
    Rouge rouge = new Rouge("test", HeroType.ROUGE, MainPrimaryAttribute.DEXTERITY);
    Ranger ranger = new Ranger("test", HeroType.RANGER, MainPrimaryAttribute.DEXTERITY);
    Warrior warrior = new Warrior("test", HeroType.WARRIOR, MainPrimaryAttribute.STRENGTH);

    @Test
    void Character_Should_Be_Level_One_When_Created() {
        int expectedLevel = 1;
        assertEquals(expectedLevel, mage.getLevel());
    }

    @Test
    void Character_Should_Be_Level_Two_When_Leveling_Up() {
        int expectedLevel = 2;
        mage.levelUp();
        assertEquals(expectedLevel, mage.getLevel());
    }

    @Test
    void Check_Mage_Primary_Attributes_When_Created() {
        int expectedStrength = 1;
        int expectedDexterity = 1;
        int expectedIntelligence = 8;
        assertEquals(expectedStrength, mage.attribute.getStrength());
        assertEquals(expectedDexterity, mage.attribute.getDexterity());
        assertEquals(expectedIntelligence, mage.attribute.getIntelligence());
    }

    @Test
    void Check_Rouge_Primary_Attributes_When_Created() {
        int expectedStrength = 2;
        int expectedDexterity = 6;
        int expectedIntelligence = 1;
        assertEquals(expectedStrength, rouge.attribute.getStrength());
        assertEquals(expectedDexterity, rouge.attribute.getDexterity());
        assertEquals(expectedIntelligence, rouge.attribute.getIntelligence());
    }

    @Test
    void Check_Ranger_Primary_Attributes_When_Created() {
        int expectedStrength = 1;
        int expectedDexterity = 7;
        int expectedIntelligence = 1;
        assertEquals(expectedStrength, ranger.attribute.getStrength());
        assertEquals(expectedDexterity, ranger.attribute.getDexterity());
        assertEquals(expectedIntelligence, ranger.attribute.getIntelligence());
    }

    @Test
    void Check_Warrior_Primary_Attributes_When_Created() {
        int expectedStrength = 5;
        int expectedDexterity = 2;
        int expectedIntelligence = 1;
        assertEquals(expectedStrength, warrior.attribute.getStrength());
        assertEquals(expectedDexterity, warrior.attribute.getDexterity());
        assertEquals(expectedIntelligence, warrior.attribute.getIntelligence());
    }

    @Test
    void Control_That_Mage_Primary_Attributes_Increase_When_Leveling() {
        int expectedStrength = 2;
        int expectedDexterity = 2;
        int expectedIntelligence = 13;
        mage.levelUp();
        assertEquals(expectedStrength, mage.attribute.getStrength());
        assertEquals(expectedDexterity, mage.attribute.getDexterity());
        assertEquals(expectedIntelligence, mage.attribute.getIntelligence());
    }

    @Test
    void Control_That_Rouge_Primary_Attributes_Increase_When_Leveling() {
        int expectedStrength = 3;
        int expectedDexterity = 10;
        int expectedIntelligence = 2;
        rouge.levelUp();
        assertEquals(expectedStrength, rouge.attribute.getStrength());
        assertEquals(expectedDexterity, rouge.attribute.getDexterity());
        assertEquals(expectedIntelligence, rouge.attribute.getIntelligence());
    }

    @Test
    void Control_That_Ranger_Primary_Attributes_Increase_When_Leveling() {
        int expectedStrength = 2;
        int expectedDexterity = 12;
        int expectedIntelligence = 2;
        ranger.levelUp();
        assertEquals(expectedStrength, ranger.attribute.getStrength());
        assertEquals(expectedDexterity, ranger.attribute.getDexterity());
        assertEquals(expectedIntelligence, ranger.attribute.getIntelligence());
    }

    @Test
    void Control_That_Warrior_Primary_Attributes_Increase_When_Leveling() {
        int expectedStrength = 8;
        int expectedDexterity = 4;
        int expectedIntelligence = 2;
        warrior.levelUp();
        assertEquals(expectedStrength, warrior.attribute.getStrength());
        assertEquals(expectedDexterity, warrior.attribute.getDexterity());
        assertEquals(expectedIntelligence, warrior.attribute.getIntelligence());
    }
}
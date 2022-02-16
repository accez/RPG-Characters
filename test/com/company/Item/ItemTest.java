package com.company.Item;

import com.company.Character.CharacterClasses.*;
import com.company.Character.Slot;
import com.company.ErrorHandling.InvalidArmor;
import com.company.ErrorHandling.InvalidLevel;
import com.company.ErrorHandling.InvalidWeapon;
import com.company.Item.Armor.ArmorTypes;
import com.company.Item.Weapon.WeaponTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    Warrior warrior;
    Mage mage = new Mage("test", HeroType.MAGE, MainPrimaryAttribute.INTELLIGENCE);

    @BeforeEach
    void setUp() {
        warrior = new Warrior("test", HeroType.WARRIOR, MainPrimaryAttribute.STRENGTH);
    }

    @Test
    void InvalidLevelException_Should_Be_Thrown_If_Character_Is_Lower_Level_Then_Required_Weapon_Level() {
        assertThrows(InvalidLevel.class, () -> warrior.equipWeapon("Test Axe", 2, Slot.WEAPON, WeaponTypes.AXES, 2, 2));
    }

    @Test
    void InvalidLevelException_Should_Be_Thrown_If_Character_Is_Lower_Level_Then_Required_Armor_Level() {
        assertThrows(InvalidLevel.class, () -> warrior.equipArmor("Test Armor", 2, Slot.BODY, ArmorTypes.PLATE, 3, 3, 3));
    }

    @Test
    void InvalidItemException_Should_Be_Thrown_If_Character_Tries_To_Equip_Wrong_Weapon_Type() {
        assertThrows(InvalidWeapon.class, () -> warrior.checkIfHeroCanUseWeapon(HeroType.RANGER, WeaponTypes.BOWS));
    }

    @Test
    void InvalidWeaponException_Should_Be_Thrown_If_Character_Tries_To_Equip_Sword() {
        assertThrows(InvalidWeapon.class, mage::checkIfHeroCanUseSword);
    }

    @Test
    void When_Equipping_A_Weapon_Return_True() throws InvalidWeapon {
        assertTrue(warrior.checkIfHeroCanUseWeapon(HeroType.WARRIOR, WeaponTypes.AXES));
    }

    @Test
    void InvalidArmorException_Should_Be_Thrown_If_Wrong_Character_Tries_To_Equip_Cloth() {
        assertThrows(InvalidArmor.class, () -> warrior.checkIfCharacterCanUseClothArmor(warrior.getHeroType()));
    }

    @Test
    void InvalidArmorException_Should_Be_Thrown_If_Wrong_Character_Tries_To_Equip_Leather() {
        assertThrows(InvalidArmor.class, () -> warrior.checkIfCharacterCanUseLeatherArmor(warrior.getHeroType()));
    }

    @Test
    void InvalidArmorException_Should_Be_Thrown_If_Wrong_Character_Tries_To_Equip_Mail() {
        assertThrows(InvalidArmor.class, () -> mage.checkIfCharacterCanUseMailArmor(mage.getHeroType()));
    }

    @Test
    void InvalidArmorException_Should_Be_Thrown_If_Wrong_Character_Tries_To_Equip_Plate() {
        assertThrows(InvalidArmor.class, () -> mage.checkIfCharacterCanUsePlateArmor(mage.getHeroType()));
    }

    @Test
    void When_Equipping_Cloth_Armor_Return_True() throws InvalidArmor {
        assertTrue(mage.checkIfCharacterCanUseClothArmor(mage.getHeroType()));
    }

    @Test
    void When_Equipping_Leather_Armor_Return_True() throws InvalidArmor {
        Rouge rouge = new Rouge("test", HeroType.ROUGE, MainPrimaryAttribute.DEXTERITY);
        assertTrue(rouge.checkIfCharacterCanUseLeatherArmor(rouge.getHeroType()));
    }

    @Test
    void When_Equipping_Mail_Armor_Return_True() throws InvalidArmor {
        assertTrue(warrior.checkIfCharacterCanUseMailArmor(warrior.getHeroType()));
    }

    @Test
    void When_Equipping_Plate_Armor_Return_True() throws InvalidArmor {
        assertTrue(warrior.checkIfCharacterCanUsePlateArmor(warrior.getHeroType()));
    }

    @Test
    void Check_Dps_Calculation_When_There_Is_No_Weapon_Or_Armor() {
        double expectedResult = 1.05;
        assertEquals(expectedResult,warrior.calculateDpsWithNoArmorOrWeapon(MainPrimaryAttribute.STRENGTH));
    }
    @Test
    void Check_Dps_Calculation_When_There_Is_A_Weapon_But_No_Armor() throws InvalidLevel{
        double expectedResult = 4.2;
        warrior.equipWeapon("test",1,Slot.WEAPON,WeaponTypes.AXES,2,2);
        assertEquals(expectedResult,warrior.calculateDpsWithWeaponAndNoArmor(MainPrimaryAttribute.STRENGTH));
    }
    @Test
    void Check_Dps_Calculation_When_There_Is_A_Armor_But_No_Weapon() throws InvalidLevel{
        double expectedResult = 1.07;
        warrior.equipArmor("test",1,Slot.HEAD,ArmorTypes.PLATE,2,2,2);
        assertEquals(expectedResult,warrior.calculateDpsWithArmorAndNoWeapon(MainPrimaryAttribute.STRENGTH));
    }
    @Test
    void Check_Dps_Calculation_When_There_Is_A_Armor_And_Weapon() throws InvalidLevel{
        double expectedResult = 4.28;
        warrior.equipArmor("test",1,Slot.HEAD,ArmorTypes.PLATE,2,2,2);
        warrior.equipWeapon("test",1,Slot.WEAPON,WeaponTypes.AXES,2,2);
        assertEquals(expectedResult,warrior.calculateDpsWithArmorAndWeapon(MainPrimaryAttribute.STRENGTH));
    }
}


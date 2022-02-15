package com.company.Item.Weapon;

import com.company.Character.Slot;
import com.company.Item.Item;

public class Weapon extends Item {
    WeaponTypes weaponTypes;
    private int damage;
    private int attackSpeed;

    public Weapon(String name, int requiredLevel, Slot slot, WeaponTypes weaponTypes, int damage, int attackSpeed) {
        super(name, requiredLevel, slot);
        this.weaponTypes = weaponTypes;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }

    public WeaponTypes getWeaponTypes() {
        return weaponTypes;
    }

    public void setWeaponTypes(WeaponTypes weaponTypes) {
        this.weaponTypes = weaponTypes;
    }

    public int dps() {
        return damage * attackSpeed;
    }

    public int getDamage() {
        return damage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }
}

package com.company.Item.Weapon;

import com.company.Character.Slot;
import com.company.Item.Item;

public class Weapon extends Item {
    WeaponTypes weaponTypes;
    private int damage;
    private int attackSpeed;

    public Weapon(String name, int requiredLevel, Slot slot, WeaponTypes weaponTypes, int damage, int attackSpeed) {
        super(name, requiredLevel, slot);
        setWeaponTypes(weaponTypes);
        setDamage(damage);
        setAttackSpeed(attackSpeed);
    }

    public WeaponTypes getWeaponTypes() {
        return weaponTypes;
    }

    public void setWeaponTypes(WeaponTypes weaponTypes) {
        this.weaponTypes = weaponTypes;
    }

    public int dps() {
        return getDamage() * getAttackSpeed();
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

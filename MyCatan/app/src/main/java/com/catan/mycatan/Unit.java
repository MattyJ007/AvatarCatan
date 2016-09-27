package com.catan.mycatan;

public class Unit {

    private String unitId;
    private String name;
    private String description;
    private float attack1;
    private float attack2;
    private double evasion;
    private float life;
    private int type;
    private int intellect;
    private int numAtts;
    private int price;

    public void setEvasion(float evasion) {
        this.evasion = evasion;
    }

    public void setLife(float life) {
        this.life = life;
    }

    public void setIntellect(int intellect) {
        this.intellect = intellect;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getUnitId() {
        return unitId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getAttack1() {
        return attack1;
    }

    public float getAttack2() {
        return attack2;
    }

    public double getEvasion() {
        return evasion;
    }

    public float getLife() {
        return life;
    }

    public String getTypeString() {

        if (type == 1){
            return "Fire";
        }
        else if (type == 2){
            return "Water";
        }
        else if (type == 3){
            return "Earth";
        }
        else if (type == 4){
            return "Air";
        }
        else if (type == 5){
            return "Advanced Fire and Lightning";
        }
        else if (type == 6){
            return "Advanced Water and Ice";
        }
        else if (type == 7){
            return "Advanced Earth and Metal";
        }
        else if (type == 8){
            return "Advanced Air";
        }
        else if (type == 9){
            return "Psychic Combustion";
        }
        else if (type == 10){
            return "Advanced Water and Blood";
        }
        else if (type == 11){
            return "Advanced Earth and Lava";
        }
        else if (type == 12){
            return "Advanced Air and Unassisted Flight";
        }
        else if (type == 13){
            return "No Bending";
        }
        else if (type == 14){
            return "Avatar";
        }
        else if (type == 15){
            return "Spirit";
        }
        else if (type == 16){
            return "Chi Blocking";
        }
        else if (type == 17){
            return "Advanced Water and Psychic Blood Bending";
        }
        else{
            return "";
        }
    }

    public int getTypeInt(){
        return type;
    }

    public int getIntellect() {
        return intellect;
    }

    public int getNumAtts() {
        return numAtts;
    }

    public Unit (String unitId, String name, String description, int type, float attack1, float attack2, int intellect, float life, double evasion, int numAtts, int price){
        this.unitId = unitId;
        this.name = name;
        this.description = description;
        this. attack1 = attack1;
        this.attack2 = attack2;
        this.evasion = evasion;
        this.life = life;
        this.intellect = intellect;
        this.numAtts = numAtts;
        this.type = type;
        this.price = price;
    }





}

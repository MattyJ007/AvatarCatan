package com.catan.mycatan.BattleMath;

public class TypeBonus {

    public static int TypeBonus(int defT, int attT){
        switch (attT){
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 0;
        }

    }

}

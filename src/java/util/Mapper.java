/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author IdeaPad
 */
public class Mapper {
    
    public String mapTypeToString(Type selectedType) {
        switch (selectedType){
            case FOOD:
                return "FOOD";
            case DRINK:
                return "DRINK";
            default:
                return "FOOD";
        }    
    }
    
    public Type mapStringToType(String selectedType) {
        switch (selectedType){
            case "FOOD":
                return Type.FOOD;
            case "DRINK":
                return Type.DRINK;
            default:
                return Type.FOOD;
        }    
    }
        
}

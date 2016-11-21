/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealswithme;

import java.util.ArrayList;

/**
 *
 * @author jencardona
 */
public class Recipe {
    
    public ArrayList buildRecipe(String s) {
        ArrayList temp = new ArrayList();
        String sub = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',' || s.charAt(i) < 32) {
                if (sub.length() > 0)
                    temp.add(sub);
                sub = "";
            } else {
                sub += s.charAt(i);
            }
        }
        if (sub.length() > 0)
                temp.add(sub);
        
        return temp;
    }
}

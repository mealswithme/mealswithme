/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mealswithme;
import java.util.ArrayList;

/**
 *
 * @author kevincardona
 */
public class LCS {
    
    public ArrayList <String> allSubsets(ArrayList <String> array)
    {
        ArrayList temp = new ArrayList();
        for (int i = 0; i < array.size(); i++) {
            for (int j = i; j < array.size(); j++) {
                temp.add(array.get(j - i));
            }
        }
        
        temp = LCP(temp);
        System.out.println("--------------------------\n\n\n");
        for (int i = 0; i < temp.size(); i++) {
            System.out.println(temp.get(i));
        }
        return temp;
    }
    
    public ArrayList <String> LCP (ArrayList <String> array) {
        ArrayList temp = new ArrayList();
        for (int i = 0; i < array.size()-1; i++) {
            for (int j = i; j < array.size(); j++) {
                temp.add(array.get(j-i));
            }
        }
        return temp;
    }
    
  
    
    
}


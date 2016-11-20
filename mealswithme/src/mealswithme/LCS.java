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
    
    public ArrayList <ArrayList <String> > allSubsets(ArrayList <String> array)
    {
        ArrayList <ArrayList <String> > container = new ArrayList();
        
        ArrayList <String> address = new ArrayList();
        String temp = new String();
        for (int i = 0; i < array.size() * array.size()-1; i++) {
            int j = i - 1;
            while(j > 0) {
                if (j % 2 == 0) {
                    temp += "0";
                }else {
                    temp += "1";
                }
                j /= 2;
            }
            address.add(temp);
            temp = new String();
        }
        
        ArrayList temp1 = new ArrayList();
        
        
        for (int i = 0; i < address.size(); i++) {
            System.out.println(address.get(i));
        }
        
        for (int i = address.size()-1; i > -1; i--) {
            temp = new String();
            for (int j = 0; j < address.get(i).length() - 1; j++) {
                temp1 = new ArrayList();
                if (address.get(i).charAt(j) == '1') {
                    temp1.add(array.get(j));
                }
            }
            container.add(temp1);
        }
        for (int i = 0; i < container.size(); i++){
            System.out.println(container.get(i));
        }
        return container;
        
    }
    
}


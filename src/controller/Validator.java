/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Window;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Cipla 1
 */
public class Validator {

    public int validate(JTextField text, JLabel error) {
        int result = 0;
        if (text.getText().length() == 0) {
            error.setText("Please Fill All the Fields");
            result = 1;
        }
        return result;

    }

    public static void validateEmail(String input, JLabel error) {
        Pattern pattent = Pattern.compile("[@]").compile("[.]");
        Matcher matcher = pattent.matcher(input);

        if (!matcher.find()) {
            error.setText("Invalid email address");
        } else {
            error.setText("");
        }

    }

    public static void validateNumber(JTextField text, int limit) {
        if (!text.getText().isEmpty()) {
            for (int i = 0; i < text.getText().length(); i++) {
                char c = text.getText().charAt(i);
                if (!Character.isDigit(c)) {
                    String s = text.getText().substring(0, i);
                    text.setText(null);
                    text.setText(s);
                }
                if (text.getText().length() > limit) {
                    String ss = text.getText().substring(i, limit);
                    text.setText(null);
                    text.setText(ss);
                }
            }
        } else {}

    }
    
    public int checkEqual(JTextField text1, JTextField text2, JLabel error) {
        int result = 0;
        if (stringCompare(text1.getText(),text2.getText())!=0) {
            error.setText("Password and Confirm Password are not matching");
            result = 1;
        }

        return result;

    }
    public static int stringCompare(String str1, String str2)
    {
  
        int l1 = str1.length();
        int l2 = str2.length();
        int lmin = Math.min(l1, l2);
  
        for (int i = 0; i < lmin; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
  
            if (str1_ch != str2_ch) {
                return str1_ch - str2_ch;
            }
        }
        if (l1 != l2) {
            return l1 - l2;
        }
        else {
            return 0;
        }}
    public static void validateAnswer(JTextField text)
    {
        if (!text.getText().isEmpty()) {
            for (int i = 0; i < text.getText().length(); i++) {
                char c = text.getText().charAt(i);
                if (c!='A' && c!='B'&& c!='C' && c!='D') {
                    String s = text.getText().substring(0, i);
                    text.setText(null);
                    text.setText(s);
                }
                
            }
        } else {}
    }

}

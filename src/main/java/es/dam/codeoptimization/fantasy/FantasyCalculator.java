/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dam.codeoptimization.fantasy;
import es.dam.codeoptimization.PlayerStats;

/**
 * THE CLASS YOU HAVE TO MODIFY
 * @author Your Name
 */
public class FantasyCalculator {

    // Method to calculate the points
    public static int calcP(PlayerStats s) {
        int r = 0; 
        int punts = 0;
        
        int m = s.minutes;
        int g = s.goals;
        int a = s.assists;
        boolean y = s.yellowCard;
        boolean red = s.redCard;
        int p = s.saves;
        int ga = s.goalsAgainst;
        char res = s.matchResult;
        String pos = s.position;

        // --- GOALKEEPER LOGIC ---
        if (pos.equals("PORTERO")) {
            if (m > 0 && m < 60) {
                r = r + 3;
            } else if (m >= 60) {
                r = r + 5;
            }

            for (int i = 0; i < g; i++) {
                r = r + 5;
            }

            r = r + (a * 6);

            // 1 point per save
            r = r + p; 
            
            if (ga == 0) {
                r = r + 5; 
            } else if (ga == 1) {
                r = r + 3;
            } else if (ga == 2) {
                r = r + 1;
            }

            if (y == true) r = r - 3; 
            if (red == true) r = r - 5;
            
            if (res == 'G') {
                r = r + 5;
            } else if (res == 'E') {
                r = r + 2;
            }

        // --- DEFENDER LOGIC ---
        } else if (pos.equals("DEFENSA")) {
            if (m > 0 && m < 60) {
                r = r + 3;
            } else if (m >= 60) {
                r = r + 5;
            }

            for (int i = 0; i < g; i++) {
                r = r + 5;
            }

            r = r + (a * 6);

            if (ga == 0) {
                r = r + 5; 
            } else if (ga == 1) {
                r = r + 3;
            } else if (ga == 2) {
                r = r + 1;
            }

            if (y == true) r = r - 3;
            if (red == true) r = r - 5;
            
            if (res == 'G') {
                r = r + 5;
            } else if (res == 'E') {
                r = r + 2;
            }

        // --- MIDFIELDER LOGIC ---
        } else if (pos.equals("MEDIO")) {
            if (m > 0 && m < 60) {
                r = r + 3;
            } else if (m >= 60) {
                r = r + 5;
            }

            for (int i = 0; i < g; i++) {
                r = r + 5;
            }

            r = r + (a * 6);

            if (y == true) r = r - 3;
            if (red == true) r = r - 5;
            
            if (res == 'G') {
                r = r + 5;
            } else if (res == 'E') {
                r = r + 2;
            }

        // --- FORWARD LOGIC ---
        } else if (pos.equals("DELANTERO")) {
            if (m > 0 && m < 60) {
                r = r + 3;
            } else if (m >= 60) {
                r = r + 5;
            }

            for (int i = 0; i < g; i++) {
                r = r + 6;
            }

            r = r + (a * 5);

            if (y == true) r = r - 3;
            if (red == true) r = r - 5;
            
            if (res == 'G') {
                r = r + 5;
            } else if (res == 'E') {
                r = r + 2;
            }
        }

        return r;
    }
}

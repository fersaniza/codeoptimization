/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dam.codeoptimization;

/**
 * Stats for a player. DO NOT EDIT
 * @author Boris
 */
public class PlayerStats {
    public String position;     // "PORTERO", "DEFENSA", "MEDIO", "DELANTERO"
    public int minutes;
    public int goals;
    public int assists;
    public boolean yellowCard;
    public boolean redCard;
    public int saves;           // Only for goalkeepers
    public int goalsAgainst;    // Only for goalkeepers and defenders
    public char matchResult;    // 'G' (Win), 'E' (Draw), 'D' (Loss)
}

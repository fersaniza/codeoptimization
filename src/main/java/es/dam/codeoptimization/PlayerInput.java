/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.dam.codeoptimization;

/**
 * Class that reads user input, DO NOT EDIT
 * @author Boris
 */

import java.util.Scanner;

public class PlayerInput {
    private static final Scanner scanner = new Scanner(System.in);

    // Private constructor prevents instantiation of this utility class
    private PlayerInput() {} 

    // STATIC method: called directly from main without creating an object
    public static PlayerStats askPlayerStats() {
        PlayerStats stats = new PlayerStats();

        System.out.println("--- Introduce los datos del jugador ---");

        stats.position = getValidPosition();
        stats.minutes = getValidInt("Minutos jugados (0-130): ", 0, 130);
        stats.goals = getValidInt("Goles marcados: ", 0, 100);
        stats.assists = getValidInt("Asistencias: ", 0, 100);

        // Only ask for saves if the player is a goalkeeper
        if (stats.position.equals("PORTERO")) {
            stats.saves = getValidInt("Paradas realizadas: ", 0, 100);
        }

        // Only ask for goals against if the player is a goalkeeper or defender
        if (stats.position.equals("PORTERO") || stats.position.equals("DEFENSA")) {
            stats.goalsAgainst = getValidInt("Goles recibidos por su equipo mientras jugaba: ", 0, 100);
        }

        stats.yellowCard = getValidBoolean("Tuvo tarjeta amarilla? (Si/No): ");
        stats.redCard = getValidBoolean("Tuvo tarjeta roja? (Si/No): ");
        
        // Updated prompt to reflect the new options
        stats.matchResult = getValidMatchResult("El equipo gano (G), empato (E) o perdio (D)?: ");

        return stats;
    }

    // --- PRIVATE VALIDATION METHODS ---

    private static String getValidPosition() {
        while (true) {
            System.out.print("Posicion (Portero, Defensa, Medio, Delantero): ");
            String input = scanner.nextLine().trim().toLowerCase();

            // Accepts both numbers as shortcuts and the actual names
            if (input.matches("0|portero")) return "PORTERO";
            if (input.matches("1|defensa")) return "DEFENSA";
            if (input.matches("2|centro|centrocampista|medio|mediocampista")) return "MEDIO";
            if (input.matches("3|delantero")) return "DELANTERO";

            System.out.println("Error: Posicion no reconocida. Intentalo de nuevo.");
        }
    }

    private static int getValidInt(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            try {
                int value = Integer.parseInt(scanner.nextLine().trim());
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Error: El valor debe estar entre " + min + " y " + max + ".");
            } catch (NumberFormatException e) {
                System.out.println("Error: Introduce un numero entero valido.");
            }
        }
    }

    private static boolean getValidBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();

            // Remove accents to simplify validation if the user types them anyway
            input = input.replace("í", "i");

            if (input.matches("si|s|1")) return true;
            if (input.matches("no|n|0")) return false;

            System.out.println("Error: Responde 'Si' o 'No'.");
        }
    }

    private static char getValidMatchResult(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            
            // Remove accents in case the user types them
            input = input.replace("ó", "o").replace("á", "a");

            // Validate all possible options with regex
            // 2 = Gano = G
            if (input.matches("g|gano|2")) {
                return 'G';
            }
            // 1 = Empato = E
            if (input.matches("e|empato|1")) {
                return 'E';
            }
            // 0 = Perdio = D (Loss)
            if (input.matches("d|p|perdio|0")) {
                return 'D';
            }
            
            System.out.println("Error: Introduce Gano, Empato o Perdio.");
        }
    }
}
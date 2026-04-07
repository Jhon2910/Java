/**
 * Classe Heater que representa um aquecedor com controle de temperatura.
 * Permite configurar limites mínimos e máximos, além de ajustar o incremento.
 * 
 * Projeto: heater-exercise
 * Autor: Jonathan Alexandre
 * Data: 15/10/2025
 */
public class Heater {
    private int temperature;
    private int min;
    private int max;
    private int increment;

    public Heater(int minTemp, int maxTemp) {
        min = minTemp;
        max = maxTemp;
        temperature = 15;
        increment = 5;
    }

    public void warmer() {
        if (temperature + increment <= max) {
            temperature += increment;
        } else {
            System.out.println("Temperatura não pode ultrapassar " + max + "º.");
        }
    }

    public void cooler() {
        if (temperature - increment >= min) {
            temperature -= increment;
        } else {
            System.out.println("Temperatura não pode ser inferior a " + min + "º.");
        }
    }

    public void setIncrement(int value) {
        if (value > 0) {
            increment = value;
        } else {
            System.out.println("Incremento deve ser um valor positivo.");
        }
    }

    public int getTemperature() {
        return temperature;
    }
}

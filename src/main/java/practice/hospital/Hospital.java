package practice.hospital;
import net.sf.saxon.expr.Component;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.StringJoiner;

public class Hospital {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.##");
    private static final DecimalFormat FORMAT = new DecimalFormat("#.#");

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] temperatures = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            float value = (float) (32.0 + 8.0 * Math.random());
            temperatures[i] = value;
        }
        return temperatures;
    }

    public static float getAverageTemperature(float[] temperatures) {
        float averageTemperature = 0.0f;

        for (float temperature : temperatures) {
            averageTemperature += temperature;
        }

        return averageTemperature / temperatures.length;
    }

    public static int calculateHealthyPeopleNumber(float[] temperatures) {
        int count = 0;

        for (float temperature : temperatures) {
            count += (temperature >= 36.2f && temperature <= 36.9f) ? 1 : 0;
        }
        return count;
    }

    public static String printTemperatures(float[] temperatures) {
        StringJoiner joiner = new StringJoiner(" ");

        for (float temperature : temperatures) {
            joiner.add(format(temperature, FORMAT));
        }
        return joiner.toString();
    }

    private static String format(float temperature, DecimalFormat dcFormat) {
        dcFormat.setRoundingMode(RoundingMode.HALF_UP);
        return dcFormat.format(temperature);
    }

    public static String getReport(float[] temperatures) {
        return "Температуры пациентов: " + printTemperatures(temperatures) +
                "\nСредняя температура: " + format(getAverageTemperature(temperatures), DECIMAL_FORMAT) +
                "\nКоличество здоровых: " + calculateHealthyPeopleNumber(temperatures);
    }
}
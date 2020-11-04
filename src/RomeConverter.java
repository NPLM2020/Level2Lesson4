import java.util.HashMap;
import java.util.Map;

public class RomeConverter {

    private final int maxLevel = 2;

    private final Map<Integer, String> romeNumbers = new HashMap() {
        {
            put(1, "I");
            put(5, "V");
            put(10, "X");
            put(50, "L");
            put(100, "C");
            put(500, "D");
            put(1000, "M");
        }
    };


    public String convert(int number) {
        String romeNumber = "";
        String numberString = Integer.toString(number);
        for (int i = 0; i < numberString.length(); i++) {
            romeNumber += getRomeSymbol(Integer.parseInt(Character.toString(numberString.charAt(i))),
                    numberString.length() - i - 1);
        }
        return romeNumber;
    }

    private String getRomeSymbol(int number, int level) {
        String romeSymbol = "";
        int power = (int) Math.pow(10, level);
        int maxPower = (int) Math.pow(10, maxLevel + 1);

        if (level > maxLevel) {
            for (int i = 0; i < number * (power / maxPower); i++) {
                romeSymbol += romeNumbers.get(maxPower);
            }
            return romeSymbol;
        }

        if (number >= 1 && number <= 3) {
            for (int i = 0; i < number; i++) {
                romeSymbol += romeNumbers.get(power);
            }
        } else if (number >= 4 && number <= 8) {
            String ones = "";
            String five = romeNumbers.get(5 * power);
            for (int i = 0; i < Math.abs(number - 5); i++) {
                ones += romeNumbers.get(power);
            }

            if (number - 5 > 0) {
                romeSymbol = five + ones;
            } else {
                romeSymbol = ones + five;
            }
        } else if (number == 9) {
            romeSymbol = romeNumbers.get(power) + romeNumbers.get(10 * power);
        }

        return romeSymbol;
    }

}

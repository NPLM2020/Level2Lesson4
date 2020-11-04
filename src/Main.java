import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        // Создать TreeMap<String, Integer>. Данная коллекция по-умолчанию сортирует по ключу.
        // Сделать так, чтобы сортировка производилась на значению.
        // К примеру, при значениях 3, 10, 1 (значения ключений могут быть любыми)
        // toString будет выводить всю структуру отсортированную по значениями {"4"=1}, {"101"=3}, {"-1"=10}
        Map<String, Integer> sortedMap = new TreeMap<>() {
            @Override
            public String toString() {
                return sortMap(this).toString();
            }
        };

        sortedMap.put("A",12);
        sortedMap.put("B",11);
        sortedMap.put("C",6);
        sortedMap.put("D",5);
        sortedMap.put("E",5);
        sortedMap.put("E5",7);

        System.out.println(sortedMap.toString());


        // Реализовать конвертор арабских цифр в диапазоне от 1 до 10 в римские (т.е. 9 станет IX, 4 - IV).
        // Все должно происходить динамические без привязки на "хадркоженные" значения,
        // с перспективой, что мы будем делать любые числа в диапазоне от 1 до N.
        RomeConverter romeConverter = new RomeConverter();
        System.out.println();
        System.out.println("Rome number for 1: " + romeConverter.convert(1));
        System.out.println("Rome number for 2: " + romeConverter.convert(2));
        System.out.println("Rome number for 3: " + romeConverter.convert(3));
        System.out.println("Rome number for 4: " + romeConverter.convert(4));
        System.out.println("Rome number for 5: " + romeConverter.convert(5));
        System.out.println("Rome number for 6: " + romeConverter.convert(6));
        System.out.println("Rome number for 7: " + romeConverter.convert(7));
        System.out.println("Rome number for 8: " + romeConverter.convert(8));
        System.out.println("Rome number for 9: " + romeConverter.convert(9));

    }

    static Map<String, Integer> sortMap(Map<String, Integer> map) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (map.get(o1).equals(map.get(o2))) return -1;
                return map.get(o1) - map.get(o2);
            }
        };

        Map<String,Integer> sortedMap = new TreeMap<>(comparator);
        sortedMap.putAll(map);
        return sortedMap;
    }


}

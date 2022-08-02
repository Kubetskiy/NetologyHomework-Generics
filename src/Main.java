public class Main {

    public static void main(String[] args) {

        MagicBox<Integer> integerMagicBox = new MagicBox<>(Integer[].class, 5);
        MagicBox<String> stringMagicBox = new MagicBox<>(String[].class, 5);

        // Заполним боксики
        int j = 0;
        while (integerMagicBox.add(++j)) {
        }
        j = 0;
        while (stringMagicBox.add(String.format("Просто строчка %3d", ++j))) {
        }
        //Достанем из боксиков по 5 значений
        for (int i = 0; i < 5; i++) {
                System.out.printf("<Integer>:%3d  <String>: %s\n",
                        integerMagicBox.pick(), stringMagicBox.pick());
        }
    }
}

import java.lang.reflect.Array;
import java.util.*;


public class Laptops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arraySize = 12;
        Map<Integer, Object> recordSearchParameters = new HashMap<>();
        Laptop[] laptopArray = new Laptop[arraySize];

        laptopArray[0] = new Laptop("ASUS", "1", 1732, 8, "Для работы", 256,
                "Чёрный");
        laptopArray[1] = new Laptop("ASUS", "2", 3699, 16, "Игровой", 512,
                "Чёрный");
        laptopArray[2] = new Laptop("ASUS", "3", 1299, 8, "Для учёбы", 256,
                "Синий");
        laptopArray[3] = new Laptop("ASUS", "4", 1799, 16, "Для дома", 512,
                "Серебристый");
        laptopArray[4] = new Laptop("HP", "1", 2587, 16, "Для работы", 512,
                "Серебристый");
        laptopArray[5] = new Laptop("HP", "2", 2890, 8, "Игровой", 512,
                "Серый");
        laptopArray[6] = new Laptop("HP", "3", 1899, 16, "Для учёбы", 512,
                "Тёмно-серый");
        laptopArray[7] = new Laptop("HP", "4", 2587, 16, "Для дома", 512,
                "Серебристый");
        laptopArray[8] = new Laptop("Apple", "1", 3050, 8, "Для работы", 256,
                "Серебристый");
        laptopArray[9] = new Laptop("Apple", "2", 18500, 64, "Для работы", 1024,
                "Серебристый");
        laptopArray[10] = new Laptop("Apple", "3", 16900, 64, "Компактный", 2048,
                "Серый");
        laptopArray[11] = new Laptop("Apple", "4", 3040, 8, "Компактный", 256,
                "Серебристый");

        searchLaptops(laptopArray, greetings(in), in, recordSearchParameters);
        in.close();
    }


    public static int greetings(Scanner in) {
        System.out.print("Пожалуйста, выберите желаемый вариант поиска:\n1) Вывести весь список ноутбуков." +
                "\n2) Выбрать критерии фильтрации.\n3) Выйти.\n Введите число: ");
        int num = in.nextInt();
        return num;
    }

    static Map<Integer, Object> filterHashMap() {
        Map<Integer, Object> filter = new HashMap<>();
        filter.put(1, "Производитель");
        filter.put(2, "Цена");
        filter.put(3, "Объём ОЗУ");
        filter.put(4, "Тип");
        filter.put(5, "Ёмкость накопителя");
        filter.put(6, "Цвет");

        return filter;
    }

    public static int searchLaptopsParam(Scanner in) {
        filterHashMap().forEach((key, value) -> {
            System.out.print(key + ") " + value + "\n");
        });
        System.out.print("Введите число  \"0\", чтобы завершить выбор параметров фильтрации: ");
        int num = in.nextInt();
        return num;
    }


    public static Map<Integer, Object> selectFilteringCriterion(Scanner in,
                                                                Map<Integer, Object> recordSearchParameters) {

        int number = searchLaptopsParam(in);

       /* String filterValue;*/
        switch (number) {
            case 1:
                System.out.println("Поиск по производителю...\n1) ASUS.\n2) HP.\n3) Apple.\n4) Назад.\nУкажите " +
                        "желаемого производителя или вернитесь назад и выберите другие параметры: ");
                int num = in.nextInt();
                switch (num) {
                    case 1:
                        recordSearchParameters.put(1, "ASUS");
                        break;
                    case 2:
                        recordSearchParameters.put(1, "HP");
                        break;
                    case 3:
                        recordSearchParameters.put(1, "Apple");
                        break;
                    case 4:
                        break;
                }
                selectFilteringCriterion(in, recordSearchParameters);
                break;
            case 2:
                System.out.println("Поиск по цене... Укажите желаемую цену: ");
                recordSearchParameters.put(2, in.next());
                selectFilteringCriterion(in, recordSearchParameters);
                break;
            case 3:
                System.out.println("Поиск по объёму ОЗУ... Укажите желаемый объём: ");
                recordSearchParameters.put(3, in.next());
                selectFilteringCriterion(in, recordSearchParameters);
                break;
            case 4:
                System.out.println("Поиск по типу использования... \n1) Игровой\n" +
                        "2) Для работы\n3) Для учёбы\n4) Для дома\n5) Компактный\n6) Назад\n Укажите желаемый " +
                        "тип использования или вернитесь назад и выберите другие параметры: ");
                num = in.nextInt();
                switch (num) {
                    case 1:
                        recordSearchParameters.put(4, "Игровой");
                        break;
                    case 2:
                        recordSearchParameters.put(4, "Для работы");
                        break;
                    case 3:
                        recordSearchParameters.put(4, "Для учёбы");
                        break;
                    case 4:
                        recordSearchParameters.put(4, "Для дома");
                        break;
                    case 5:
                        recordSearchParameters.put(4, "Компактный");
                        break;
                }
                selectFilteringCriterion(in, recordSearchParameters);
                break;
            case 5:
                System.out.println("Поиск по объёму накопителя... Укажите желаемый объём (0 = значение " +
                        "\"по умолчанию\": ");
                recordSearchParameters.put(5, in.next());
                selectFilteringCriterion(in, recordSearchParameters);
                break;
            case 6:
                System.out.println("Поиск по цвету...\n 1) Чёрный 2) Серый 3) Серебристый 4) Синий 5) Тёмно-серый" +
                        "\nУкажите желаемый цвет: ");
                num = in.nextInt();
                switch (num) {
                    case 1:
                        recordSearchParameters.put(6, "Чёрный");
                        break;
                    case 2:
                        recordSearchParameters.put(6, "Серый");
                        break;
                    case 3:
                        recordSearchParameters.put(6, "Серебристый");
                        break;
                    case 4:
                        recordSearchParameters.put(6, "Синий");
                        break;
                    case 5:
                        recordSearchParameters.put(6, "Тёмно-серый");
                        break;
                }
                break;
            default:
                System.out.println("Некорректный выбор. Попробуйте снова.");
        }
        return recordSearchParameters;
    }

    public static void searchLaptops(Laptop[] array, int number, Scanner in,
                                     Map<Integer, Object> recordSearchParameters) {
        switch (number) {
            case 1:
                System.out.println("Ваш список:");
                for (int i = 0; i < array.length; i++) {
                    array[i].displayInfo();
                }
                break;
            case 2:
                foundLaptops(array, in, recordSearchParameters);
                System.out.print("Желаете очистить параметры фильтрации? (1 - да, 0 - нет): ");
                int clearChoice = in.nextInt();
                if (clearChoice == 1) {
                    clearFilterParameters(recordSearchParameters);
                }
                break;
            case 3:
                return;
        }
        searchLaptops(array, greetings(in), in, recordSearchParameters);
    }

    static void foundLaptops(Laptop[] array, Scanner in, Map<Integer, Object> recordSearchParameters) {
        Map<Integer, Object> recordedSearchParameters = selectFilteringCriterion(in, recordSearchParameters);
        ArrayList<Laptop> finalLaptop = new ArrayList<>();

        for (Laptop laptop : array) {
            boolean matchAllCriteria = true;

            for (Map.Entry<Integer, Object> entry : recordedSearchParameters.entrySet()) {
                switch (entry.getKey()) {
                    case 1: // Производитель
                        if (!laptop.manufacturer.equals(entry.getValue())) {
                            matchAllCriteria = false;
                        }
                        break;
                    case 2: // Цена
                        if (laptop.price < Integer.parseInt(entry.getValue().toString())) {
                            matchAllCriteria = false;
                        }
                        break;
                    case 3: // Объём ОЗУ
                        if (laptop.ram < Integer.parseInt(entry.getValue().toString())) {
                            matchAllCriteria = false;
                        }
                        break;
                    case 4: // Тип
                        if (!laptop.type.equals(entry.getValue())) {
                            matchAllCriteria = false;
                        }
                        break;
                    case 5: // Ёмкость накопителя
                        if (laptop.storageCapacity < Integer.parseInt(entry.getValue().toString())) {
                            matchAllCriteria = false;
                        }
                        break;
                    case 6: // Цвет
                        if (!laptop.color.equals(entry.getValue())) {
                            matchAllCriteria = false;
                        }
                        break;
                }
            }
            if (matchAllCriteria) {
                finalLaptop.add(laptop);
            }
        }

        if (finalLaptop.isEmpty()) {
            System.out.println("Таких ноутбуков нет на складе, попробуйте изменить параметры поиска!");
        } else {
            for (Laptop laptop : finalLaptop) {
                laptop.displayInfo();
            }
        }
    }
    public static void clearFilterParameters(Map<Integer, Object> recordSearchParameters) {
        recordSearchParameters.clear();
        System.out.println("Параметры фильтрации успешно очищены.");
    }
}

class Laptop {
    String manufacturer;
    String model;
    int price;
    int ram;
    String type;
    int storageCapacity;
    String color;

    Laptop(String manufacturer, String model, int price, int ram, String type, int storageCapacity,
           String color) {

        this.manufacturer = manufacturer;
        this.model = model;
        this.price = price;
        this.ram = ram;
        this.type = type;
        this.storageCapacity = storageCapacity;
        this.color = color;
    }
    void displayInfo() {
        System.out.printf("Производитель: %s\nМодель: %s\nЦена: %d\nОбъём ОЗУ: %d\nТип: %s\nЁмкость накопителя: %d" +
                        "\nЦвет: %s\n\n", manufacturer, model, price, ram, type, storageCapacity, color);
    }
}


import java.lang.reflect.Array;
import java.util.*;

public class Laptops {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arraySize = 12;
        Laptop[] laptopArray = new Laptop[arraySize];

        laptopArray[0] = new Laptop("ASUS", "1", 1732, 8, "Для работы",256,
                "Чёрный");
        laptopArray[1] = new Laptop("ASUS", "2", 3699, 16, "Игровой",512,
                "Чёрный");
        laptopArray[2] = new Laptop("ASUS", "3", 1299, 8, "Для учёбы",256,
                "Синий");
        laptopArray[3] = new Laptop("ASUS", "4", 1799, 16, "Для дома",512,
                "Серебристый");
        laptopArray[4] = new Laptop("HP", "1", 2587, 16, "Для работы",512,
                "Серебристый");
        laptopArray[5] = new Laptop("HP", "2", 2890, 8, "Игровой",512,
                "Серый");
        laptopArray[6] = new Laptop("HP", "3", 1899, 16, "Для учёбы",512,
                "Тёмно-серый");
        laptopArray[7] = new Laptop("HP", "4",2587, 16, "Для дома",512,
                "Серебристый");
        laptopArray[8] = new Laptop("Apple", "1",3050, 8, "Для работы",256,
                "Серебристый");
        laptopArray[9] = new Laptop("Apple", "2",18500, 64, "Для работы",1024,
                "Серебристый");
        laptopArray[10] = new Laptop("Apple", "3",16900, 64, "Компактный",2048,
                "Серый");
        laptopArray[11] = new Laptop("Apple", "4",3040, 8, "Компактный",256,
                "Серебристый");

        searchLaptops(laptopArray, greetings(in), in);
        in.close();
    }


    public static int greetings(Scanner in){
        System.out.print("Пожалуйста, выберите желаемый вариант поиска:\n1) Вывести весь список ноутбуков." +
                "\n2) Выбрать критерии фильтрации.\n3) Подобрать в 1 клик.\n4) Выйти.\n Введите число: ");
        int num = in.nextInt();
        return num;
    }

    static Map<Integer, String> filterHashMap(){
        Map<Integer, String> filter = new HashMap<Integer, String>();
        filter.put(1, "Производитель.");
        filter.put(2, "Цена.");
        filter.put(3, "Объём ОЗУ.");
        filter.put(4, "Тип.");
        filter.put(5, "Ёмкость накопителя.");
        filter.put(6, "Цвет.");

        return filter;
    }
    public static int searchLaptopsParam(Scanner in){
        filterHashMap().forEach((key, value) -> {
            System.out.print(key + ") " + value + "\n");
        });
        System.out.print("Введите число (\"0\", чтобы выйти): ");
        int num = in.nextInt();
        return num;
    }


        public static Map<Integer, Object> selectFilteringCriterion(Scanner in){
        Map<Integer, Object> recordSearchParameters = new HashMap<Integer, Object>();
        int number = searchLaptopsParam(in);

        switch (number) {
            case 1:
                System.out.println("Поиск по производителю...\n1) ASUS.\n2) HP.\n3) Apple.\n4) Назад.\nУкажите " +
                        "желаемого производителя или вернитесь назад и выберите другие параметры: ");
                int num = in.nextInt();
                switch (num){
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
                selectFilteringCriterion(in);
                break;
            case 2:
                System.out.println("Поиск по цене... Укажите желаемую цену: ");
//                num = in.nextInt();
                recordSearchParameters.put(2, in.nextInt());
                selectFilteringCriterion(in);
                break;
            case 3:
                System.out.println("Поиск по объёму ОЗУ... Укажите желаемый объём: ");
                num = in.nextInt();
                recordSearchParameters.put(3, num);
                selectFilteringCriterion(in);
                break;
            case 4:
                System.out.println("Поиск по типу использования... \n1) Игровой\n" +
                        "2) Для работы\n3) Для учёбы\n4) Для дома\n5) Компактный\n6) Назад\n Укажите желаемый " +
                        "тип использования или вернитесь назад и выберите другие параметры: ");
                num = in.nextInt();
                switch (num){
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
                selectFilteringCriterion(in);
                break;
            case 5:
                System.out.println("Поиск по объёму накопителя... Укажите желаемый объём (0 = значение " +
                        "\"по умолчанию\": ");
                num = in.nextInt();
                recordSearchParameters.put(5, num);
                selectFilteringCriterion(in);
                break;
            case 6:
                System.out.println("Поиск по цвету...\n 1) Чёрный 2) Серый 3) Серебристый 4) Синий 5) Тёмно-серый\nУкажите желаемый цвет: ");
                num = in.nextInt();
                switch (num){
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
                selectFilteringCriterion(in);
                break;
        }
        return recordSearchParameters;
    }

    public static void searchLaptops(Laptop[] array, int number, Scanner in){
        switch (number) {
            case 1:
                System.out.println("Ваш список:");
                for (int i = 0; i < array.length; i++) {
                    array[i].displayInfo();
                }
                break;
            case 2:
                foundLaptops(array, in);
                break;
            case 3:
                System.out.printf("Выберите тип использования: ");
                chooseInOneClick(array ,in);

                break;
            case 4:
                return;
        }
        searchLaptops(array, greetings(in), in);
    }

    static void foundLaptops(Laptop[] array, Scanner in){
        Map<Integer, Object> recordedSearchParameters = selectFilteringCriterion(in);
        Collection<Object> valuesLaptop = recordedSearchParameters.values();

        for (Map.Entry<Integer, Object> item : recordedSearchParameters.entrySet()){
            //кошмар и костыли
            int objToInt = 0;
            if (item.getValue() instanceof Integer){
                objToInt = (Integer) item.getValue();
            }

            if(array[item.getKey()- 1].manufacturer.equals(item.getValue())){
                array[item.getKey()- 1].displayInfo();
            }
            // ☺
            if(array[item.getKey()- 1].price >= objToInt){
                array[item.getKey()- 1].displayInfo();
            }
            if(array[item.getKey()- 1].ram >= objToInt){
                array[item.getKey()- 1].displayInfo();
            }
            if(array[item.getKey()- 1].type.equals(item.getValue())){
                array[item.getKey()- 1].displayInfo();
            }
            if(array[item.getKey()- 1].storageCapacity >= objToInt){
                array[item.getKey()- 1].displayInfo();
            }
            if(array[item.getKey()- 1].color.equals(item.getValue())){
                array[item.getKey()- 1].displayInfo();
            }
            else {
                System.out.println("К сожалению ничего не найдено, попробуйте поменять параметры фильтрации!");
            }
        }
    }

    static void chooseInOneClick(Laptop[] array, Scanner in) {
        Map<Integer, Object> recordedSearchParameters = selectFilteringCriterion(in);
        Collection<Object> valuesLaptop = recordedSearchParameters.values();

        System.out.println("Выберите из списка для кого нужен ноутбук:\n1) Для учёбы\n2) Для работы\n3) Для дома\n" +
                "4) Игровой\n5) Компактный");
        Scanner input = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = input.nextInt();

        switch (num) {
            case 1:
                System.out.printf("Вы выбрали: %d - для учёбы, ваш список:\n", num);
                for (Map.Entry<Integer, Object> item : recordedSearchParameters.entrySet()) {
                    if (array[item.getKey() - 1].type.equals("Для учёбы")){
                        array[item.getKey() - 1].displayInfo();
                    }
                }
                break;
            case 2:
                System.out.printf("Вы выбрали: %d - для работы, ваш список:\n", num);
                for (Map.Entry<Integer, Object> item : recordedSearchParameters.entrySet()) {
                    if (array[item.getKey() - 1].type.equals("Для работы")){
                        array[item.getKey() - 1].displayInfo();
                    }
                }
                break;
            case 3:
                System.out.printf("Вы выбрали: %d - для дома, ваш список:\n", num);
                for (Map.Entry<Integer, Object> item : recordedSearchParameters.entrySet()) {
                    if (array[item.getKey() - 1].type.equals("Для дома")){
                        array[item.getKey() - 1].displayInfo();
                    }
                }
                break;
            case 4:
                System.out.printf("Вы выбрали: %d - игровой, ваш список:\n", num);
                for (Map.Entry<Integer, Object> item : recordedSearchParameters.entrySet()) {
                    if (array[item.getKey() - 1].type.equals("Игровой")){
                        array[item.getKey() - 1].displayInfo();
                    }
                }
                break;
            case 5:
            System.out.printf("Вы выбрали: %d - игровой, ваш список:\n", num);
            for (Map.Entry<Integer, Object> item : recordedSearchParameters.entrySet()) {
                if (array[item.getKey() - 1].type.equals("Компактный")){
                    array[item.getKey() - 1].displayInfo();
                }
            }
            break;
        }
        input.close();
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

    Laptop(String manufacturer, String model, int price, int ram, String type, int storageCapacity, String color) {

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
   /* public String getManufacturer() {
        return manufacturer;
    }

    public float getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }
    public String getType() {
        return type;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public String getColor() {
        return color;
    }*/

    /*@Override
    public String toString() {
        return "Laptop{" + "manufacturer=" + manufacturer + ", price=" + price + ", ram=" + ram
                + "type=" + type + ", storageCapacity=" + storageCapacity + ", color=" + color + '}';
    }*/


}





public class Program {



    public static void main(String[] args) {
        ToyShop toyShop = new ToyShop();

        // Добавление игрушек в магазин
        toyShop.addToy(1, "робот", 2);
        toyShop.addToy(2, "конструктор", 2);
        toyShop.addToy(3, "кукла", 6);

        // Запись результатов розыгрыша в файл
        toyShop.writeToFile("output.txt", 10);
    }

}

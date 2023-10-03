import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Random;



public class ToyShop {
    private PriorityQueue<Toy> toyQueue; // Очередь игрушек
    private Random random; // Генератор случайных чисел

    public ToyShop() {
        toyQueue = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.getFrequency(), t1.getFrequency()));
        random = new Random();
    }



    // Метод для добавления новой игрушки в магазин
    public void addToy(int id, String name, int frequency) {
        Toy toy = new Toy(id, name, frequency);
        toyQueue.add(toy);
    }

    // Метод для случайного выбора игрушки на основе частоты выпадения
    public Toy getRandomToy() {
        int totalFrequency = toyQueue.stream().mapToInt(Toy::getFrequency).sum();
        int randomNumber = random.nextInt(totalFrequency);
        int cumulativeFrequency = 0;

        for (Toy toy : toyQueue) {
            cumulativeFrequency += toy.getFrequency();
            if (randomNumber < cumulativeFrequency) {
                return toy;
            }
        }

        // Вернуть значение по умолчанию, если не удалось выбрать игрушку
        return new Toy(0, "Неизвестная игрушка", 0);
    }





    // Метод для записи результатов розыгрыша в файл
    public void writeToFile(String fileName, int numAttempts) {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (int i = 0; i < numAttempts; i++) {
                Toy toy = getRandomToy();
                fileWriter.write(toy.toString());
                fileWriter.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
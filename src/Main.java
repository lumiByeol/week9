import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("cow", 10));
        animals.add(new Animal("pig", 2));
        animals.add(new Animal("cat", 1));
        animals.add(new Animal("lion", 4));
        animals.add(new Animal("duck", 9));
        animals.add(new Animal("tiger", 7));
        animals.add(new Animal("zebra", 3));
        animals.add(new Animal("elephant", 6));
        animals.add(new Animal("rhino", 8));
        animals.add(new Animal("horse", 5));

        //вывести изначальную коллекцию
        animals.stream().forEach(Animal -> System.out.println(Animal.getName() + " " + Animal.getAge()));

        System.out.println("------");

        // вывести всех львов, если их нет - выбросить исключение
        animals.stream()
                .filter(Animal -> Animal.getName().equals("lion"))
                .forEach(Animal -> System.out.println("this lion is " + Animal.getAge() + " years old"));

        if (animals.stream().noneMatch(Animal -> Animal.getName().equals("lion"))){
            throw new IllegalArgumentException();
        }

        System.out.println("------");

        //вывести всех животных в порядке возрастания возраста
        //сортировка через Comparator
        List<Animal> sortedList = animals.stream()
                .sorted(Comparator.comparingInt(Animal::getAge))
                .toList();
        //вывод отсортированной коллекции
        sortedList.forEach(Animal -> System.out.println(Animal.getName() + " " + Animal.getAge()));

        System.out.println("------");

        //посчитать, сколько животных, которым больше 4 лет
        long count = animals.stream()
                .filter(animal -> animal.getAge() > 4)
                .count();
        System.out.println("there are " + count + " animals who are older than 4 years");

        System.out.println("------");

        //преобразовать коллекцию в мапу. ключ - название, значение - экземпляр животного
        Map<String, Animal> animalMap = animals.stream()
                        .collect(Collectors.toMap(Animal::getName, animal -> animal));
        System.out.println(animalMap);

        System.out.println("------");

        //вывести названия всех животных одной строкой
        String animalNames = animals.stream()
                .reduce("", (partialString, animal) -> partialString + animal.getName(), String::concat);
        System.out.println(animalNames);


        System.out.println("------");



    }
}

package pl.sapiens.javarestsoap.stream;

import java.util.List;
import java.util.function.Function;

public class StreamMain {
    public static void main(String[] args) {

        
        var persons = List.of(
                new Person("Maniek", "P", 38),
                new Person("Mateusz", "W.", 28),
                new Person("Adrian", "R", 16)
        );
        
        var filteredListOfNames = persons.stream()
                .filter(person -> person.age() >=18)
                .map(person -> {
                    String name = person.name();
                    System.out.println(name);
                    return name;
                })
                //.forEach(s -> System.out.println("name: " + s));
                .toList();

        for (var name: filteredListOfNames){
            System.out.println("name: " + name);
        }
        
    }
}

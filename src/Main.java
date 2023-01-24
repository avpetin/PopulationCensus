import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for(int i = 0; i < 10_000_000; i++){
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]
            ));
        }

        int count = (int) persons.stream()
               .filter(x -> x.getAge() < 18)
               .count();
        System.out.println(count);

        List<String> list1 = persons.stream()
                .filter(x -> x.getSex() == Sex.MAN && x.getAge() > 18 && x.getAge() < 27)
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(list1);

        List<String> list2 = persons.stream()
                .filter(x -> x.getAge() > 18 && (x.getSex() == Sex.WOMAN && x.getAge() < 60) || (x.getSex() == Sex.MAN && x.getAge() < 65))
                .filter(x -> x.getEducation() == Education.HIGHER)
                .map(Person::getFamily)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(list2);


    }
}

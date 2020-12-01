package ArrayListEG4;

import java.util.ArrayList;
import java.util.List;

public class RemoveElementsFormArray {
    public static void main(String[] args) {
        List<String> programingLanguages = new ArrayList<>();
        programingLanguages.add("C");
        programingLanguages.add("C++");
        programingLanguages.add("Java");
        programingLanguages.add("Kotlin");
        programingLanguages.add("Python");
        programingLanguages.add("Perl");
        programingLanguages.add("Ruby");

        System.out.println("Initial List: " + programingLanguages);

        programingLanguages.remove(5);
        System.out.println("After remove(5): " + programingLanguages);

        boolean isRemoved = programingLanguages.remove("Kotlin");
        System.out.println("After remove (\"Kotlin\"): " +programingLanguages);

        List<String> scriptingLanguages = new ArrayList<>();
        scriptingLanguages.add("Python");
        scriptingLanguages.add("Ruby");
        scriptingLanguages.add("Perl");

        programingLanguages.removeAll(scriptingLanguages);
        System.out.println("After removeAll (scriptingLanguages): " + programingLanguages);

//        Remove all the elements that exist in a given collection
        programingLanguages.removeIf(n -> (n.charAt(0) == 'T'));

        System.out.println("After removingall elements that start with \"C\": "+ programingLanguages);

        programingLanguages.clear();
        System.out.println("After clear(): " + programingLanguages);
    }
}

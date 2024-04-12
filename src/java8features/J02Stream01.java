package java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class J02Stream01 {

    public static void main(String[] args) {

        // Creating a Stream
        String[] array = {"a", "b", "c", "d"};
        Stream<String> streamFromArray = Arrays.stream(array);

        // Stream from Collection
        List<String> list = Arrays.asList("one", "two", "three");
        Stream<String> streamFromList = list.stream();

        // Intermediate Operation on streams
        streamFromArray.filter(s -> s.startsWith("a")).forEach(System.out::println); // Prints "a"
        streamFromList.map(String::toUpperCase).forEach(System.out::println); // Prints "ONE", "TWO", "THREE"

        Stream<String> streamFromList2 = list.stream();
        streamFromList2.sorted().forEach(System.out::println); // Sort in natural order

        // Terminal Operation on streams
        Stream<String> streamFromList3 = list.stream();
        List<String> filteredList = streamFromList3.filter(x -> x.contains("o"))
                .collect(Collectors.toList());
        System.out.println(filteredList); // Prints "[one, two]"

        Stream<String> streamFromArray2 = Arrays.stream(array);
        streamFromArray2.forEach(System.out::println); // Prints all elements

        Stream<String> streamFromList4 = list.stream();
        Optional<String> concatenated = streamFromList4.reduce((a, b) -> a + b);
        concatenated.ifPresent(System.out::println);

        Stream<String> streamFromList5 = list.stream();
        long count = streamFromList5.count();
        System.out.println(count); // Prints the number of elements

        long count2 = list.parallelStream().filter(x -> x.contains("o")).count();
        System.out.println(count2); // Count elements containing "o"

        Stream<String> stream1 = Stream.of("A", "B");
        Stream<String> stream2 = Stream.of("C", "D");
        Stream<String> combinedStream = Stream.concat(stream1, stream2);
        combinedStream.forEach(System.out::println); // Prints "A", "B", "C", "D"

    }
}

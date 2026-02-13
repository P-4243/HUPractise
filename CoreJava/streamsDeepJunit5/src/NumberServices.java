import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NumberServices {
//    reduce() combines all elements into one final value.
//            It "reduces" many values → into one result.
//    0 → starting value (identity)
//    Integer::sum → how to combine two numbers
    public int sumOfSquaredEvenNumber(List<Integer> numbers)
    {
        return numbers.stream()
                .filter(a->a%2==0)
                .map(a->a*a)
                .reduce(0,(a,b)->a+b);
    }
    public List<Integer> flattenList(List<List<Integer>> nestedList)
    {
        return nestedList.stream()
                .flatMap(List::stream)
                .toList();
    }
//    public Integer[] flattenList(List<List<Integer>> nestedList)
//    {
//        return nestedList.stream()
//                .flatMap(List::stream)
//                .toArray(Integer[]::new);
//    }
    public Map<Boolean,List<Integer>> groupEvenOdd(List<Integer> numbers)
    {
        return numbers.stream()
                .collect(Collectors.groupingBy(a->a%2==0));
    }
}

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        NumberServices numberServices=new NumberServices();
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6);
        System.out.println("squared evens sum: "+
                numberServices.sumOfSquaredEvenNumber(numbers));
        System.out.println("Grouped: "+
                numberServices.groupEvenOdd(numbers));
        List<List<Integer>> nested=List.of(
                List.of(1,2),
                List.of(3,4),
                List.of(5,6)
        );
        System.out.println("flattened: "+numberServices.flattenList(nested));
    }
}
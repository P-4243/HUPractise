import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,7,8,9);
        NumberService ns=new NumberService();
        List<Integer> result=ns.sqOddFun(numbers);
        System.out.println(result);
    }
}
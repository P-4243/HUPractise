import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private final NumberService ns=new NumberService();
    @Test
    public void shouldReturnSqOdd(){
        // GIVEN (input)
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9);
        // WHEN (method under test)
        List<Integer> result=ns.sqOddFun(numbers);
        List<Integer> expected=Arrays.asList(1,
                9,25,49,81);
        assertEquals(result,expected);
    }

    @Test
    public void shouldReturnEmptyListWhenNoOdd(){
        List<Integer> numbers=Arrays.asList(2,4,6,8);
        List<Integer> result=ns.sqOddFun(numbers);
        assertEquals(result,List.of());
    }
}

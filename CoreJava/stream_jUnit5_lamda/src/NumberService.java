import java.util.List;

//filter → remove unwanted data
//
//map → transform data
//
//collect → convert stream back to a list
//
//forEach → terminal operation
public class NumberService {
    public List<Integer> sqOddFun(List<Integer> numbers)
    {
        if(numbers==null)
            return List.of();
        return numbers.stream()
                .filter(a->a%2!=0)
                .map(a->a*a)
                .toList();
    }
    //    What about null input?
//
//    Right now, this will throw a NullPointerException.
//
//    That’s acceptable unless your requirements say otherwise.

}

import java.util.List;
import java.util.Optional;

public class UserRepository {

    private final List<User> users=List.of(
            new User(1,"Pooja","pooja@mail.com"),
            new User(2,"FairyGodMother",null)
    );

    public Optional<User> findById(int id)
    {
        return users.stream()
                .filter(a->a.getId()==id)
                .findFirst();
//        Streams are lazy.
//            Nothing executes until a terminal operation is called.
//
//            findFirst() is that terminal operation here.
    }

}

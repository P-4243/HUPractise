
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;
    //Mockito creates a fake object

    @InjectMocks
    private UserService userService;
//    Mockito injects the fake repository into service
    @Test
    public void shouldReturnUsernameWhenUserExists()
    {
        //given
        when(userRepository.findUsernameById(1))
                .thenReturn(Optional.of("pooja"));
        //when
        String result=userService.getUsername(1);

        //then
        assertEquals(result,"pooja");
    }
    @Test
    public void shouldThrowExceptionWhenUserNotFound(){
        //given
        when(userRepository.findUsernameById(2))
                .thenReturn(Optional.empty());
        //then
        assertThrows(RuntimeException.class,()->{
            userService.getUsername(2);
        }); 
    }



}

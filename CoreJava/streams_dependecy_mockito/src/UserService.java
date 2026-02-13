public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public String getUsername(int id)
    {
        return userRepository.findUsernameById(id)
                .orElseThrow(()->new RuntimeException("user not found"));
    }

}

import exception.UserNotFoundException;

import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }

    // 1️⃣ orElseThrow
    public User getUserOrFail(int id)
    {
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException("User with id " + id + " not found",404));
               // .orElseThrow(()->new RuntimeException("user not found"));
    }

    // 2️⃣ orElse
    public String getUserNameOrDefault(int id)
    {
        return userRepository.findById(id)
                .map(User::getName)
                .orElse("guest");
    }

    // 3️⃣ orElseGet
    public String getEmailOrGenerate(int id)
    {
        return userRepository.findById(id)
                .map(User::getEmail)
                .orElseGet(()->generateTemporaryEmail());
    }

    private String generateTemporaryEmail()
    {
        System.out.println("generating  temporary email...");
        return "temp@System.com";
    }

    // 4️⃣ map + Optional
    public Optional<String> getEmail(int id)
    {
        return userRepository.findById(id)
                .map(User::getEmail);
    }
//    If email is null ,It becomes:
//Optional.empty()....Not NullPointerException.
}

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository=new UserRepository();
        UserService userService=new UserService(userRepository);

        // 1️⃣ orElseThrow
        System.out.println(userService.getUserOrFail(1).getName());

        // 2️⃣ orElse
        System.out.println(userService.getUserNameOrDefault(5));

        // 3️⃣ orElseGet(lazy)
        System.out.println(userService.getEmailOrGenerate(1));

        // 4️⃣ map + Optional
        userService.getEmail(1).
                ifPresent((email->System.out.println("email: "+email)));

    }
}
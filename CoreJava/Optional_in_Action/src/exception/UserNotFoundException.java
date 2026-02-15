package exception;

public class UserNotFoundException extends RuntimeException{

    private final int errorCode;

    public UserNotFoundException(String message,int errorCode)
    {
        super(message);
        this.errorCode=errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
    //    Why extend RuntimeException?
//    Because:
//    It’s unchecked
//    Business exceptions are usually unchecked
//    Interview tip:
//
//            “Business exceptions should usually be unchecked.”
}

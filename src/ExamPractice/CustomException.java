
import java.util.Scanner;

class userException extends Exception {

    public userException(String m) {
        super(m);
    }
}

public class CustomException {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the username");
            String username = sc.nextLine();
            if (username.length() < 10) {
                System.out.print("The Username is valid : " + username);
            } else {
                throw new userException("Invalid Username");
            }
        } catch (userException e) {
            System.out.println(e.getMessage());

        }
    }
}
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("Введите вашу роль (Admin/Moderator/User):");
        Scanner scr_1 = new Scanner(System.in);
        String scr_1_string = scr_1.next();
        User auth = new User (scr_1_string);
        auth.Login();
        auth.Password();

    }
}

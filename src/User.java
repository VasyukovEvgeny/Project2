import java.util.Scanner;
public class User implements User_Interface{
    String Login;
    String Password;
    String Login_in;
    String Password_in;
    String Role_Name;
    String scr_3_string;
    enum Role {Admin, Moderator, User};
    User(String Role_Name) {
        this.Role_Name = Role_Name;
        this.Login = Login;
        this.Password = Password;
        if (Role_Name.equals("Admin")) {
            Login = "Adm";
            Password = "123";
        }
        if (Role_Name.equals("Moderator")) {
            Login = "Moderat";
            Password = "1234";
        }
        if (Role_Name.equals("User")) {
            Login = "User";
            Password = "12345";
        }
    }
    public void Login() {
        System.out.printf("Ваш логин: %s", Login);
        System.out.println("");

    }
    public void Password() {
        System.out.printf("Ваш пароль: %s", Password);
        System.out.println("");
    }
    public void User_Check() {
        int ok = 0;
        while (ok == 0) {
            System.out.println("Введите Ваш Login:");
            Scanner scr_1 = new Scanner(System.in);
            String Login_in = scr_1.next();
            System.out.println("Введите Ваш Пароль:");
            Scanner scr_2 = new Scanner(System.in);
            String Password_in = scr_2.next();
            try {
            if (!Password.equals(Password_in) | !Login.equals(Login_in)) {
                ok = 0;
                throw new NotCorrectAuth();
            }
            else {
                ok=1;}
            }
            catch(NotCorrectAuth exception){
            System.out.println("Неверный логин или пароль");
            }
        }
    }
    public void New_User_Authorization(){
        System.out.println("Введите вашу роль (Admin/Moderator/User):");
                    Scanner scr_3 = new Scanner(System.in);
                    String scr_3_string = scr_3.next();
                    this.scr_3_string = scr_3_string;
                    User auth_new = new User(scr_3_string);
                    auth_new.Login();
                    auth_new.Password();
                    auth_new.User_Check();
    }
}

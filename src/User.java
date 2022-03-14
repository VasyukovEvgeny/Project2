public class User implements User_Interface {
    String Login;
    String Password;
    String Role_Name;
    enum Role {Admin,Moderator,User};

     User (String Role_Name){
        this.Role_Name = Role_Name;
        this.Login= Login;
        this.Password= Password;
        if (Role_Name == "Admin") {
            Login = "Adm";
            Password = "123";
        }
        if (Role_Name == "Moderator") {
            Login = "Moderat";
            Password = "1234";
        }
        if (Role_Name == "User") {
            Login = "User";
            Password = "12345";
        }


    }


    public void Login(){
        System.out.printf("Ваш логин: %s", Login);
    }
    public void Password(){
        System.out.printf("Ваш пароль: %s", Password);
    }
}

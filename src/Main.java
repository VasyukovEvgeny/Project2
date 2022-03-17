import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        System.out.println("Введите вашу роль (Admin/Moderator/User):");
        Scanner scr_1 = new Scanner(System.in);
        String scr_1_string = scr_1.next();
        User auth = new User (scr_1_string);
        String note_type_string = "News";
        String note_name_string = "ds";
        String note_data_string = "fsdfsdf";
        int check_note = 0;
        int search_id;
        Note note = new Note(){};
        auth.Login();
        auth.Password();
        auth.User_Check();
        int exit = 0;
        String [] notes = {"","","","",""};
        String [] notes_data = {"","","","",""};
        String [] notes_authors = {"","","","",""};
        String [] notes_types = {"","","","",""};
        String scr_3_string = "";
        while (exit==0) {
            System.out.println("Чтобы вы хотели сделать?");
            System.out.println("1. Выполнить вход под другим пользоваталем");
            System.out.println("2. Создать новую заметку");
            System.out.println("3. Найти заметку");
            System.out.println("4. Выйти из приложения");
            Scanner scr_2 = new Scanner(System.in);
            String scr_2_string = scr_2.next();
            System.out.println(scr_2_string);
            if (scr_2_string.equals("1")) {
                    auth.New_User_Authorization();
                    exit = 0;
                    scr_3_string = auth.scr_3_string;
            }
            if (scr_2_string.equals("2")) {
                System.out.println("Введите название вашей заметки:");
                Scanner note_name = new Scanner(System.in);
                note_name_string = note_name.next();
                System.out.println("Введите инфо вашей заметки:");
                Scanner note_data = new Scanner(System.in);
                note_data_string = note_data.next();
                System.out.println("Введите тип вашей заметки (Hobbies/News):");
                Scanner note_type = new Scanner(System.in);
                note_type_string = note_type.next();
                try {
                    if (!note_type_string.equals("Hobbies") & !note_type_string.equals("News"))
                        throw new NotCorrectAuth();
                }
                catch(NotCorrectAuth exception){
                    System.out.println("Неверный тип заметки");
                }
                Note note_local = new Note(){};
                note_local.Note(note_type_string,note_name_string,note_data_string,scr_1_string);
                note.notes = note_local.notes;
                note.notes_data = note_local.notes_data;
                note.notes_types= note_local.notes_types ;
                note.Body = note_local.Body;
            }
            if (scr_2_string.equals("3")) {
                System.out.println("Введите название заметки для поиска:");
                Scanner note_search = new Scanner(System.in);
                String note_search_string = note_search.next();
                note.Search(note_search_string);
                search_id = note.search_id;
                int exit_2=0;
                check_note = note.check_note;
                if (check_note>0) {
                    while (exit_2 == 0) {
                        System.out.println("Чтобы вы хотели с вашей заметкой?");
                        System.out.println("1.Вывести содержимое заметки");
                        System.out.println("2.Изменить название");
                        System.out.println("3.Заменить слово");
                        System.out.println("4.Заменить содержимое заметки");
                        System.out.println("5.Вывести автора заметки");
                        System.out.println("6.Удалить заметку");
                        Scanner scr_2_menu = new Scanner(System.in);
                        String scr_2_menu_string = scr_2_menu.next();
                        if (scr_2_menu_string.equals("1")) {
                            note.Show_Note();
                            exit_2=0;
                        }
                        if (scr_2_menu_string.equals("2")) {
                            note.Change_Name(scr_1_string);
                            exit_2=0;
                        }
                        if (scr_2_menu_string.equals("3")) {
                            note.Change_Word(scr_1_string);
                            exit_2=0;
                        }
                        if (scr_2_menu_string.equals("4")) {
                            if (!scr_1_string.equals("User")) {
                                note.Change_Data(scr_1_string);
                            exit_2=0;
                        }
                        if (scr_2_menu_string.equals("5")) {
                            System.out.println(notes_authors[search_id]);
                            exit_2=0;
                        }
                        if (scr_2_menu_string.equals("6")) {
                            note.Delete_Note(scr_1_string);
                            exit_2=1;
                        }
                    }
                }}
                else {
                    System.out.println("Ваша заметка не найдена");
                }
            }
            if (scr_2_string.equals("4")) {
                exit = 1;
            }
            }

    }
}

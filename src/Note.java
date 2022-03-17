import java.util.Scanner;

public abstract class Note {

    String Type;
    String Body;
    String Name;
    String Author;
    int search_id;
    public Note(){};
    String scr_3_string;
    String note_name_string;
    String note_search_string;
    String note_data_string;
    String note_type_string;
    String [] notes = {"","","","",""};
    String [] notes_data = {"","","","",""};
    String [] notes_authors = {"","","","",""};
    String [] notes_types = {"","","","",""};
    int exit;
    String scr_1_string;
    int check_note=0;
    public void Show_Note(){
        System.out.println(notes_data[search_id]);
    };
    public void Change_Name(String scr_1_string){
        this.scr_1_string = scr_1_string;
        System.out.println(scr_1_string);
        if (!scr_1_string.equals("User")) {
            System.out.println("Введите новое название заметки");
            Scanner new_name = new Scanner(System.in);
            String new_name_string = new_name.next();
            notes[search_id] = new_name_string;
        }
        else {
            System.out.println("У вас нет прав на изменение названия");
        }
    };
    public void Change_Data(String scr_1_string){
        this.scr_1_string = scr_1_string;
        if (!scr_1_string.equals("User")) {
            System.out.println("Введите новое содержимое заметки");
            Scanner new_data = new Scanner(System.in);
            String new_data_string = new_data.next();
            notes_data[search_id] = new_data_string;
        }
        else {
            System.out.println("У вас нет прав на изменение содержимого");
        }
    };
    public void Delete_Note(String scr_1_string){
        this.scr_1_string = scr_1_string;
        if (!scr_1_string.equals("User")) {
            notes_data[search_id] = "";
            notes[search_id] = "";
            notes_authors[search_id] = "";
            notes_types[search_id] = "";
            System.out.println("");
        }
        else {
            System.out.println("У вас нет прав на удаление");
        }
    };
    public void Note(String Type, String Name, String Body,String Author){

        this.note_name_string = Name;
        this.note_data_string = Body;
        this.note_type_string = Type;
        this.scr_1_string = Author;
        if (Type.equals("News")) {
            Note_News News = new Note_News();
            News.Create_New(Name,Body);
        }
        if (Type.equals("Hobbies")) {
            Note_Hobbies Hobbies = new Note_Hobbies();
            Hobbies.Create_New(Name,Body);
        }
        if (!scr_1_string.equals("User")) {
            int k = 0;
            for(int i=1;i<notes.length;i++){
                if (!notes[i-1].equals("")) {
                    k=i;
                }
            }
            notes [k] = note_name_string;
            notes_data [k] = note_data_string;
            notes_authors [k] = scr_1_string;
            notes_types [k] = note_type_string;
        }
        else {
            System.out.println("У вас нет прав на создание");
        }
        exit = 0;
    }
    public void Search(String search){
        System.out.println(notes[0]);
        this.note_search_string = search;
        int i=0;
        int search_id=0;
        for(i=0;i<notes.length;i++){
            if (notes[i].equals(note_search_string)) {
                check_note=check_note+1;
                search_id=i;
//                System.out.println(i);
//                System.out.println(note_search_string);
//                System.out.println(notes[i]);
            }
        }
    }
    public void Change_Word(String scr_1_string){
        this.scr_1_string = scr_1_string;
        System.out.println(scr_1_string);
        if (!scr_1_string.equals("User")) {
            System.out.println("Введите cлово для замены");
            Scanner old_word = new Scanner(System.in);
            String old_word_string = old_word.next();
            System.out.println("Введите новое слово");
            Scanner new_word = new Scanner(System.in);
            String new_word_string = new_word.next();
            notes_data[search_id].replace(old_word_string,new_word_string);
        }
        else {
            System.out.println("У вас нет прав на изменение названия");
        }
    };
}

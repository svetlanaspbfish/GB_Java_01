package task1;

//Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
public class Main {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Sveta", "111111111");
        phonebook.add("Sveta", "55555555");
        phonebook.add("Sveta", "55555555");
        phonebook.add("Danya", "333333333");

        System.out.println( phonebook.getPhonesByName("Sveta") );
    }
}
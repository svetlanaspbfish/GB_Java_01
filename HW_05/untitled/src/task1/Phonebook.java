package task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phonebook {
    private Map<String, List<String>> phonebook = new HashMap<>();

    public void add( String name, String phone ) {
        if ( phonebook.containsKey( name ) )
        {
            if ( phonebook.get( name ).contains(phone) )
            {
                System.out.println("Такой номер уже есть");
            }
            else
            {
                phonebook.get( name ).add( phone );
            }
        }
        else
        {
            ArrayList<String> phones = new ArrayList<>();
            phones.add(phone);
            phonebook.put(name, phones );
        }
    }

    public List<String> getPhonesByName( String name )
    {
        if ( phonebook.containsKey( name ) )
        {
            System.out.println("Найдено совпадение");
            return phonebook.get( name );
        }
        else
        {
            System.out.println("Ничего не найдено");
            return new ArrayList<>();
        }
    }
}

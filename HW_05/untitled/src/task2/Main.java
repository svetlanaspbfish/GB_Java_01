package task2;
//Пусть дан список сотрудников:Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов. Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности. Для сортировки использовать TreeMap

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        String[] workers = {
                "Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"
        };

        Map<String, Integer> namesCount = new HashMap<>();

        for ( String curFullName: workers )
        {
            String firstName = curFullName.split(" ")[0];
            if ( namesCount.containsKey( firstName ) )
            {
                Integer count = namesCount.get( firstName );
                namesCount.put( firstName, ++count );
            }
            else namesCount.put( firstName, 1 );
        }

        for ( String curName: namesCount.keySet() )
        {
            if ( namesCount.get( curName ) > 1 )
            {
                System.out.println( curName + ": " + namesCount.get( curName ) );
            }
        }

        Map <String, Integer> sortedNamesCount = new TreeMap<>(
                ( name1, name2 ) -> namesCount.get( name2 ).compareTo( namesCount.get( name1 ) )
        );

        sortedNamesCount.putAll( namesCount );


        System.out.println();

        for ( String curName: sortedNamesCount.keySet() )
        {
            if ( sortedNamesCount.get( curName ) > 1 )
            {
                System.out.println( curName + ": " + sortedNamesCount.get( curName ) );
            }
        }
    }
}
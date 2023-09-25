import java.util.*;

import static java.lang.System.in;

public class Laptop {
    private String model; // Наименование модели ноутбука
    public String getModel()
    {
        return model;
    }
    private int ramMemory; // ОЗУ
    public int getRamMemory()
    {
        return ramMemory;
    }
    private int hardDiscMemory; // Объем ЖД
    public int getHardDiscMemory() {
        return hardDiscMemory;
    }
    private String os; // Операционная система
    public String getOs() {
        return os;
    }
    private String color; // Цвет

    public String getColor() {
        return color;
    }
    private int batteryPower; // мощность аккумулятора
    public int getBatteryPower() {
        return batteryPower;
    }
    public Laptop(
            String model,
            int ramMemory,
            int hardDiscMemory,
            String os,
            String color,
            int batteryPower
    )
    {
        this.model = model;
        this.ramMemory = ramMemory;
        this.hardDiscMemory = hardDiscMemory;
        this.os = os;
        this.color = color;
        this.batteryPower = batteryPower;
    }

    static void filter(Set<Laptop> laptops) {
        if ( laptops.isEmpty() )
        {
            System.out.println("Фильтровать нечего, до свидания.");
            return;
        }

        Set<Laptop> res = new HashSet<>();

        Map<Integer, String> paramsForFilter = new HashMap<Integer, String>();

        List<String> models = new ArrayList<>();
        List<Integer> rams = new ArrayList<>();
        List<Integer> hardDiscMemories = new ArrayList<>();
        List<String> oses = new ArrayList<>();
        List<String> colors = new ArrayList<>();
        List<Integer> batteryPowers = new ArrayList<>();

        for ( Laptop curLaptop : laptops)
        {
            models.add( curLaptop.getModel() );
            rams.add( curLaptop.getRamMemory() );
            hardDiscMemories.add( curLaptop.getHardDiscMemory() );
            oses.add( curLaptop.getOs() );
            colors.add( curLaptop.getColor() );
            batteryPowers.add( curLaptop.getBatteryPower() );
        }

        int i = 1;
        System.out.println("Фильтр выводит ноутбуки, отвечающие условиям фильтрации.");
        System.out.println("Доступные к фильтрации параметры:");
        System.out.println( i++ + ". Модель. Доступны: " + models.toString() );
        System.out.println( i++ + ". ОЗУ. Доступны: " + rams.toString() );
        System.out.println( i++ + ". ПЗУ (Объем ЖД). Доступны: " + hardDiscMemories.toString() );
        System.out.println( i++ + ". ОС. Доступны: " + oses.toString() );
        System.out.println( i++ + ". Цвета. Доступны: " + colors.toString() );
        System.out.println( i++ + ". Ёмкости аккума. Доступны: " + batteryPowers.toString() );
        System.out.println("Если захотите законить ввод, введите *.");

        Scanner in = new Scanner(System.in);
        String filterCode = " ";
        String filterParamValue = " ";
        int criteriaNum = 0;
        while ( true )
        {
            System.out.println("Введите порядковый номер критерия.");
            filterCode = in.nextLine();

            if ( filterCode.equals("*") ) break;

            criteriaNum = Integer.parseInt( filterCode );

            if ( criteriaNum < 0 || criteriaNum > 6 )
            {
                System.out.println("Некорректный ввод. До свидания.");
                return;
            }

            System.out.println("Введите значение для фильтра по выбранному критерию.");
            filterParamValue = in.nextLine();

            paramsForFilter.put( criteriaNum, filterParamValue);
        }

        in.close();

        boolean isOk = true;

        for ( Laptop curLaptop : laptops)
        {
            isOk = true;

            for (Map.Entry<Integer, String > entry : paramsForFilter.entrySet()) {
                Integer key = entry.getKey();
                String value = entry.getValue();

                switch ( key )
                {
                    case 1:
                        if ( !value.equals( curLaptop.getModel() ) ) isOk = false;
                        break;

                    case 2:
                        if ( Integer.parseInt( value ) > curLaptop.getRamMemory() ) isOk = false;
                        break;

                    case 3:
                        if ( Integer.parseInt( value ) > curLaptop.getHardDiscMemory() ) isOk = false;
                        break;
                    case 4:
                        if ( !value.equals( curLaptop.getOs() ) ) isOk = false;
                        break;
                    case 5:
                        if ( !value.equals( curLaptop.getColor() ) ) isOk = false;
                        break;
                    case 6:
                        if ( Integer.parseInt( value ) > curLaptop.getBatteryPower() ) isOk = false;
                        break;
                }

                if ( isOk == false ) break;
            }

            if ( isOk )
            {
                res.add(curLaptop);
            }
        }

        if ( res.isEmpty() )
        {
            System.out.println("Ничего не нашлось. До свидания.");
        }
        else
        {
            System.out.println("Вам подойдут следующие модели:");
            for ( Laptop curLaptop : res)
            {
                System.out.println( curLaptop.getModel() );
            }
        }

    }
}

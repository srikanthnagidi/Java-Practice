package com.foodAndAgriculturalStatsOfUN;

import com.foodAndAgriculturalStatsOfUN.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    private static final String PERSISTENCE_UNIT_NAME = "my-persistence-unit";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<File> files = readCSVFiles();
        Set<Country> countries = new HashSet<>();
        Set<Item> items = new HashSet<>();
        Set<Element> elements = new HashSet<>();
        Set<DateInYear> years = new HashSet<>();
        List<Data> dataList = new ArrayList<>();
        for (File f : files) {
            /*try(Stream<String> lines = Files.lines(Paths.get(f.getAbsolutePath()))){
                lines.forEach(line -> {
                    String[] strings = line.substring(1).split("(\",\")");
                    Country country = new Country(strings[0], strings[1]);
                    countries.add(country);
                    Item item = new Item(strings[2], strings[3]);
                    items.add(item);
                    Element element = new Element(Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), strings[6]);
                    elements.add(element);
                    DateInYear year = new DateInYear(Integer.parseInt(strings[7]));
                    years.add(year);
                    Data data = new Data(country, item, year, element, strings[8], new BigDecimal(strings[9]), strings[10].substring(0, strings[10].length() - 1));
                    dataList.add(data);
                });

            }catch (IOException e){

            }*/
            try {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
                String line;
                line = bufferedReader.readLine();
                while ((line = bufferedReader.readLine()) != null) {
                    String[] strings = line.substring(1).split("(\",\")");
                    Country country = new Country(strings[0], strings[1]);
                    countries.add(country);
                    Item item = new Item(strings[2], strings[3]);
                    items.add(item);
                    Element element = new Element(Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), strings[6]);
                    elements.add(element);
                    DateInYear year = new DateInYear(Integer.parseInt(strings[7]));
                    years.add(year);
                    Data data = new Data(country, item, year, element, strings[8], new BigDecimal(strings[9]), strings[10].substring(0, strings[10].length() - 1));
                    dataList.add(data);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(f.toString() + " done");
            //break;
        }
       /* countries.stream().forEach(c -> entityManager.persist(c));
        items.stream().forEach(i -> entityManager.persist(i));
        elements.stream().forEach(e -> entityManager.persist(e));
        years.stream().forEach(s -> entityManager.persist(s));*/
        //System.out.println(dataList.size());
        //System.out.println(dataList.stream().distinct().count());
        //dataList.stream().parallel().forEach(data -> System.out.println(data));
        //dataList.stream().distinct().forEach(data -> System.out.println(data.getId()));
        dataList.stream().distinct().filter(data -> data.getId() != null).collect(Collectors.toList()).stream().forEach(data -> entityManager.persist(data));

        entityManager.setFlushMode(FlushModeType.AUTO);
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    private static List<File> readCSVFiles() {
        List<File> files = new ArrayList<>();
        File f = new File("C:/Users/srika/Desktop/data");
        for (File file : f.listFiles()) {
            files.add(file);
        }
        return files;
    }

}

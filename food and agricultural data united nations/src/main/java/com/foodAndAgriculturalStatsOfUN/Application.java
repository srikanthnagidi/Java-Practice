package com.foodAndAgriculturalStatsOfUN;

import com.foodAndAgriculturalStatsOfUN.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Stream;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Application {

    private static final String PERSISTENCE_UNIT_NAME = "my-persistence-unit";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

        List<File> files =  readCSVFiles();
        Set<Country> countries = new HashSet<>();
        Set<Item> items = new HashSet<>();
        Set<Element> elements = new HashSet<>();
        Set<DateInYear> years = new HashSet<>();
        for (File f : files){
            try{
                BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
                String line;
                line = bufferedReader.readLine();
                while((line = bufferedReader.readLine()) != null){
                    System.out.println(line);
                    String[] strings = line.substring(1, line.length()).split("(\",\")");
                    //Arrays.asList(strings).forEach(System.out::print);
                   // System.out.println(strings[10].substring(0, strings[10].length()-1));
                    Country country = new Country(strings[0], strings[1]);
                    if (!countries.contains(country)){
                        countries.add(country);
                        entityManager.persist(country);
                    }
                    Item item = new Item(strings[2], strings[3]);
                    if (!items.contains(item)){
                        items.add(item);
                        entityManager.persist(item);
                    }
                    Element element = new Element(Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), strings[6]);
                    if (!elements.contains(element)){
                        elements.add(element);
                        entityManager.persist(element);
                    }
                    DateInYear year = new DateInYear(Integer.parseInt(strings[7]));
                    if (!years.contains(year)){
                        years.add(year);
                        entityManager.persist(year);
                    }
                    Data data = new Data(country, item, year, element, strings[8], new BigDecimal(strings[9]), strings[10].substring(0, strings[10].length()-1));
                    entityManager.persist(data);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(f.toString() + " done");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

    private static List<File>  readCSVFiles(){
        List<File> files = new ArrayList<>();
        File f = new File("C:/Users/srika/Desktop/data");
        for(File file : f.listFiles()){
            files.add(file);
        }
        return files;
    }

}

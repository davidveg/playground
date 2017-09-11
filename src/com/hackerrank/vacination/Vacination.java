package com.hackerrank.vacination;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.hackerrank.vacination.Vacination.City;

public class Vacination {

    public static class City {
    private int clinics;
    private double population;
    private double number_of_vacinated_people;

    public City(int clinics, int population) {
        this.clinics = clinics;
        this.population = population;
        this.number_of_vacinated_people = population / clinics;
    }

    public double getNumberOfVacinatedPeople() {
        return number_of_vacinated_people;
    }
}


public static void main(String[] args) throws IOException {

    int n = 0; // the number of cities
    int b = 0; // the number of clinics

    Scanner in = new Scanner(System.in);

    while (in.hasNextLine()) {
        String cityAndClinics = in.nextLine();

        List<String> optionStream = Arrays.stream(cityAndClinics.trim().split("\\s+")).map(s -> s.trim()).collect(Collectors.toList());
        n = Integer.parseInt(optionStream.size() > 0 ? optionStream.get(0) : "0"); // number of cities
        b = Integer.parseInt(optionStream.size() > 1 ? optionStream.get(1) : "0"); // number of clinics

        break;
    }

    List<City> cities = new ArrayList<>();

    IntStream.range(0, n).forEach(s -> {
        int population = in.nextInt();
        cities.add(new City(1, population));
    });

    
    Comparator<City> vacineComparator = Comparator.comparing(City::getNumberOfVacinatedPeople);
    PriorityQueue<City> city_queue = new PriorityQueue<City>(vacineComparator.reversed());
    for(City c : cities) {
    	city_queue.add(c);
    }
    
    IntStream.range(n, b).forEach(s -> {

        Stream t = cities.stream();
        city_queue.stream().sorted().findFirst().map(c -> {
            c.clinics++;
            c.number_of_vacinated_people = Math.ceil(c.population / c.clinics);
            return c;
        });
    });

    DecimalFormat df = new DecimalFormat("###.#");
    System.out.println(df.format(cities.stream().sorted(vacineComparator.reversed()).findFirst().get().getNumberOfVacinatedPeople()));
}
}

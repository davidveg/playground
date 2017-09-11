package com.hackerrank.sorthotels;

import java.util.Scanner;
import java.util.TreeSet;

public class SortHotels {

	public static class Hotel {
        private Long id;
        private String review;
        
        private Hotel(Long id, String review) {
            this.id = id;
            this.review = review;
        }
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        String set_words = in.nextLine();
        int numberOfReviews = in.nextInt();
        TreeSet <Hotel> hotels = new TreeSet<Hotel>();
        while(in.hasNext()) {
            Hotel h = new Hotel(in.nextLong(), in.nextLine());
            hotels.add(h);
        }
    }
}

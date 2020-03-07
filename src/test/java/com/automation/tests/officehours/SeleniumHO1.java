package com.automation.tests.officehours;

import java.util.ArrayList;
import java.util.Iterator;

public class SeleniumHO1 {

        /*
        iterator
        - List,Set,Map and other type of collections can use Iterator class to iterate over that collection
        -List has index(for i, for each, while, Iterator)
        Map (for each, Iterator-to loop through keys)
        -Basic Selenium Nagivation
         */
        public static void main(String[] args) {
            ArrayList<String> keysToSearch = new ArrayList<>();
            keysToSearch.add("fruits");
            keysToSearch.add("veggies");
            keysToSearch.add("berries");
            Iterator iterator=keysToSearch.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next());
            }
    }
}

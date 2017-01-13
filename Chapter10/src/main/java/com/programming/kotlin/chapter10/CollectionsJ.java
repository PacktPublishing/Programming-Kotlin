package com.programming.kotlin.chapter10;

import java.util.Collection;
import java.util.Map;

/**
 * Created by stepi on 29/10/16.
 */
public class CollectionsJ {
  public static void arrays() {
    int[] intArray = new int[]{1, 2, 3, 4};
  }

  public static void countries() {
    String[] countries = new String[]{"UK", "Germany", "Italy"};
    for (String country : countries) {
      System.out.print(country + ";");
    }
  }

  public static void dangerous(Collection<Long> l) {
    l.add(1000L);
  }

  public static void dangerousCall(Collection<Integer> l) {
    l.add(1000);
  }

  public static void dangerousCallMap(Map<String,String> map){
    map.put("newKey!", "newValue!");
  }
}

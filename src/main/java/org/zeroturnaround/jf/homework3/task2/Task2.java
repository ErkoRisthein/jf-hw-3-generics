package org.zeroturnaround.jf.homework3.task2;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;

public class Task2 {

  /**
   * @param lists vararg of List-s
   * @return a List of values that exist only once across all collections
   */
  @SafeVarargs
  public static <E> List<E> unique(List<E>... lists) {
    if(lists == null) {
      return emptyList();
    }

    Set<E> uniques = new LinkedHashSet<>();
    for (List<E> list : lists) {
      if(list != null) {
        uniques.addAll(list);
      }
    }

    return new ArrayList<>(uniques);
  }
}

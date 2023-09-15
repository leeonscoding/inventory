package com.leeonscoding.inventory.api;

import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public interface Util {

    class PageObject<T> {
        public static void pageObject(int offset, int limit, String sort, String order) {
            StringTokenizer tokenizer = new StringTokenizer(sort, ",");
            List<String> sortAttrList = new ArrayList<>();

            while(tokenizer.hasMoreElements()) {
                sortAttrList.add(tokenizer.nextToken());
            }

            //Sort.sort().by().
        }
    }
}

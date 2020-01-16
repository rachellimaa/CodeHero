package com.rachellima.codehero;

import java.util.ArrayList;
import java.util.List;

public class Paginator {
    public static final int TOTAL_NUM_ITEMS = 52;
    public static final int ITEMS_PER_PAGE = 4;
    public static final int ITEMS_REMAINING = TOTAL_NUM_ITEMS % ITEMS_PER_PAGE;
    public static final int LAST_PAGE = TOTAL_NUM_ITEMS / ITEMS_PER_PAGE;

    public List<Integer> generatePage(int currentPage) {
        int startItem = currentPage * ITEMS_PER_PAGE + 1;
        int numOfData = ITEMS_PER_PAGE;
        List<Integer> pageData = new ArrayList<>();

        if (currentPage == LAST_PAGE && ITEMS_REMAINING > 0) {
            for (int i = startItem; i < startItem + ITEMS_REMAINING; i++) {
                pageData.add(i);
            }
        } else {
            for (int i = startItem; i < startItem + numOfData; i++) {
                pageData.add(i);
            }
        }
        return pageData;
    }

}

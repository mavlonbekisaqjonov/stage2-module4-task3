package com.mjc.stage2.impl;

import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;
import com.mjc.stage2.entity.RectangleValues;

public class RectangleObserver {

    public void handleEvent(RectangleEvent event) {
        Rectangle rectangle = event.getSource();

        double sideA = rectangle.getSideA();
        double sideB = rectangle.getSideB();
        double perimeter = 2 * (sideA + sideB);
        double area = sideA * sideB;

        RectangleValues values = new RectangleValues(perimeter, area);
        RectangleWarehouse.getInstance().put(rectangle.getId(), values);

        System.out.println("Observer updated warehouse for rectangle ID " + rectangle.getId()
                + " with perimeter=" + perimeter + " and area=" + area);
    }
}

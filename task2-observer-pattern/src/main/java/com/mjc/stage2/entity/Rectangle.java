package com.mjc.stage2.entity;

import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.impl.RectangleObserver;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
    private int id;
    private double sideA;
    private double sideB;

    private final List<RectangleObserver> observers = new ArrayList<>();

    public Rectangle(int id, double sideA, double sideB) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        notifyObservers();
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        notifyObservers();
    }

    public void addObserver(RectangleObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RectangleObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        RectangleEvent event = new RectangleEvent(this);
        for (RectangleObserver observer : observers) {
            observer.handleEvent(event);
        }
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "id=" + id +
                ", sideA=" + sideA +
                ", sideB=" + sideB +
                '}';
    }
}

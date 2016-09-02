package com.example.siddhant.attendancemanager.Class;

/**
 * Created by ABC on 31-08-2016.
 */
public class subject {
    String name;
    int total_classes;
    int bunks_available;
    int left_classes;
    int classes_attended;
    int percentage;

    public subject(String name, int total_classes, int bunks_available, int left_classes, int classes_attended) {
        this.name = name;
        this.total_classes = total_classes;
        this.bunks_available = bunks_available;
        this.left_classes = left_classes;
        this.classes_attended = classes_attended;
    }

    public void setBunks_available(int bunks_available) {
        this.bunks_available = bunks_available;
    }

    public void setLeft_classes(int left_classes) {
        this.left_classes = left_classes;
    }

    public void setClasses_attended(int classes_attended) {
        this.classes_attended = classes_attended;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }

    public subject(String name, int total_classes) {
        this.name = name;
        this.total_classes = total_classes;
    }

    public int getClasses_attended() {
        return classes_attended;
    }

    public String getName() {
        return name;
    }

    public int getTotal_classes() {
        return total_classes;
    }

    public int getBunks_available() {
        return bunks_available;
    }

    public int getLeft_classes() {
        return left_classes;
    }
}

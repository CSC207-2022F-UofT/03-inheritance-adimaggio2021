/*
 * This file defines an abstract class named Bag.
 * In this exercise, you will be writing a larger class according to
 * the TODOs we have left you. You may find the readings in chapter
 * 1. Introduction to Java helpful.
 */

public abstract class Bag {
    private String color;
    private int numberOfContents;
    private int capacity;
    private String[] contents;

    /*
     * The other attributes (private instance variables) should
     * be empty (e.g. numberOfContents is 0 and an empty String array for
     * its contents.)
     */
    public Bag(String color, int capacity){
        this.numberOfContents = 0;
        this.color = color;
        this.capacity = capacity;
        this.contents = new String[capacity];
    }

    public String getColor(){
        return this.color;
    }

    public int getNumberOfContents(){
        return this.numberOfContents;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void setColor(String newColor){
        this.color = newColor;
    }



    public Boolean addItem(String newItem){
        if(numberOfContents < capacity){
            this.contents[numberOfContents] = newItem;
            numberOfContents += 1;
            return true;
        }  else {
            return false;
        }
    }



    /**
     *
     * If there are no items in this Bag, return null.
     *
     * @return: The last item added to this bag. If bag empty, return null
     */
    public String popItem(){
        if(numberOfContents == 0){
            return null;
        } else {
            String lastItem = contents[numberOfContents - 1];
            contents[numberOfContents - 1] = null;
            numberOfContents -= 1;
            return lastItem;
        }
    }


    /**
     * Increase this bag's capacity by n.
     *
     * @param n the amount to increase this Bag's capacity by
     */
    public void increaseCapacity(int n) {
        String [] newContents = new String[capacity + n];

        for (int i = 0; i < capacity; i++){
            newContents[i] = contents[i];
        }

        capacity += n;
        this.contents = newContents;
    }

    /**
     * Return the details of this Bag.
     * This method requires you to have created the private
     * instance variables mentioned above.
     *
     * @return
     */
    @Override
    public String toString() {
        return this.color + " Bag (" + this.numberOfContents + " / " +
                this.capacity + ")";
    }

    /*
     * Below we have defined an abstract method.
     * This method takes no arguments and does not return anything.
     * It increases the capacity of this Bag.
     *
     * You will need to implement this method in
     * HandBag.java and CrossbodyBag.java.
     *
     * We recommend you look at HandBag.java first.
     */
    public abstract void enhance();
}
///////////////////////////////////////////////////////////////
///Name: Fenil Patel 001-15-9661                            ///
///CSC 3410                                                 ///
///Spring 2015                                              ///
///Homework 3: arraylist.java                               ///
///Custom Array Class                                       ///
///Submitted: 02/21/2015                                    ///
///////////////////////////////////////////////////////////////

/*
 * The purpose of this program is to create an arraylist class that implements the ArrayList data structure in the java library. First, there are two constructors defined in the arraylist class. The default constructor creates an array of capacity 10. The second constructor accepts an integer parameter and sets the capacity of the list to this parameter. Second, there are eight methods defined so the user can dynamically modify the list. The first method, add, allows the user to specify an object they want added to the end of the array list. The second method, add, allows the user to specify an object and an index location where they would like that object placed. The third method, get, allows the users to determine the index of the object in the arraylist. The fourth method, size, allows the user to determine how many elements are in the array. The fifth method, isEmpty, allows the users to determine if the list is empty or not. The sixth method, isIn, checks if there is a particular object present in the array list and returns a boolean value. The seventh method, find, allows the user to find the objects first occurrence location in the array list. Lastly, the remove method allows the user to remove the first occurrence of the object in the array list.
 *
 * To create a dynamic array list the array data structure was used. The default constructors create an object array, which will be used in the arraylist class called list. The add method takes the user defined object and places it at the end of the array list. Afterwards, the size integer is incremented to count the amount of elements in the array list. The add method with an index and object defined first takes the checks if the index is greater than the capacity of the list array. If true, a temp array is created with a capacity set to next greatest tenth. In order to calculate the next greatest then the following formula is used: (index - (index % 10) + 10). First, the remainder of the index divided by 10 is subtracted from the index then 10 is added to value. After a for loop copies the elements in list array to new temp array. Then the list array is set to equal to the temp array and capacity set to the capacity of the new array. Later, the object defined is added to the index location specified by the user and the size increment by 1.  The get method simply returns the element in the index specified by the user. The getSize method returns the size variable which tell the users the amount of elements in the array list.  The isEmpty method checks if the size value is equal to 0. If it is, then it returns true otherwise false. The isIn method first sets a Boolean inIn value to false. Afterwards a for loop checks the elements in the array to see if it exist. As soon as the first value is found, the loop breaks and returns the value of the isIn Boolean. The find method is similar to the isIn method. First, a find_index is set to 0. Afterwards, a for loop check the array for a matching object. If so, the for loop breaks and returns the index value of the array. Lastly, the remove method removes the first occurrence of the object specified by the user. The method firs called the isIn method to check if the object exists in the array list. If true then it calls the find method to determine the index location of the object and sets it to null. Afterwards, the size is decremented by one.
 */

import java.util.Arrays;

public class arraylist {

    //Instance Variables

    //Defines an object array called list.
    Object [] list;
    //Initializes the variable size and sets it to 0.
    int size = 0;
    //Initializes the variable capacity and sets it to 0.
    int capacity = 0;
    //Initializes the variable default capacity as final to 10.
    private static final int DEFAULT_CAPACITY = 10;

    //Constructors

    //Default constructor which creates an Array of size 10.
    public arraylist() {
        list = new Object [DEFAULT_CAPACITY];
    }

    //Default constructor which creates an Array of size specified by user.
    public arraylist(int capacity) {
        this.capacity = capacity;
        list = new Object [capacity];
    }

    //Instance Methods

    //Method that adds the object specified by the user to the end of the list.
    public void add(Object x){
        list[size] = x;
        size++;
    }

    //Method that adds the object to the index specified by the user.
    public void add(int index, Object x){
        if(index >= list.length){
            Object [] list_new = new Object [(index - (index % 10)) + 10];
            for(int i = 0; i < list.length; i++){
                list_new [i] = list [i];
            }
            this.list = list_new;
            capacity = ((index - (index % 10)) + 10);
        }
        list[index] = x;
        size++;
    }

    //Method that gets the value of element at the index specified by the user.
    public Object get(int index){
        return list[index];
    }

    //Method that retuns the number of elements in the array list.
    public int getSize(){
        return size;
    }

    //Method that checks if the array list is empty.
    public boolean isEmpty(){
        if(size == 0)
            return true;
        else
            return false;
    }

    //Method that checks if a particular object exist in the array list.
    public boolean isIn(Object ob){
        boolean isIn = false;
        for(int i = 0; i < list.length; i++){
            if(list[i] == ob){
                isIn = true;
                break;
            }
        }
        return isIn;
    }

    //Method that returns the first occurrence of an object from location 0.
    public int find(Object n){
        int find_Index = 0;
        for(int i = 0; i < list.length; i++){
            if(list[i] == n){
                find_Index = i;
                break;
            }
        }
        return find_Index;
    }

    //Method that removes the first occurrence of an object from location 0.
    public void remove(Object n){
        if(isIn(n)){
            list[find(n)] = null;
            size--;
        }
    }
}
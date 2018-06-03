/**
 * @file:    Project.java
 * @package: flexjson_test.entities
 * @info:    test flexjson library / http://flexjson.sourceforge.net
 *
 * @author:  Moisés Alcocer, 2018
 * @link:    https://www.ironwoods.es
 * @license: MIT License
 */
package flexjson_test.entities;

import java.util.ArrayList;


public class Project {
    private int id;
    private String name;
    private ArrayList<Task> tasks;


    public Project() {}
    public Project(int id, String name) {
        this.id   = id;
        this.name = name;

        this.tasks = new ArrayList<>();
    }
    public Project(int id, String name, ArrayList<Task> tasks) {
        this.id    = id;
        this.name  = name;
        this.tasks = tasks;
    }


    public void addTask(Task t) {
        if (t == null) {
            System.err.println("Error storing task: 'null' given");
            return;
        }

        this.tasks.add( t );
    }

    public void clearTasks() {
        this.tasks.clear();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

} // class

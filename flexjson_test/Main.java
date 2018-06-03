/**
 * @file:    Main.java
 * @package: flexjson_test
 * @info:    test flexjson library / http://flexjson.sourceforge.net
 *
 * @author:  Moisés Alcocer, 2018
 * @link:    https://www.ironwoods.es
 * @license: MIT License
 */
package flexjson_test;

import flexjson_test.entities.Project;
import flexjson_test.entities.Task;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;


public class Main {

    private JSONSerializer serializer;
    private JSONDeserializer<Project> projectDeserializer;
    private JSONDeserializer<Task> taskDeserializer;
    private String jsonProject, jsonTask;


    /**
     * Main method
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main();
    }

    /**
     * Constructor
     *
     */
    public Main() {
        serializer          = new JSONSerializer().exclude("*.class");
        projectDeserializer = new JSONDeserializer<>();
        taskDeserializer    = new JSONDeserializer<>();

        this.testSerialize();
        this.testDeserialize();
    }


    /**
     * Tests
     *
     */

    private void testDeserialize() {
        System.out.println("Deserialization tests...");
        Project project = this.deserialiceProject(this.jsonProject);
        Task task = this.deserialiceTask(this.jsonTask);

        System.out.println("-------------------------------------\n\n");
        System.out.println(project.getId() + " - " + project.getName( ));
        System.out.println(task.getId() + " - " + task.getName( ));
    }

    private void testSerialize() {
        System.out.println("Serialization tests...");
        Project project = getProject();
        Task task       = getTask();

        this.jsonTask = serializer.serialize( task );
        System.out.println("Task: \n" + jsonTask);

        this.jsonProject = serializer.serialize( project );
        System.out.println("Project: \n" + jsonProject);

        project.addTask(task);
        this.jsonProject = serializer.include( "tasks" ).serialize( project );
        System.out.println("Project: \n" + jsonProject);

        System.out.println("-------------------------------------\n\n");
    }

    /**
     * Deserialices
     *
     */

    private Project deserialiceProject(String json) {

        if ( json == null || json.equals("")) {
            System.err.println("ERR args-> deserializing Project");
            return null;
        }

        Project p = null;
        try {
            p = projectDeserializer.deserialize(json, Project.class);
        } catch(Exception e) {
            System.err.println(
                "ERR -> deserializing Project -> " + e.toString( ));
        }

        return p;
    }

    private Task deserialiceTask(String json) {

        if ( json == null || json.equals("")) {
            System.err.println("ERR args-> deserializing Task");
            return null;
        }

        Task t = null;
        try {
            t = taskDeserializer.deserialize(json, Task.class);
        } catch(Exception e) {
            System.err.println(
                "ERR -> deseriazing Task -> " + e.toString( ));
        }

        return t;
    }


    /**
     * Create entities
     *
     */

    private Task getTask() {
        Task t = new Task( 1, "task one" );
        System.out.println(t.toString( ));
        return t;
    }

    private Project getProject() {
        Project p = new Project( 1, "test" );
        System.out.println(p.toString( ));
        return p;
    }

} // class

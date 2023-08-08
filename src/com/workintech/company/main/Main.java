package com.workintech.company.main;

import com.workintech.company.model.Priority;
import com.workintech.company.model.Status;
import com.workintech.company.model.Task;
import com.workintech.company.model.TaskData;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Task task = new Task("Java Sets", "Set", "Ann", Priority.MED, Status.ASSIGNED);
        Task task1 = new Task("Java Lists", "Lists", "Bob", Priority.MED, Status.ASSIGNED);
        Task task2 = new Task("Java Interfaces", "Interfaces", "Carol", Priority.MED, Status.ASSIGNED);
        Task task3 = new Task("Java Classes", "Classes", "Carol", Priority.HIGH, Status.IN_QUEUE);
        Task task4 = new Task("Java Sets", "Set", "Ann", Priority.MED, Status.ASSIGNED);
        Task task5 = new Task("Java Sets", "Set", "Carol", Priority.MED, Status.ASSIGNED);

        Set<Task> allTasks = new HashSet<>();
        allTasks.add(task);
        allTasks.add(task1);
        allTasks.add(task2);
        allTasks.add(task3);
        allTasks.add(task5);

        Set<Task> annsTask = new LinkedHashSet<>();
        annsTask.add(task);
        annsTask.add(task4);

        Set<Task> bobsTask = new LinkedHashSet<>();
        bobsTask.add(task1);

        Set<Task> carolsTask = new LinkedHashSet<>();
        carolsTask.add(task2);
        carolsTask.add(task5);

        Set<Task> unassignedTask = new LinkedHashSet<>();
        annsTask.add(task3);

        TaskData taskData =new TaskData(annsTask, bobsTask, carolsTask, unassignedTask);

        System.out.println("All tasks: " + taskData.getTasks("all"));

        System.out.println("Ann's tasks: " + taskData.getTasks("ann"));

        System.out.println("Bob's tasks: " + taskData.getTasks("bob"));

        System.out.println("Carol's tasks: " + taskData.getTasks("carol"));

        System.out.println("Difference tasks: " + taskData.getDifference(allTasks, taskData.getTasks("all")));

        System.out.println("Bob + Carol tasks: " + taskData.getIntersection(bobsTask, carolsTask));

        System.out.println("Ann + Carol tasks: " + taskData.getIntersection(annsTask, carolsTask));

        System.out.println("Ann + Bob tasks: " + taskData.getIntersection(annsTask, bobsTask));

        System.out.println("-------------");

        String text = "Carroll began writing the manuscript of the story the next day, although that earliest version is lost. " +
                "The girls and Carroll took another boat trip a month later, when he elaborated the plot to the story of Alice, " +
                "and in November he began working on the manuscript in earnest. To add the finishing touches he researched " +
                "natural history in connection with the animals presented in the book and then had the book examined " +
                "by other children—particularly those of George MacDonald. Though Carroll did add his own illustrations " +
                "to the original copy, on publication he was advised to find a professional illustrator so the pictures " +
                "were more appealing to its audiences. He subsequently approached John Tenniel to reinterpret " +
                "Carroll's visions through his own artistic eye, telling him that the story had been well liked by the" +
                " children.\n" + "\n" + "Carroll began planning a print edition of the Alice story in 1863. " +
                "He wrote on 9 May 1863 that MacDonald's family had suggested he publish Alice." +
                " A diary entry for 2 July says that he received a specimen page of the print edition around that date. " +
                "On 26 November 1864, Carroll gave Alice the manuscript of Alice's Adventures Under Ground, with illustrations " +
                "by Carroll, dedicating it as \"A Christmas Gift to a Dear Child in Memory of a Summer's Day\"." + " " +
                "The published version of Alice's Adventures in Wonderland is about twice the length of " +
                "Alice's Adventures Under Ground and includes episodes, such as the Mad Tea-Party, " +
                "that did not appear in the manuscript. The only known manuscript copy of Under Ground " +
                 "is held in the British Library. Macmillan published a facsimile of the manuscript in 1886.";

        String[] words = text.split(" ");
        System.out.println("Total count: " + words.length);
        TreeSet<String> uniqueWords = new TreeSet<>();

        for(String word: words) {
            if(word != null) {
                word = word.replace(".", "")
                        .replace("!", "")
                        .replace(",", "")
                        .replace("'", "")
                        .replace("\"", "")
                        .replace("?", "");
                uniqueWords.add(word.toLowerCase());
            }
        }

        System.out.println("Unique Words: " + uniqueWords);
        System.out.println("Unique words Count: " + uniqueWords.size());
    }
}
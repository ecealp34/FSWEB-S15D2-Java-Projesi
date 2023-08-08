package com.workintech.company.model;

import java.util.*;

public class TaskData {

    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }
    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getTasks(String taskOwner) {
        if(taskOwner.equals("ann")) {
            return annsTasks;
        } else if(taskOwner.equals("bob")) {
            return bobsTasks;
        }  else if(taskOwner.equals("carol")) {
            return carolsTasks;
        }
        if(taskOwner.equals("all")) {
            List<Set<Task>> taskList = new ArrayList<>();
            taskList.add(annsTasks);
            taskList.add(carolsTasks);
            taskList.add(bobsTasks);
            return getUnion(taskList);
        }
        return new HashSet<>();
    }

    public Set<Task> getUnion(List<Set<Task>> taskList) {
        Set<Task> totalTasks = new LinkedHashSet<>();
        for(Set<Task> tasks: taskList) {
            totalTasks.addAll(tasks);
        }
        return totalTasks;
    }

    public Set<Task> getIntersection(Set<Task> first, Set<Task> second) {
        Set<Task> intersectionTasks = new HashSet<>(first);
        intersectionTasks.retainAll(second);
        return intersectionTasks;
    }

    public Set<Task> getDifference(Set<Task> first, Set<Task> second) {
        Set<Task> differenceTasks = new HashSet<>(first);
        differenceTasks.removeAll(second);
        return differenceTasks;
    }
}

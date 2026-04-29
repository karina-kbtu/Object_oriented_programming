package oop_project;

import java.util.List;


public class SortByDate implements SortStrategy {

    public void sort(List<ResearchPaper> papers) {
        papers.sort((p1, p2) -> p2.getPublicationDate().compareTo(p1.getPublicationDate())); 
        System.out.println("Sorted by date.");
    }
}


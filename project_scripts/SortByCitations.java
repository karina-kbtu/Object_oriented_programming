package oop_project;

import java.util.List;

public class SortByCitations implements SortStrategy {

    public void sort(List<ResearchPaper> papers) {
        papers.sort((p1, p2) -> Integer.compare(p2.getCitations(), p1.getCitations())); 
        System.out.println("Sorted by citations.");
    }
}
package oop_project;

import java.util.List;

public interface Researcher {
    void addResearchPaper(ResearchPaper paper); 
    List<ResearchPaper> getResearchPapers(); 
    int calculateHIndex(); 
    String getName();
    String getId();
}

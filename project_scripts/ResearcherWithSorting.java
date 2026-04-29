package oop_project;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class ResearcherWithSorting implements Researcher {
    private List<ResearchPaper> researchPapers;
    private SortStrategy sortStrategy;

    public ResearcherWithSorting(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
        this.researchPapers = new ArrayList<>();
    }

    public void addResearchPaper(ResearchPaper paper) {
        researchPapers.add(paper);
    }
    public List<ResearchPaper> getResearchPapers() {
        return new ArrayList<>(researchPapers);
    }
    public int calculateHIndex() {
    	if (researchPapers == null || researchPapers.isEmpty()) return 0;  
        List<Integer> citations = new ArrayList<>();
        for (ResearchPaper paper : researchPapers) {
            citations.add(paper.getCitations());  
        }
        Collections.sort(citations, Collections.reverseOrder());
        
        int hIndex = 0;
       
        for (int i = 0; i < citations.size(); i++) {
            if (citations.get(i) >= i + 1) {
                hIndex++; 
            } else {
                break; 
            }
        }
        return hIndex;
    }
    public void printSortedPapers() {
        sortStrategy.sort(researchPapers);
        researchPapers.forEach(System.out::println);
    }

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}




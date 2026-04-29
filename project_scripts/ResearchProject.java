package oop_project;

import java.util.ArrayList;
import java.util.List;

public class ResearchProject {
    private String topic;
    private List<ResearchPaper> papers = new ArrayList<>();
    private List<Researcher> participants = new ArrayList<>();

    public ResearchProject(String topic) {
        this.topic = topic;
    }

    public void addPaper(ResearchPaper paper) {
        papers.add(paper);
    }

    public void addParticipant(Researcher researcher) {
        participants.add(researcher);
    }

    public String getTopic() {
        return topic;
    }

    public List<ResearchPaper> getPapers() {
        return new ArrayList<>(papers);
    }

    public List<Researcher> getParticipants() {
        return new ArrayList<>(participants);
    }
}

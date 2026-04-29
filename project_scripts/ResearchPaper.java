package oop_project;

import java.time.LocalDate;

public class ResearchPaper {
    private String title;
    private String author;
    private String journal;
    private LocalDate publicationDate;
    private int citations;

    public ResearchPaper(String title,String author, String journal, LocalDate publicationDate, int citations) {
        this.title = title;
        this.author = author;
        this.journal = journal;
        this.publicationDate = publicationDate;
        this.citations = citations;
    }

    public String getTitle() {
        return title;
    }
    public String getAuthor() {
    	return author;
    }

    public String getJournal() {
        return journal;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public int getCitations() {
        return citations;
    }
    public String toString() {
        return "ResearchPaper{" +
                "title='" + title + '\'' +
                "author='"+ author +'\''+ 
                ", journal='" + journal + '\'' +
                ", publicationDate=" + publicationDate +
                ", citations=" + citations +
                '}';
    }
}


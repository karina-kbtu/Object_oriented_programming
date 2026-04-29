package oop_project;


public class Mark {
	 private double attestation1;
	    private double attestation2;
	    private double finalExam;

	    public Mark(double attestation1, double attestation2, double finalExam, Course course) {
	        this.attestation1 = attestation1;
	        this.attestation2 = attestation2;
	        this.finalExam = finalExam;
	    }
	    public double getFinalScore() {
	        return (attestation1 + attestation2 + finalExam) / 3;
	    }
	    public String toString() {
	        return String.format("Mark{attestation1=%.2f, attestation2=%.2f, finalExam=%.2f}", attestation1, attestation2, finalExam);
	    }
	
}

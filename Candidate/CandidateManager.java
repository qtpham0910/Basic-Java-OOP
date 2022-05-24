package Candidate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
@SuppressWarnings("unchecked")
public class CandidateManager {
    
    private ArrayList<Candidate> candidates;
    
    public CandidateManager() {
        this.candidates = new ArrayList<>();
    }
    
    /*
    readData
    doc du lieu tu file van ban textFile va luu du lieu vao cac bien thanh vien
    */
    public boolean readData(String textFile) {
    		
    		try {
                // add code here
        		File inpfile = new File(textFile);
        		Scanner fileReader = new Scanner(inpfile);
        		while(fileReader.hasNextLine()) {
        			String[] info = fileReader.nextLine().split("\\s*\\|\\s*");// input file: somewhere have space between  " | ", some are not :)
        			String id = info[0];
        			String name = info[1];
        			String selection = info[2];
        			String sex = info[3];
        			int year = Integer.parseInt(info[4]);
        			int priority = Integer.parseInt(info[5]);
        			
        			Candidate cand = new Candidate(id, name, selection, sex, year, priority);
        			candidates.add(cand);
            }
            
            fileReader.close();
            return true;
        } catch(IOException ex) {
            System.out.println("Error reading file '" + textFile + "'");
            ex.printStackTrace();
            return false;
        }  
    }
    
    /* 
    getSelectionCandicates 
    trả về danh sách các thí sinh có khối thi là selection 
    */
    public ArrayList<Candidate> getSelectionCandicates(String selection) { 
        
        /* Todo */
        ArrayList<Candidate> bySelection = new ArrayList<>();
        for(Candidate i: candidates) {
        	if(i.getSelection().equals(selection)) {
        		bySelection.add(i);
        	}
        }
        return bySelection;
    }
    
    /* 
    getPriorityCandidates 
    trả về danh sách thí sinh được ưu tiên (có độ ưu tiên bằng 1)
    */
    public ArrayList<Candidate> getPriorityCandidates() {
        
        /* Todo */
    	ArrayList<Candidate> byPrio = new ArrayList<>();
        for(Candidate i: candidates) {
        	if(i.getPriority() == 1) {
        		byPrio.add(i);
        	}
        }
        return byPrio;
    }
    
    /* 
    sortByName 
    tra ve danh sach cac thi sinh duoc sap xep theo ho va ten (name)
    */
    public ArrayList<Candidate> sortByName() {
        
        /* Todo */
        ArrayList<Candidate> sortName = new ArrayList<>(candidates);
        for(int i = 0; i < sortName.size(); i++) {
        	for(int j = i + 1; j < sortName.size(); j++) {
        		if(sortName.get(i).getName().compareTo(sortName.get(j).getName()) > 0) {
        			Candidate temp = sortName.get(i);
        			sortName.set(i, sortName.get(j));
        			sortName.set(j, temp);
        		}
        	}
        }
        return sortName;
    }
    
    /* 
    getSecondYoungestCandidates 
    trả về danh sách các thí sinh có tuổi trẻ thứ 2 trong danh sách 
    (ví dụ: các khách hàng có các năm sinh 1990 1991 1992 1993, 
    trả về danh sách các thi sinh sinh năm 1992)
    */
    public ArrayList<Candidate> getSecondYoungestCandidates() {
        
        /* Todo */
    	 ArrayList<Candidate> sortYear= new ArrayList<>(candidates);
         for(int i = 0; i < sortYear.size(); i++) {
         	for(int j = i + 1; j < sortYear.size(); j++) {
         		if(sortYear.get(i).getYear() > sortYear.get(j).getYear()) {
         			Candidate temp = sortYear.get(i);
         			sortYear.set(i, sortYear.get(j));
         			sortYear.set(j, temp);
         		}
         	}
         }
         ArrayList<Candidate> secondYoung = new ArrayList<>();
         if(sortYear.size() < 2) {
        	 secondYoung.add(sortYear.get(0));
        	 return secondYoung;
         }
         int year = 0;
         for(int i = sortYear.size() - 2; i >= 0; i--) {
        	 if(sortYear.get(i).getYear() != sortYear.get(sortYear.size() - 1).getYear()) {
        		 year = sortYear.get(i).getYear();
        		 break;
        	 }
         }
         
         for(Candidate i:candidates) {
        	 if(i.getYear() == year) {
        		 secondYoung.add(i);
        	 }
         }
        return secondYoung;
    }
    
    /*
    printCandidatesFromArray 
    in danh sach cac thi sinh tu mot List da cho
    */
    public void printCandidatesFromArray(ArrayList<Candidate> candidates) {
        if (candidates == null) {
            return;
        }
        
        for (int i = 0; i < candidates.size(); i++) {
            candidates.get(i).print();
        }
    }
    
    /*
    printCandidates 
    in danh cach cac thi sinh duoc luu trong bien thanh vien candidates
    */
    public void printCandidates() {
        printCandidatesFromArray(this.candidates);
    }
    
    public static void main(String[] args) {
        CandidateManager candidateManager = new CandidateManager();
        if (!candidateManager.readData("candidates.txt")) {
            return;
        }
            
        //ArrayList<Candidate> selectionCandidates = candidateManager.getSelectionCandicates("A");
        //candidateManager.printCandidatesFromArray(selectionCandidates);
        //System.out.println();
        
        //ArrayList<Candidate> priorityCandidates = candidateManager.getPriorityCandidates();
        //candidateManager.printCandidatesFromArray(priorityCandidates);
        //System.out.println();
            
        //ArrayList<Candidate> sortedNameCandidates = candidateManager.sortByName();
        //candidateManager.printCandidatesFromArray(sortedNameCandidates);
        //System.out.println();
            
        //ArrayList<Candidate> secondYoungestCandidates = candidateManager.getSecondYoungestCandidates();
        //candidateManager.printCandidatesFromArray(secondYoungestCandidates);
    }
}
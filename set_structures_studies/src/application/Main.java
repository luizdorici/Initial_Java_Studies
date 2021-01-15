package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Set<Integer> courseA = new HashSet<>();
		Set<Integer> courseB = new HashSet<>();
		Set<Integer> courseC = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int nroStudents = sc.nextInt();
		
		for(int i = 0; i< nroStudents; i++) {
			Integer student = sc.nextInt();
			courseA.add(student);
		}
		
		System.out.print("How many students for course B? ");
		nroStudents = sc.nextInt();
		
		for(int i = 0; i< nroStudents; i++) {
			Integer student = sc.nextInt();
			courseB.add(student);
		}
		
		System.out.print("How many students for course C? ");
		nroStudents = sc.nextInt();
		
		for(int i = 0; i< nroStudents; i++) {
			Integer student = sc.nextInt();
			courseC.add(student);
		}
		
		Set<Integer> allStudents = new HashSet<>(courseA);
		
		allStudents.addAll(courseB);
		allStudents.addAll(courseC);
		
		System.out.println("Total students: " + allStudents.size());
		
		sc.close();
	}

}

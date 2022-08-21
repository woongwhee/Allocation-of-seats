package com.ung.seat.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentDAO {

	public String[] getStudent() {
		String[] Students = new String[23];
		try {
			BufferedReader br = new BufferedReader(new FileReader("student.txt"));
			for (int i = 0; i < 23; i++) {
				Students[i] = br.readLine();

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return Students;
	}

	public void recordStudents(String[] Students) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("student.txt"));
			for (int i = 0; i < Students.length; i++) {
				if (Students[i] == null) {
					bw.flush();
					break;
				}
				bw.write(Students[i]);
				bw.newLine();
				bw.flush();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void recordResult(String[] Students) {

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("result.txt"));
			for (int i = 0; i < Students.length; i++) {
				if (Students[i] == null) {
					bw.flush();
					break;
				}
				bw.write(Students[i]);
				bw.newLine();
				if (i == 22) {
					bw.flush();
				}
			}

		} catch (EOFException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public String[] recordView() {
		
		String[] record=new String[23];
		try {
			BufferedReader br = new BufferedReader(new FileReader("result.txt"));
			for (int i = 0; i < 23; i++) {
				record[i] = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		return record;
	}
}

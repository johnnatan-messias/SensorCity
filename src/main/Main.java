package main;

import database.Database;

public class Main {
	public static void main(String[] args) {

		Database.getInstance();
		System.out.println("Running");
	}

}

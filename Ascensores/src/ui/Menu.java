package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import model.*;

public class Menu {
	
	private static Reception recepcion;
	
	public Menu() {
		recepcion= new Reception();
	}

	public void showMenu() {
		System.out.println("[1] Start the program"+
		                   "[2] Exit the program.\n");
	}
	
	public int readOption(BufferedReader br) throws NumberFormatException, IOException {
		int option = Integer.parseInt(br.readLine());
		return option;
	}
	
	public void doOption(int option, BufferedReader br) throws NumberFormatException, IOException {
		switch(option) {
		
		case 1:
			System.out.println("-----------------------------------------------------");
			System.out.println("                     DISCREET GUYS INC");
			System.out.println("-----------------------------------------------------");
			
			System.out.println("\nPlease enter the following information:: ");
			System.out.println("Line 1: Number of buildings, example: 5\n"+
			                   "Line 2: ID of each building, number of people in the building, number of floors in the building, and number of offices per floor. Example: A 5 3 2 \n"+
			                   "Next lines: Write the name of each person in the building and the floor where they are located. Hit enter each time you finish typing a person's name and floor. Example: Luis 3 [enter]");
			readData(br);
			
			break;
				
		case 2:
			System.out.println("Bye!");
			break;
		}
	}
	
	public void startProgram() throws NumberFormatException, IOException {
		int option = 0;
		int exit = 2;
		do {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			showMenu();
			option = readOption(br);
			doOption(option, br);
		}while(option != exit);
	}
	
	public void readData(BufferedReader br) throws NumberFormatException, IOException {
		System.out.println("Line 1: Number of buildings, example: 5\n");
		int numberOfBuildings = Integer.parseInt(br.readLine());
		System.out.println("Line 2: ID of each building, number of people in the building, number of floors in the building, and number of offices per floor. Example: A 5 3 2 \n");
		for (int i = 0; i < numberOfBuildings; i++) {
			
			String line = br.readLine();
			String[] parts = line.split(" ");
			String IDBuilding = parts[0];
			int numberOfPeopleBuilding = Integer.parseInt(parts[1]);
			int numberOfFloorPerBuilding = Integer.parseInt(parts[2]);
			int numberOfOfficesPerFloor = Integer.parseInt(parts[3]);
			recepcion.createBuilding(IDBuilding, numberOfFloorPerBuilding, numberOfOfficesPerFloor);
			for (int j = 0; j < numberOfPeopleBuilding; j++) {
				System.out.println("Name and destiny of the person. Example: 'Jorge 4' ");
				line = br.readLine();
				String[] parts2 = line.split(" ");
				String name = parts2[0];
				int destiny = Integer.parseInt(parts2[1]);
				recepcion.createPerson(name, destiny);
				
			}
		}
	}

}

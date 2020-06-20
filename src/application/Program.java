import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		String path = "c:\\Projetos\\funcionarios.txt";
		
		List<Employee> list = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			String array[] = new String [3];
			while(line != null) {
				array = line.split(",");
				list.add(new Employee(array[0], array[1], Double.parseDouble(array[2])));
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}

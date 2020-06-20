package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
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
			
			System.out.println("Enter salary");
			double salary = sc.nextDouble();
			
			System.out.println("E-mail of people whose salary is more than " + String.format("%.2f R$", salary));
			List<String> email = list.stream()
					.filter(p -> p.getSalary() > salary)
					.map(p -> p.getEmail())
					.collect(Collectors.toList());
			email.forEach(System.out :: println);
			
			double sum = list.stream()
					.filter(p -> p.getName().charAt(0) == 'M')
					.map(p -> p.getSalary())
					.reduce(0.0, (x, y) -> x+y);
					
			System.out.println("Sum of salary of people whose name starts with 'M' " + sum);
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}

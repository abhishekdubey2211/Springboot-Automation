//package com.microservice.hotel;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import lombok.Data;
//import java.util.ArrayList;
//import java.util.List;
//
//@Data
//class Employee {
//	private int employeeId;
//	private String name;
//	private int age;
//	private String department;
//	private String designation;
//	private String email;
//	private double salary;
//
//	public Employee(int employeeId, String name, int age, String department, String designation, String email,
//			double salary) {
//		this.employeeId = employeeId;
//		this.name = name;
//		this.age = age;
//		this.department = department;
//		this.designation = designation;
//		this.email = email;
//		this.salary = salary;
//	}
//
//	@Override
//	public String toString() {
//		return "Employee{" + "employeeId=" + employeeId + ", name='" + name + '\'' + ", age=" + age + ", department='"
//				+ department + '\'' + ", designation='" + designation + '\'' + ", email='" + email + '\'' + ", salary="
//				+ salary + '}';
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Employee other = (Employee) obj;
//		return age == other.age && Objects.equals(department, other.department)
//				&& Objects.equals(designation, other.designation) && Objects.equals(email, other.email)
//				&& employeeId == other.employeeId && Objects.equals(name, other.name)
//				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(age, department, designation, email, employeeId, name, salary);
//	}
//
//	// Getters and Setters can be added here if needed
//}
//
//public class Main {
//	public static void main(String[] args) {
//		List<Employee> employees = new ArrayList<>();
//
//		// Adding employees to the list
//		employees.add(
//				new Employee(1, "John Doe", 30, "Engineering", "Software Engineer", "john.doe@example.com", 75000));
//		employees.add(new Employee(2, "Jane Smith", 25, "Marketing", "Marketing Specialist", "jane.smith@example.com",
//				50000));
//		employees.add(new Employee(3, "Alice Johnson", 28, "HR", "HR Manager", "alice.johnson@example.com", 60000));
//		employees.add(new Employee(4, "Bob Brown", 35, "Sales", "Sales Manager", "bob.brown@example.com", 65000));
//		employees
//				.add(new Employee(5, "Charlie White", 29, "Finance", "Accountant", "charlie.white@example.com", 55000));
//		employees.add(
//				new Employee(6, "Daisy Green", 32, "Engineering", "DevOps Engineer", "daisy.green@example.com", 80000));
//		employees.add(new Employee(7, "Ethan Black", 40, "Legal", "Legal Advisor", "ethan.black@example.com", 90000));
//		employees.add(new Employee(8, "Fiona Blue", 27, "Design", "UI/UX Designer", "fiona.blue@example.com", 48000));
//		employees.add(new Employee(9, "George Grey", 45, "Operations", "Operations Manager", "george.grey@example.com",
//				85000));
//		employees.add(new Employee(10, "Hannah Red", 22, "Support", "Customer Support Representative",
//				"hannah.red@example.com", 40000));
//
//		// Example: Partitioning employees based on salary threshold
//		System.out.println("\nEmployees partitioned by salary (above 60000):");
//		Map<Boolean, List<Employee>> partitionedBySalary = employees.stream()
//				.collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
//		partitionedBySalary.forEach((isAboveThreshold, empList) -> {
//			System.out.println("Salary > 60000: " + isAboveThreshold);
//			empList.forEach(System.out::println);
//		});
//
//		// Example: Mapping and joining employee names
//		System.out.println("\nList of employee names:");
//		String employeeNames = employees.stream().map(Employee::getName).collect(Collectors.joining(", "));
//		System.out.println(employeeNames);
//
//		// Example: Creating a map of employee names to emails
//		System.out.println("\nEmployee names and their email addresses:");
//		Map<String, String> employeeMap = employees.stream()
//				.collect(Collectors.toMap(Employee::getName, Employee::getEmail));
//		employeeMap.forEach((name, email) -> System.out.println(name + ": " + email));
//
//		List<Employee> salaryIncrementedList = employees.stream().filter(e -> e.getAge() > 30).peek(System.out::println)
//				.peek(e -> e.setSalary(e.getSalary() + 5000)).collect(Collectors.toList());
//
//		List<Employee> updatedList = employees.stream().filter(e -> e.getAge() > 30)
//				.map(e -> new Employee(e.getEmployeeId(), e.getName(), e.getAge(), e.getDepartment(),
//						e.getDesignation(), e.getEmail(), e.getSalary() + 5000)) // Create new Employee objects
//				.peek(System.out::println).collect(Collectors.toList());
//
//		List<Employee> sortedByAge = employees.stream().sorted((e, f) -> Integer.compare(f.getAge(), e.getAge()))
//				.peek(System.out::println).collect(Collectors.toList());
//
//		List<Employee> sortedByName = employees.stream().sorted((e, f) -> e.getName().compareTo(f.getName()))
//				.peek(System.out::println).collect(Collectors.toList());
//
//		List<Employee> updatename = employees.stream().filter(e -> e.getName() == "Fiona Blue")
//				.peek(e -> e.setName("Abhishek Dubey")).collect(Collectors.toList());
//		updatename.forEach(System.out::println);
//
//		// Example 5: Grouping employees by department
//		// This operation groups employees based on their department.
//		// The result is a Map where the key is the department and the value is a list
//		// of employees in that department.
//		// employeesByDepartment.forEach((department, empList) -> { ... }) iterates
//		// through each group and prints the results.
//		System.out.println("\nEmployees grouped by department:");
//		Map<String, List<Employee>> employeesByDepartment = employees.stream()
//				.collect(Collectors.groupingBy(Employee::getDepartment));
//		employeesByDepartment.forEach((department, empList) -> {
//			System.out.println(department + ":");
//			empList.forEach(System.out::println);
//		});
//
//		// Example 6: Counting employees in each department
//		// This operation counts the number of employees in each department.
//		// The result is a Map where the key is the department and the value is the
//		// count of employees in that department.
//		System.out.println("\nCount of employees in each department:");
//		Map<String, Long> employeeCountByDepartment = employees.stream()
//				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//		employeeCountByDepartment.forEach((department, count) -> System.out.println(department + ": " + count));
//
//		// Example 7: Finding the employee with the maximum salary
//		// This operation finds the employee with the highest salary.
//		System.out.println("\nEmployee with the highest salary:");
//		employees.stream().max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
//				.ifPresent(System.out::println);
//
//		// Example 7 (continued): Finding the employee with the lowest salary
//		// This operation finds the employee with the lowest salary.
//		System.out.println("\nEmployee with the lowest salary:");
//		employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()))
//				.ifPresent(System.out::println);
//
//		// Example 8: Reducing to calculate the total salary
//		// This operation reduces the list of employees to calculate the sum of all
//		// salaries.
//		System.out.println("\nTotal salary of all employees:");
//		double totalSalary = employees.stream().map(Employee::getSalary).reduce(0.0, Double::sum);
//		System.out.println(totalSalary);
//
//		// Example 9: Generating a list of emails
//		// This operation creates a list of emails from the list of employees.
//		System.out.println("\nEmployee emails:");
//		List<String> emails = employees.stream().map(Employee::getEmail).collect(Collectors.toList());
//		emails.forEach(System.out::println);
//
//		// Example 10: Checking if all employees have salary > 30000
//		// This operation checks if all employees have a salary greater than 30,000.
//		System.out.println("\nDo all employees have a salary > 30000?");
//		boolean allHighSalary = employees.stream().allMatch(e -> e.getSalary() > 30000);
//		System.out.println(allHighSalary);
//
//		// Example 11: Finding any employee in the Engineering department
//		// This operation finds any employee who works in the Engineering department.
//		System.out.println("\nFinding any employee in Engineering:");
//		employees.stream().filter(e -> e.getDepartment().equals("Engineering")).findAny()
//				.ifPresent(System.out::println);
//
//		// Example 12: Limit and skip examples
//		// This operation demonstrates how to limit the number of results and skip the
//		// first few.
//		System.out.println("\nFirst 3 employees:");
//		employees.stream().limit(3).forEach(System.out::println);
//
//		System.out.println("\nSkipping first 3 employees:");
//		employees.stream().skip(3).forEach(System.out::println);
//	}
//}
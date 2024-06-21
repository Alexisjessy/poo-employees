package fr.afpa.employees;

import java.time.LocalDate;

/**
 * Classe principale du projet, contient la fonction "main"
 */
public class EmployeeMain {
    public static void main(String[] args) {
        System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

        // Instanciation de 4 objets de la classe "Employee"
		
        Employee employee1 = new Employee("11AAA66", "Dupont", "Jean", "1991-12-10", 3500.0);
        Employee employee2 = new Employee("33XYZ44", "Martin", "Marie", "1991-07-10", 3200.0);
        Employee employee3 = new Employee("55LMN66", "Leroy", "Pierre", "1968-03-10", 3700.0);
        Employee employee4 = new Employee("77QRS88", "Moreau", "Alice", "1954-12-10", 3000.0);

        // Affichage des informations des employés
        // System.out.println(employee1);
        // System.out.println(employee2);
        // System.out.println(employee3);
        // System.out.println(employee4);
		
		Employee.displayAllEmployees();
        // Affichage des salaires nets et des jours avant les anniversaires
        System.out.println("Salaires nets :");
        System.out.println("N°" + employee1.getRegistrationNumber()+ " " + employee1.getFirstName() + " " + employee1.getLastName() + " (" + employee1.getBirthDate() + "): " + employee1.netSalary() + "  Jours avant anniversaire : " + employee1.daysBeforeBirthday());
        System.out.println(employee2.getFirstName() + " " + employee2.getLastName() + " (" + employee2.getBirthDate() + "): " + employee2.netSalary() + "  - Jours avant anniversaire : " + employee2.daysBeforeBirthday());
        System.out.println(employee3.getFirstName() + " " + employee3.getLastName() + " (" + employee3.getBirthDate() + "): " + employee3.netSalary() + " - Jours avant anniversaire : " + employee3.daysBeforeBirthday());
        System.out.println(employee4.getFirstName() + " " + employee4.getLastName() + " (" + employee4.getBirthDate() + "): " + employee4.netSalary() + " - Jours avant anniversaire : " + employee4.daysBeforeBirthday());
    }
}

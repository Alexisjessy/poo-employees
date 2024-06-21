package fr.afpa.employees;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


/**
 * Objectif :
 * L’objectif de ce TP est de concevoir un programme en console basé sur une
 * approche objet et
 * permettant de gérer (vraiment très basiquement) des salariés d’une
 * entreprise.
 * 
 * Vous allez écrire une classe représentant les salariés d'une entreprise.
 * Vous pourrez vous aider du PDF disponible pour obtenir des informations sur
 * la façon de faire.
 */

public class Employee {

	/**
	 * Matricule de l'employé
	 */
	private String registrationNumber;

	
	private String lastName;
	private String firstName;
	private LocalDate birthDate;
	private double salary;
	private final int socialRate = 30;

	
	private static ArrayList<Employee> employeeList = new ArrayList<>();

	
	public Employee(String registrationNumber, String lastName, String firstName, String birthDay, double salary) {
		setRegistrationNumber(registrationNumber);
		setLastName(lastName);
		setFirstName(firstName);
		setBirthDate(birthDay);
		this.salary = salary;

	
		employeeList.add(this);
	}

	// Getters et Setters

	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
        if (!isValidRegistrationNumber(registrationNumber)) {
            throw new IllegalArgumentException("Le format du matricule est invalide. Il doit être de la forme nnXXXnn.");
        }
        this.registrationNumber = registrationNumber;
    }
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if (lastName == null || lastName.trim().isEmpty() || containsDigit(lastName)) {
			throw new IllegalArgumentException("Le nom ne peut pas être vide et ne doit pas contenir de chiffres.");
		}
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if (firstName == null || firstName.trim().isEmpty() || containsDigit(firstName)) {
			throw new IllegalArgumentException("Le prénom ne peut pas être vide et ne doit pas contenir de chiffres.");
		}
		this.firstName = firstName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDay) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		try {
			this.birthDate = LocalDate.parse(birthDay, formatter);
		} catch (DateTimeParseException e) {
			throw new IllegalArgumentException("Entrez la date de naissance au format yyyy-MM-dd.");
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getSocialRate() {
		return socialRate;
	}

	// Méthode toString pour représenter un objet de la classe Employee sous forme
	// de chaîne de caractères
	@Override
	public String toString() {
		return "Employee{" +
				"registrationNumber='" + getRegistrationNumber() + '\'' +
				", lastName='" + getLastName() + '\'' +
				", firstName='" + getFirstName() + '\'' +
				", birthDate=" + getBirthDate() +
				", salary=" + getSalary() +
				", socialRate=" + getSocialRate() +
				'}';
	}

	// Méthode pour calculer le salaire net
	public double netSalary() {
		return this.salary - this.salary * (this.socialRate / 100.0);
	}

	// Méthode pour calculer le nombre de jours avant le prochain anniversaire
	public long daysBeforeBirthday() {
		LocalDate currentDate = LocalDate.now();
		LocalDate nextBirthday = this.birthDate.withYear(currentDate.getYear());

		// Si l'anniversaire est déjà passé cette année, prendre l'année suivante
		if (nextBirthday.isBefore(currentDate) || nextBirthday.isEqual(currentDate)) {
			nextBirthday = nextBirthday.plusYears(1);
		}

		return ChronoUnit.DAYS.between(currentDate, nextBirthday);
	}

	// Méthode pour vérifier si une chaîne contient des chiffres


	private boolean containsDigit(String str) {
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		return false;
	}
    
	   // Méthode pour vérifier le format du matricule
	   private boolean isValidRegistrationNumber(String registrationNumber) {
        return registrationNumber.matches("\\d{2}[A-Za-z]{3}\\d{2}");
    }

	// Méthode pour afficher les informations de tous les employés
	public static void displayAllEmployees() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}

}

package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservas;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.println("Número do quarto: ");
			int numeroQuarto = sc.nextInt();
			System.out.println("Check-in data (dd/mm/aaaa): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out data (dd/mm/aaaa): ");
			Date checkOut = sdf.parse(sc.next());

			Reservas reservas = new Reservas(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.println("Check-in data (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out data (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());

			reservas.updateDate(checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
		} catch (ParseException e) {
			System.out.println("Formato da data inválida!");
		} catch (DomainException e) {
			System.out.println("Erro na reserva: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Error inesperado!");
		}
		sc.close();
	}

}

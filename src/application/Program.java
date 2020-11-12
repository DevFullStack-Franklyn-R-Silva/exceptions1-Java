package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Número do quarto: ");
		int numeroQuarto = sc.nextInt();
		System.out.println("Check-in data (dd/mm/aaaa): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-Out data (dd/mm/aaaa): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser posterior à data de check-in");
		} else {
			Reservas reservas = new Reservas(numeroQuarto, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);

			System.out.println();
			System.out.println("Insira os dados para atualizar a reserva:");
			System.out.println("Check-in data (dd/mm/aaaa): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Check-Out data (dd/mm/aaaa): ");
			checkOut = sdf.parse(sc.next());

			String error = reservas.updateDate(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error na reservar: ");
			} else {
				System.out.println("Reserva: " + reservas);
			}
		}

		sc.close();
	}

}

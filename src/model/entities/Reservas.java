package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {

	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservas() {
	}

	public Reservas(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	// métodos
	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public String updateDate(Date checkIn, Date checkOut) {
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "As datas de reserva para atualização devem ser datas futuras.";
		}
		if (!checkOut.after(checkIn)) {
			return "Check-out deve ser posterior à data de check-in";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
		
	}

	@Override
	public String toString() {
		return "Quarto " + numeroDoQuarto + ", checkIn: " + sdf.format(checkIn) + ", checkOut: " + sdf.format(checkOut)
				+ ", " + duracao() + " noites.";
	}

}

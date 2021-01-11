package application;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date data = Date.from(Instant.parse("2021-01-10T22:57:07Z"));
		//10/01/2021 19:57:07
		System.out.println(sdf.format(data));
		
		//cria um calendario, util para adicionar horas,dias,meses, etc, a uma data
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		cal.add(Calendar.HOUR_OF_DAY, 4);
		data = cal.getTime();
		
		//10/01/2021 23:57:07
		System.out.println(sdf.format(data));
		
		//pegando valores de um tipo Date
		int min = cal.get(Calendar.MINUTE);
		//mes comeca no 0 entao precisa somar 1
		int mes = 1 + cal.get(Calendar.MONTH);
		
		System.out.println("Minutes: " + min);
		System.out.println("Month: " + mes);
		
	}

}

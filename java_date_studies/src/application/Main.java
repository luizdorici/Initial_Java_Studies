package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;


/*
 * 		IMPORTANT NOTES:
 * 	Simple Date formats:
 * 		dd/MM/yyyy
 * 		dd/MM/yyyy HH:mm:ss
 * 	ISO 8601 pattern
 * 		yyyy-MM-ddTHH:mm:ssZ
 * 
 */
public class Main {

	public static void main(String[] args) throws ParseException {
		//declaracao de uma data de formato simples
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		//declaracao de uma data de formato simples com hora
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		//transforma a string em uma data do tipo simples e armazena na variavel data1
		//formato apresentado, dia da semana e mes nao sao numeros
		//apresentado em BRT pq estou no Brasil
		Date data1 = sdf1.parse("10/01/2021");
		//precisa fazer tratamento de excessoes corretamente - catch
		Date data2 = sdf2.parse("10/01/2021 22:13:07");

		// output:
		//Sun Jan 10 00:00:00 BRT 2021
		//Sun Jan 10 22:13:07 BRT 2021
		System.out.println(data1 + "\n" + data2);
		// output 2
		//10/01/2021
		//10/01/2021 22:13:07
		System.out.println(sdf1.format(data2) + "\n" + sdf2.format(data2));
		
		//cria uma data com horario atual
		Date newdate = new Date();	
		System.out.println(newdate);
		
		//cria a data com horario atual passando o tempo atual em milisegundos
		Date newdate2 = new Date(System.currentTimeMillis());	
		System.out.println(newdate2);
		
		//o objeto Date internamente armazena o numero de milisegundos desde a 
		//meia noite do dia 1 de janeiro de 1970 GMT (UTC)
		//porem como estamos em BRT, este horario tem um modificador de -3horas
		Date olddate = new Date(0L);	
		System.out.println(olddate);
		
		//imprime a data no formato UTC, caso nosso sistema esteja em BRT
		//isso faz com que a data seja decrementada em 3 horas
		Date dataISO = Date.from(Instant.parse("2021-01-10T22:29:07Z"));
		System.out.println(sdf2.format(dataISO));
		
		//caso queira imprimir como GMT (UTF)
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		sdf3.setTimeZone(TimeZone.getTimeZone("GMT"));
		System.out.println(sdf3.format(dataISO));
		
		//armazenar sempre em GMT (UTF) como boa pratica apra converter de acordo com a regiao
		//onde o a aplicacao esta rodando
		
	}

}

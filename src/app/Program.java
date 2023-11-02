package app;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

	public static void main(String[] args) {

		DateTimeFormatter fmtLocalDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");// LocalDate
		DateTimeFormatter fmtLocalDateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");// LocalDateTime
		DateTimeFormatter fmtInstant = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

//---------(agora)->DATA-HORA-------------------------

		// Atribui a data atual(YYY-MM-DD)
		LocalDate d01 = LocalDate.now();
		// Atribui a data/hora local(YYY-MM-DDTHH:MM:SS.ss(fração de segundos))
		LocalDateTime d02 = LocalDateTime.now();
		// Atribui a data/hora ZULU (YYY-MM-DDTHH:MM:SS.ss(fração de segundos))
		Instant d03 = Instant.now();

		System.out.println("(agora)->DATA-HORA");
		System.out.println("LocalDate     d01 = " + d01);
		System.out.println("LocalDateTime d02 = " + d02);
		System.out.println("Instant       d03 = " + d03);
		System.out.println();

//---------TEXTO ISO 8601->DATA-HORA-------------------------		

		System.out.println("TEXTO -> DATA-HORA");

		LocalDate d04 = LocalDate.parse("2023-10-28");
		LocalDateTime d05 = LocalDateTime.parse("2023-10-28T00:00:00");
		Instant d06 = Instant.parse("2023-10-28T00:00:00Z");
		Instant d07 = Instant.parse("2023-10-28T00:00:00-03:00");// INDICO A HORA LOCAL E IMPRIME GLOBAL

		System.out.println("d04 = " + d04);
		System.out.println("d05 = " + d05);
		System.out.println("d06 = " + d06);
		System.out.println("d07 = " + d07);
		System.out.println();

// ---------TEXTO CUSTOMIZADO->DATA-HORA-------------------------

		System.out.println("TEXTO CUSTOMIZADO -> DATA-HORA");

		LocalDate d08 = LocalDate.parse("26/10/2023", fmtLocalDate);
		LocalDateTime d09 = LocalDateTime.parse("26/10/2023 01:30", fmtLocalDateTime);

		System.out.println("d08 = " + d08);
		System.out.println("d09 = " + d09);
		System.out.println();

// ---------dia . mês, ano, [horario]->DATA-HORA LOCAL-------------------------

		System.out.println("DIA . MES, ANO, [HORARIO]->DATA-HORA LOCAL");

		LocalDate d10 = LocalDate.of(2023, 10, 26);
		LocalDateTime d11 = LocalDateTime.of(2023, 10, 26, 18, 33);

		System.out.println("d10 = " + d10);
		System.out.println("d11 = " + d11);
		System.out.println();

// ---------DATA-HORA -> Texto Customizado----------------------------------------		

		System.out.println("DATA-HORA -> Customizado");

		LocalDate d12 = LocalDate.parse("2023-10-28");
		LocalDateTime d13 = LocalDateTime.parse("2023-10-28T00:00:00");
		Instant d14 = Instant.parse("2023-10-28T00:00:00Z");

		System.out.println("d12 = " + fmtLocalDate.format(d12));
		System.out.println("d13 = " + fmtLocalDateTime.format(d13));
		System.out.println("d14 = " + fmtInstant.format(d14));
		System.out.println();

// ---------Converter data-hora global para local---------------------------------

		System.out.println("Data-hora global, timezone (sistema local) ➞ Data-hora local");

		LocalDate d15 = LocalDate.parse("2023-10-28");
		LocalDateTime d16 = LocalDateTime.parse("2023-10-28T00:00:00");
		Instant d17 = Instant.parse("2023-10-28T00:00:00Z");

		LocalDate r1 = LocalDate.ofInstant(d17, ZoneId.systemDefault());// instant(d17) para localdate do sistema
		LocalDate r2 = LocalDate.ofInstant(d17, ZoneId.of("Portugal"));// instant(d17) para localdate de Portugal
		LocalDateTime r3 = LocalDateTime.ofInstant(d17, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d17, ZoneId.of("Portugal"));

		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2);
		System.out.println("r3 = " + r3);
		System.out.println("r4 = " + r4);
		System.out.println();

// ---------Obter dados de uma data-hora local---------------------------------

		System.out.println("Data-hora local ➞ dia, mês, ano, horário");

		LocalDate d18 = LocalDate.parse("2023-10-28");
		LocalDateTime d19 = LocalDateTime.parse("2023-10-28T00:00:00");

		System.out.println("d18 dia = " + d18.getDayOfMonth());
		System.out.println("d18 mês = " + d18.getMonthValue());
		System.out.println("d18 ano = " + d18.getYear());

		System.out.println("d19 dia = " + d19.getDayOfMonth());
		System.out.println("d19 mês = " + d19.getMonthValue());
		System.out.println("d19 ano = " + d19.getYear());
		System.out.println("d19 Hora = " + d19.getHour());
		System.out.println("d19 Minuto = " + d19.getMinute());
		System.out.println();

// ---------Cálculos com data-hora---------------------------------	

		System.out.println("Data-hora +/- tempo ➞ Data-hora");

		LocalDate d20 = LocalDate.parse("2023-10-28");
		LocalDateTime d21 = LocalDateTime.parse("2023-10-28T00:00:00");
		Instant d22 = Instant.parse("2023-10-28T00:00:00Z");

		LocalDate pastWeekLocalDate = d20.minusDays(7);
		LocalDate nextWeekLocalDate = d20.plusDays(7);
		System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

		LocalDateTime pastWeekLocalDateTime = d21.minusDays(7);
		LocalDateTime nextWeekLocalDateTime = d21.plusDays(7);
		System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
		System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);

		Instant pastWeekInstant = d22.minus(7, ChronoUnit.DAYS);
		Instant nextpastWeekInstant = d22.plus(7, ChronoUnit.DAYS);
		System.out.println("pastpastWeekInstant = " + pastWeekInstant);
		System.out.println("nextpastWeekInstant = " + nextpastWeekInstant);

		System.out.println();

		System.out.println("Data-hora 1, Data-hora 2 ➞ Duração");

		// duration trabalha com horas, precisou indicarum horario a partir das zero
		// horas
		// between(data menor,data maior), invertido o resultado será negativo
		Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d20.atStartOfDay());
		Duration t2 = Duration.between(pastWeekLocalDateTime, d21);
		Duration t3 = Duration.between(pastWeekInstant, d22);

		// sem o toDays o padrão é em horas(PT168H)
		System.out.println("t1 dias = " + t1.toDays());
		System.out.println("t2 dias = " + t2.toDays());
		System.out.println("t3 dias = " + t3.toDays());

	}

}

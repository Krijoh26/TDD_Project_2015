import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class DataCollectorTest {
	DataCollector dataCollector;
	FileReader fileReader;

	@Before
	public void setUp() {
		fileReader = mock(FileReader.class);
		dataCollector = new DataCollector(fileReader);
	}
	
	@Test
	public void openFile_filetxt_returnsTrue() {
		when(fileReader.openFile("file.txt")).thenReturn(true);
		assertTrue(dataCollector.openFile("file.txt"));
		verify(fileReader, times(1)).openFile("file.txt");
	}
	
	@Test
	public void readLine_001000011110011101001111_returnsTheSameString() {
		String expectedString = "001000011110011101001111";
		when(fileReader.readLine()).thenReturn(expectedString);
		assertEquals(expectedString, dataCollector.readFile("file.txt"));
		verify(fileReader, times(1)).readLine();
	}
	
	@Test
	public void hasMore_returnsFalse() {
		when(fileReader.hasMore()).thenReturn(false);
		assertEquals(false, dataCollector.hasMore());
		verify(fileReader, times(1)).hasMore();
	}
}
/*Vi trenger en klasse som tar seg av åpning og lesing av en gitt fil, samt at data lagres unna. Den
første hex sekvensen representerer en måle-id som skal brukes i forbindelse med lagring i en
passende collection klasse. Dersom en måle-id allerede er lest og lagret, skal den duplikate måle-id
og måledata lagres i en annen passende collection klasse som en logg (se nærmere beskrivelse
nedenfor).

Krav, datainnsamlingsklassen:

Når ei linje med måledata leses, skal følgende skje:
-- Måledata id skal brukes som nøkkel for lagring og gjenfinning av bearbeidede måledata i en
passende Java collection klasse
-- Feil antall argumenter skal kaste en exception
-- Operasjon (bitwise OR eller AND) skal utføres på måledata (bearbeidingen)
-- Originale måledata samt resultat av operasjon (bearbeidede måledata) skal lagres, både som
bitstrenger og int verdier, og skal kunne gjenfinnes ved hjelp av måledata id
-- Vi skal logge data med duplikate måledata-id, samt måledata med feil bitoperasjon (alt annet
enn 1 eller 2 er å anse som en feil), dette skjer på enkleste måte ved at hele tekstlinja som er lest
lagres unna i en liste (en pasende Java Collection klasse)*/
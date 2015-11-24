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
/*Vi trenger en klasse som tar seg av �pning og lesing av en gitt fil, samt at data lagres unna. Den
f�rste hex sekvensen representerer en m�le-id som skal brukes i forbindelse med lagring i en
passende collection klasse. Dersom en m�le-id allerede er lest og lagret, skal den duplikate m�le-id
og m�ledata lagres i en annen passende collection klasse som en logg (se n�rmere beskrivelse
nedenfor).

Krav, datainnsamlingsklassen:

N�r ei linje med m�ledata leses, skal f�lgende skje:
-- M�ledata id skal brukes som n�kkel for lagring og gjenfinning av bearbeidede m�ledata i en
passende Java collection klasse
-- Feil antall argumenter skal kaste en exception
-- Operasjon (bitwise OR eller AND) skal utf�res p� m�ledata (bearbeidingen)
-- Originale m�ledata samt resultat av operasjon (bearbeidede m�ledata) skal lagres, b�de som
bitstrenger og int verdier, og skal kunne gjenfinnes ved hjelp av m�ledata id
-- Vi skal logge data med duplikate m�ledata-id, samt m�ledata med feil bitoperasjon (alt annet
enn 1 eller 2 er � anse som en feil), dette skjer p� enkleste m�te ved at hele tekstlinja som er lest
lagres unna i en liste (en pasende Java Collection klasse)*/
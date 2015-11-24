
public class DataCollector {

	private FileReader fileReader;

	public DataCollector(FileReader fileReader) {
		this.fileReader = fileReader;
	}

	public boolean openFile(String fileName) {
		return fileReader.openFile(fileName);
	}

	public String readFile(String textToRead) {
		return fileReader.readLine();
	}

	public boolean hasMore() {
		return fileReader.hasMore();
	}
}

public interface FileReader {

	boolean openFile(String fileName);

	String readLine();

	boolean hasMore();
}
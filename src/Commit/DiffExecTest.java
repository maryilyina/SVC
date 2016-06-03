package Commit;

public class DiffExecTest {
	public static void main(String args[])
	{
		String dir = "/home/maryilyina/Desktop/SVC/12";
		String command = "mkdir " + dir;
		Executor.runSystemCommand(command);
	}
}

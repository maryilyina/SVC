
public class HistoryCommand implements Command{
	private int user_id;
	private int currTreeNode;
	private int dir_id;
	public HistoryCommand(Session session){
		user_id = session.getId();
		dir_id = session.getDirId();
		currTreeNode = session.getCTN();
	}
	public void viewHistory(){
		checkRights(user_id);
		commitDB.getHistory(user_id, currTreeNode, dir_id);
	}

	@Override
	public void execute() {
		viewHistory();
	}	 

}

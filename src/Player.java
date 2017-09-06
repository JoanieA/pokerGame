import java.util.ArrayList;
import java.util.List;

/**
 * 玩家类
 * @author zhang
 *
 */
public class Player {
	private String id;
	private String name;
	private List<Poker> handPokerList;
	
	public Player() {
		
	}
	
	public Player(String id,String name) {
		this.id = id;
		this.name = name;
		this.handPokerList = new ArrayList<Poker>();
	}
	
	public List<Poker> getHandPokerList(){
		return handPokerList;
	}
	
	public void setHandPokerList(List<Poker> pokerList) {
		this.handPokerList = pokerList;
	}
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}

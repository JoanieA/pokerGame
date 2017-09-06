import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 扑克游戏类
 * @author zhang
 *
 */
public class PokerPlay {
	
	//键盘输入
	Scanner sc = new Scanner(System.in);
	//扑克牌序列
	private List<Poker> pokerList; 
	//玩家序列
	private List<Player> playerList;
	//扑克牌的花色数组
	private final String[] pokerSuits = {"黑桃","红桃","梅花","方块"};
	//扑克牌的点数数组
	private final String[] pokerValues = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
	
	//无参构造器,初始化扑克牌和玩家序列
	public PokerPlay() {
		pokerList = new ArrayList<Poker>();
		playerList = new ArrayList<Player>();
		
	}
	
	//主函数
	public static void main(String[] args) {
		//创建主类对象
		PokerPlay pp = new PokerPlay();
		
		//创建一副新的扑克牌
		System.out.println("-------创建一副新的扑克牌-------");
		pp.createPoker();
		
		//显示新创建的扑克牌
		System.out.println("-------新建扑克牌成功！-------");
		pp.showPoker();
		
		//洗牌
		pp.shufflePoker();
		
		//创建玩家
		System.out.println("-------请输入三名玩家的ID和姓名-------");
		pp.createPlayer();
		
		//发牌
		pp.dealPoker();
		
		//开始游戏
		pp.play();
		pp.winner();
		
		//显示每个玩家的底牌
		pp.showHandPoker();
	}
	
	/**
	 * 创建一副新的扑克牌
	 */
	public void createPoker() {
		for(int i=0; i<pokerSuits.length; i++)
			for(int j=0; j<pokerValues.length; j++) {
				Poker poker = new Poker(pokerSuits[i],pokerValues[j]);
				pokerList.add(poker);
			}		
	}
	
	/**
	 * 显示扑克牌
	 */
	public void showPoker() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");	
		for (Poker poker : pokerList) {
			sb.append(poker.getInfo() + ',');
		}
		System.out.println("如下：" + sb.substring(0, sb.length() - 1) + "]");
	}
	
	/**
	 * 洗牌
	 */
	public void shufflePoker() {
		Collections.shuffle(pokerList);
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (Poker poker : pokerList) {
			sb.append(poker.getInfo() + ',');
		}
		sb.append("]");
	}
	
	/**
	 * 新建玩家&欢迎玩家
	 */
	public void createPlayer() {
		for(int i=0;i<3;i++) {
			System.out.println("请输入玩家id");
			String id = sc.next();
			System.out.println("请输入玩家姓名");
			String name = sc.next();
			playerList.add(new Player(id,name));
		}
		for (Player player : playerList) {
			System.out.println("-------欢迎玩家：" + player.getName());
		}
	}
	
	/**
	 * 发牌：每个玩家发两张牌
	 */
	public void dealPoker() {
		for(int i=0;i<2;i++) {
			for (Player player : playerList) {
				Poker p = pokerList.get(0);
				player.getHandPokerList().add(p);
				System.out.println("-------玩家：" + player.getName() + "拿牌");
				pokerList.remove(0);
			}
		}
	}
	
	/**
	 * 开始游戏
	 */
	public void play() {
		for (Player player : playerList) {
			Collections.sort(player.getHandPokerList());
			System.out.println("玩家：" + player.getName() + "的最大手牌为：" + player.getHandPokerList().get(0).getInfo());
		}
	}
	
	/**
	 * 判断获胜者
	 */
	public void winner() {
		String winner = "";
		List<Poker> maxList = new ArrayList<Poker>();
		for (Player p : playerList) {
			maxList.add(p.getHandPokerList().get(0));
		}
		Collections.sort(maxList);
		Poker max = maxList.get(0);
		for (Player p : playerList) {
			if(p.getHandPokerList().contains(max))
				winner = p.getName();
		}
		System.out.println("-------恭喜" + winner + "获胜!");
	}
	
	/**
	 * 显示各玩家手中的底牌
	 */
	public void showHandPoker() {
		for (Player p : playerList) {
			System.out.println("-------玩家" + p.getName() + "的底牌为：");
				System.out.println(p.getHandPokerList().get(0).getInfo() + "," + p.getHandPokerList().get(1).getInfo());
		}
	}
}

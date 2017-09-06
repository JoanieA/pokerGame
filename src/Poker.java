import java.util.Arrays;
import java.util.List;

/**
 * 扑克牌类
 * @author zhang
 *
 */
public class Poker implements Comparable<Poker>{

	private String suit;
	private String value;
	
	//无参构造器
	public Poker() {
		
	}
	
	//含参构造器
	public Poker(String suit,String value) {
		this.suit = suit;
		this.value = value;
	}
	
	//返回扑克牌的信息
	public String getInfo() {
		return suit+value; 
	}
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	//重写compareTo方法，用扑克的点数和花色进行比较
	public int compareTo(Poker p) {
		final String[] pokerValuesArr =  {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		final String[] pokerSuitsArr = {"方块","梅花","红桃","黑桃"};
		List<String> valueList = Arrays.asList(pokerValuesArr);
		List<String> suitList = Arrays.asList(pokerSuitsArr);
		int thisValueIndex = valueList.indexOf(value);
		int comValueIndex = valueList.indexOf(p.value);
		if(thisValueIndex == comValueIndex) {
			int thisSuitIndex = suitList.indexOf(suit);
			int comSuitIndex = suitList.indexOf(p.suit);
			return comSuitIndex - thisSuitIndex;
		}
		return comValueIndex - thisValueIndex;
		
	}
}

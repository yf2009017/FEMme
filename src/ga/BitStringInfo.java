package ga;

import java.util.ArrayList;

public class BitStringInfo 
{
	private ArrayList<BitInfo> list;
	
	public BitStringInfo() {
		this.list = new ArrayList<BitInfo>();
	}
	
	public int count() {
		return this.list.size();
	}
	
	public BitInfo getBitInfo(int i) {
		return this.list.get(i);
	}
	
	public void add(BitInfo bi) {
		this.list.add(bi);
	}
}
	
		
		

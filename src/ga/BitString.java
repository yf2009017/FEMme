package ga;

public class BitString
{
	private Bit[] bits;
	
	//////////CONSTRUCTORS/////////////////////
	public BitString(Bit[] ab) {
		this.bits = new Bit[ab.length];
		for (int i = 0; i < this.bits.length; i++) {
			this.bits[i] = new Bit(ab[i].getValue(), ab[i].getBitInfo());
		}
	}
	
	public BitString(BitString bs) {
		Bit[] bb;
		bb = new Bit[bs.bitCount()];
		for (int i = 0; i < bs.bitCount(); i++) {
			bb[i] = new Bit(bs.getBit(i).getValue(), bs.getBit(i).getBitInfo());
		}
		
		this.bits = new Bit[bb.length];
		for (int i = 0; i < this.bits.length; i++) {
			this.bits[i] = bb[i];
		}
	}
	
	public BitString(BitStringInfo bsinf) {
		this.bits = new Bit[bsinf.count()];
		for (int i = 0; i < bsinf.count(); i++) {
			this.bits[i] = new Bit(bsinf.getBitInfo(i));
		}
	}
	
	//////////PROPERTIES///////////////////////
	public int bitCount() {
		return this.bits.length;
	}
	
	public Bit getBit(int i) {
		return this.bits[i];
	}	
	
	//////////METHODS//////////////////////////
	public String toBinaryString() {
		String ret = "";
		for (int i = 0; i < this.bitCount(); i++) {
			ret += this.getBit(i).toBinaryString();
		}
		
		return ret;
	}	
	
	//Sum of lengths of individual bits
	public int getLength() {
		int i;
		int ret = 0;		
		for (i = 0; i < this.bitCount(); i++) {
			ret += this.getBit(i).getBitInfo().getDigits();
		}
		return ret;
	}
	
	//get rightmost bit of Binary String
	public int getBitAt(int pos) {
		int ret = 0;
		if (pos <= this.getLength()) {
			int l = pos;
			int i = this.bitCount() - 1;
			while (l > this.getBit(i).getLength()) {
				l -= this.getBit(i).getLength();
				i--;
			}

			ret = this.getBit(i).getBitAt(l);
		}		
		return ret;
	}
	
	public void toggleBitAt(int pos) {
		if (pos <= this.getLength()) {
			int l = pos;
			int i = this.bitCount() - 1;
			while (l > this.getBit(i).getLength()) {
				l -= this.getBit(i).getLength();
				i--;
			}

			this.getBit(i).toggleBitAt(l);
		}
	}
	
	public void randomize() {
		for (int i = 0; i < this.bitCount(); i++) {
			this.getBit(i).randomize();
		}
	}
	
	public void print() {
		System.out.println(this.toBinaryString());
	}
}

//66

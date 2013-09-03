package ga;

import fem.*;

public class GATruss extends GAMachine
{
	public Truss t;
	
	public GATruss() {
		
	}		
	
	public void init(Truss aTrs, int gens, int pop, double mprob, double cprob) {
		t = aTrs;
		int c = t.memberCount();

		BitInfo bAr = new BitInfo(50, 1, 5);
		BitInfo bE = new BitInfo(500, 250, 3);

		BitStringInfo bsi;
		bsi = new BitStringInfo();
		
		for (int i = 0; i < this.getTruss().memberCount(); i++) {
			bsi.add(bAr);
			bsi.add(bE);
		}
		
		super.init(bsi, gens, pop, mprob, cprob);
	}
	
	public Truss getTruss() {
		return t;
	}
	
	public void doGA() {
		super.initGA();
		for (int i = 0; i < super.maxGen(); i++) {
			super.stepGA();
			System.out.println("Generation " + i + " " + super.avgFitness() );
		}
	}
			
			 
	
	public double fitness(BitString bs) {
		double[] area;
		double[] e;
		double cost = 0;
		double ret = 0;
		
		int c = bs.bitCount() / 2;
		
		area = new double[c];
		e = new double[c];
		cost = 0;
		
		double l;
		double rate = 1;
		
		for (int i = 0; i < c; i++) {
			area[i] = bs.getBit(2 * i).getRealValue();
			e[i] = bs.getBit(2 * i + 1).getRealValue();
			l = this.getTruss().getMember(i).getLength();
			
			if (TrussAnalyser.PostProcessingResult.MemberForces.getValueAt(i, 0) > e[i]) {
				rate = 2;
			}
			
			cost += area[i] * e[i] * l * rate;
		}
		ret = 1 / cost;
		return ret * 1000000;
	}
}

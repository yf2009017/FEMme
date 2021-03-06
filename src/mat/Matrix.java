package mat;

public class Matrix 
{
    private int nrows;
    private int ncols;
    private double[][] data;

	//////////CONSTRUCTORS//////////////	
	public Matrix(double[][] dat) {
        this.data = dat;
        this.nrows = dat.length;
        this.ncols = dat[0].length;
    }

    public Matrix(int nrow, int ncol) {
        this.nrows = nrow;
        this.ncols = ncol;
        data = new double[nrow][ncol];
    }
    
    //For initializing to column Matrices only
    public Matrix(double[] dat) {
		this.data = new double[dat.length][1];
		
		int i = 0;
		for (i = 0; i < dat.length; i++) {
			this.data[i][0] = dat[i];
		}
		
		this.nrows = dat.length;
		this.ncols = 1;
	}

	///////////PROPERTIES//////////////
	public double[][] getData() {
		return this.data;
	}

	public int getNrows() {
		return this.nrows;
	}

	public int getNcols() {
		return this.ncols;
	}

	public double getValueAt(int i, int j) {
		return this.getData()[i][j];
	}

	public void setValueAt(int i, int j, double value) {
		this.data[i][j] = value;
	}

	public boolean isSquare() {
		if (this.getNrows() == this.getNcols())
			return true;		
		else
			return false;
	}

	public int size() {
		return (this.getNrows() + this.getNcols())/2;
	}	
	//////////METHODS////////////////
	public Matrix multiplyByConstant(double c) {
		int i = 0;
		int j = 0;
		for (i = 0; i < getNrows(); i++) {
			for (j = 0; j < getNcols(); j++) {
				this.setValueAt(i, j, this.getValueAt(i,j) * c);
			}
		}
		return this;
	}

	public void printMatrix() {
		int i = 0;
		int j = 0;
		
		String str = "";

		for (i = 0; i <= (this.getNrows() - 1); i++) {
			for (j = 0; j <= (this.getNcols() - 2); j++) {
				str += this.getValueAt(i, j) + " ";
			}
			
			str += this.getValueAt(i, this.getNcols() - 1);
						
			System.out.println(str);
			
			str = "";
		}			
	}
	
	//swaps row r1 for r2 in a matrix
	public void swapRows(int r1, int r2) {
		if ((r1 <= this.getNrows()) && (r2 < this.getNrows())) {
			int i = 0;
			double[] dat;			
			dat = new double[this.getNcols()];
			
			for (i = 0;  i < this.getNcols(); i++) {
				dat[i] = this.getValueAt(r2, i);
				this.setValueAt(r2, i, this.getValueAt(r1, i));
				this.setValueAt(r1, i, dat[i]);
			}	
			
		}
		else {
			System.out.println("Array bounds exceeded");
		}
	}
	
	//returns sub matrix for the given indices.
	public Matrix subMatrix(int[] aI) {
		int i = 0;
		int j = 0;
		Matrix ret = new Matrix(aI.length, aI.length) ;
		
		for(i = 0; i < aI.length; i++) {
			for(j = 0; j < aI.length; j++) {
				ret.setValueAt(i, j, this.getValueAt(aI[i], aI[j]));
			}
		}
		
		return ret;
	}		
}

//130

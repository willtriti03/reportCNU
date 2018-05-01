
class Cube {
	private int len; 
	private int cube[][];
	private int tmp[][];

	public Cube(int len){
		this.len = len;
		cube = new int[len][len];
		tmp = new int[len][len];
		for(int i =0; i< len; ++i){
			for(int j=0; j<len; ++j){
				cube[i][j]= (int)(Math.random()*100);
			}
		}
	}
	public void printCube() {
		System.out.println("////////////////////////////////////////////");
		System.out.println("////////////////////////////////////////////");
		for(int i =0; i< len; ++i){
			for(int j=0; j<len; ++j){
				System.out.printf("%5d",cube[i][j]);
			}
			System.out.println();
		}
	}

	public void CubeTurn(int time){
		for(int i =0; i<time; ++i){
			for(int j=0; j<len; ++j){
				for(int z=0; z<len;++z){
					tmp[z][len-j-1]= cube[j][z];
				}
			}
		}
		cube = tmp;
	}
	
}
public class CubeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cube cube = new Cube(5);
		cube.printCube();
		cube.CubeTurn(1);
		cube.printCube();
		cube.CubeTurn(1);
		cube.printCube();
		cube.CubeTurn(1);
		cube.printCube();
	}

}


package KataCalc;

public enum Rome {
	I(1),II(2),III(3),IV(4),V(5),VI(6),VII(7),VIII(8),IX(9),X(10);
	
	private int value;
	
	Rome(int value) {
		this.value = value;	
	}
	
	public int getNum() {
		return value;
	}
	public static Rome getByValue(int value) {
		for (Rome rome : Rome.values()) {
			if(rome.value == value) {
				return rome;	
			}
		}
		return null;
	}
}

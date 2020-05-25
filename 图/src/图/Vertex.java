package Õº;
/**
 * ∂•µ„¿‡
 *
 */
public class Vertex {
	
	private String value;
	public boolean visited;
	//private  MyStack stack =new MyStack();
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}

	public Vertex(String value) {
		super();
		this.value = value;
	}
}

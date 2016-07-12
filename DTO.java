import java.util.ArrayList;
import java.util.List;

public class DTO {

	private String name;
	private int dataSize;
	private List<Integer> dataItems = new ArrayList<Integer>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

	public List<Integer> getDataItems() {
		return dataItems;
	}

	public void setDataItems(List<Integer> dataItems) {
		this.dataItems = dataItems;
	}

	@Override
	public String toString() {
		return "DTO [name=" + name + ", dataSize=" + dataSize + ", dataItems=" + dataItems + "]";
	}

}

package jackson_playground.immutable;

import org.codehaus.jackson.annotate.JsonProperty;

/***
 * Immutable set through constructor
 */
public class Example2 {
	
	private final String name;
	private final boolean value;
	
	private Example2(@JsonProperty("name") String name, @JsonProperty("value") boolean value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() { return name; }
	public boolean isValue() { return value; }
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer("[Example2 => ");
		sb.append("name: ").append(name).append(",");
		sb.append("value: ").append(value).append("]");
		return sb.toString();
	}
}

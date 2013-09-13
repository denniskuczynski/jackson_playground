package jackson_playground.immutable;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonCreator;

/***
 * Immutable set through constructor
 */
public class Example2 {
	
	private final String name;
	private final boolean value;
	
	@JsonCreator
	public Example2(@JsonProperty("name") String name, @JsonProperty("value") boolean value) {
		this.name = name;
		this.value = value;
	}
	
	
	@JsonProperty("name")
	public String getName() { return name; }
	
	@JsonProperty("value")
	public boolean isValue() { return value; }
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer("[Example2 => ");
		sb.append("name: ").append(name).append(",");
		sb.append("value: ").append(value).append("]");
		return sb.toString();
	}
}

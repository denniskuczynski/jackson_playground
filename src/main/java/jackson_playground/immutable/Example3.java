package jackson_playground.immutable;

import org.codehaus.jackson.annotate.JsonProperty;

/***
 * Immutable but set through reflection anyway
 */
public class Example3 {
	
	@JsonProperty("name")
	private final String name;

	@JsonProperty("value")
	private final boolean value;
	
	private Example3() {
		this.name = null;
		this.value = false;
	}
	
	public String getName() { return name; }
	public boolean isValue() { return value; }
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer("[Example3 => ");
		sb.append("name: ").append(name).append(",");
		sb.append("value: ").append(value).append("]");
		return sb.toString();
	}
}

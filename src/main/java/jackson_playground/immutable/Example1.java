package jackson_playground.immutable;

import org.codehaus.jackson.annotate.JsonProperty;

/***
 * Immutable because there's no setter
 */
public class Example1 {
	
	@JsonProperty("name") 
	private String name;

	@JsonProperty("value")
	private boolean value;
	
	private Example1() {
	}
	
	public String getName() { return name; }
	public boolean isValue() { return value; }
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer("[Example1 => ");
		sb.append("name: ").append(name).append(",");
		sb.append("value: ").append(value).append("]");
		return sb.toString();
	}
}

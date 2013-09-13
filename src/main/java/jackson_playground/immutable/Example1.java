package jackson_playground.immutable;

import org.codehaus.jackson.annotate.JsonProperty;

/***
 * Immutable because there's no setter
 */
public class Example1 {
	
	@JsonProperty("name") 
	public String name;

	@JsonProperty("value")
	public boolean value;
	
	public Example1() {
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

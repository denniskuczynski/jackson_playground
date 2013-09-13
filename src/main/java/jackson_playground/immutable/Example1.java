package jackson_playground.immutable;

import org.codehaus.jackson.annotate.JsonProperty;

/***
 * Immutable because there's no setter
 */
public class Example1 {
	
	@JsonProperty("name") 
	private String name;
	
	private Example1() {
		this.name = null;
	}
	
	public String getName() { return name; }
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer("[Example1 => ");
		sb.append("name: ").append(name).append("]");
		return sb.toString();
	}
}

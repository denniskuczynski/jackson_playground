package jackson_playground.immutable;

import org.codehaus.jackson.annotate.JsonProperty;

/***
 * Immutable set through constructor
 */
public class Example2 {
	
	private final String name;
	
	private Example2(@JsonProperty("name") String name) {
		this.name = name;
	}
	
	public String getName() { return name; }
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer("[Example2 => ");
		sb.append("name: ").append(name).append("]");
		return sb.toString();
	}
}

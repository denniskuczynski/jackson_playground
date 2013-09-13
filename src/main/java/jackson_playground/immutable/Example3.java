package jackson_playground.immutable;

import org.codehaus.jackson.annotate.JsonProperty;

/***
 * Immutable but set through reflection anyway
 */
public class Example3 {
	
	@JsonProperty("name")
	private final String name;
	
	private Example3() {
		this.name = null;
	}
	
	public String getName() { return name; }
	
	@Override public String toString() {
		StringBuffer sb = new StringBuffer("[Example3 => ");
		sb.append("name: ").append(name).append("]");
		return sb.toString();
	}
}
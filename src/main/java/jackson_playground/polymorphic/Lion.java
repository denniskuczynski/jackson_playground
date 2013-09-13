package jackson_playground.polymorphic;

import org.codehaus.jackson.annotate.JsonProperty;

public class Lion extends Animal {
	
	@JsonProperty("roar") 
	public String roar;
	
	protected Lion() {
		super();
	}
	
	public String getRoar() { return roar; }
}

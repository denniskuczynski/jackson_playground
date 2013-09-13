package jackson_playground.polymorphic;

import org.codehaus.jackson.annotate.JsonProperty;

public class Bird extends Animal {
	
	@JsonProperty("chirp") 
	public String chirp;
	
	protected Bird() {
		super();
	}
	
	public String getChirp() { return chirp; }
}

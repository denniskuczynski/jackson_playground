package jackson_playground.polymorphic;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonTypeInfo;  
import org.codehaus.jackson.annotate.JsonSubTypes;

// Example using custom discriminator property
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "_t")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Lion.class, name = "lion"),
    @JsonSubTypes.Type(value = Bird.class, name = "bird")})
/*
// Example with fully specified classname
@JsonTypeInfo(
	use=JsonTypeInfo.Id.CLASS,
	include=JsonTypeInfo.As.PROPERTY,
	property="class")
*/
public abstract class Animal {
	
	@JsonProperty("name") 
	public String name;
	
	protected Animal() {
	}
	
	public String getName() { return name; }
}

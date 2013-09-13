package jackson_playground;

import jackson_playground.immutable.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import java.io.File;

public class Test {
	
		public static void main(String[] args) {
		try {	
		    ObjectMapper mapper = new ObjectMapper();
		    AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
            AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
            AnnotationIntrospector introspector = new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
            mapper.setDeserializationConfig(mapper.getDeserializationConfig().withAnnotationIntrospector(jacksonIntrospector));
            mapper.setSerializationConfig(mapper.getSerializationConfig().withAnnotationIntrospector(introspector));
            
            //Example1
            try {
                Example1 example1 = mapper.readValue(new File("./json/immutable/example.json"), Example1.class);
                System.out.println("Example1 toString: "+example1);
                System.out.println("Example1 JSON: "+mapper.writeValueAsString(example1));
            } catch(Throwable t) {
    			System.out.println("Exception in Example1");
    			t.printStackTrace();
    		}
            
            //Example2
            try {
                Example2 example2 = mapper.readValue(new File("./json/immutable/example.json"), Example2.class);
                System.out.println("Example2 toString: "+example2);
                System.out.println("Example2 JSON: "+mapper.writeValueAsString(example2));
            } catch(Throwable t) {
    			System.out.println("Exception in Example2");
    			t.printStackTrace();
    		}
            
            //Example3
            try {
                Example3 example3 = mapper.readValue(new File("./json/immutable/example.json"), Example3.class);
                System.out.println("Example3 toString: "+example3);
                System.out.println("Example3 JSON: "+mapper.writeValueAsString(example3));
            } catch(Throwable t) {
    			System.out.println("Exception in Example3");
    			t.printStackTrace();
    		}
		} catch(Throwable t) {
			System.out.println("Exception in Test");
			t.printStackTrace();
		}
	}
}

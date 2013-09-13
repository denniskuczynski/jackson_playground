package jackson_playground;

import jackson_playground.immutable.*;
import jackson_playground.polymorphic.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

import java.io.File;

public class Test {
	
		public static void main(String[] args) {
		try {	
		    ObjectMapper mapper = new ObjectMapper();
		    AnnotationIntrospector jaxbIntrospector = new JaxbAnnotationIntrospector();
            AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();
            AnnotationIntrospector introspector = new AnnotationIntrospector.Pair(jacksonIntrospector, jaxbIntrospector);
            mapper.setDeserializationConfig(mapper.getDeserializationConfig().withAnnotationIntrospector(introspector));
            mapper.getDeserializationConfig().disable(DeserializationConfig.Feature.AUTO_DETECT_CREATORS);
            mapper.getDeserializationConfig().disable(DeserializationConfig.Feature.AUTO_DETECT_FIELDS);
            mapper.setSerializationConfig(mapper.getSerializationConfig().withAnnotationIntrospector(introspector));
            mapper.getSerializationConfig().disable(SerializationConfig.Feature.AUTO_DETECT_GETTERS);
            mapper.getSerializationConfig().disable(SerializationConfig.Feature.AUTO_DETECT_IS_GETTERS);
            mapper.getSerializationConfig().disable(SerializationConfig.Feature.AUTO_DETECT_FIELDS);
            
            immutableTests(mapper);
            polymorphicTests(mapper);
            
            
		} catch(Throwable t) {
			System.out.println("Exception in Test");
			t.printStackTrace();
		}
	}

    public static void immutableTests(ObjectMapper mapper)
        throws Throwable {
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
    }

    public static void polymorphicTests(ObjectMapper mapper)
        throws Throwable {
        //Lion
        try {
            Lion lion = mapper.readValue(new File("./json/polymorphic/lion.json"), Lion.class);
            System.out.println("Lion toString: "+lion);
            System.out.println("Lion JSON: "+mapper.writeValueAsString(lion));
        } catch(Throwable t) {
            System.out.println("Exception in Lion");
            t.printStackTrace();
        }
        
        //Bird
        try {
            Bird bird = mapper.readValue(new File("./json/polymorphic/bird.json"), Bird.class);
            System.out.println("Bird toString: "+bird);
            System.out.println("Bird JSON: "+mapper.writeValueAsString(bird));
        } catch(Throwable t) {
            System.out.println("Exception in Bird");
            t.printStackTrace();
        }
    }
}

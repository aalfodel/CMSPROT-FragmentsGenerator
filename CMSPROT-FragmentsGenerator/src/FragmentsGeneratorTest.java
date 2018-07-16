import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.app.Velocity;

public class FragmentsGeneratorTest {

	public static void main(String[] args) throws Exception {
		
		//setup Velocity
		Properties p = new Properties();
	    p.setProperty("resource.loader", "file");
	    p.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
	    p.setProperty("file.resource.loader.path", "/home/aalfodel/eclipse-workspace/CMSPROT-FragmentsGenerator/templates/");	//TODO improve this
	   
		//init Velocity
	    Velocity.init(p);
	    /* DEBUG
	     * System.out.println("PROPERTY \"resource.loader\": "+Velocity.getProperty("resource.loader"));  
	     * System.out.println("PROPERTY \"file.resource.loader.class\": "+Velocity.getProperty("file.resource.loader.class"));  
	     * System.out.println("PROPERTY \"file.resource.loader.path\" "+Velocity.getProperty("file.resource.loader.path"));  
	     */
	    
	    //TESTS
	    
	    System.out.println("---- <h1> test ----");
	    
	    //generate mock data
	    FragmentType mockTypeH1 = FragmentType.TITLE;
	    Map<String, String> mockMapH1 = new HashMap<String, String>();
	    mockMapH1.put("id", "0");
	    mockMapH1.put("color", "red");
	    mockMapH1.put("text", "Title");
	    //compose html
	    String outHtmlH1 = FragmentsGenerator.generateFragmentHtml(mockTypeH1, mockMapH1);
	    System.out.println(outHtmlH1);
	    
	    
	    System.out.println();
	    System.out.println("---- <p> test ----");
	    
	    FragmentType mockTypeP = FragmentType.PARAGRAPH;
	    Map<String, String> mockMapP = new HashMap<String, String>();
	    mockMapP.put("id", "1");
	    mockMapP.put("color", "blue");
	    mockMapP.put("text", "Hello World");
	    
	    String outHtmlP = FragmentsGenerator.generateFragmentHtml(mockTypeP, mockMapP);
	    System.out.println(outHtmlP);
	   
	}

}

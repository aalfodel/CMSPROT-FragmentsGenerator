import java.io.StringWriter;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

public class FragmentsGenerator {
	
	public static String generateFragmentHtml(FragmentType type, Map<String,String> inputData) throws ResourceNotFoundException, ParseErrorException, Exception {
		
		String templateFile = type.toString().toLowerCase() + ".vm";	//example:      type      template
																		//            FOO_BAR -> foo_bar.vm
		Template template = Velocity.getTemplate(templateFile);
		
		VelocityContext context = new VelocityContext();
		context.put("map", inputData);		//we'll use $map in the .vm file
		
		StringWriter outputHtml = new StringWriter();
		template.merge(context,outputHtml);
		return outputHtml.toString();
		
	}
	
}

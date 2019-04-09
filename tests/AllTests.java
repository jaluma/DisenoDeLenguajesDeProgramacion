import codegeneration.CodeGenerationTest;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import parser.ParserTest;
import semantic.SematicTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ParserTest.class, SematicTest.class, CodeGenerationTest.class})
public class AllTests {
	public static Test suite() {
		return new JUnit4TestAdapter(AllTests.class);
	}
}
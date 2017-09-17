import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import static org.jbehave.core.reporters.StoryReporterBuilder.Format.*;

public class RyanairTest extends JUnitStory {

	private final CrossReference xref = new CrossReference();

	@Override
	public Configuration configuration() {

		Class<? extends Embeddable> embeddableClass = this.getClass();

		Properties viewResources = new Properties();
		viewResources.put("decorateNonHtml", "true");

		URL storyURL = null;
		try {
			// This requires you to start Maven from the project directory
			storyURL = new URL("file://" + System.getProperty("user.dir")
					+ "/src/main/resources/stories/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new MostUsefulConfiguration().useStoryLoader(
				new LoadFromRelativeFile(storyURL))
				.useStoryReporterBuilder(new StoryReporterBuilder()
						.withCodeLocation(CodeLocations.codeLocationFromClass(embeddableClass))
						.withDefaultFormats().withPathResolver(new FilePrintStreamFactory.ResolveToPackagedName())
						.withViewResources(viewResources).withFormats(CONSOLE, TXT, HTML, XML)
						.withFailureTrace(true).withFailureTraceCompression(true).withCrossReference(xref));
	}

	@Override
	public List<CandidateSteps> candidateSteps() {
		return new InstanceStepsFactory(configuration(), new StepLibrary())
				.createCandidateSteps();
	}
	
	@Override
	@Test
	public void run() {
		try {
			super.run();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

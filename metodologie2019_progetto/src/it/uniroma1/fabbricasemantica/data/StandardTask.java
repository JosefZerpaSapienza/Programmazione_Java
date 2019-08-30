package it.uniroma1.fabbricasemantica.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Enumeration of Tasks implemented.
 * @author josef
 *
 */
public enum StandardTask implements Task 
{
	TRANSLATION_ANNOTATION ("translationAnnotation.html"),
	WORD_ANNOTATION ("wordAnnotation.html"),
	DEFINITION_ANNOTATION ("definitionAnnotation.html"),
	SENSE_ANNOTATION ("senseAnnotation.html"),
	TRANSLATION_VALIDATION ("translationValidation.html"),
	SENSE_VALIDATION ("senseValidation.html"),
	MY_ANNOTATION ("myAnnotation.html");
	
	private static final Random RANDOM = new Random();
	/**
	 * Task url.
	 */
	private final String taskURL;
	
	StandardTask (String taskURL) { this.taskURL = taskURL; }
	
	/**
	 * Return a random Task between StandardTask.values()
	 * @return
	 */
	public static StandardTask getRandomTask()
	{
		List<StandardTask> values = Arrays.asList(values());
		int random = RANDOM.nextInt(values.size());
		
		return values.get(random);
	}
	
	/**
	 * Return the task's url.
	 * @return
	 */
	public String getTaskUrl() { return taskURL; }

}

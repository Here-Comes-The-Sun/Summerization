package restapitest.web;

import java.time.Duration;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.theokanning.openai.audio.CreateTranscriptionRequest;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;

@RestController
@RequestMapping("/restapi")
public class restapitest {
	static String englishAudioFilePath = "/Users/jiuhyeong/Documents/Handong/capstone1/Dani_california.mp3";
	@GetMapping("/{name}")
	public String sayHello(@PathVariable String name) {
		String result="Hello eGovFramework!! name : " + name;  
		return result;
	}

	@PostMapping("/postMethod")
    void createTranscription() {
		OpenAiService service = new OpenAiService("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",Duration.ofMinutes(9999));
        CreateTranscriptionRequest createTranscriptionRequest = CreateTranscriptionRequest.builder()
                .model("whisper-1")
                .build();

        String text = service.createTranscription(createTranscriptionRequest, englishAudioFilePath).getText();
        System.out.println(text);
        //assertEquals("Hello World.", text);
    }

}

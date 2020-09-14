package mailgun;

import java.io.File;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 * You can see a record of this email in your logs: https://app.mailgun.com/app/logs
 * You can send up to 300 emails/day from this sandbox server.
 * Next, you should add your own domain so you can send 10,000 emails/month for free.
 * @author mario.bacellar
 *
 */
public class GunslingerAPI {

	public static void main(String[] args) {
		
		try {
			JsonNode json = GunslingerAPI.sendSimpleMessage();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

    public static JsonNode sendSimpleMessage() throws UnirestException {
    	
    	String API_KEY			= "543f5348004674aca94861e990b8898c-3fb021d1-81be7be2";
    	String YOUR_DOMAIN_NAME	= "sandboxf7fc5fd99bdf4dcbbb7646f3bb89a19f.mailgun.org";
    	String API_BASE_URL 	= "https://api.mailgun.net/v3/"+YOUR_DOMAIN_NAME;
    	
        HttpResponse<JsonNode> request = Unirest.post(API_BASE_URL+"/messages")
            .basicAuth("api", API_KEY)
            .field("from", "Excited User <USER@YOURDOMAIN.COM>")
            .field("to", "mario.bacellar@gmail.com")
            .field("subject", "hello")
            .field("text", "testing")
            .asJson();

        return request.getBody();
    }
	
}

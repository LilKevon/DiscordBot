import java.io.ObjectInputFilter.Status;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class ServerBot {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		
		JDABuilder jdaBuilder3 = JDABuilder.createDefault("OTc3MDA4ODI5NDE1OTU2NTEw.GBslmI.Emg0HgUrNIs8MgQ7RjKMH9gbKnK7wetDl4SqRw"
				+ "");
		
			ServerBotCommands ss = new ServerBotCommands();
			jdaBuilder3.addEventListeners(ss);
			

			jdaBuilder3.setActivity(Activity.playing("Among Us || Prefix: ~"));
			jdaBuilder3.setStatus(OnlineStatus.IDLE);
			
			try {	
		jdaBuilder3.build();
		}
		catch(LoginException e) {
			e.printStackTrace();
		}
	
	}

}

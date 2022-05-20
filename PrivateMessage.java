import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PrivateMessage extends ListenerAdapter {

	
		// TODO Auto-generated method stub
public void onGuildMemberJoin(GuildMemberJoinEvent e) {
	Member member = e.getMember();
	member.getUser().openPrivateChannel().queue();
	

}
	

}

//imports
import java.awt.Color;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;


//Table of Embeds:
//emb1, usage: for information about the bot.
//emb2, usage: Among Us Headcount.
//emb3, usage: for headcount, and to see whos playing.
//emb4, usage: If the command is not known.

//Class


public class ServerBotCommands extends ListenerAdapter{
	Random random = new Random();
	public static int a = 0;
	StringBuilder sb1;
	StringBuilder sb2;
	StringBuilder sb3;
	public static String W1= "";
	public static String W2 = "";
	public static String W3 = "";

	public static String S1 = "";
	public static String S2 = "";

	public static String Host = "";

	LinkedList<String> SS1 = new LinkedList<>();
	LinkedList<String> SS2 = new LinkedList<>();
	LinkedList<String> SS3 = new LinkedList<>();

	LinkedList<String>TFT1 = new LinkedList<>();
	LinkedList<String>TFT2 = new LinkedList<>();

	public  void onGuildMessageReceived(GuildMessageReceivedEvent e) {
		//Constants:
		DateFormat DATE_FORMAT = new SimpleDateFormat("hh:mm aa");
		String DATE_STRING = DATE_FORMAT.format(new Date()).toString();


		//Main Message Receiver
		String MessageSent = e.getMessage().getContentRaw();

		//Splitting Message
		String[]args = e.getMessage().getContentRaw().split("\\s+");
		//Information Center
		if(MessageSent.equalsIgnoreCase("~Info")) {
			EmbedBuilder emb1 = new EmbedBuilder();
			emb1.setTitle("Information about Me!");
			emb1.setThumbnail("https://cdn.discordapp.com/attachments/877004214763667468/879924549439864873/wp8361057.png");
			emb1.addField("Name", "Bubbles Bot", false);
			emb1.addField("Creator:", "Kevin Li", false);
			emb1.addField("Prefix: ", "~", false);
			emb1.addField("About Me:", "Big fan of Evangelion, Dante's Divine Comedy, and Realm of the Mad God. ", false);
			emb1.addField("Have Feedback?", "Message me here: https://discord.gg/b5ynh2bwRq", false);
			emb1.setColor(Color.BLUE);
			e.getChannel().sendMessage(emb1.build()).queue();

		}

		//TFT Headcount
		else if(MessageSent.equalsIgnoreCase("~TFTopen")) {
			e.getChannel().sendMessage("@everyone," + e.getAuthor().getName() + " has started a new TFT headcount in <#895051680960360458>! The Headcount will open in 5 seconds.").queue();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			EmbedBuilder emb5 = new EmbedBuilder();
			emb5.setTitle("TFT Headcount!");
			emb5.setThumbnail("https://cdn.discordapp.com/attachments/877014655543951370/895052266413912144/xXCu9iA-_400x400.png");
			emb5.addField("Time: " + DATE_STRING.toUpperCase(), e.getAuthor().getName() + " has started a new TFT game in <#895051680960360458>. \n React with ✅ if you are attending. \n React with 👀 if you are just spectating. \n GLHF~!", false);

			Message message = e.getChannel().sendMessage(emb5.build()).complete();
			message.addReaction("✅").queue();
			message.addReaction("👀").queue();


		}

		else if(MessageSent.equalsIgnoreCase("~TFTclose")) {
			if(a == 1) {
				e.getChannel().sendMessage("This headcount of Among Us has closed. We have started with " + a + " player!" ).queue();
			}

			else {
				e.getChannel().sendMessage("This headcount of Among Us has closed. We have started with " + a + " players in <#895051680960360458>!" ).queue();
			}

			if(!TFT1.isEmpty()) {
				for(int i =0; i< TFT1.size(); i++) {
					S1 = S1 + TFT1.get(i) + " ";
					e.getChannel().sendMessage(TFT1.get(i)).queue();
				}
			}
			if(!TFT2.isEmpty()) {
				for(int i =0; i<TFT2.size(); i++) {
					S2 = S2 + TFT2.get(i) + " ";
				}
			}

			System.out.println(S1);
			System.out.println(S2);
			S1 = S1.substring(0, S1.length());
			S2 = S2.substring(0, S2.length());

			EmbedBuilder emb6 = new EmbedBuilder();
			emb6.setTitle("List of players for today's TFT game~!");
			emb6.setDescription("GLHF!");
			emb6.setThumbnail("https://cdn.discordapp.com/attachments/877014655543951370/895052266413912144/xXCu9iA-_400x400.png");
			emb6.addField("Players: ", S1, false);
			emb6.addField("Spectators", S2, false );

			e.getChannel().sendTyping().queue();
			e.getChannel().sendMessage(emb6.build()).queue();

			TFT1.clear();
			TFT2.clear();
			S1 = "";
			S2 = "";

			SS1.clear();
			SS2.clear();
			SS3.clear();
			emb6.clear();


		}
		
		//troll
		else if(MessageSent.equalsIgnoreCase("hi")) {
			e.getChannel().sendMessage("Hello! I am Kevin's Bot!").queue();
		}
		else if(MessageSent.equalsIgnoreCase("hand")) {
			e.getChannel().sendMessage("hand").queue();
		}
		//Among Us Headcount
		else if(MessageSent.equalsIgnoreCase("~AMGopen")) {
			e.getChannel().sendMessage("@everyone, " +e.getAuthor().getName() + " has started a new Among Us Headcount in <#848999707056930856>! The Headcount will open in 5 seconds.").queue();

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}


			EmbedBuilder emb2 = new EmbedBuilder();
			emb2.setTitle("Among Us Headcount!");
			emb2.setThumbnail("https://cdn.discordapp.com/attachments/877014655543951370/879569769412583484/wonder-day-among-us-21.png");
			emb2.addField("Time: " + DATE_STRING.toUpperCase(), e.getAuthor().getName() + " has started a new Among Us game in <#848999707056930856>. \n React with ✅ if you are attending. \n React with 👑 if you want to host the game \n React with"
					+ "🔇 if you can play, but cannot speak. \n React with 👀 if you are just listening in. \n GLHF~!", false);

			Message message = e.getChannel().sendMessage(emb2.build()).complete();
			message.addReaction("✅").queue();
			message.addReaction("👑").queue();
			message.addReaction("🔇").queue();
			message.addReaction("👀").queue();



		}	

		else if(MessageSent.equalsIgnoreCase("~AMGclose")) {
			if(a == 1) {
				e.getChannel().sendMessage("This headcount of Among Us has closed. We have started with " + a + " player!" ).queue();
			}

			else {
				e.getChannel().sendMessage("This headcount of Among Us has closed. We have started with " + a + " players in <#848999707056930856>!" ).queue();
			}


			if(!SS1.isEmpty()) {
				for(int i =0; i< SS1.size(); i++) {
					W1 = W1 + SS1.get(i) + " ";
				}
			}
			if(!SS2.isEmpty()) {
				for(int i =0; i<SS2.size(); i++) {
					W2 = W2 + SS2.get(i) + " ";
				}
			}
			if(!SS3.isEmpty()) {
				for(int i =0; i<SS3.size(); i++) {
					W3 = W3 + SS3.get(i) + " ";
				}
			}


			EmbedBuilder emb3 = new EmbedBuilder();
			emb3.setTitle("List of players for today's game~!");
			emb3.setDescription("GLHF!");
			emb3.setThumbnail("https://cdn.discordapp.com/attachments/877014655543951370/879569769412583484/wonder-day-among-us-21.png");
			emb3.addField("Players: ",W1, false);
			emb3.addField("Host: ", Host,false);
			emb3.addField("Mutes: ", W2, false);
			emb3.addField("Spectators", W3, false );

			e.getChannel().sendTyping().queue();
			e.getChannel().sendMessage(emb3.build()).queue();
			emb3.clear();

			TFT1.clear();
			TFT2.clear();
			S1 = "";
			S2 = "";

			SS1.clear();
			SS2.clear();
			SS3.clear();


		}

		//Clear Command:
		else if(args[0].equalsIgnoreCase("~clear")) {

			try {
				List<Message> messages = e.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
				e.getChannel().purgeMessages(messages);

				e.getChannel().sendMessage("**✅"  + args[1]+" texts deleted!**").queue();

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				messages = e.getChannel().getHistory().retrievePast(1).complete();
				e.getChannel().purgeMessages(messages);
			}
			catch(IllegalArgumentException o) {
				if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval")) {
					EmbedBuilder emb6 = new EmbedBuilder();
					emb6.setTitle("Sorry!");
					emb6.setColor(Color.CYAN);
					emb6.setThumbnail("https://cdn.discordapp.com/emojis/864362936541249567.gif?v=1");
					emb6.addField("Messages over 100, and Messages over 2 weeks old cannot be deleted. :/", "", false);

					e.getChannel().sendMessage(emb6.build()).queue();
				}
			}

		}

		//poke
		else if(args[0].equalsIgnoreCase("~poke")) {
			e.getChannel().sendMessage(args[1]+ ", " + e.getAuthor().getAsMention() + " just poked you. Maybe they need you for something?").queue();

		}
		//slap
		else if(args[0].equalsIgnoreCase("~slap")) {
			int A = random.nextInt(11);



			if(A==0)	
				e.getChannel().sendMessage(args[1]+ ", " + e.getAuthor().getAsMention() + " just vented in front of you. Instead of killing you, they slapped you. ").queue();

			else if(A==1)
				e.getChannel().sendMessage(args[1]+ ", " + e.getAuthor().getAsMention() + " just slapped you. How do you feel? ").queue();	

			else if(A==2)
				e.getChannel().sendMessage("The world shakes when "+ e.getAuthor().getAsMention()+ " slaps " + args[1] + " without permission.").queue();

			else if(A==3)
				e.getChannel().sendMessage("Uh oh. "+  e.getAuthor().getAsMention()+ " just slapped " + args[1] + ". Prepare for fallout. :pensive:").queue();

			else if(A==4)
				e.getChannel().sendMessage(""+ e.getAuthor().getAsMention()+ " slapped " + args[1]+ ". :fatassbaby:").queue();

			else if(A==5) {
				e.getChannel().sendMessage("https://tenor.com/view/slap-bear-slap-me-you-gif-17942299").queue();
				e.getChannel().sendMessage("POV: You're "+ args[1]+ ", and " + e.getAuthor().getAsMention() + " just slapped you.").queue();
			}
			else if(A==6)
				e.getChannel().sendMessage(e.getAuthor().getAsMention() + ", you're being filed for assault for slapping " + args[1]).queue();

			else if(A==7)
				e.getChannel().sendMessage("Wow. "+  e.getAuthor().getAsMention()+ " just slapped " + args[1] + ". Where did your friendship go?").queue();	

			else if(A==8)
				e.getChannel().sendMessage("Finding out that "+  e.getAuthor().getAsMention()+ " just slapped " + args[1] + " online hurts me more then it hurts them.").queue();	

			else if(A==9)
				e.getChannel().sendMessage("Hi guys, my name is" + e.getAuthor().getAsMention()+ ", and I just slapped the shit out of " + args[1]+ ". Follow for more!").queue();	

			else if(A==10)
				e.getChannel().sendMessage("One more time, "+  e.getAuthor().getAsMention()+ ". Slap " + args[1] + " one more time. :angry:").queue();




		}

		//Annoy
		else if(args[0].equalsIgnoreCase("~annoy")) {

			for(int i =0; i<20; i++) {
				e.getChannel().sendMessage(args[1]).queue();
			}

			e.getChannel().sendMessage("Hello :)").queue();
		}



		else if(MessageSent.equalsIgnoreCase("~help")) {
			EmbedBuilder emb5 = new EmbedBuilder();
			emb5.setTitle("Help Centre");
			emb5.setThumbnail("https://cdn.discordapp.com/attachments/879585092689862748/879926380995960862/ask-for-help.png");
			emb5.setDescription("Scroll down to find which command you would like to use.");
			emb5.addField("~Info", "Generates info about me. Pretty boring stuff if you ask me.", false);
			emb5.addField("AMGopen", "Opens a new Among Us headcount under your name. Everyone who wishes to play can react.", false);
			emb5.addField("~AMGclose", "Closes the headcount, and begins naming the players. The game should start after that.", false);
			emb5.addField("TFTopen", "Opens a new TFT headcount under your name. Everyone who wishes to play can react.", false);
			emb5.addField("~TFTclose", "Closes the headcount, and begins naming the players. The game should start after that.", false);
			emb5.addField("~clear [#]", "clears the amount of lines you entered. Use at your own risk!", false);
			emb5.addField("~poke [member]", "Pokes the member you enter for their attention.", false);
			emb5.addField("~slap [member]", "Slaps the person with a funny prompt.", false);
			emb5.addField("~annoy[member]", "Annoys the person. Beware, you may be blocked.", false);

			emb5.addField("~help", "For trusty help!", false);
			e.getChannel().sendMessage(emb5.build()).queue();
		}


		//Error Prompt
		else if(MessageSent.contains("~")) {
			EmbedBuilder emb4 = new EmbedBuilder();
			emb4.setTitle("Sorry!");
			emb4.setThumbnail("https://cdn.discordapp.com/emojis/864362936541249567.gif?v=1");
			emb4.addField("I didn't understand what you wanted to do! If you need help, type ~help for help!", "", false);
			e.getChannel().sendMessage(emb4.build()).queue();
		}

	}



	//	Reactions Section of Among Us Headcount
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){

		if (event.getReactionEmote().getName().equals("✅") && !event.getMember().getUser().isBot()) {
			ServerBotCommands.a +=1;
			SS1.add(event.getMember().getEffectiveName());
			TFT1.add(event.getMember().getEffectiveName());

		}

		else if(event.getReactionEmote().getName().equals("🔇") && !event.getMember().getUser().isBot()) {
			SS2.add(event.getMember().getEffectiveName());
		}

		else if(event.getReactionEmote().getName().equals("👑") && !event.getMember().getUser().isBot()) {
			Host = event.getMember().getEffectiveName();
		}
		else if(event.getReactionEmote().getName().equals("👀") && !event.getMember().getUser().isBot()) {
			SS3.add(event.getMember().getEffectiveName());
			TFT2.add(event.getMember().getEffectiveName());
		}	
	}


}

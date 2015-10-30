package in.org.samhita.android.app;

import java.util.ArrayList;
import java.util.List;







import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper{
	private static final int DATABASE_VERSION = 21;

	private static final String DATABASE_NAME = "SAMHITA";

	private static final String TABLE_UPDATES = "UPDATES";
	private static final String TABLE_EVENTS = "Events";
	private static final String TABLE_WS = "Workshops";
	private static final String KEY_ID = "UPDADE_ID";
	private static final String KEY_UPDATENAME="NAME";
	private static final String KEY_UPDATEDESC="DESC";
	private static final String KEY_UPDATETIME="TIME";
	private static final String KEY_UPDATETYPE="TYPE";
	private static final String KEY_UPDATEURL="URL";
	private static final String KEY_EVENT_ID="EVENT_ID";
	private static final String KEY_EVENT = "EVENT_NAME";
	private static final String KEY_TIME="EVENT_TIME";
	private static final String KEY_ORGANIZER="EVENT_ORGANIZER";
	private static final String KEY_DESC="EVENT_DESC";
	private static final String KEY_PHONE="EVENT_PHONE";
	private static final String KEY_TYPE="EVENT_TYPE";
	private static final String KEY_URL="EVENT_URL";
	private static final String KEY_WEVENT_ID="WS_ID";
	private static final String KEY_WEVENT = "WS_NAME";
	private static final String KEY_WTIME="WS_TIME";
	private static final String KEY_WORGANIZER="WS_ORGANIZER";
	private static final String KEY_WDESC="WS_DESC";
	private static final String KEY_WPHONE="WS_PHONE";
	
	private static final String KEY_WURL="WS_URL";
	private Context context;
	public DataBaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.context=context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_UPDATES_TABLE = "CREATE TABLE  " + TABLE_UPDATES + "("+ KEY_ID + " TEXT  ,"+ KEY_UPDATENAME +" TEXT ," + KEY_UPDATEDESC +" TEXT , "+KEY_UPDATETIME+" TEXT , "+KEY_UPDATETYPE+" TEXT , "+KEY_UPDATEURL+" TEXT )";
		db.execSQL(CREATE_UPDATES_TABLE);
		String insertQuery="insert into "+TABLE_UPDATES+ "("+KEY_ID+","+KEY_UPDATENAME+","+KEY_UPDATEDESC+","+KEY_UPDATETIME+","+KEY_UPDATETYPE+","+KEY_UPDATEURL+") values ('1','Samhita`14','Welcome to the Annual Technical festival of Madras Institute of Technology. Please connect your phone and refresh to get current updates.','2014-01-01 00:00:55','1',''); ";
		db.execSQL(insertQuery);
		String CREATE_EVENTS_TABLE = "CREATE TABLE  " + TABLE_EVENTS + "( " + KEY_EVENT_ID + " INTEGER PRIMARY KEY , "
				+ KEY_EVENT + " TEXT , " + KEY_TIME + " TEXT , "+ KEY_DESC+" TEXT , "+KEY_ORGANIZER+" TEXT , "+ KEY_PHONE+" TEXT  , "+ KEY_TYPE+" TEXT )";
		db.execSQL(CREATE_EVENTS_TABLE);
		String CREATE_WS_TABLE = "CREATE TABLE  " + TABLE_WS + "( " + KEY_WEVENT_ID + " INTEGER PRIMARY KEY , "
				+ KEY_WEVENT + " TEXT , " + KEY_WTIME + " TEXT , "+ KEY_WDESC+" TEXT , "+KEY_WORGANIZER+" TEXT , "+ KEY_WPHONE+" TEXT  , "+KEY_WURL+" TEXT )";
		db.execSQL(CREATE_WS_TABLE);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('22','B plan','Feb 2nd week,2014','<tab><singlequote>If a plan doesn<singlequote>t work, change the plan but NEVER the goal!<singlequote><enter><tab>Good at planning? Are you a strategic team player? This event is made just for the entrepreneur in you. Amaze us with your problem solving and managerial skills. Show us that you<singlequote>re good with people. Confront crisis with your innate talents. Claim your prize by your pragmatic and effective approach.','Hameed Faizel','9677569843','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('13','Coffee with JAVA','Feb 2nd week,2014','<tab>An exclusive round purely dedicated to Java Freaks. Get ready to drown yourself inside out in Gosling<singlequote>s baby creation. This event is all set to test your expertise in JAVA – be it applets, swings, AWT and just everything that makes JAVA so tantalizing. Drop by and have your share of caffeine. After all, this event requires you to be stimulated!','Sampath','9962797769','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('15','Debugging','Feb 2nd week,2014','<enter><tab><singlequote>It<singlequote>s hard enough to find an error in your code when you<singlequote>re looking for it; it<singlequote>s even harder when you<singlequote>ve assumed your code is error-free.<singlequote><enter><tab> -Steve Mc Connell<enter><tab>The art of programming lies not just in typing lines and lines of code. Debugging is in itself a challenge that lets you identify your difference of opinion with the compiler. Get ready to sort out things with the compiler – Identify all the errors and your relationship becomes successful! You really don<singlequote>t want a conflict with your compiler do you??','Monisha S','9790547837','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('12','Dexterity Unbounded','Feb 2nd week,2014','<tab>Being a geek doesn<singlequote>t count here. This event is tailor made to test your cognitive skills and deftness in the most simplest of tasks. All it takes is agility, good use of memory and logic to come out the winner. The most favorite, fun-filled team event of all is here to put your team spirit to test. Get ready for an exhilarating ride through brain wrecking rounds to reach the zenith of your glory! ','Kirthanaa','8056284638','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('8','Gaming','Feb 2nd week,2014','<enter><tab><singlequote>I am a gamer, not because I don<singlequote>t have a life. But because I chose to have many!<singlequote><enter><tab>Tired of juggling around with your PS2 and XBOXs? Come to MIT to witness the most aggressive of all battles. Join us with your comrades to battle the most belligerent opponents in Counter Strike. Speed definitely thrills but kills. Do you have it in you to do it without getting killed? Bring out the car racer in you and your passion for an adrenaline pumped ride battling your opponents in NFS.','Murali Manohar','9952923967','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('11','General Quiz','Feb 2nd week,2014','<enter><tab><singlequote>It<singlequote>s not a silly question if you can<singlequote>t answer it!<singlequote><enter><tab><tab>-Jostein Gaarder<enter><tab>Sharpen your brains. Time is of the essence. For each second lost, you<singlequote>re an answer away from glory. Join us with your friends in the most thrilling and the most intellectual event of Samhita <singlequote>14. Be ready to dodge the ammos of questions fired at you and you may emerge the conqueror of brains!','Kanchan Kumar','9940024504','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('20','Hackathon','Feb 2nd week,2014','Tired of being ethical? Well, here<singlequote>s the chance to bring out the villain in you. Go on a hacking spree. And we<singlequote>ll reward you for that. ','Balakrishnan R','9677767721','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('9','How stuff works?','Feb 2nd week,2014','<tab><singlequote>The most important thing is not to stop questioning. Curiosity has its own reason for existing!<singlequote><enter><tab><tab>-Albert Einstein<enter><tab>Do you marvel at how the most complex phenomenon in our Universe is driven by simple laws of Science? Watching Discovery channel is finally going to pay off.Can you uncover the hidden logic behind what makes a bulb glow to how the Universe was created? This event is meant especially to bring out the Archimedes in you. Logical reasoning will take you to great heights and this is just the right place for you to squeeze the juice out of your cerebrum.','Karthik C','9941409229','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('16','Linux mate','Feb 2nd week,2014','<tab>Crazy about Linux? This event is all set to test your knowledge on everything about Linux. Show us your expertise on Torvalds<singlequote> creation. Bring out the Linux Lunatic in you and you might walk out wearing the <singlequote>Red Hat<singlequote>!','Suriya','9994346699','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('6','Math - o - mania','Feb 2nd week,2014','<tab><singlequote>Math may not teach us how to add love or minus hate!<enter><tab>But it gives us every reason to hope that every problem has a solution!<singlequote><enter><tab>The essence of math is not to make simple things complicated but to make complicated things simple. Even the most complicated problem can be solved with the simplest solution. Can you make life a whole lot simpler by reducing the biggest problems to an equation of reasons that started it? Then sharpen your pencils and get ready for the challenge. Because it all comes down to attacking every problem rather than accepting defeat.','Keerthana C B','9444244233','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('5','Meta Grobalise ','Feb 2nd week,2014','<tab><singlequote>Math may not teach us how to add love or minus hate!But it gives us every reason to hope that every problem has a solution!<singlequote><enter><tab>The essence of math is not to make simple things complicated but to make complicated things simple. Even the most complicated problem can be solved with the simplest solution. Can you make life a whole lot simpler by reducing the biggest problems to an equation of reasons that started it? Then sharpen your pencils and get ready for the challenge. Because it all comes down to attacking every problem rather than accepting defeat.','Sampath','9962797769','1'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('7','mu – pro','Feb 2nd week,2014','<tab><singlequote>A great life isn<singlequote>t about huge things. It<singlequote>s about small things that make a big difference!<singlequote><enter><tab>Physics has taught us that all it takes is an electron to move to drive even the biggest of machines. Can you make an impact at the micro level and make wonders happen? Can you make your microprocessor dance according to your whims? Then this is just the event for you.  Show us you can manipulate the itsy-bitsy processors and prove that you can make the biggest change just by controlling the smallest things!','Vishabanathan','9597793357','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('17','NetWiz','Feb 2nd week,2014','<tab>NetWiz is all set to drive the neurons in you crazy. Join this event to enter a tortuous world of network puzzles and emerge the winner. All you need to do is follow the protocols, keep your headers calm and make sure your packets of knowledge don<singlequote>t get lost!','Shiva Prakash','9176449525','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('1','OLPC','Feb 2nd week,2014','<tab>Here<singlequote>s the most anticipated event for all you geeks out there. An adrenaline filled event where every second counts. Get a chance to compete with the top programmers of the nation and make it to the top of the leaderboard with the best possible solutions. Show us what you got in your geeky cerebrum and walk away with honors','Arun Lakshman','9962973191','1'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('23','Paper presentation','Feb 2nd week,2014','<tab><singlequote>If at first an idea does not sound absurd, then there is no hope for it!<singlequote><enter><tab><tab>-Albert Einstein<enter>Here<singlequote>s a chance to share your <singlequote>Eureka moment<singlequote> with us. Got cool new ideas that will help make our world better? Share it with us. Let the world know what you got in you. Present your ideas and give us a chance to be inspired by your novel ideas.<enter><tab>Rules for paper presentation<enter>1. Submit papers to samhita2k14.pp@gmail.com<enter>2. Add your name, college, phone no. and E-Mail along with your paper.<enter>3. Max 6 pages in IEEE format saved as pdf or doc.<enter>4. Submission deadline date-26th Jan, 2014. The submitted papers will be shortlisted and announced on Feb 1. <enter> <tab>Topics:<enter>1. Big data analytics<enter>2. Artificial intelligence<enter>3. Cloud, grid and cluster computing<enter>4. Algorithms<enter>5. Wireless sensor networks<enter>6. SOA, web service and semantic web<enter>7. Data mining<enter>8. Human computer interaction<enter>9. Green computing<enter>10. E-Governance<enter>11. Cryptography and network security<enter>12. Image processing<enter>  ','Priya T','9751351911','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('2','PS I Love You!','Feb 2nd week,2014','<tab><singlequote>Reality leaves a lot to the imagination<singlequote><enter><tab><tab>-John lennon<enter><tab>Are you a PS fanatic? Are you good with colors and designs? Well, here’s the best platform you can ever get to showcase your <singlequote>creative skills<singlequote>. Pour out every ounce of the creative <singlequote>you<singlequote> in your posters and your well on your way to glory. Mail your designs to us and throw us off guard with your Spielberg ideas. Who knows? We might actually end up discovering a new Spielberg in the making.','Kanchan Kumar','9940024504','1'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('14','Reverse Coding','Feb 2nd week,2014','<tab><singlequote>Programmers are not to be measured by their ingenuity and their logic but by the completeness of their case analysis.<singlequote> <enter><tab> -Alan Perlis<enter><tab>Wanna try something different? How <singlequote>bout doing things in reverse for a change? Reverse Coding is just the event for you. Reverse engineer a program to get the desired specifications.  ','Sivagurunathan','9487090953','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('18','Sequel Scholars','Feb 2nd week,2014',' <tab>Do you have it in you to work with and manipulate the most powerful entity that drives a world facing an explosion of it? Yes, we are talking about data and databases. Get ready to trigger the gray cells in your mind, avoid being deadlocked and complete the query quest.','Priya T','9751351911','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('21','Shutters','Feb 2nd week,2014','<tab><singlequote>Sometimes the simplest pictures are the hardest to get!<singlequote><enter><tab><tab>-Neil Leifer<enter><tab>Time to take out your DSLRs. Nature beckons you. Capture anything that awes you. Play with lights. The one that touches a chord with many takes away the prize. Explore your familiar surroundings for the unfamiliar. Enjoy the beauty of everything around you. You<singlequote>re just a click away from euphoria.','Titus Azariah','7845169911','1'); ";
		db.execSQL(insertQuery); 
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('19','Street Coding','Feb 2nd week,2014','<tab>Bored of sitting in lab all day and coding monotonously? We are determined to get you out on the streets. And code. Here<singlequote>s a rare chance to experience a code fest in a completely different environment. Enjoy the beauty of MIT as you sit under the canopy of trees and work in unison with Mother Nature.','Jayadharini','9944662298','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('4','Treasure Hunt','Feb 2nd week,2014','<tab>Do you love treasures?? Do you have the enthusiasm and the ebullience to go on a never ending search for the most elusive trophies? Join the plunder with your friends, go on a clue – finding mission and unravel the mysteries hidden in plain sight. Get ready to be mystified and battle an army of clues to reach the most coveted prize of the event!','Jagdeesh','9566949998','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('10','Web designing','Feb 2nd week,2014','<tab>An irresistible event where creativity holds the upper hand. Show us what you can do with anything from the basic HTML to the fascinating JQueries. What are you waiting for? Join the event to compete with the most creative designers from around the nation. Amaze us with your designs and be crowned the victor.','Asiya','9840770886','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('3','Mr & Ms Techie','Feb 2nd week,2014','<tab><singlequote>Winning isn<singlequote>t everything but wanting it is!<singlequote><enter><tab><tab>-Arnold Palmer<enter><tab>The mega event of Samhita <singlequote>14 is here to bring out the techie in u. Do you have a zeal that never lets you stop at anything? Do you have a burning passion that drives you to greater heights? Then this might just be the event for you.  A myriad of rounds and events are planned just for you to pound your knowledge that u gained in all these grueling years of Engineering. Show us that you got all it takes to get through the labyrinth of challenges and emerge the winner.','Hemalathaa','9788413291','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('24','Google Trotter','Feb 2nd week,2014','<tab>This online treasure hunt is designed to unlock the Vasco-da-Gama in you. Unlock clues, find treasures and fight your way through the most complicated mazes to emerge the winner.','Prabakaran B','7708288018','1'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('25','Code Venture','Feb 2nd week,2014','<tab>Come join us in MIT to venture into the world of programming. Special event for all the coders with a special aptitude for cracking your way through the toughest problems with the simplest solutions.','Vignesh R','9176515760','1'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('26','Google Geek','Feb 2nd week,2014','<tab>Search the path to follow, destiny awaits..','Gowtham G','9940625988','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('27','Dumb C','Feb 2nd week,2014','<tab>A fun event for all the C maniacs out there. Act out the words given to you and guess them. The more right ones you strike, the merrier! We techies know how to have fun in our own way, don<singlequote>t we??','Reshma K N','9790811880','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_EVENTS+ "("+KEY_EVENT_ID+","+KEY_EVENT+","+KEY_TIME+","+KEY_DESC+","+KEY_ORGANIZER+","+KEY_PHONE+","+KEY_TYPE+ ") values ('28','OSPC','Feb 2nd week,2014','<tab>Yet another programming contest to test the programmer in you. Show us that you<singlequote> got all that it takes to solve the problems with speed and precision','Vignesh','9176515760','2'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_WS+ "("+KEY_WEVENT_ID+","+KEY_WEVENT+","+KEY_WTIME+","+KEY_WDESC+","+KEY_WORGANIZER+","+KEY_WPHONE+","+KEY_WURL+ ") values ('1','Android Workshop','Feb 8 ,2014','<tab>Android is the latest Smartphone OS developed by Google taking the smart phone industry by storm. In nearly 2 years of it existence, it has over 40% of the Smartphone OS share. And still Android is not showing any sign of slowing down. Besides Android OS being Open Source, it is a real treat for programmers & developers to dwell into it.<enter><tab> Topics:<enter>1. Why Android?<enter>2. Android Overview<enter>3. SDK Intro<enter>4. Android Stack<enter>5. Hello World App<enter>6. Main Building Blocks<enter>7. Hello Views - Intro to different Views<enter>8. Basic Android UI<enter>9. Android System Overview<enter>10. Advanced UI<enter>11. Introduction to Facebook Android SDK.<enter>12. Do your app in Facebook Android SDK.<enter>13. More advanced topics in Facebook Android SDK.<enter><tab>Duration<enter>The duration of this workshop will be one day, with six hour session a day <enter><tab>Eligibility<enter>It<singlequote>s a basic level workshop so there are no prerequisites. Anyone interested, can join this workshop','Balakrishnan','9677767721','http:<slash><slash>bit.ly<slash>s14ANDROID'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_WS+ "("+KEY_WEVENT_ID+","+KEY_WEVENT+","+KEY_WTIME+","+KEY_WDESC+","+KEY_WORGANIZER+","+KEY_WPHONE+","+KEY_WURL+ ") values ('2','MATLAB Workshop','Feb 8 ,2014','<tab>Digital Image Processing is a hands-on discipline, and the best way to learn is by doing. This training program will enable the participants to get hands-on training in practical implementation of theoretical concepts of DIP using MatLab®.<enter><tab> Contents:<enter>1. Fundamentals of Digital Image Representation, Sampling, Quantization, Spatial and Gray Level Resolution, Brightness and Contrast Control.<enter>2. Input<slash>Output operations with Images, Data types, Point Processing for Gray Scale and Color Images, Linear & Non-linear Transfer Function Implementation.<enter>3. Color Image Processing (RGB, YcbCr – Color planes).<enter>4. Block Processing: Spatial Filtering: Low Pass Filtering (Averaging filter), Median Filtering, High Pass Filtering and High Boost filtering.<enter>5. Fourier Transform for Images & Filtering in Frequency Domain.<enter>6. Image Segmentation by Thresholding.<enter>7. Applications in various fields (Medical, Biometric, Satellite, Robotics, Microscopic Images etc).<enter>','Gokulananthan','9600795745','http:<slash><slash>bit.ly<slash>s14MATLAB'); ";
		db.execSQL(insertQuery);
		insertQuery="insert into "+TABLE_WS+ "("+KEY_WEVENT_ID+","+KEY_WEVENT+","+KEY_WTIME+","+KEY_WDESC+","+KEY_WORGANIZER+","+KEY_WPHONE+","+KEY_WURL+ ") values ('3','Mobile Computing','Feb 9 ,2014','<tab>Mobile computing is human–computer interaction by which a computer is expected to be transported during normal usage.<enter>Ubiquitous computing (ubicomp) is an advanced computing concept where computing is made to appear everywhere and anywhere. In contrast to desktop computing, ubiquitous computing can occur using any device, in any location, and in any format. A user interacts with the computer, which can exist in many different forms, including laptop computers, tablets, terminals and phones.','Priya','9751351911','http:<slash><slash>bit.ly<slash>s14MOBILE'); ";
		db.execSQL(insertQuery);

		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		arg0.execSQL("DROP TABLE IF EXISTS "+TABLE_EVENTS);
		arg0.execSQL("DROP TABLE IF EXISTS "+TABLE_UPDATES);
		
		arg0.execSQL("DROP TABLE IF EXISTS "+TABLE_WS);
		onCreate(arg0);
		
	}
	public 
	int addMessage(Update update) {
		SQLiteDatabase db = this.getWritableDatabase();
		int yes=-2;
		ContentValues values = new ContentValues();
		values.put(KEY_ID,""+update.getId());
		values.put(KEY_UPDATENAME, update.getUpdate()); // Contact Name
		values.put(KEY_UPDATEDESC, update.getDesc());
		values.put(KEY_UPDATETIME, update.getTime());// Contact Phone
		values.put(KEY_UPDATETYPE, update.getUpdateType());
		values.put(KEY_UPDATEURL, update.getUrl());
  try {
		// Inserting Row
		yes=(int)db.insert(TABLE_UPDATES, null, values);
		db.close(); // Closing database connection
	//	 Log.v("location on updatedb",""+yes);
  }catch(SQLException e)
  {
//	Log.v("Exception caught", e.getMessage());  
  }
		return yes;
	}
	public int addEvent(Event event) {
		// TODO Auto-generated method stub
		
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		
		values.put(KEY_EVENT, event.getEventName()); // Cloud message
		values.put(KEY_TIME, event.getTime());
		values.put(KEY_ORGANIZER, event.getOrganizer());
		values.put(KEY_DESC, event.getDesc());
		values.put(KEY_PHONE, event.getPhone());
		values.put(KEY_TYPE, event.getType());
		
		// Inserting Row
		int yes=(int)db.insert(TABLE_EVENTS, null, values);
		db.close(); // Closing database connection
		return yes ;
		
	}
  public List<Update> getAllUpdates() {
	  List<Update> updates = new ArrayList<Update>();
	  String selectQuery = "SELECT  * FROM " + TABLE_UPDATES +" ORDER BY "+ KEY_UPDATETIME +" DESC" ;
	  SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Update sms=new Update();
				sms.SetDetails(Integer.parseInt(cursor.getString(0)), cursor.getString(1).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(2).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(3).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\"").replaceAll("<tab>", "\t"),Integer.parseInt(cursor.getString(4)),cursor.getString(5).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""));  //(Integer.parseInt(cursor.getString(0)));
				
				updates.add(sms);
			} while (cursor.moveToNext());
		}
		
		cursor.close();
		db.close();
		return updates;
	  
  }
  public Event getEvent(int pos) {
		SQLiteDatabase db = this.getReadableDatabase();
		Event e=new Event();
		Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_EVENTS +" WHERE "+KEY_EVENT_ID+ " = "+pos, null);
		if(cursor.moveToFirst()) {
			e.setDetails(cursor.getInt(0),cursor.getString(1).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""), cursor.getString(2).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(3).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(4).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\"").replaceAll("<tab>", "\t"),cursor.getString(5).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),Integer.parseInt(cursor.getString(6)));  //(Integer.parseInt(cursor.getString(0)));
			return e;
		}
		db.close();
		return null;
	}
  public void deleteAllUpdates() {
	 
			
			SQLiteDatabase db = this.getReadableDatabase();
			
			String del="DELETE  FROM "+TABLE_UPDATES+" WHERE "+KEY_ID+" IN (SELECT "+KEY_ID+" FROM "+TABLE_UPDATES+" ORDER BY  "+KEY_ID+" DESC )";
			
			db.execSQL(del);
			db.close();
			
			
		}
  
  public void executeQuery(String query){
		SQLiteDatabase db=this.getWritableDatabase();
		
		
		try {
			db.execSQL(query);
		}catch(SQLException e){
			Log.v("Query Error", "execution of the query made an error");
			Log.v("Query Error", e.getLocalizedMessage());

			
		}
		
		db.close();
		return;
		
	}
  
  public List<Event> getAllEvents() {
		List<Event> eventlist = new ArrayList<Event>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_EVENTS +" ORDER BY "+KEY_EVENT_ID ;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Event event=new Event();
				event.setDetails(cursor.getInt(0),cursor.getString(1).replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""), cursor.getString(2).replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(3).replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\"").replaceAll("<tab>", "\t"),cursor.getString(4).replaceAll("<singlequote>", "'").replaceAll("<tab>", "\t").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(5).replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),Integer.parseInt(cursor.getString(6)));  //(Integer.parseInt(cursor.getString(0)));
				// Adding sms  to list
				eventlist.add(event);
			} while (cursor.moveToNext());
		}
		else
		{
			//Log.v("database dashboard", "all events list database.. gokka maakkaa");
		}

		// return contact list
		db.close();
		return eventlist;
	}
  public List<Event> getAllWorkshops() {
		List<Event> eventlist = new ArrayList<Event>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_WS +" ORDER BY "+KEY_WEVENT_ID ;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Event event=new Event();
				event.setDetails(cursor.getInt(0),cursor.getString(1).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""), cursor.getString(2).replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(3).replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\"").replaceAll("<tab>", "\t"),cursor.getString(4).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(5).replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),Integer.parseInt(cursor.getString(6)));  //(Integer.parseInt(cursor.getString(0)));
				// Adding sms  to list
				eventlist.add(event);
			} while (cursor.moveToNext());
		}
		else
		{
			//Log.v("database dashboard", "all events list database.. gokka maakkaa");
		}

		// return contact list
		db.close();
		return eventlist;
	}
  public Event getWorkshop(int pos) {
		SQLiteDatabase db = this.getReadableDatabase();
		Event e=new Event();
		Cursor cursor=db.rawQuery("SELECT * FROM "+TABLE_WS +" WHERE "+KEY_WEVENT_ID+ " = "+pos, null);
		if(cursor.moveToFirst()) {
			e.setDetails(cursor.getInt(0),cursor.getString(1).replaceAll("<singlequote>", "'").replaceAll("<tab>", "\t").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""), cursor.getString(2).replaceAll("<singlequote>", "'").replaceAll("<tab>", "\t").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(3).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(4).replaceAll("<tab>", "\t").replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(5).replaceAll("<singlequote>", "'").replaceAll("<enter>", "\n").replaceAll("<doublequote>", "\""),cursor.getString(6).replaceAll("<slash>", "/"));  //(Integer.parseInt(cursor.getString(0)));//.replaceAll("<slash>", "//")
			return e;
		}
		db.close();
		return null;
	}
  }


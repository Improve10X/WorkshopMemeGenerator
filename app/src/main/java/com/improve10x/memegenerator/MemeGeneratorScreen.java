package com.improve10x.memegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/*
    Guidelines

    To show screen title, use
    getSupportActionBar().setTitle(title);

    To get Template name text, use
    templateNameTxt.getText().toString()

    To get top text, use
    topTextTxt.getText().toString()

    To get bottom text, use
    bottomTextTxt.getText().toString()

    To load a image using url
    Picasso.get().load(<URL>).into(previewImg);

    To get selected template name from dropdown, use
    templateDropDown.getSelectedItem().toString();

    To show templates, use method
    showDataInDropdown(templateNames)

    To get all the template names as an array, use method
    createTemplateNames()

    To navigate to next screen, use method
    openMemePreviewScreen(memeImageUrl)

    To hide preview image
    previewImg.setVisibility(View.GONE)
 */
public class MemeGeneratorScreen extends AppCompatActivity implements IMemeGeneratorScreen {

    private Spinner templateNameDropDown;
    private EditText topTextTxt;
    private EditText bottomTextTxt;
    private Button generateMemeBtn;
    private ImageView previewImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showScreen();
    }

    // Do not touch this method
    private void initComponents() {
        templateNameDropDown = findViewById(R.id.templateNameDropDown);
        topTextTxt = findViewById(R.id.topTextTxt);
        bottomTextTxt = findViewById(R.id.bottomTextTxt);
        generateMemeBtn = findViewById(R.id.generateBtn);
        previewImg = findViewById(R.id.previewImg);
    }

    // DO not touch this method
    private void setupListeners() {
        generateMemeBtn.setOnClickListener(v -> {
            onGenerateMemeClicked();
        });
    }

    // DO not touch this method
    private String[] createTemplateNames() {
        return new String[]{"10 Guy", "1950s Middle Finger", "1990s First World Problems",
                "1st World Canadian Problems", "2nd Term Obama", "Aaaaand Its Gone", "Ace Primo",
                "Actual Advice Mallard", "Adalia Rose", "Admiral Ackbar Relationship Expert",
                "Advice Dog", "Advice Doge", "Advice God", "Advice Peeta", "Advice Tam",
                "Advice Yoda", "Afraid To Ask Andy", "Afraid To Ask Andy Closeup",
                "Aint Nobody Got Time For That", "Alan Greenspan", "Alarm Clock", "Albert Cagestein", "Albert Einstein 1", "Alien Meeting Suggestion", "Alright Gentlemen We Need A New Idea", "Always Has Been", "Alyssa Silent Hill", "Am I The Only One Around Here", "American Chopper Argument", "Ancient Aliens", "And everybody loses their minds", "And then I said Obama", "Angry Asian", "Angry Baby", "Angry Birds Pig", "Angry Bride", "Angry Chef Gordon Ramsay", "Angry Chicken Boss", "Angry Dumbledore", "Angry Koala", "Angry Rant Randy", "Angry Toddler", "Annoying Childhood Friend", "Annoying Facebook Girl", "Anri Stares", "Anti Joke Chicken", "Apathetic Xbox Laser", "Archer", "Are Your Parents Brother And Sister", "Are you a Wizard", "Arrogant Rich Man", "Art Attack", "Art Student Owl", "Arthur Fist", "Asshole Ref", "Aunt Carol", "Austin Powers Honestly", "Aw Yeah Rage Face", "Awkward Moment Sealion", "Awkward Olympics", "BANE AND BRUCE", "BM Employees", "Babushkas On Facebook", "Baby Cry", "Baby Godfather", "Baby Insanity Wolf", "Back In My Day", "Bad Advice Cat", "Bad Joke Eel", "Bad Luck Bear", "Bad Luck Brian", "Bad Luck Hannah", "Bad Pun Anna Kendrick", "Bad Pun Dog", "Bad Wife Worse Mom", "Bah Humbug", "Bane", "Bane Permission", "Barack And Kumar 2013", "Barba", "Barbosa And Sparrow", "Barney Stinson Win", "Baromney", "Baron Creater", "Bart Simpson Peeking", "Batman And Superman", "Batman Slapping Robin", "Batman Smiles", "Batmobile", "Bazooka Squirrel", "Be Like Bill", "Bear Grylls", "Beard Baby", "Bebo", "Because Race Car", "Ben Barba Pointing", "Bender", "Benito", "Bernie I Am Once Again Asking For Your Support", "Beyonce Knowles Superbowl", "Beyonce Knowles Superbowl Face", "Beyonce Superbowl Yell", "Big Bird", "Big Bird And Mitt Romney", "Big Bird And Snuffy", "Big Ego Man", "Big Family Comeback", "Bike Fall", "Bill Murray Golf", "Bill Nye The Science Guy", "Bill OReilly", "Billy Graham Mitt Romney", "Bitch Please", "Black Girl Wat", "Blank Blue Background", "Blank Colored Background", "Blank Comic Panel 1x2", "Blank Comic Panel 2x1", "Blank Comic Panel 2x2", "Blank Nut Button", "Blank Starter Pack", "Blank Transparent Square", "Blank Yellow Sign", "Blob", "Blue Futurama Fry", "Boardroom Meeting Suggestion", "Bonobo Lyfe", "Booty Warrior", "Bothered Bond", "Brace Yourselves X is Coming", "Brian Burke On The Phone", "Brian Griffin", "Brian Williams Was There", "Brian Williams Was There 2", "Brian Williams Was There 3", "Brian Wilson Vs ZZ Top", "Britney Spears", "Bubba And Barack", "Buddy Christ", "Buddy The Elf", "Buff Doge vs Cheems", "Bullets", "Burn Kitty", "Business Cat", "But Thats None Of My Business", "But Thats None Of My Business Neutral", "Butthurt Dweller", "CASHWAG Crew", "CURLEY", "Captain Hindsight", "Captain Phillips Im The Captain Now", "Captain Picard Facepalm", "Car Salesman Slaps Hood", "Casper", "Castaway Fire", "Ceiling Cat", "Cel Jesuno", "Cereal Guy", "Cereal Guy Spitting", "Cereal Guys Daddy", "Chad Johnson", "Chainsaw Bear", "Challenge Accepted Rage Face", "Change My Mind", "Charlie Sheen Derp", "Chavez", "Chef Gordon Ramsay", "Chemistry Cat", "Chester The Cat", "Chicken Bob", "Chief Keef", "Chihuahua dog", "Chill Out Lemur", "Chinese Cat", "Chocolate Spongebob", "Chubby Bubbles Girl", "Chuck Norris", "Chuck Norris Approves", "Chuck Norris Finger", "Chuck Norris Flex", "Chuck Norris Guns", "Chuck Norris Laughing", "Chuck Norris Phone", "Chuck Norris With Guns", "Chuckchuckchuck", "City Bear", "Cleavage Girl", "Clefable", "Close Enough", "Clown Applying Makeup", "College Freshman", "College Liberal", "Comic Book Guy", "Computer Guy", "Computer Guy Facepalm", "Computer Horse", "Condescending Goku", "Condescending Wonka", "Confession Bear", "Confused Cam", "Confused Gandalf", "Confused Granddad", "Confused Lebowski", "Confused Mel Gibson", "Conspiracy Keanu", "Consuela", "Contradictory Chris", "Cool Cat Stroll", "Cool Obama", "Cool Story Bro", "Corona", "Costanza", "Coulson", "Courage Wolf", "Crazy Dawg", "Crazy Girlfriend Praying Mantis", "Crazy Hispanic Man", "Creeper Dog", "Creepy Condescending Wonka", "Criana", "Crosseyed Goku", "Crying Because Of Cute", "Cute Cat", "Cute Dog", "Cute Puppies", "DJ Pauly D", "Dad Joke Dog", "Dafuq Did I Just Read", "Dallas Cowboys", "Dancing Trollmom", "Darth Maul", "Darti Boy", "Dat Ass", "Dat Boi", "Dating Site Murderer", "Dave Chappelle", "Dead Space", "Deadpool Pick Up Lines", "Deadpool Surprised", "Depressed Cat", "Depression Dog", "Derp", "Derpina", "Determined Guy Rage Face", "Dexter", "Dick Cheney", "Disappointed Tyson", "Disaster Girl", "Distracted Boyfriend", "Do I Care Doe", "Doge", "Doge 2", "Dolph Ziggler Sells", "Donald Trump sewing his name into the American Flag", "Dont You Squidward", "DoucheBag DJ", "Doug", "Down Syndrome", "Downcast Dark Souls", "Downvoting Roman", "Dr Crane", "Dr Evil", "Dr Evil Laser", "Drake Bad Good", "Drake Hotline Bling", "Drunk Baby", "Duck Face", "Duck Face Chicks", "Dumb Blonde", "Dwight Schrute", "Dwight Schrute 2", "ERMAHGERD TWERLERT", "Edu Camargo", "Edward Elric 1", "Efrain Juarez", "Eighties Teen", "Eminem", "Empty Red And Black", "Endel Tulviste", "Engineering Professor", "Epic Handshake", "Epicurist Kid", "Ermahgerd Berks", "Ermahgerd Beyonce", "Ermahgerd IPHERN 3GM", "Error 404", "Evil Baby", "Evil Cows", "Evil Kermit", "Evil Otter", "Evil Plotting Raccoon", "Evil Toddler", "Excited Cat", "Excited Minions", "Expanding Brain", "Eye Of Sauron", "FFFFFFFUUUUUUUUUUUU", "FRANGO", "Fabulous Frank And His Snake", "Face You Make Robert Downey Jr", "Facepalm Bear", "Fake Hurricane Guy", "Family Guy Brian", "Family Guy Peter", "Family Tech Support Guy", "Fast Furious Johnny Tran", "Fat Cat", "Fat Val Kilmer", "Father Ted", "Fear And Loathing Cat", "Feels Bad Frog   Feels Bad Man", "Felix Baumgartner", "Felix Baumgartner Lulz", "Fernando Litre", "Fifa E Call Of Duty", "Fim De Semana", "Finding Neverland", "Fini", "Finn The Human", "First Day On The Internet Kid", "First World Frat Guy", "First World Problems", "First World Problems Cat", "First World Stoner Problems", "Fk Yeah", "Flavor Flav", "Foal Of Mine", "Folean Dynamite", "Forever Alone", "Forever Alone Christmas", "Forever Alone Happy", "Foul Bachelor Frog", "Foul Bachelorette Frog", "Friend Zone Fiona", "Frowning Nun", "Frustrated Boromir", "Frustrating Mom", "Futurama Fry", "Futurama Leela", "Futurama Zoidberg", "Gaga Baby", "Gandhi", "Gangnam Style", "Gangnam Style PSY", "Gangnam Style2", "Gangster Baby", "Gasp Rage Face", "George Bush", "George Washington", "Ghetto Jesus", "Ghost Nappa", "Giovanni Vernia", "Give me Karma   Beating the dead horse", "Gladys Falcon", "God", "Gollum", "Good Fellas Hilarious", "Good Guy Greg", "Good Guy Pizza Rolls", "Good Guy Putin", "Good Guy Socially Awkward Penguin", "Google Chrome", "Gordo", "Got Room For One More", "Gotta Go Cat", "Grandma Finds The Internet", "Green Day", "Grumpy Cat", "Grumpy Cat Bed", "Grumpy Cat Birthday", "Grumpy Cat Christmas", "Grumpy Cat Does Not Believe", "Grumpy Cat Halloween", "Grumpy Cat Happy", "Grumpy Cat Mistletoe", "Grumpy Cat Not Amused", "Grumpy Cat Reverse", "Grumpy Cat Sky", "Grumpy Cat Star Wars", "Grumpy Cat Table", "Grumpy Cat Top Hat", "Grumpy Cats Father", "Grumpy Toad", "Grus Plan", "Guinness World Record", "Guy Fawkes", "Guy Holding Cardboard Sign", "Hal Jordan", "Hamtaro", "Han Solo", "Happy Guy Rage Face", "Happy Minaj", "Happy Minaj 2", "Happy Star Congratulations", "Hard To Swallow Pills", "Hardworking Guy", "Harley Quinn", "Harmless Scout Leader", "Harper WEF", "Harry Potter Ok", "Hawkward", "He Needs The Vaccine", "He Will Never Get A Girlfriend", "Headbanzer", "Headless Rider DRRR", "Heavy Breathing Cat", "Hedonism Bot", "Hello Kassem", "Hello Kitty", "Helpful Tyler Durden", "Henry David Thoreau", "Hercules Hades", "Heres Johnny", "Herm Edwards", "Hey Internet", "Hide Yo Kids Hide Yo Wife", "Hide the Pain Harold", "High Dog", "High Expectations Asian Father", "Hillary Clinton", "Hillary Clinton Cellphone", "Hipster Ariel", "Hipster Barista", "Hipster Kitty", "Hohoho", "Homophobic Seal", "Hoody Cat", "Hora Extra", "Hornist Hamster", "Horny Harry", "Hot Caleb", "Hot Scale", "Hotline Miami Richard", "House Bunny", "How About No Bear", "How Tough Are You", "Hypnotoad", "Hypocritical Islam Terrorist", "Hysterical Tom", "I Am Not A Gator Im A X", "I Bet Hes Thinking About Other Women", "I Forsee", "I Guarantee It", "I Have No Idea What I Am Doing", "I Have No Idea What I Am Doing Dog", "I Know Fuck Me Right", "I Know That Feel Bro", "I Lied 2", "I See Dead People", "I Should Buy A Boat Cat", "I Too Like To Live Dangerously", "I Was Told There Would Be", "I Will Find You And Kill You", "Idiot Nerd Girl", "Idiotaco", "If You Know What I Mean Bean", "Ill Have You Know Spongebob", "Ill Just Wait Here", "Im Curious Nappa", "Im Fabulous Adam", "Im The Captain Now", "Imagination Spongebob", "Impossibru Guy Original", "Inception", "Inhaling Seagull", "Inigo Montoya", "Innocent Sasha", "Insanity Puppy", "Insanity Wolf", "Intelligent Dog", "Internet Explorer", "Internet Guide", "Interupting Kanye", "Invalid Argument Vader", "Is This A Pigeon", "Islam Rage   Angry Muslim", "Its Finally Over", "Its Not Going To Happen", "Its True All of It Han Solo", "Jack Nicholson The Shining Snow", "Jack Sparrow Being Chased", "Jackie Chan WTF", "Jammin Baby", "Jay Knows Facts", "Jehovas Witness Squirrel", "Jerkoff Javert", "Jersey Santa", "Jessica Nigri Cosplay", "Jesus Talking To Cool Dude", "Jim Lehrer The Man", "Joe Biden", "John Riley Condescension", "Joker", "Joker Rainbow Hands", "Jon Stewart Skeptical", "Joo Espontneo", "Joseph Ducreux", "Justin Bieber Suit", "Karate Kid", "Karate Kyle", "Keep Calm And Carry On Aqua", "Keep Calm And Carry On Black", "Keep Calm And Carry On Purple", "Keep Calm And Carry On Red", "Kevin Hart", "Kevin Hart The Hell", "Kill You Cat", "Kill Yourself Guy", "Kim Jong Il Y U No", "Kim Jong Un Sad", "Koala", "Kobe", "Kool Kid Klan", "Krusty Krab Vs Chum Bucket", "Krusty Krab Vs Chum Bucket Blank", "Kyon Face Palm", "LIGAF", "LOL Guy", "Lame Pun Coon", "Larfleeze", "Larry The Cable Guy", "Laughing Goat", "Laughing Leo", "Laughing Men In Suits", "Laughing Villains", "Laundry Viking", "Lazy College Senior", "Left Exit 12 Off Ramp", "Legal Bill Murray", "Leonardo Dicaprio Cheers", "Leonardo Dicaprio Wolf Of Wall Street", "Lethal Weapon Danny Glover", "Lewandowski E Reus", "Liam Neeson Taken", "Liam Neeson Taken 2", "Life Sucks", "Lil Wayne", "Lion King", "Little Romney", "Look At All These", "Look At Me", "Look Son", "Luiz Fabiano", "Macklemore Thrift Store", "Mad Money Jim Cramer", "Mad Moxxi", "Malicious Advice Mallard", "Mamimoe", "Manning Broncos", "Mario Hammer Smash", "Marked Safe From", "Maroney And Obama Not Impressed", "Marvel Civil War", "Marvel Civil War 1", "Marvel Civil War 2", "Matanza", "Matrix Morpheus", "Maury Lie Detector", "Mayu Watanabe", "McKayla Maroney Not Impressed", "McKayla Maroney Not Impressed2", "McMelch", "Mega Rage Face", "Member Berries", "Meme Dad Creature", "Memeo", "Men In Black", "Men Laughing", "Merida Brave", "Metal Jesus", "Mexican Pizza", "Michael Jackson Popcorn", "Michael Phelps Death Stare", "Minegishi Minami", "Minegishi Minami2", "Minor Mistake Marvin", "Misunderstood Mitch", "Mitch McConnell", "Mocking Spongebob", "Modern Warfare 3", "Molly Weasley", "Money Man", "Money Money", "Monkey Business", "Monkey OOH", "Monkey Puppet", "Morgan Freeman Good Luck", "Morpheus", "Morty", "Mother Of God", "Mozart Not Sure", "Mr Black Knows Everything", "Mr Krabs Blur Meme", "Mr Mackey", "Mr T", "Mr T Pity The Fool", "Mugatu So Hot Right Now", "Multi Doge", "Murica", "Muschamp", "Musically Oblivious 8th Grader", "NPC", "Nabilah Jkt48", "Nailed It", "Nakagawa Haruka", "Natsu", "Neil deGrasse Tyson", "Net Noob", "Nice Guy Loki", "Nickleback", "Nicolas Cage   You dont say", "Nilo", "Nissim Ourfali", "No Bullshit Business Baby", "No I Cant Obama", "No Nappa Its A Trick", "No Patrick", "Not Bad Obama", "Not Okay Rage Face", "Not a Meme, Just Boobs", "Nuclear Explosion", "OMG Cat", "OMG Karen", "Obama", "Obama Cowboy Hat", "Obama No Listen", "Obama Romney Pointing", "Obi Wan Kenobi", "Oblivious Hot Girl", "Officer Cartman", "Oh My God Orange", "Oh No", "Okay Guy Rage Face", "Okay Guy Rage Face2", "Okay Truck", "Oku Manami", "Onde", "One Does Not Simply", "Oprah You Get A", "Oprah You Get A Car Everybody Gets A Car", "Optimistic Niall", "Ordinary Muslim Man", "Original Bad Luck Brian", "Original I Lied", "Original Stoner Dog", "Osabama", "Our Glorious Leader Nicolas Cage", "Over Educated Problems", "Overjoyed", "Overly Attached Father", "Overly Attached Girlfriend", "Overly Attached Nicolas Cage", "Overly Manly Man", "Overly Suave IT Guy", "PPAP", "PTSD Clarinet Boy", "Packers", "Panik Kalm Panik", "Papa Fking John", "Paranoid Parrot", "Pat Quinn", "Pathetic Spidey", "Patrick Bateman", "Patrick Henry", "Patrick Says", "Patriotic Eagle", "Paul Ryan", "Paul Wonder Years", "Pedobear", "Pedophile Orochimaru", "Pelosi", "Penguin Gang", "Pentagon Hexagon Octagon", "Pepperidge Farm Remembers", "Perfection Michael Fassbender", "Permission Bane", "Persian Cat Room Guardian", "Persian Cat Room Guardian Single", "Perturbed Portman", "Peter Griffin News", "Peter Parker Cry", "Philosoraptor", "Photogenic College Football Player", "Photogenic Scene Guy", "Picard Wtf", "Pickle Rick", "Pickup Line Panda", "Pickup Master", "Pickup Professor", "Pillow Pet", "Pink Escalade", "Pinky and the Brain", "Pissed Off Obama", "Police Officer Testifying", "Pony Shrugs", "Pope Nicolas Cage", "Portuguese", "Pothead Fry", "Predator", "Premature Pete", "Presidential Alert", "Priority Peter", "Professor Oak", "Proper Lady", "Psy Horse Dance", "Put It Somewhere Else Patrick", "Putin", "Question Rage Face", "Questionable Strategy Kobe", "Quit Hatin", "RPG Fan", "Rarity", "Rasta Science Teacher", "Really Evil College Teacher", "Rebecca Black", "Redditors Wife", "Rediculously Well Mannered Athlete", "Redneck Randal", "Reimu Hakurei", "Relaxed Office Guy", "Religious Couple", "Rena Matsui", "Rich Guy Dont Care", "Rich Raven", "Richard Benson", "Rick", "Rick Grimes", "Rick and Carl", "Rick and Carl 3", "Rick and Carl Long", "Rick and Carl Longer", "Ridiculously Photogenic Guy", "Ridiculously Photogenic Judge", "Right In The Childhood", "Rmoney Again", "Rob In The Hood", "Robots", "Rocket Raccoon", "Rodgers Doublecheck", "Roll Safe Think About It", "Romney", "Romney And Ryan", "Romney Bong", "Romneys Hindenberg", "Ron Burgundy", "Ron Swanson", "Running Away Balloon", "Ryan Gosling", "Sad Axl", "Sad Baby", "Sad Cat", "Sad Keanu", "Sad Pablo Escobar", "Sad Spiderman", "Sad X All The Y", "Sadly I Am Only An Eel", "Samuel Jackson Glance", "Samuel L Jackson", "Sarcastic Anthony", "Sassy Iguana", "Satisfied Seal", "Saw Fulla", "Say That Again I Dare You", "Scared Cat", "Scary Harry", "Scene Wolf", "Scooby Doo", "Scott Howson", "Scrooge McDuck", "Scrooge McDuck 2", "Scumbag Boss", "Scumbag Brain", "Scumbag Daylight Savings Time", "Scumbag Girl", "Scumbag Job Market", "Scumbag MSNBC", "Scumbag Minecraft", "Scumbag Miraak", "Scumbag Muslim", "Scumbag Parents", "Scumbag Redditor", "Scumbag Steve", "Secure Parking", "See Nobody Cares", "Self Loathing Otter", "Selfish Ozzy", "Sergeant Hartmann", "Serious Xzibit", "Seriously Face", "Sexual Deviant Walrus", "Sexually Oblivious Girlfriend", "Sexually Oblivious Rhino", "Sexy Railroad Spiderman", "Shaq Only Smokes The Dankest", "Sheltering Suburban Mom", "Shocked Ape", "Short Satisfaction VS Truth", "Shouter", "Shrek Cat", "Shut Up And Take My Money Fry", "Shutup Batty Boy", "Sidious Error", "Sigmund Freud", "Simba Shadowy Place", "Simpsons Grandpa", "Simsimi", "Since When Were You Under The Impression", "Sinestro", "Skeptical Baby", "Skeptical Swardson", "Skinhead John Travolta", "Skype", "Sleeping Shaq", "Slenderman", "Slick Fry", "Slowpoke", "Small Dog", "Small Face Romney", "Smilin Biden", "Smiling Cat", "Smiling Jesus", "Smirk Rage Face", "Smug Bear", "Snape", "Snoop", "So God Made A Farmer", "So I Got That Goin For Me Which Is Nice", "So I Got That Goin For Me Which Is Nice 2", "So I Guess You Can Say Things Are Getting Pretty Serious", "So Many Shirts", "So Much Drama", "Socially Awesome Awkward Penguin", "Socially Awesome Penguin", "Socially Awkward Awesome Penguin", "Socially Awkward Couple", "Socially Awkward Penguin", "Solemn Lumberjack", "SonTung", "Sotally Tober", "South Park Craig", "Spacey Casey", "Spangles", "Sparta Leonidas", "Speechless Colbert Face", "Spiderman Camera", "Spiderman Computer Desk", "Spiderman Hospital", "Spiderman Laugh", "Spiderman Peter Parker", "Sponegebob Coffee", "Spongebob Ight Imma Head Out", "Spongegar", "Squidward", "Star Wars No", "Star Wars Yoda", "Stephen Harper Podium", "Steve Harvey", "Steve Jobs", "Stoner Dog", "Stoner PhD", "Stop Cop", "Storytelling Grandpa", "Subtle Pickup Liner", "Success Kid", "Success Kid Girl", "Success Kid Original", "Successful Black Man", "Sudden Clarity Clarence", "Sudden Disgust Danny", "Super Birthday Squirrel", "Super Cool Ski Instructor", "Super Kami Guru Allows This", "Superior Wadsworth", "Surpised Frodo", "Surprised CatMan", "Surprised Coala", "Surprised Koala", "Surprised Pikachu", "Surprized Vegeta", "Suspicious Cat", "Sweaty Concentrated Rage Face", "TED", "TSA Douche", "Table Flip Guy", "Take A Seat Cat", "Talk To Spongebob", "Tamou", "Team Rocket", "Tears Of Joy", "Tech Impaired Duck", "Tennis Defeat", "Terry Davis", "That Would Be Great", "Thats Just Something X Say", "Thats a paddlin", "The Bobs", "The Critic", "The Most Interesting Cat In The World", "The Most Interesting Justin Bieber", "The Most Interesting Man In The World", "The Probelm Is", "The Problem Is", "The Rock Driving", "The Rock It Doesnt Matter", "The Scroll Of Truth", "These Arent The Droids You Were Looking For", "Theyre The Same Picture", "Think", "Third World Skeptical Kid", "Third World Success Kid", "This Is Fine", "This Is Where Id Put My Trophy If I Had One", "Thumbs Up Emoji", "Time To Fap", "Today Was A Good Day", "Tom Hardy", "Tomas Rosicky", "Too Damn High", "Too Drunk At Party Tina", "Too Kool Kyle", "Torreshit", "Tough Guy Wanna Be", "Trailer Park Boys Bubbles", "Travelonshark", "Troll Face", "Troll Face Colored", "True Story", "Trump Bill Signing", "Turkey", "Tuxedo Winnie The Pooh", "Two Buttons", "UNO Draw 25 Cards", "USA Lifter", "Ugly Twins", "Uncle Sam", "Unhappy Baby", "Unhelpful High School Teacher", "Unicorn MAN", "Unpopular Opinion Puffin", "Unsettled Tom", "Unwanted House Guest", "V For Vendetta", "Vali Corleone", "Vengeance Dad", "Viking Dudes", "Vladimir Putin", "WTF", "Waiting Skeleton", "Warning Sign", "We Will Rebuild", "Weird Stuff I Do Potoo", "Welcome To The Internets", "Well That Escalated Quickly", "What Do We Want", "What Do We Want 3", "What Year Is It", "Whisper Sloth", "Who Killed Hannibal", "Why Cant I", "Why Cant I Hold All These Limes", "Why Is The Rum Gone", "Why Not Both", "Will Ferrell", "Wink", "Woah Kitty", "Woman Yelling At Cat", "Wrong Neighboorhood Cats", "Wrong Number Rita", "X, X Everywhere", "X All The Y", "X Everywhere", "X X Everywhere", "Y U No", "Yakuza", "Yall Got Any More Of", "Yall Got Any More Of That", "Yao Ming", "Yo Dawg Heard You", "Yo Mamas So Fat", "You Dont Say", "You Dont Want No Part Of This", "You Get An X And You Get An X", "You Should Feel Bad Zoidberg", "You The Real MVP", "You The Real MVP 2", "You Underestimate My Power", "You Were The Chosen One Star Wars", "Young And Reckless", "Young Cardi B", "Youre Too Slow Sonic", "Yuko With Gun", "ZNMD", "Zoidberg Jesus", "Zombie Bad Luck Brian", "Zombie Overly Attached Girlfriend", "Zorg", "Zuckerberg", "Zura Janai Katsura Da", "confession kid"};
    }

    // DO not touch this method
    private void showDataInDropdown(String[] templateNames) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, templateNames);
        templateNameDropDown.setAdapter(adapter);
    }

    // Do not touch this method
    // Use this method to open preview screen
    private void openMemePreviewScreen(String memeImageUrl) {
        Intent intent = new Intent(this, MemePreviewScreen.class);
        intent.putExtra("MEME_IMAGE_URL", memeImageUrl);
        startActivity(intent);
    }

    // This will create the meme image url using ApiMeme.com
    private String createMemeImageUrl(String template, String topText, String bottomText) {
        return "https://apimeme.com/meme?meme=" + template + "&top=" + topText + "&bottom=" + bottomText;
    }

    @Override
    public void showScreen() {
        setContentView(R.layout.activity_main); // shows the UI on screen
        initComponents(); // This will create objects for all the ui components
        setupListeners(); // Setting listener for button click action
        showTitle("Meme Generator");
        showTemplateNamesDropDown();
    }

    @Override
    public void showTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void showTemplateNamesDropDown() {
        showDataInDropdown(createTemplateNames());
    }

    @Override
    public String getSelectedTemplateName() {
        return templateNameDropDown.getSelectedItem().toString();
    }

    @Override
    public String getTopText() {
        return topTextTxt.getText().toString();
    }

    @Override
    public String getBottomText() {
        return bottomTextTxt.getText().toString();
    }

    @Override
    public void onGenerateMemeClicked() {
        // TODO : open MemePreviewScreen with meme ImageUrl
    }
}
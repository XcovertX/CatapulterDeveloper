package gameObjects;

import java.awt.Color;

import body.Body;
import characteristics.Charisma;
import characteristics.Constitution;
import characteristics.Dexterity;
import characteristics.Intelligence;
import characteristics.Strength;
import characteristics.Wisdom;
import game.Game;
import verbs.Conversation;
import verbs.Fight;
import world.GameTile;

public class Actor extends ThingHolder {
	
	protected GameTile currentTile; // the tile where the Person is at present
	protected String actorSymbol;
	private String race;
	
	private Body body;
	
	protected double hitPoints;
	protected int thirst;
	protected int hunger;
	
	protected Strength strength;
	protected Dexterity dexterity;
	protected Constitution constitution;
	protected Intelligence intelligence;
	protected Wisdom wisdom;
	protected Charisma charisma;

	protected int decomposed;
	private int thirstCounter;
	private int hungerCounter;
	
	private boolean isAlive;
	private boolean isCorpse;
	private boolean isDecomposing;
	private boolean isEngagedInCombat;
	private boolean isEngagedInConversation;
	private boolean isWalking;
	private boolean isRunning;
	private boolean isWandering;
	
	private Fight fight; 					//current fight
	private Conversation conversation;		//current conversation
	protected long deathDate;
	

    public Actor( String aName, String aDescription, GameTile aGameTile, ThingList tList, String aActorSymbol ) {
    	
        super( aName, aDescription, tList ); 
        this.currentTile = aGameTile;
        this.setIsAlive( true );
        this.isActor = true;
        this.setThirst( 49 );
        this.setHitPoints( 5 );
        this.setHunger( 12 );
        this.setDecomposed( 100 );
        this.setActorSymbol(aActorSymbol);
        this.type = "Actor";
    }

    public Actor() {
    	
        super( "", "", new ThingList() ); 
        this.setIsAlive( true );
        this.isActor = true;
        this.setThirst( 49 );
        this.setHitPoints( 5 );
        this.setHunger( 12 );
        this.setDecomposed( 100 );
        this.type = "Actor";
	}
    
	public void setTile( GameTile aGameTile ) {
    	
        currentTile = aGameTile;
    }

    public GameTile getTile() {

        return this.currentTile;
    }

	public String getActorSymbol() {
		
		return actorSymbol;
	}

	public void setActorSymbol( String actorSymbol ) {
		
		this.actorSymbol = actorSymbol;
	}
	
	// TODO make some kind of verb list for other character 
	public void say( String words ) {
		Game.currentGame.getUI().printColor( this.toString(), Color.GREEN );
		Game.currentGame.getUI().printColor(" says: ", Color.YELLOW);
		Game.currentGame.getUI().println( "\"" + words + ".\"" );
	}
	
    public void setThirst( int tLevel ) {
    	
        this.thirst = tLevel;
    }

    public int getThirst() {

        return this.thirst;
    }
    
    public void setHunger( int hLevel ) {
    	
        this.hunger = hLevel;
    }

    public int getHunger() {

        return this.hunger;
    }

	public double getHitPoints() {
		
		return hitPoints;
	}

	public void setHitPoints( int hitPoints ) {
		
		this.hitPoints = hitPoints;
	}

	public boolean isAttackable() {
		return attackable;
	}

	public void setAttackable( boolean attackable ) {
		this.attackable = attackable;
	}

	public Strength getStrength() {
		return strength;
	}

	public void setStrength( Strength strength ) {
		this.strength = strength;
	}

	public Dexterity getDexterity() {
		return dexterity;
	}

	public void setDexterity( Dexterity dexterity ) {
		this.dexterity = dexterity;
	}

	public Constitution getConstitution() {
		return constitution;
	}

	public void setConstitution( Constitution constitution ) {
		this.constitution = constitution;
	}

	public Intelligence getIntelligence() {
		return intelligence;
	}

	public void setIntelligence( Intelligence intelligence ) {
		this.intelligence = intelligence;
	}

	public Wisdom getWisdom() {
		return wisdom;
	}

	public void setWisdom( Wisdom wisdom ) {
		this.wisdom = wisdom;
	}

	public Charisma getCharisma() {
		return charisma;
	}
	
	public void setIsAlive( boolean isAlive ) {
		this.isAlive = isAlive;
	}
	
	public boolean isAlive() {
		return this.isAlive;
	}
	
	public void setCharisma( Charisma charisma ) {
		this.charisma = charisma;
	}
	
	public void decrementHitPoints( double amount ) {
		this.hitPoints = hitPoints - amount;
	}
	
	public void incrementHunger( int amount ) {
		this.hunger = hunger + amount;
	}
	
	public void incrementThirst( int amount ) {
		this.thirst = thirst + amount;
	}
	
	public void die() {
		
		setIsAlive( false );
		setCorpse( true );
		setDeathDate( Game.calendar.getTick() );
		setDecomposed( 100 );
		setDecomposing( true );
		
	}
	
	public ThingList getInventory() {
		return this.things;
	}
	
	public void dropAll() {
		
		for(int i = 0; i < this.things.size(); i++) {
			this.getTile().getThings().add( this.things.remove( i ) );
		}
	}

	public boolean isCorpse() {
		return isCorpse;
	}

	public void setCorpse(boolean isCorpse) {
		this.isCorpse = isCorpse;
	}

	public boolean isDecomposing() {
		return isDecomposing;
	}

	public void setDecomposed(int decomposed) {
		this.decomposed = decomposed;
	}

	public long getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(long deathDate) {
		this.deathDate = deathDate;
	}

	public void setDecomposing(boolean isDecomposing) {
		this.isDecomposing = isDecomposing;
	}

	public boolean isEngagedInCombat() {
		return isEngagedInCombat;
	}

	public void setEngagedInCombat(boolean isEngagedInCombat) {
		this.isEngagedInCombat = isEngagedInCombat;
	}

	public boolean isWalking() {
		return isWalking;
	}

	public void setWalking(boolean isWalking) {
		this.isWalking = isWalking;
	}

	public boolean isWandering() {
		return isWandering;
	}

	public void setWandering(boolean isWandering) {
		this.isWandering = isWandering;
	}

	public Fight getFight() {
		return fight;
	}

	public void setFight(Fight fight) {
		this.fight = fight;
	}

	public boolean isEngagedInConversation() {
		return isEngagedInConversation;
	}

	public void setEngagedInConversation(boolean isEngagedInConversation) {
		this.isEngagedInConversation = isEngagedInConversation;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	public boolean isPlayer() {
		
		if( this.equals( Game.currentGame.getPlayer() ) ) {
			return true;
		} else {
			return false;
		}
	}

	public int getThirstCounter() {
		return thirstCounter;
	}

	public void setThirstCounter(int thirstCounter) {
		this.thirstCounter = thirstCounter;
	}

	public int getHungerCounter() {
		return hungerCounter;
	}

	public void setHungerCounter(int hungerCounter) {
		this.hungerCounter = hungerCounter;
	}
	
	public void incrementThirstCounter() {
		this.thirstCounter++;
	}
	
	public void incrementHungerCounter() {
		this.hungerCounter++;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}
    
}
 
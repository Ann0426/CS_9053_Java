package game;

public class ScoreRecord implements java.io.Serializable{

		  String name;
		  int Ace, Two, Three, Four, Five, Six,UpScore,UpBonus,UpGrand, 
		  ThreeOfKind,FourOfKind,Full,Small,Large ,Yahtzee,Bon,lowSec,GraTo;

		  public ScoreRecord(String name, int Ace, int Two,int Three, int Four, int Five, int Six,int UpScore,
				  int UpBonus,int UpGrand, 
				  int ThreeOfKind,int FourOfKind,int Full,int Small,int Large ,int Yahtzee,int Bon,int lowSec,int GraTo) {
		    this.name = name;
		    this.Ace = Ace;
		    this.Two = Two;
		    this.Three = Three;
		    this.Four = Four;
		    this.Five = Five;
		    this.Six = Six;
		    this.UpScore = UpScore;
		    this.UpBonus = UpBonus;
		    this.UpGrand = UpGrand;
		    this.ThreeOfKind = ThreeOfKind;
		    this.FourOfKind =FourOfKind;
		    this.Full = Full;
		    this.Small = Small;
		    this.Large = Large;
		    this.Yahtzee = Yahtzee;
		    this.Bon = Bon;
		    this.lowSec = lowSec;
		    this.GraTo = GraTo;
		  }

}

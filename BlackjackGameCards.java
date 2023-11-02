import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


class BlackjackGameWindow extends JFrame implements ActionListener{
	
	//First Array is values for all cards
	int[] values=new int[]{2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,2,3,4,5,6,7,8,9,10,10,10,10,11,0};
	ImageIcon[] ImagesOfCards=new ImageIcon[53];
	JButton DrawCard = new JButton("Draw Card");
	JButton Stand = new JButton("Stand");
	JButton Hit = new JButton ("Hit");
	//Betting chips with ImageIcon
	JButton Bet1= new JButton(new ImageIcon("Betting Chip 1.png"));
	JButton Bet5= new JButton(new ImageIcon("Betting Chip 5.png"));
	JButton Bet10= new JButton(new ImageIcon("Betting Chip 10.png"));
	JButton Bet50= new JButton(new ImageIcon("Betting Chip 50.png"));
	JButton Bet100= new JButton(new ImageIcon("Betting Chip 100.png"));
	JButton Bet500= new JButton(new ImageIcon("Betting Chip 500.png"));
	JButton BetUndo = new JButton(new ImageIcon("Undo betting.png"));
	
	JLabel temporaryCardBackside=new JLabel(); //The JLabel that will show the backside
	JLabel HiddenCard = new JLabel(); //Storing the hidden card in this label
	JLabel PlayerSumText = new JLabel();
	JLabel DealerSumText = new JLabel();
	JLabel CenterBlackjackText=new JLabel("BLACKJACK PAYS 3 TO 2");
	JLabel BettingText=new JLabel("Start Betting. You have: 2000 Current bet: 0");
	
	int presentCardindex = 0; //The element in the Array for the deck that will be used
	int PlayerSum = 0;
	int DealerSum = 0;
	int hiddenCardValue=0;
	double WinningAmount=0;
	boolean PlayerTurn =true;
	boolean UndoBetting = false;
	int PlayerAces=0;
	int DealerAces=0;
	int PlayerBettingLeft=2000;
	int PlayerChoosenBet=0;
	String WinningStatus = new String();
	Color colorBackground = new Color(114,225,80); //Green background used for all JPanels
	
	
	JPanel NorthPanel = new JPanel(new GridLayout(2,1,0,0));
		JPanel ButtonsPanel = new JPanel(new GridLayout(1, 2, 0, 0));
		JPanel BettingPanel = new JPanel(new FlowLayout());
	JPanel CenterPanel = new JPanel(new GridLayout(3,2,0,0));
		JPanel DealerCardPanel=new JPanel(new FlowLayout());
		JPanel CenterTextPanel = new JPanel(new GridLayout(1,1,0,0));
		JPanel PlayerCardPanel = new JPanel(new FlowLayout());
	JPanel CardDeckPanel = new JPanel(new GridLayout(2,1,0,0));
	JPanel PlayButtonPanel = new JPanel(new GridLayout(2,2,0,0));
	JPanel BettingChipsPanel = new JPanel(new GridLayout(7,1,1,0));
	
	JMenu menu;
	JMenuItem HelpOption;
	
	public BlackjackGameWindow(){
	
		super("Blackjack");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Container contentArea = getContentPane();
		contentArea.setBackground(colorBackground);
		
		//Creating the menu bar
		JMenuBar menubar=new JMenuBar();
		menu= new JMenu("Menu");
		HelpOption=new JMenuItem("Help");
		menu.add(HelpOption);
		menubar.add(menu);
		setJMenuBar(menubar);
	
		//Setting all panels to green
		ButtonsPanel.setBackground(colorBackground);
		BettingPanel.setBackground(colorBackground);
		DealerCardPanel.setBackground(colorBackground);
		CenterTextPanel.setBackground(colorBackground);
		PlayerCardPanel.setBackground(colorBackground);		
		CardDeckPanel.setBackground(colorBackground);
		BettingChipsPanel.setBackground(colorBackground);
		PlayButtonPanel.setBackground(colorBackground);
		
		
		
		DrawCard.addActionListener(this);
		Hit.addActionListener(this);
		Stand.addActionListener(this);
		Bet1.addActionListener(this);
		Bet5.addActionListener(this);
		Bet10.addActionListener(this);
		Bet50.addActionListener(this);
		Bet100.addActionListener(this);
		Bet500.addActionListener(this);
		BetUndo.addActionListener(this);
		HelpOption.addActionListener(this);
		
		/*North*/
		//Adding the Buttons and Text above 
		NorthPanel.add(ButtonsPanel);
		NorthPanel.add(BettingPanel);
		ButtonsPanel.add(DrawCard);
		DrawCard.setEnabled(false);	//Disabled before betting
		BettingPanel.add(BettingText);
		
		/*Center*/
		//The panel in the middle adds the panel for the dealer, player and the text of "Blackjack gives 3 to 2"
		CenterPanel.add(DealerCardPanel);
		CenterPanel.add(CenterTextPanel);
		CenterPanel.add(PlayerCardPanel);
		DealerCardPanel.add(DealerSumText);
		CenterTextPanel.add(CenterBlackjackText);
		
		/*East*/
		//Panel showing a picture of the deck and play buttons 
		CardDeckPanel.add(new JLabel(new ImageIcon("red_deck.png")));
		CardDeckPanel.add(PlayButtonPanel);
		//Adding the playing buttons and making them disabled before start
		PlayButtonPanel.add(Hit);
		PlayButtonPanel.add(Stand);
		Hit.setEnabled(false);
		Stand.setEnabled(false);
		
		/*West*/
		//Add the betting chips and making the button's background invisible
		BettingChipsPanel.add(Bet1);
		BettingChipsPanel.add(Bet5);
		BettingChipsPanel.add(Bet10);
		BettingChipsPanel.add(Bet50);
		BettingChipsPanel.add(Bet100);
		BettingChipsPanel.add(Bet500);
		BettingChipsPanel.add(BetUndo);
		
		//Removing fills and border of the buttons
		Bet1.setContentAreaFilled(false);
		Bet1.setBorderPainted(false);
		Bet5.setContentAreaFilled(false);
		Bet5.setBorderPainted(false);
		Bet10.setContentAreaFilled(false);
		Bet10.setBorderPainted(false);
		Bet50.setContentAreaFilled(false);
		Bet50.setBorderPainted(false);
		Bet100.setContentAreaFilled(false);
		Bet100.setBorderPainted(false);
		Bet500.setContentAreaFilled(false);
		Bet500.setBorderPainted(false);
		BetUndo.setContentAreaFilled(false);
		BetUndo.setBorderPainted(false);
		
		contentArea.add("North", NorthPanel);
		contentArea.add("Center", CenterPanel);
		contentArea.add("East",CardDeckPanel);
		contentArea.add("West",BettingChipsPanel);
		
		/*Changing the appearance of the text in the middle*/
		CenterBlackjackText.setFont(new Font(CenterBlackjackText.getName(),Font.PLAIN,50));
		CenterBlackjackText.setForeground(Color.YELLOW);
		CenterBlackjackText.setHorizontalAlignment(JLabel.CENTER);
		
		setContentPane(contentArea);
		DeckOfCard();	//Create the deck
		
		//Shuffles the deck using the method from Array class. 
		Array.shuffleImageIconArrayIntArray(ImagesOfCards,values);
		
		//Asking for the player's bet
		Betting(0);
		
	}
	
	
	
	/*Checks the players bet and how much it has left depending on the input value. 
	 *If the player has no money, the message would appear that they cannot bet anymore*/
	public void Betting(int BettingInput){
		if(PlayerBettingLeft>0){ //Only possible if the player has money
			int BettingUndoFactor = 1;
			if(UndoBetting){
				//The factor allows the player to remove betting chips when the factor is negative (inverse factor).
				BettingUndoFactor=-1;
			}
					
			PlayerBettingLeft=PlayerBettingLeft-BettingInput*BettingUndoFactor;
			PlayerChoosenBet=PlayerChoosenBet+BettingInput*BettingUndoFactor;
			BettingText.setText("You have: "+PlayerBettingLeft+" Current bet: "+PlayerChoosenBet);
			BettingText.setHorizontalAlignment(JLabel.CENTER);
			UndoBetting=false;
			if(PlayerChoosenBet>0){
				//The player is allowed to start playing when bet is larger than 0 and the button is enabled
				DrawCard.setEnabled(true);
			}
			else DrawCard.setEnabled(false); //Or else it is turned off.
		}
		else
			BettingText.setText("You cannot bet more. "+BettingText.getText());	//When it does not have money
		
	}
	
	/*Creates a String as the filename with help of the arrays with all the characters, which is used to identify correct image and 
	 *upload it and insert them into an array of ImageIcon by the file name.
	 *The uploading is done by the loop together with the file name, where the loop changes out the face every time and the suit every 13th card.
	 *A 53rd card as null exists in the end, which is the "shuffle card"
	 *The Array with match up with the array with all the values*/
	public void DeckOfCard(){
		int CardNumber=0;
		String[] faces = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String[] suits=new String[]{"C","D","H","S"};
		for(int SuitsIndex=0;SuitsIndex<4;SuitsIndex++){	//Every round the suit is changed
			for (int FaceIndex=0;FaceIndex<13;FaceIndex++){	//Every round the face is changed
				String FileName=faces[FaceIndex]+suits[SuitsIndex]+".png";	//Adding .png to say which kind of file it is
				ImagesOfCards[CardNumber]=new ImageIcon(FileName);	//The image is uploaded and inserted into the Array at that specific element/index (CardNumber)
				CardNumber++;
			}
		}
	}
	
	/*Deals the card by taking the image of the card from its array and is placed onto a new JLabel, which is displayed in the player's/dealer's panel. 
	 *Afterwards, it counts the sum with help of the array with values and changes the counter to show the next card for next time. 
	 *The program knows if it's player's or dealer's turn depending on the boolean PlayerTurn. */
	public void DealingCard(int NumberCard){
		/*If the shuffle card is detected, when the element is null, the deck will shuffle again and output that
		 *the deck has been shuffled. The next card will be taken from the top, because presentCardindex is reset.*/
		if(values[presentCardindex]==0){
			Array.shuffleImageIconArrayIntArray(ImagesOfCards,values);
			BettingText.setText(BettingText.getText()+" The deck is shuffled");
			presentCardindex=0;
		}
			
		/*Player's turn*/
		if(PlayerTurn){
			if(values[presentCardindex]==11){
				PlayerAces++;	//Counts player's aces when received
			}
			PlayerCardPanel.add(new JLabel(ImagesOfCards[presentCardindex]));
			PlayerSum = PlayerSum + values[presentCardindex];
			
			//Reduces the sum by 10 if the the sum is over 21
			if(PlayerSum>21){
				PlayerSum=PlayerSum-10*PlayerAces; //Number of aces the player has, allows the sum to be reduced by 10 times the number of aces
				PlayerAces=0;
			}
		}
		
		/*Dealer's turn*/
		if(!PlayerTurn){
			if(values[presentCardindex]==11){
				DealerAces++;	//Counts dealer's aces
			}
			//The second card is stored in HiddenCard, while a picture of the card's backside is displayed (temporary).
			//Else, the new card is displayed
			if(NumberCard==2){
				temporaryCardBackside.setIcon(new ImageIcon("red_back.png"));
				DealerCardPanel.add(temporaryCardBackside);	//The seen card added to the panel
				HiddenCard.setIcon(ImagesOfCards[presentCardindex]);	//The hidden card
				hiddenCardValue=values[presentCardindex];	//Stores the card's value to be added later
			}
			else{
			DealerCardPanel.add(new JLabel(ImagesOfCards[presentCardindex]));
			DealerSum=DealerSum+values[presentCardindex];
			}
			
			//Reduces the sum by 10 if the the sum is over 21
			if(DealerSum>21){
				DealerSum=DealerSum-10*DealerAces;	//Subtracts by 10 depending on how many aces are in hand
				DealerAces=0;
			}
		}
		presentCardindex++;
	}
	
	//The dialog shows who won the game and asks if the player wants to continue. The game will end if it presses No, 
	//If yes, the game will reset and continue.
	public void EndingDialog(){
		Object[] options = {"Yes","No",};
		int ButtonOption= JOptionPane.showOptionDialog(null, WinningStatus+"\nContinue?", "End", 
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		if(ButtonOption==0){
			Reset();	//Resetting the game
		}
		if(ButtonOption==1){
			System.exit(0);	//Closing program
		}
	}
	
	public void Reset(){
		PlayerTurn=true;
		DrawCard.setEnabled(false);
		Hit.setEnabled(false);
		Stand.setEnabled(false);
		BettingChipsPanel.setVisible(true);
		PlayerSum=0;
		DealerSum=0;
		DealerAces=0;
		PlayerAces=0;
		PlayerChoosenBet=0;
		PlayerCardPanel.removeAll();
		PlayerCardPanel.repaint();
		DealerCardPanel.removeAll();
		DealerCardPanel.repaint();
		PlayerSumText.setText("");
		DealerSumText.setText("");
		BettingText.setText("Start Betting. You have: "+PlayerBettingLeft+" Current bet: "+PlayerChoosenBet);
	}
	
	/*The game calculate who won the game depending on the various scenarios and will output a String 
	 *that is used in the method EndingDialog.*/
	public void FinishMoment(){
		/*If Player wins*/
		if(PlayerSum>DealerSum&&PlayerSum<=21||DealerSum>21){
			WinningStatus=("You won!");
			//Busted scenario
			if(DealerSum>21){
				WinningStatus=("Dealer busted. "+WinningStatus);
				WinningAmount=PlayerChoosenBet; //Player is rewarded what it bet
			}
			//Player's Blackjack
			if(PlayerSum==21){
				WinningStatus=("Blackjack! "+WinningStatus);
				WinningAmount=PlayerChoosenBet*1.5; //Player is rewarded 150% of its bet
			}
			
			PlayerBettingLeft+=PlayerChoosenBet+WinningAmount;
		}
		
		/*If Dealer wins*/
		if(PlayerSum<DealerSum&&DealerSum<=21||PlayerSum>21){
			WinningStatus=("Dealer won!");
			//Busted scenario
			if(PlayerSum>21){
				WinningStatus=("Player busted. "+WinningStatus);
			}
			//Dealer's Blackjack
			if(DealerSum==21){
				WinningStatus=("Blackjack! "+WinningStatus);
			}
			
			PlayerBettingLeft-=PlayerChoosenBet;
		}
		
		/*If it's tie*/
		if(PlayerSum==DealerSum){
			WinningStatus=("Tie");
			PlayerBettingLeft=PlayerBettingLeft+PlayerChoosenBet;
		}

		EndingDialog(); //Prompts/opens up the dialog of who won.
	}

	//Display a guide on how to play the game.
	public void HelpDialog(){
		JOptionPane.showMessageDialog(null,"The aim of the game is to beat the dealer by getting 21 as close as possible without" +
				"							\nsurpassing 21. In that case, you have busted. " +
				"							\n\nBetting:" +
				"							\nBefore starting, you will be asked to place your bet by pressing the different betting chips." +
				"							\nYou start with 2000 and will increase as the game goes on. If you want to lower your bet," +
				"							\nyou can do so by pressing the blue undo icon, and then the desired amount by pressing the chips." +
				"							\n\nStart:" +
				"							\nWhen you are done, press Draw Card to get your first two cards and the dealer gets two where" +
				"							\nwhere one is shown. Your and the dealers sum will be shown to the left of the cards." +
				"							\nThe cards value are their faces, Jacks, Queens and King are worth 10 and Ace is 11 or 1 depending" +
				"							\non what is suitable to not bust. Thereafter, you will have two options: Hit or Stand." +
				"							\n\nHit:" +
				"							\nBy pressing Hit, you will be dealt another card. Make sure your sum does not surpass 21," +
				"							\nor else you will lose your bet." +
				"							\n\nStand:" +
				"							\nBy pressing Stand, you will pass and the dealer will show its cards. If it has a sum lower than" +
				"							\n17, it will take more cards until it has minimum 17." +
				"							\n\nEnding:" +
				"							\nThe winner is decided depending on who has larger sum or is not busted." +
				"							\nIf you win you will earn double of your bet. If you get Blackjack or 21, you will get 150%" +
				"							\nof your bet. You will lose your bet if you lose.");
	}
	
	//Betting buttons when pressed
	public void actionPerformed(ActionEvent event) {
		if(event.getSource()==HelpOption){
			//Displays the guidelines of the game.
			HelpDialog();
		}
		
		//Betting chips
		if(event.getSource()==Bet1){
			Betting(1);
		}
		if(event.getSource()==Bet5){
			Betting(5);
		}
		if(event.getSource()==Bet10){
			Betting(10);
		}
		if(event.getSource()==Bet50){
			Betting(50);
		}
		if(event.getSource()==Bet100){
			Betting(100);
		}
		if(event.getSource()==Bet500){
			Betting(500);
		}
		/*When pressed once, the player can lower its bet by first pressing this button and one chip.*/
		if(event.getSource()==BetUndo){
			UndoBetting=true;
		}
		
		
		
		/*When the player starts, two cards are dealt and the sum as JLabel is displayed to the left. 
		The hit and stand buttons are displayed and can be pressed after the player's choice.*/
		if (event.getSource()== DrawCard){
			BettingText.setText("You have: "+PlayerBettingLeft+" Current bet: "+PlayerChoosenBet);
			DrawCard.setEnabled(false);
			Hit.setEnabled(true);
			Stand.setEnabled(true);
			BettingChipsPanel.setVisible(false);
			PlayerCardPanel.add(PlayerSumText);
			DealerCardPanel.add(DealerSumText);
			//Dealing two cards
			for(int NumberCard=1;NumberCard<=2;NumberCard++){
				DealingCard(NumberCard);			
				PlayerSumText.setText(Integer.toString(PlayerSum));
			}
						
			//Changes to dealer's turn from here and the dealer is dealt two cards. Dealer's sum is also displayed
			PlayerTurn=false;
			for(int NumberCard=1;NumberCard<=2;NumberCard++){
				DealingCard(NumberCard);
			}
			DealerSumText.setText(Integer.toString(DealerSum));
		}
		
		/*When the player wants to Hit, a card is dealt and the sum is updated. The program controls if the player busts 
		 *and it cannot use the hit button.*/
		if(event.getSource()==Hit){
			PlayerTurn=true;
			DealingCard(0);
			PlayerSumText.setText(Integer.toString(PlayerSum));
			//When the player busts
			if(PlayerSum>21){
				Hit.setEnabled(false);
				WinningStatus=("Player busted. Dealer Won.");
				EndingDialog();
			}
		}
		
		/*When the player chooses to Stand, the boolean changes and the hidden card is displayed. 
		 *The dealer pulls cards until it has more than 16 and it's sum is updated. 
		 *In the end the game goes through the finishing processes and displays the winner*/
		if(event.getSource()==Stand){
			PlayerTurn=false;
			temporaryCardBackside.setIcon(HiddenCard.getIcon());	//Displaying the hidden card
			DealerSum=DealerSum+hiddenCardValue;	//Adds the hidden card's value
			
			//Dealing card until it has more than 16
			if(DealerSum<16){
			do{
				DealingCard(0);
			}while(DealerSum<16);}
			DealerSumText.setText(Integer.toString(DealerSum));
			
			FinishMoment();
		}
	}
}

public class BlackjackGameCards {
	
	public static void main(String[] args) {
		new BlackjackGameWindow();
	}

}


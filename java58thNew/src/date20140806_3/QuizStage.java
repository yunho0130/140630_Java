package date20140806_3;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizStage {
	
	private QuizManager manager1 = new QuizManager();
	private ChanceManager chance1 = new ChanceManager();
	private String userName;
	private Quiz currentQuiz;
	private boolean oxValue;
	private int userMoney;
	
	

	Scanner sc = new Scanner (System.in); 
	
	public QuizStage() throws InterruptedException{
		//this.phoneChance();
		this.createUser();
		this.solveQuestions();
	}
	
	
	public void showAllChance(){
		int cnt = 0;
		for (Chance item : chance1.getArr()){
			cnt++;
			System.out.println(cnt + "λ²? : " + item);
		}
	}
	
	
	
	
	public boolean nextOrStop(){
		System.out.println("?€?λ¬Έμ  ? κ±°λ©΄ 1 , κ·Έλ§? κΊΌλ©΄ 0 ");
		String goNext = sc.nextLine();
		if (goNext.equals("1")){
			System.out.println("?€?λ¬Έμ λ‘? κ°λ€.");
			return true;
		}
			System.out.println("μ’λ£?©??€.");
			return false;
	}
	
	public void createUser(){
		System.out.println("?΄μ¦?Ό? ?€? κ±? ???©??€. ");
		System.out.print("?΄λ¦μ ?? ₯??Έ? : ");
		userName = sc.nextLine();
		System.out.println(userName + " ? ??");
	}
	
	public void showQuestion(Quiz quiz1){
		System.out.println(quiz1.getOrd() + "λ²? λ¬Έμ ???€. λ¬Έμ  ?κΈ? : " + quiz1.getRewards() + "?");
		System.out.println(quiz1.getQuestion());
	}
	
	public String askAnswer(){
		System.out.print("?΅? ?? ₯?΄μ£ΌμΈ?: ");
		String userAnswer = sc.nextLine();
		return userAnswer;
	}
	
	
	public int addMoney(int amount){
		this.userMoney = this.userMoney + amount;
		System.out.println("??¬ ?κΈμ? " + this.userMoney + "???€.");
		return this.userMoney;
	}
	
	
	public void phoneChance() throws InterruptedException {
		      Timer t = new Timer(true);
		      //TimerTask task1 = new MyTimeTask();
		      System.out.println("? ??΄μ¦? 30μ΄κ° μ§ν?©??€.");
//		      t.schedule(task1, 0);
		      double countSec = 0;
		      for (double i = 0; i < 300 ; i++) {
		         countSec = i/10;
		         System.out.println("30μ΄κ? ?λ©? ??©??€: "+countSec+"μ΄?");
		         Thread.sleep(100); //1000?΄ 1μ΄? // ?€??κΉμ? ??κΈ?
		      }
		      System.out.println("?΄?  ? ??΄μ¦λ₯? μ’λ£?©??€.");
		      return;
		   }
	
	
	public void solveQuestions() throws InterruptedException{
		Chance chanceInstance = null;
		currentQuiz = manager1.getNextQuiz();
		this.showQuestion(currentQuiz);
		
		System.out.println("μ°¬μ€λ₯? ?°?κ² μ΅?κΉ??");
		if(sc.nextLine().equals("y")){
			this.showAllChance();
			System.out.println("?°κ³ μΆ?? μ°¬μ€? λ²νΈλ₯? ?? ₯?΄μ£ΌμΈ?");
			int userResponse = Integer.parseInt(sc.nextLine());
			chanceInstance = chance1.getSelectedChance(userResponse);
			chanceInstance.chanceEvent(currentQuiz);
		}
		
		if((chanceInstance.getClass().getName()).equals("date20140806.EraserChance")){
			for(int i = 0; i < 2; i++){
				if((((EraserChance)chanceInstance).getResult(currentQuiz))){
					this.solveQuestions();
				}else if(i == 1){
					System.out.println("λͺ¨λ  κΈ°ν ?€ ?°?¨?Ό? ?€?κΈ°ν? ?? ??Έ?!!");
					return;
				}
			}
		}else{
			 if((chanceInstance.getClass().getName()).equals("date20140806.ARSChance")){
					this.phoneChance();
				}
			oxValue = currentQuiz.checkAnswer(this.askAnswer());
			if (oxValue){
				System.out.println("? ?΅!");
				this.addMoney(currentQuiz.getRewards());
				if (manager1.getArr().length == manager1.getIdx())
				{
					System.out.println("μ€?λΉλ ?΄μ¦λ₯? ? λΆ? λ§μΆ?¨?΅??€. μΆν?©??€.");
					return;
				}
				if(!this.nextOrStop()){
					return;
				}
			}
			else{
				System.out.println("?€?΅! ?€?κΈ°ν?...");
				return;
			}
			this.solveQuestions();
		}
	}
}

package brickbreak;

import javax.swing.JFrame;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("to play brick breack, press 1, to play pong, press 2.");
		int option = sc.nextInt();
		while (option<1 || option >2) {
			System.out.println("select either 1 or 2");
			
			option = sc.nextInt();
		}
		
		if(option==1) {
		JFrame obj =  new JFrame();
		Gameplay gameplay = new Gameplay();
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Breakout Ball");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
	}
//		else if(option==2){
//			JFrame obj =  new JFrame();
//			PongGameplay gameplay = new PongGameplay();
//			obj.setBounds(10, 10, 700, 600);
//			obj.setTitle("Pong");
//			obj.setResizable(false);
//			obj.setVisible(true);
//			obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			obj.add(gameplay);
//		}
}

}
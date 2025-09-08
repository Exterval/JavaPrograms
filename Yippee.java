import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Yippee {
    public static void main(String[] args) throws LineUnavailableException, IOException, UnsupportedAudioFileException, InterruptedException {
        // make a program that will produce a celebration sound when
        // when the user chooses the right choice

        int sum, choice = 0; //initialization of sum and choice

        Scanner in = new Scanner(System.in); //allows input
        File file = new File("Yippeee.wav"); //allows program to access file to celebration sound
        AudioInputStream audio = AudioSystem.getAudioInputStream(file); //allows program to play sound, initializes the .wav file, keep in mind .mp3 does not work on Java
        Clip clip = AudioSystem.getClip(); //kinda the same as audioinputstream except it can load and play the sound

        clip.open(audio); // accessing the audio file
        System.out.println("Welcome!");
        System.out.println("Please enter x and y: ");

        int x = in.nextInt(); //input for x
        int y = in.nextInt(); //input for y
        sum = x + y;

        while(choice != sum){ //loops when input is not equal to the sum of two integers
            System.out.println("What is the sum of x and y?");
            choice = in.nextInt();
        }

      System.out.println("Good job! :)");  
      clip.start(); //plays the sound
      Thread.sleep(1300); //lets program play sound fully, does not terminate immediately
    }
}

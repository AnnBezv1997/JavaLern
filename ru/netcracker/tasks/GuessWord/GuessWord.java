package ru.netcracker.tasks.GuessWord;
import java.util.*;
import java.io.*;
/**
 * Приложение загадывает слово выбирая случайное из специального банка. Банк
 * реализуется как массив в памяти и задается кодом. Пользователь угадывает слово через
 * интерфейс командной строки вводя по 1 букве или слово целиком если уже готов угадать.
 * Если игрок вводит слово и оно неправильное, то он автоматом проигрывает.
 * Пример взаимодействия с игрой:
 * Key in one character or your guess word: t
 * Trial 1: t__t___
 * Key in one character or your guess word: g
 * Trial 2: t__t__g
 * Key in one character or your guess word: e
 * Trial 3: te_t__g
 * Key in one character or your guess word: testing
 * Congratulation!
 * You got in 4 trials
 */
public class GuessWord {
    private String[] words =wordsPut();
    private String word = words[(int) (Math.random() * words.length)];
    private String mask = new String(new char[word.length()]).replace("\0", "_");
    private int count = 0;


    public  void gameStart() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Guess any letter in a word or the whole word " + mask.replace("_"," _ "));
        while ( mask.contains("_")) {
            count++;
            System.out.println("Key in one character or your guess word: ");
            String guess = sc.next();
            checkValue(guess);
        }

        sc.close();
    }

    public String readFiles(){
        String fileName = "F:/java/IDEA18/testJUNIT/src/main/java/ru/netcracker/tasks/GuessWord/bank_words.txt";
        String str = "";
        try(BufferedReader buf = new BufferedReader(new FileReader(fileName))) {
            String s;
            while((s= buf.readLine()) != null){
                str = s;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        return str;
    }
    public String[] wordsPut(){
        String str = readFiles();
        String[] tempWords = str.toLowerCase().split(" ");
        return tempWords;
    }

    public void checkValue(String guess) {
        String newmask = "";
        if(guess.length() > 2){

            if(word.equals(guess)) {
                newmask = guess;
                mask = newmask;

            }else {
                mask = mask.replaceAll("_","");
                System.out.println("GAME OVER! The word was: " + word);

            }
        } else {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess.charAt(0)) {
                    newmask += guess.charAt(0);
                } else if (mask.charAt(i) != '_') {
                    newmask += word.charAt(i);
                } else {
                    newmask += "_";
                }
            }
            if (!mask.equals(newmask)) {
                mask = newmask;
            }
            System.out.println("Trial "+count+ ":" + mask);
        }

        if (mask.equals(word)) {
            System.out.println("Congratulation!  " + word +"!");
            System.out.println("You got in "+ count +" trials");
        }

    }
    }


package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ls.LSOutput;


/**
* This program counts the sum and the number of prime (int) numbers in interval 0-1000
*/
public class Prime {

	List<Integer> primes = new ArrayList<>();
    private int count = 0;
    private int sumOfPrimes = 0;
    private int counter = 2;
    
    public int getUserInput() {
    	Scanner scan = new Scanner(System.in);
		
		try {
			System.out.println("Mata in första talet: ");
			int firstNumber = scan.nextInt();
			
			System.out.println("Mata in andra talet: ");
			int secondNumber = scan.nextInt();
			
			if(firstNumber >= 0 && firstNumber < 1000 && secondNumber > 0 && secondNumber < 1001) {
				calculatePrimes(firstNumber, secondNumber);
				printCount(firstNumber, secondNumber);
		        printSum();
		        
			}else {
				System.out.println("Hoppsan, fel intervall angivet!");
				count = -1;
			}
			
		} catch (Exception e) {
			System.out.println("Hoppsan, fel format angivet!");
			count = -1;
		}
		
		scan.close();
		
		return count;
		
    }
    
    public Prime() {
    }

    public boolean numIsPrime(int current, int counter) {
        if (counter >= current) {
            return true;
        }

        if (current % counter == 0) {
            return false;
        }

        return numIsPrime(current, ++counter);
    }
    
    public int printCount(int firstNumber, int secondNumber) {
        System.out.println("Hej, det finns " + count + " primtal mellan " + firstNumber + " och " + secondNumber + "!");
        return count;
    }

    public int printSum() {
        System.out.println("Och den totala summan av dessa primtal är " + sumOfPrimes + ".");
        return sumOfPrimes;
    }

    public int calculatePrimes(int current, int stop) {
        if (current > stop) {
            for(int prime : primes) {
            	System.out.println(prime);
            }
        } else if (numIsPrime(current, counter) && current != 0 && current != 1) {
            primes.add(current);
            ++count;
            sumOfPrimes += current;
            calculatePrimes(++current, stop);
        } else {
        	calculatePrimes(++current, stop);
        }
        return sumOfPrimes;
    }

    public List<Integer> getPrimes() {
        return primes;
    }
    
//    public static void main(String[] args) {
//		Prime prime = new Prime();
//		prime.getUserInput();
//	}
}

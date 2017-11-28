package cipher;

import java.util.Random;
import java.util.Scanner;

public class Cipher {
	public static final char[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' '};

	
	public static void main(String[] args) {

		System.out.println("Please enter a string of characters.");
		Scanner input = new Scanner(System.in);
		String plainT = input.next();
		plainT = plainT.toLowerCase();
		char[] textArray = plainT.toCharArray();

		char[] cipherArray = createCipher();
		char[] encryptedText = encrypt(textArray, cipherArray);
		char[] check = crypt(encryptedText, cipherArray);
		input.close();
		String encryptString = new String(encryptedText);
		String checkString = new String(check);
		System.out.println("The encrypted text is: " + encryptString);
		System.out.println("The crypted text is: " + checkString);
	}

	public static char[] createCipher() {

		{
			Random generator = new Random();
			char[] cipherArray = new char[alphabet.length];

			System.arraycopy(alphabet, 0, cipherArray, 0, 26);
			char temporary = ' ';
			for (int i = 0; i < cipherArray.length; i++) {

				int randomIndex = generator.nextInt(alphabet.length);
				temporary = cipherArray[i];
				cipherArray[i] = cipherArray[randomIndex];
				cipherArray[randomIndex] = temporary;
				

			}

			return cipherArray;
		}

	}

	public static char[] encrypt(char[] text, char[] cipherArray) {
		char[] encryptedText = new char[text.length];

		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < cipherArray.length; j++) {
				if (text[i] == alphabet[j]) {
					encryptedText[i] = cipherArray[j];
				}
			}
		}

		return encryptedText;

	}

	public static char[] crypt(char[] encryptedText, char[] cipherArray) {
		char[] text = new char[encryptedText.length];
		for (int i = 0; i < text.length; i++) {
			for (int j = 0; j < cipherArray.length; j++) {
				if (encryptedText[i] == cipherArray[j]) {
					text[i] = alphabet[j];
				}
			}
		}

		return text;

	}
}

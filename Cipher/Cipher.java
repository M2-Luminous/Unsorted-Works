import java.util.Random;
import java.util.Scanner;

public class Cipher {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		final char[] PLAIN_CHARACTERS = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
				'v', 'w', 'x', 'y', 'z', ' ', '.', ',', '\'', '"', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
				'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
			char[] cipherCharacters = createCipher(PLAIN_CHARACTERS);
			Scanner input = new Scanner( System.in );
			boolean quit = false;
				while (!quit)
				{
					System.out.print("Enter sentence to be encrypted or decrypted (or enter quit): ");
					String sentence = input.nextLine();
					if (!sentence.toLowerCase().equals("quit"))
					{
						String encryptedSentence = encryptOrDecrypt(sentence, PLAIN_CHARACTERS, cipherCharacters);
						System.out.println("The encrypted sentence is '" + encryptedSentence + "'");
						String decryptedSentence = encryptOrDecrypt(sentence, cipherCharacters, PLAIN_CHARACTERS);
						System.out.println("The decrypted sentence is '" + decryptedSentence + "'");
					}
						else quit = true;
					}
						input.close();
	}
	
	public static char[] createCipher( char[] plainCharacters )
	{
			char[] cipherCharacters = plainCharacters.clone();
			Random generator = new Random();
			for (int index=0; index<cipherCharacters.length; index++)
			{
				int otherIndex = generator.nextInt(cipherCharacters.length);
				char temp = cipherCharacters[index];
				cipherCharacters[index] = cipherCharacters[otherIndex];
				cipherCharacters[otherIndex] = temp;
			}
			return cipherCharacters;
	}
	public static String encryptOrDecrypt( String phrase, char[] fromCharacters, char[] toCharacters )
		{
			char[] remappedPhrase = new char[phrase.length()];
			for (int phraseIndex=0; phraseIndex<phrase.length(); phraseIndex++)
			{
				int mappingIndex=0;
				while ((mappingIndex < fromCharacters.length) &&
						(fromCharacters[mappingIndex] != phrase.charAt(phraseIndex)))
				{
					mappingIndex++;
				}
				remappedPhrase[phraseIndex] = (mappingIndex < fromCharacters.length) ?
						toCharacters[mappingIndex] : phrase.charAt(phraseIndex);
			}
			return new String( remappedPhrase );
		}
}

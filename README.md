# AES File Encryption in Java

A console program in Java that encrypts and decrypts text files with AES. I made it for a CA in the first semester of second year at DkIT (November 2024).

## What it does

From the menu you choose to encrypt or decrypt a file. When you encrypt, the program creates a new random 128 bit key with SecureRandom, encrypts the file into ciphertext.txt and shows the key in Base64 so you can save it. To decrypt you give it the encrypted file and the key, and it writes the original text back to plaintext.txt. If the key is not valid Base64 or is the wrong key, it shows an error instead of crashing.

```
Menu:
1. Encrypt a File
2. Decrypt a File
3. Quit
```

## How it's built

All the crypto is in AESUtility.java. It uses javax.crypto.Cipher with a SecretKeySpec, and the file is read and written in blocks through the cipher with streams, so it also works with bigger files. Main.java only has the menu and the input checks.

One thing I would change now: Cipher.getInstance("AES") uses ECB mode by default, which encrypts the same block of text to the same output every time. For real use it should be AES/GCM with a random IV saved together with the ciphertext.

## How to run it

You need Java 17 or newer.

```
git clone https://github.com/hypzx2105/AES_Encryption_CA2.git
cd AES_Encryption_CA2
javac -d out src/*.java
java -cp out Main
```

Choose option 1 and type plaintext.txt to try it with the sample file. You can also open the folder in IntelliJ and run Main.

Iker Arza, DkIT, BSc in Computing in Software Development

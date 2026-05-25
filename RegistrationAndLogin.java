/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.registrationandlogin;



import java.util.Scanner;

public class RegistrationAndLogin {

    // Username validation
    public static boolean checkUserName(String userName) {

        return userName.contains("_") && userName.length() <= 5;
    }

    // Password validation
    public static boolean checkPasswordComplexity(String passWord) {

        return passWord.length() >= 8
                && passWord.matches(".*[A-Z].*")
                && passWord.matches(".*[0-9].*")
                && passWord.matches(".*[!@#$%^&*()].*");
    }

    // Phone number validation
    public static boolean checkPhoneNumberComplexity(String cellPhoneNumber) {

        return cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== REGISTER USER =====");

        System.out.print("Enter First Name: ");
        String firstName = input.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = input.nextLine();

        // USERNAME
        String userName;

        do {

            System.out.print("Enter Username: ");
            userName = input.nextLine();

            if (!checkUserName(userName)) {

                System.out.println("Username is not correctly formatted.");
            }

        } while (!checkUserName(userName));

        System.out.println("Username successfully captured.");

        // PASSWORD
        String passWord;

        do {

            System.out.print("Enter Password: ");
            passWord = input.nextLine();

            if (!checkPasswordComplexity(passWord)) {

                System.out.println(" Password is not correctly formatted.Password must contain: - 8 characters - Capital letter- Number- Special character ");
            }

        } while (!checkPasswordComplexity(passWord));

        System.out.println("Password successfully captured.");

        // PHONE NUMBER
        String phoneNumber;

        do {

            System.out.print("Enter cellphone number: ");
            phoneNumber = input.nextLine();

            if (!checkPhoneNumberComplexity(phoneNumber)) {

                System.out.println("Cell phone number incorrectly formatted.");
            }

        } while (!checkPhoneNumberComplexity(phoneNumber));

        System.out.println("Cell phone number successfully added.");

        // REGISTER USER
        UserLogin login = new UserLogin();

        System.out.println( login.registerUser(userName,passWord,firstName,lastName ) );

        // LOGIN USER
        System.out.println("\n===== LOGIN USER =====");

        boolean loggedIn = false;

        do {

            System.out.print("Enter Username: ");
            String loginUsername = input.nextLine();

            System.out.print("Enter Password: ");
            String loginPassword = input.nextLine();

            loggedIn = login.loginUser(
                    loginUsername,
                    loginPassword
            );

            System.out.println(
                    login.returnLoginStatus(loggedIn)
            );

        } while (!loggedIn);

        

        if (loggedIn) {

            System.out.println("\nWelcome to QuickChat.");

            // Ask number of messages
            System.out.print("How many messages would you like to send? ");
            int totalMessages = input.nextInt();
            input.nextLine();

            int sentMessages = 0;

            Message message = new Message();

            boolean running = true;

            while (running) {

                // MENU
                System.out.println("\n===== QUICKCHAT MENU =====");
                System.out.println("1. Send Messages");
                System.out.println("2. Show Recently Sent Messages");
                System.out.println("3. Quit");

                System.out.print("Choose option: ");
                int option = input.nextInt();
                input.nextLine();

                switch (option) {

                    case 1:

                        // Check limit
                        if (sentMessages >= totalMessages) {

                            System.out.println("Message limit reached.");
                            break;
                        }

                        // Recipient
                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        if (!message.checkRecipientCell(recipient)) {

                            System.out.println("Cell phone number incorrectly formatted.");
                            break;
                        }

                        // Message text
                        System.out.print("Enter message: ");
                        String messageText = input.nextLine();

                       // Check message length
     if (messageText.length() > 250) {

     int extra = messageText.length() - 250;

     System.out.println( "Message exceeds 250 characters by " + extra+ " characters.");

          break;
                        }

    System.out.println("Message ready to send.");

                        // Create ID
       String messageID = message.createMessageID();

                        // Create hash
       String hash = message.createMessageHash(
                                messageID,
                                sentMessages,
                                messageText
                        );

                        // Options
       System.out.println("\n1. Send Message");
       System.out.println("2. Disregard Message");
       System.out.println("3. Store Message");

        System.out.print("Choose option: ");
                        int messageOption = input.nextInt();
                        input.nextLine();

                        switch (messageOption) {

                            case 1:

          message.storeMessage(
              messageID,
              hash,
               recipient,
                 messageText
                                );

         sentMessages++;

   System.out.println("\nMessage successfully sent.");

    System.out.println("Message ID: " + messageID);
   System.out.println("Message Hash: " + hash);
     System.out.println("Recipient: " + recipient);
     System.out.println("Message: " + messageText);

            break;

             case 2:

     System.out.println("Message disregarded.");
             break;

              case 3:

         message.storeMessage(
            messageID,
             hash,
             recipient,
              messageText
                                );

      System.out.println("Message stored successfully.");

              break;

              default:

           System.out.println("Invalid option.");
                        }

          break;

            case 2:

       System.out.println("Coming Soon.");
             break;

            case 3:

       System.out.println("Total messages sent: "+ message.returnTotalMessages());

        System.out.println("Exiting QuickChat...");

              running = false;

                 break;

                    default:

        System.out.println("Invalid option.");
                }
            }
        }

        input.close();
    }
}
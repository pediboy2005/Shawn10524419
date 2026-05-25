/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// ===============================
// MESSAGE CLASS
// Message.java
// ===============================

package com.mycompany.registrationandlogin;

import java.io.FileWriter;
import java.util.Random;

public class Message {

    // Variables
    private String messageID;
    private String recipient;
    private String message;
    private String messageHash;

    // Counter
    private int totalMessages = 0;

    // Create Message ID
    public String createMessageID() {

        Random random = new Random();

        long number = 1000000000L
                + (long)(random.nextDouble() * 9000000000L);

        messageID = String.valueOf(number);

        return messageID;
    }

    // Check recipient number
    public boolean checkRecipientCell(String recipient) {

        return recipient.matches("^\\+27\\d{9}$");
    }

    // Create Message Hash
    public String createMessageHash(
            String messageID,
            int messageNumber,
            String messageText) {

        String[] words = messageText.split(" ");

        String firstWord = words[0].toUpperCase();

        String lastWord =
                words[words.length - 1].toUpperCase();

        String firstTwoNumbers =
                messageID.substring(0, 2);

        messageHash = firstTwoNumbers
                + ":"
                + messageNumber
                + ":"
                + firstWord
                + lastWord;

        return messageHash;
    }

    // Store message into JSON file
    public void storeMessage(
            String messageID,
            String messageHash,
            String recipient,
            String message) {

        try {

            FileWriter writer =
                    new FileWriter("storedMessages.json", true);

            writer.write("{\n");

            writer.write("\"MessageID\":\""
                    + messageID + "\",\n");

            writer.write("\"MessageHash\":\""
                    + messageHash + "\",\n");

            writer.write("\"Recipient\":\""
                    + recipient + "\",\n");

            writer.write("\"Message\":\""
                    + message + "\"\n");

            writer.write("}\n");

            writer.close();

        } catch (Exception e) {

            System.out.println("Error saving message");
        }
    }

    // Display message details
    public void printMessage(
            String messageID,
            String hash,
            String recipient,
            String messageText) {

        System.out.println("\n===== MESSAGE DETAILS =====");

        System.out.println("Message ID: " + messageID);

        System.out.println("Message Hash: " + hash);

        System.out.println("Recipient: " + recipient);

        System.out.println("Message: " + messageText);
    }

    // Count sent messages
    public void sentMessage() {

        totalMessages++;
    }

    // Return total messages
    public int returnTotalMessages() {

        return totalMessages;
    }
}

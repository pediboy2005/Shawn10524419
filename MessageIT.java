/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.registrationandlogin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageIT {

    // ===============================
    // TEST CREATE MESSAGE ID
    // ===============================

    @Test
    public void testCreateMessageID() {

        Message instance = new Message();

        String result = instance.createMessageID();

        // Check if ID is not null
        assertNotNull(result);

        // Check if ID length is 10
        assertEquals(10, result.length());
    }

    // ===============================
    // TEST RECIPIENT NUMBER
    // ===============================

    @Test
    public void testCheckRecipientCellSuccess() {

        Message instance = new Message();

        boolean result =
                instance.checkRecipientCell("+27831234567");

        assertTrue(result);
    }

    @Test
    public void testCheckRecipientCellFail() {

        Message instance = new Message();

        boolean result =
                instance.checkRecipientCell("0831234567");

        assertFalse(result);
    }

    // ===============================
    // TEST MESSAGE HASH
    // ===============================

    @Test
    public void testCreateMessageHash() {

        Message instance = new Message();

        String result =
                instance.createMessageHash(
                        "1234567890",
                        1,
                        "Hello World"
                );

        String expected = "12:1:HELLOWORLD";

        assertEquals(expected, result);
    }

    // ===============================
    // TEST STORE MESSAGE
    // ===============================

    @Test
    public void testStoreMessage() {

        Message instance = new Message();

        assertDoesNotThrow(() -> {

            instance.storeMessage(
                    "1234567890",
                    "12:1:HELLOWORLD",
                    "+27831234567",
                    "Hello World"
            );
        });
    }

    // ===============================
    // TEST PRINT MESSAGE
    // ===============================

    @Test
    public void testPrintMessage() {

        Message instance = new Message();

        assertDoesNotThrow(() -> {

            instance.printMessage(
                    "1234567890",
                    "12:1:HELLOWORLD",
                    "+27831234567",
                    "Hello World"
            );
        });
    }

    // ===============================
    // TEST SENT MESSAGE
    // ===============================

    @Test
    public void testSentMessage() {

        Message instance = new Message();

        instance.sentMessage();

        int result =
                instance.returnTotalMessages();

        assertEquals(1, result);
    }

    // ===============================
    // TEST RETURN TOTAL MESSAGES
    // ===============================

    @Test
    public void testReturnTotalMessages() {

        Message instance = new Message();

        int result =
                instance.returnTotalMessages();

        assertEquals(0, result);
    }
}

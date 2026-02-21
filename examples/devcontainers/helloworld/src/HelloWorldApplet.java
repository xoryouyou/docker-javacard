package helloworld;

import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.ISO7816;
import javacard.framework.ISOException;
import javacard.framework.Util;

/**
 * HelloWorld JavaCard Applet
 * 
 * A simple applet that responds with "Hello" when queried.
 * Use this as a starting point for your own JavaCard development.
 */
public class HelloWorldApplet extends Applet {
    
    // Response data
    private static final byte[] helloWorld = { 'H', 'e', 'l', 'l', 'o' };
    
    // APDU constants
    private static final byte HW_CLA = (byte) 0x80;
    private static final byte HW_INS = (byte) 0x00;

    /**
     * Installs the applet on the card.
     */
    public static void install(byte[] bArray, short bOffset, byte bLength) {
        new HelloWorldApplet().register(bArray, (short) (bOffset + 1), bArray[bOffset]);
    }

    /**
     * Processes incoming APDU commands.
     */
    public void process(APDU apdu) {
        if (selectingApplet()) {
            return;
        }

        byte[] buffer = apdu.getBuffer();
        byte CLA = buffer[ISO7816.OFFSET_CLA];
        byte INS = buffer[ISO7816.OFFSET_INS];

        if (CLA != HW_CLA) {
            ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
        }

        if (INS == HW_INS) {
            getHelloWorld(apdu);
        } else {
            ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
        }
    }

    /**
     * Returns "Hello" String as bytes in the response APDU.
     */
    private void getHelloWorld(APDU apdu) {
        byte[] buffer = apdu.getBuffer();
        short length = (short) helloWorld.length;
        Util.arrayCopyNonAtomic(helloWorld, (short) 0, buffer, (short) 0, length);
        apdu.setOutgoingAndSend((short) 0, length);
    }
}

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;

import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

import org.junit.Test;

import com.licel.jcardsim.bouncycastle.util.encoders.Hex;
import com.licel.jcardsim.smartcardio.CardSimulator;
import com.licel.jcardsim.utils.AIDUtil;

import javacard.framework.AID;

/**
 * Unit tests for HelloWorldApplet using jCardSim simulator.
 */
public class HelloWorldAppletTest {
    
    @Test
    public void testHelloWorldResponse() throws Exception {
        // Create simulator instance
        CardSimulator simulator = new CardSimulator();
        System.out.println("Running on Simulator: " + simulator);

        // Install applet with AID
        String PACKAGE_AID_HEX = "01020304050607";
        byte[] aid_bytes = Hex.decode(PACKAGE_AID_HEX + "01");

        AID aid = AIDUtil.create(aid_bytes);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        bos.write(aid_bytes.length);
        bos.write(aid_bytes);

        simulator.installApplet(aid, helloworld.HelloWorldApplet.class, bos.toByteArray(),
            (short) 0, (byte) bos.size());
        bos.close();

        // Select applet
        simulator.selectApplet(aid);
        
        // Send APDU command (CLA=0x80, INS=0x00)
        CommandAPDU apdu = new CommandAPDU(0x80, 0x00, 0, 0);
        ResponseAPDU result = simulator.transmitCommand(apdu);
        
        // Verify response
        assertEquals("Expected SW 0x9000", 0x9000, result.getSW());
        assertArrayEquals("Expected 'Hello' response", "Hello".getBytes(), result.getData());
        
        System.out.println("Test passed!");
    }
}

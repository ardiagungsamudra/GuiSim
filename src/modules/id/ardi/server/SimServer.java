/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.id.ardi.server;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import modules.id.ardi.model.Helper;
import modules.id.ardi.participant.*;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISORequestListener;
import org.jpos.iso.ISOServer;
import org.jpos.iso.ISOSource;
import org.jpos.iso.ServerChannel;
import org.jpos.iso.channel.NACChannel;
import org.jpos.iso.packager.ISO87APackager;
import org.jpos.transaction.Context;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;
/**
 *
 * @author user
 */
public class SimServer extends Logger implements ISORequestListener {

    public static final String REQUEST = "REQUEST";
    public static final String ISOSOURCE = "ISOSOURCE";
    ISOServer server = null;
    List<Helper> listMTI = null;
    
    Map mIso = new HashMap();

    public SimServer(int Port, byte[] TPDU, Map map) {
        System.out.println("Constructor SimServer");
        mIso = map;
        byte[] tpdu = {0x60,00,00,00,00};
        try {
            Logger logger = new Logger();
            logger.addListener(new SimpleLogListener(System.out));
            ServerChannel sc = new NACChannel(new ISO87APackager(), tpdu, null);
            server = new ISOServer(Port, sc, null);
            server.addISORequestListener(this);
            server.setLogger(logger, "SimServer");
            new Thread(server).start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void poweroff() {
    }

    public boolean process(ISOSource isosource, ISOMsg isomsg) {
        Context context = new Context();
        context.put(REQUEST, isomsg);
        context.put(ISOSOURCE, isosource);
        System.out.println("Process!!!");
        try {
            System.out.println("MTI "+isomsg.getMTI());
            if (isomsg.getMTI().equals("0100") && mIso.containsKey("0100")) {
                MTI0100Participant ti = new MTI0100Participant((List) mIso.get("0100"));
                ti.commit(1, context);
            }
            if(isomsg.getMTI().equals("0200") && mIso.containsKey("0200")) {
                MTI0200Participant ti = new MTI0200Participant((List) mIso.get("0200"));
                ti.commit(2, context);
            }
            if(isomsg.getMTI().equals("0320") && mIso.containsKey("0320")) {
                MTI0320Participant ti = new MTI0320Participant((List) mIso.get("0320"));
                ti.commit(3, context);
            }
            if(isomsg.getMTI().equals("0400") && mIso.containsKey("0400")) {
                MTI0400Participant ti = new MTI0400Participant((List) mIso.get("0400"));
                ti.commit(4, context);
            }
            if(isomsg.getMTI().equals("0500") && mIso.containsKey("0500")) {
                MTI0500Participant ti = new MTI0500Participant((List) mIso.get("0500"));
                ti.commit(5, context);
            }
            if(isomsg.getMTI().equals("0800")&& mIso.containsKey("0800")) {
                System.out.println("getMTI 0800");
                MTI0800Participant ti = new MTI0800Participant((List) mIso.get("0800"));
                ti.commit(6, context);
            }
        } catch (ISOException ex) {
            java.util.logging.Logger.getLogger(SimServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.id.ardi.participant;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOSource;
import org.jpos.transaction.Context;
import org.jpos.transaction.TransactionParticipant;
import java.util.logging.Level;
import java.util.logging.Logger;
import modules.id.ardi.model.FieldModel;

/**
 *
 * @author user
 */
public class MTI0100Participant implements TransactionParticipant {
    List<FieldModel> lf = new ArrayList<FieldModel>();
    
    public MTI0100Participant(List list){
        lf = list;
    }
    
    public int prepare(long id, Serializable context) {
        return PREPARED;
    }

    public void commit(long id, Serializable context) {
        Context ctx = (Context) context;
        ISOSource source = (ISOSource) ctx.get("ISOSOURCE");
        ISOMsg msg = (ISOMsg) ctx.get("REQUEST");

        try {
            msg.setResponseMTI();
           
            for(int i = 0; i < lf.size(); i++){
                if(lf.get(i).getStatus())   //set if status field true
                    msg.set(Integer.parseInt(lf.get(i).getField().toString()), lf.get(i).getValue());
                else    
                    msg.unset(Integer.parseInt(lf.get(i).getField().toString())); //unset if status field false
            }
            msg.set(39, "00");
            source.send(msg);

        } catch (ISOException ex) {
            Logger.getLogger(MTI0200Participant.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MTI0200Participant.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void abort(long id, Serializable context) {
    }
}

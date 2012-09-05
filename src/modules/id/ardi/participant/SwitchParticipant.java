/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modules.id.ardi.participant;
import java.io.Serializable;

import org.jpos.core.Configurable;
import org.jpos.core.Configuration;
import org.jpos.core.ConfigurationException;
import org.jpos.iso.ISOMsg;
import org.jpos.transaction.Context;
import org.jpos.transaction.GroupSelector;
/**
 *
 * @author user
 */
public class SwitchParticipant implements Configurable, GroupSelector {

    Configuration cfg;

    @Override
    public String select(long id, Serializable context) {
        // TODO Auto-generated method stub
        try {
            ISOMsg m = getRequest((Context) context);
            System.out.println("mti " + m.getMTI());
            String groups = cfg.get(m.getMTI(), null);
            System.out.println("Group to pick : " + m.getMTI());
            return groups;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void abort(long id, Serializable context) {
    }

    @Override
    public void commit(long id, Serializable context) {
    }

    @Override
    public int prepare(long id, Serializable context) {
        // TODO Auto-generated method stub
        return PREPARED | READONLY | NO_JOIN;
    }

    private ISOMsg getRequest(Context context) {
        return (ISOMsg) context.get("REQUEST");
    }

    public void setConfiguration(Configuration cfg)
            throws ConfigurationException {
        this.cfg = cfg;
    }
}

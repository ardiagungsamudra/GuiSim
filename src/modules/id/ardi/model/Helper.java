/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.id.ardi.model;

/**
 *
 * @author user
 */
/* Helper class for build table :)
 */
public class Helper {
    String mti, button;

    public Helper() {
        mti = null;
        button = "Set Fields";
    }

    public String getMTI() {
        return mti;
    }

    public String getButton() {
        return button;
    }

    public void setMTI(String mti) {
        this.mti = mti;
    }

}
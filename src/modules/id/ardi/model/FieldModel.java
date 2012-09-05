/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modules.id.ardi.model;

/**
 *
 * @author user
 */
public class FieldModel {

    String field;
    String value;
    Boolean status;

    public FieldModel(String fld, String vl, boolean st) {
        field = fld;
        value = vl;
        status = new Boolean(st);
    }

    public String getField() {
        return field;
    }

    public String getValue() {
        return value;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setField(String fld) {
        field = fld;
    }

    public void setValue(String vl) {
        value = vl;
    }

    public void setStatus(boolean st) {
        status = st;
    }
}

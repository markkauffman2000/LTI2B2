/**
 * 
 */
package bbdn.lti2.dao;

/**
 * @author mkauffman
 *
 */

import java.util.List;

import bbdn.lti2.beans.Lti2Config;
import bbdn.lti2.beans.Lti2Contact;
import blackboard.persist.KeyNotFoundException;
import blackboard.persist.dao.impl.SimpleDAO;
import blackboard.persist.impl.SimpleSelectQuery;
import blackboard.util.StringUtil;

public class Lti2ContactDAO extends SimpleDAO<Lti2Contact>
{

    public Lti2ContactDAO() {
            super(Lti2Contact.class);
    }

    public Lti2ContactDAO(Class<Lti2Contact> cls) {
            super(cls);
    }

    public List<Lti2Contact> loadAll() {
            return getDAOSupport().loadAll();
    }
	
    public Lti2Contact load() {
        List<Lti2Contact> contacts;
        contacts = getDAOSupport().loadAll();
        if(contacts!=null&&!contacts.isEmpty())
        return contacts.get(0);
        else return null;
    } // Lti2Contact load()
    
    public void save(Lti2Contact contact) {
        System.out.println(contact);        
                
        getDAOSupport().persist(contact);
    }
    
}// end public class Lti2ContactDAO

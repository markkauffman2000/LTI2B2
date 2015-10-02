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
import blackboard.persist.impl.SelectQuery;
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
    
    public Lti2Contact loadByEmail(String email) {
        if (!StringUtil.isEmpty(email)) {
            SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
            //Change column name to whatever the name is in the bean
            query.addWhere("email", email);
            List<Lti2Contact> contacts; // Using loadList because we don't want to throw KeyNotFoundException.
            contacts = getDAOSupport().loadList(query);
            if(contacts!=null&&!contacts.isEmpty())
                return contacts.get(0);
        }
            return null;           // Instead, we want to return null if it's not found.
    }
    
    public void save(Lti2Contact contact) {
        System.out.println(contact);        
                
        getDAOSupport().persist(contact);
    }
    
    public void update(Lti2Contact contact){
        getDAOSupport().update(contact);
    }
    
}// end public class Lti2ContactDAO

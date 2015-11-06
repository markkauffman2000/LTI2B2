/**
 * 
 */
package bbdn.lti2.dao;

/**
 * @author mkauffman
 *
 */

import java.util.List;

import bbdn.lti2.beans.Lti2Name;
import blackboard.persist.dao.impl.SimpleDAO;
import blackboard.persist.impl.SimpleSelectQuery;
import blackboard.util.StringUtil;

public class Lti2NameDAO extends SimpleDAO<Lti2Name>
{

    public Lti2NameDAO() {
            super(Lti2Name.class);
    }

    public Lti2NameDAO(Class<Lti2Name> cls) {
            super(cls);
    }

    @Override
    public List<Lti2Name> loadAll() {
            return getDAOSupport().loadAll();
    }
	
   
    public Lti2Name load() {
        List<Lti2Name> descriptions;
        descriptions = getDAOSupport().loadAll();
        if(descriptions !=null&&!descriptions.isEmpty())
        return descriptions.get(0);
        else return null;
    } // Lti2Name load()
    
    public Lti2Name loadByKey(String key) {
        if (!StringUtil.isEmpty(key)) {
            SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
            //Change column name to whatever the name is in the bean
            query.addWhere("key", key);
            List<Lti2Name> descriptions; // Using loadList because we don't want to throw KeyNotFoundException.
            descriptions = getDAOSupport().loadList(query);
            if(descriptions!=null&&!descriptions.isEmpty())
                return descriptions.get(0);
        }
            return null;           // Instead, we want to return null if it's not found.
    }
    
    public void save(Lti2Name name) {
        System.out.println(name);        
                
        getDAOSupport().persist(name);
    }
    
    public void update(Lti2Name description){
        getDAOSupport().update(description);
    }
    
}// end public class Lti2NameDAO

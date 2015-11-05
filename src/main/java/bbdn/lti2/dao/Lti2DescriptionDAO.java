/**
 * 
 */
package bbdn.lti2.dao;

/**
 * @author mkauffman
 *
 */

import java.util.List;

import bbdn.lti2.beans.Lti2Description;
import blackboard.persist.dao.impl.SimpleDAO;
import blackboard.persist.impl.SimpleSelectQuery;
import blackboard.util.StringUtil;

public class Lti2DescriptionDAO extends SimpleDAO<Lti2Description>
{

    public Lti2DescriptionDAO() {
            super(Lti2Description.class);
    }

    public Lti2DescriptionDAO(Class<Lti2Description> cls) {
            super(cls);
    }

    @Override
    public List<Lti2Description> loadAll() {
            return getDAOSupport().loadAll();
    }
	
   
    public Lti2Description load() {
        List<Lti2Description> descriptions;
        descriptions = getDAOSupport().loadAll();
        if(descriptions !=null&&!descriptions.isEmpty())
        return descriptions.get(0);
        else return null;
    } // Lti2Description load()
    
    public Lti2Description loadByKey(String key) {
        if (!StringUtil.isEmpty(key)) {
            SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
            //Change column name to whatever the name is in the bean
            query.addWhere("key", key);
            List<Lti2Description> descriptions; // Using loadList because we don't want to throw KeyNotFoundException.
            descriptions = getDAOSupport().loadList(query);
            if(descriptions!=null&&!descriptions.isEmpty())
                return descriptions.get(0);
        }
            return null;           // Instead, we want to return null if it's not found.
    }
    
    public void save(Lti2Description description) {
        System.out.println(description);        
                
        getDAOSupport().persist(description);
    }
    
    public void update(Lti2Description description){
        getDAOSupport().update(description);
    }
    
}// end public class Lti2DescriptionDAO

/**
 * 
 */
package bbdn.lti2.dao;

/**
 * @author shurrey
 *
 */

import java.util.List;

import blackboard.persist.KeyNotFoundException;
import blackboard.persist.dao.impl.SimpleDAO;
import blackboard.persist.impl.SimpleSelectQuery;
import blackboard.util.StringUtil;

public class Lti2LinkDAO extends SimpleDAO<Lti2Link>
{

	public Lti2LinkDAO() {
		super(Lti2Link.class);
	}

	public Lti2LinkDAO(Class<Lti2Link> cls) {
		super(cls);
	}

	public List<Lti2Link> loadAll() {
		return getDAOSupport().loadAll();
	}

	public List<Lti2Link> searchByCourseBatchUid(String courseBatchUid) 
			throws KeyNotFoundException {
		if (!StringUtil.isEmpty(courseBatchUid)) {
			SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
			//Change column name to whatever the name is in the bean
			query.addWhere("course_batch_uid", courseBatchUid);
			return getDAOSupport().loadList(query);
		}
		return null;  
	} 
	
	public Lti2Link load() {
        List<Lti2Link> link;
        link = getDAOSupport().loadAll();
        if(link!=null&&!link.isEmpty())
        return link.get(0);
        else return null;
    } 
    
    public void save(Lti2Link link) {
        System.out.println(link);        
                
        getDAOSupport().persist(link);
    }
    
    public boolean isInstalled(){
        //System.out.print("\nisInstalled called\n");
        List<Lti2Link> link = null;
        link = getDAOSupport().loadAll();
        if (link.size() > 0) {
            return true;
        }
        return false;
    }
    
    public void writeDefaults() {
    	Lti2Link link = new Lti2Link();
        
        getDAOSupport().persist(link);
        
    }
}

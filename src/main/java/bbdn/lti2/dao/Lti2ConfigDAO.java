/**
 * 
 */
package bbdn.lti2.dao;

/**
 * @author shurrey
 *
 */

import java.util.List;

import bbdn.lti2.beans.Lti2Config;
import blackboard.persist.KeyNotFoundException;
import blackboard.persist.dao.impl.SimpleDAO;
import blackboard.persist.impl.SimpleSelectQuery;
import blackboard.util.StringUtil;

public class Lti2ConfigDAO extends SimpleDAO<Lti2Config>
{

	public Lti2ConfigDAO() {
		super(Lti2Config.class);
	}

	public Lti2ConfigDAO(Class<Lti2Config> cls) {
		super(cls);
	}

	public List<Lti2Config> loadAll() {
		return getDAOSupport().loadAll();
	}

	public List<Lti2Config> searchByCourseBatchUid(String courseBatchUid) 
			throws KeyNotFoundException {
		if (!StringUtil.isEmpty(courseBatchUid)) {
			SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
			//Change column name to whatever the name is in the bean
			query.addWhere("course_batch_uid", courseBatchUid);
			return getDAOSupport().loadList(query);
		}
		return null;  
	} 
	
	public Lti2Config load() {
        List<Lti2Config> link;
        link = getDAOSupport().loadAll();
        if(link!=null&&!link.isEmpty())
        return link.get(0);
        else return null;
    } 
    
    public void save(Lti2Config config) {
        System.out.println(config);        
                
        getDAOSupport().persist(config);
    }
    
    public boolean isInstalled(){
        //System.out.print("\nisInstalled called\n");
        List<Lti2Config> config = null;
        config = getDAOSupport().loadAll();
        if (config.size() > 0) {
            return true;
        }
        return false;
    }
    
    public void writeDefaults() {
    	Lti2Config config = new Lti2Config();
        
        getDAOSupport().persist(config);
        
    }
}

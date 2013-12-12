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

public class Lti2GlobalSettingsDAO extends SimpleDAO<Lti2GlobalSettings>
{

	public Lti2GlobalSettingsDAO() {
		super(Lti2GlobalSettings.class);
	}

	public Lti2GlobalSettingsDAO(Class<Lti2GlobalSettings> cls) {
		super(cls);
	}

	public List<Lti2GlobalSettings> loadAll() {
		return getDAOSupport().loadAll();
	}

	public List<Lti2GlobalSettings> searchByCourseBatchUid(String courseBatchUid) 
			throws KeyNotFoundException {
		if (!StringUtil.isEmpty(courseBatchUid)) {
			SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
			//Change column name to whatever the name is in the bean
			query.addWhere("course_batch_uid", courseBatchUid);
			return getDAOSupport().loadList(query);
		}
		return null;  
	} 
	
    public Lti2GlobalSettings load() {
        List<Lti2GlobalSettings> globalSettings;
        globalSettings = getDAOSupport().loadAll();
        if(globalSettings!=null&&!globalSettings.isEmpty())
        return globalSettings.get(0);
        else return null;
    } 
    
    public void save(Lti2GlobalSettings globalSettings) {
        System.out.println(globalSettings);        
                
        getDAOSupport().persist(globalSettings);
    }
    
    public boolean isInstalled(){
        //System.out.print("\nisInstalled called\n");
        List<Lti2GlobalSettings> globalSettings = null;
        globalSettings = getDAOSupport().loadAll();
        if (globalSettings.size() > 0) {
            return true;
        }
        return false;
    }
    
    public void writeDefaults() {
    	Lti2GlobalSettings globalSettings = new Lti2GlobalSettings();
        
        getDAOSupport().persist(globalSettings);
        
    }
}

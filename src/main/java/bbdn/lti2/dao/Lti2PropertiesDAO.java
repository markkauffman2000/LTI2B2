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

public class Lti2PropertiesDAO extends SimpleDAO<Lti2Properties>
{

	public Lti2PropertiesDAO() {
		super(Lti2Properties.class);
	}

	public Lti2PropertiesDAO(Class<Lti2Properties> cls) {
		super(cls);
	}

	public List<Lti2Properties> loadAll() {
		return getDAOSupport().loadAll();
	}

	public List<Lti2Properties> searchByCourseBatchUid(String courseBatchUid) 
			throws KeyNotFoundException {
		if (!StringUtil.isEmpty(courseBatchUid)) {
			SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
			//Change column name to whatever the name is in the bean
			query.addWhere("course_batch_uid", courseBatchUid);
			return getDAOSupport().loadList(query);
		}
		return null;  
	} 
	
    public Lti2Properties load() {
        List<Lti2Properties> globalSettings;
        globalSettings = getDAOSupport().loadAll();
        if(globalSettings!=null&&!globalSettings.isEmpty())
        return globalSettings.get(0);
        else return null;
    } 
    
    public void save(Lti2Properties globalSettings) {
        System.out.println(globalSettings);        
                
        getDAOSupport().persist(globalSettings);
    }
    
    public boolean isInstalled(){
        //System.out.print("\nisInstalled called\n");
        List<Lti2Properties> globalSettings = null;
        globalSettings = getDAOSupport().loadAll();
        if (globalSettings.size() > 0) {
            return true;
        }
        return false;
    }
    
    public void writeDefaults() {
    	Lti2Properties globalSettings = new Lti2Properties();
        
        getDAOSupport().persist(globalSettings);
        
    }
}

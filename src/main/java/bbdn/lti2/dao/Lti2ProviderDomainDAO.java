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

public class Lti2ProviderDomainDAO extends SimpleDAO<Lti2ProviderDomain>
{

	public Lti2ProviderDomainDAO() {
		super(Lti2ProviderDomain.class);
	}

	public Lti2ProviderDomainDAO(Class<Lti2ProviderDomain> cls) {
		super(cls);
	}

	public List<Lti2ProviderDomain> loadAll() {
		return getDAOSupport().loadAll();
	}

	public Lti2ProviderDomain loadById(String toolId) 
			throws KeyNotFoundException {
		if (!StringUtil.isEmpty(toolId)) {
			SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
			//Change column name to whatever the name is in the bean
			query.addWhere("pk1", toolId);
			return getDAOSupport().load(query);
		}
		return null;  
	} 
	
	public Lti2ProviderDomain loadByDomain(String domain) 
			throws KeyNotFoundException {
		if (!StringUtil.isEmpty(domain)) {
			SimpleSelectQuery query = new SimpleSelectQuery(getDAOSupport().getMap());
			//Change column name to whatever the name is in the bean
			query.addWhere("tool_domain", domain);
			return getDAOSupport().load(query);
		}
		return null;  
	}
	
	public Lti2ProviderDomain load() {
        List<Lti2ProviderDomain> providerDomain;
        providerDomain = getDAOSupport().loadAll();
        if(providerDomain!=null&&!providerDomain.isEmpty())
        return providerDomain.get(0);
        else return null;
    } 
    
    public void save(Lti2ProviderDomain providerDomain) {
        System.out.println(providerDomain);        
                
        getDAOSupport().persist(providerDomain);
    }
    
    public boolean isInstalled(){
        //System.out.print("\nisInstalled called\n");
        List<Lti2ProviderDomain> providerDomain = null;
        providerDomain = getDAOSupport().loadAll();
        if (providerDomain.size() > 0) {
            return true;
        }
        return false;
    }
    
    public void writeDefaults() {
    	Lti2ProviderDomain providerDomain = new Lti2ProviderDomain();
        
        getDAOSupport().persist(providerDomain);
        
    }
}

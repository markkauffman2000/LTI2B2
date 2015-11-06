package bbdn.lti2.beans;

import blackboard.data.AbstractIdentifiable;
import blackboard.persist.DataType;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.Table;

import com.google.gson.Gson;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

// This Lti2Description class "wraps" an org.imsglobal.lti2.objects.Name
import org.imsglobal.lti2.objects.Name;

@Table("bbdn_lti2_name")
public class Lti2Name  extends AbstractIdentifiable {

		   public static final DataType DATA_TYPE = new DataType( Lti2Name.class );
                   
                   private Name imsName;
	   
                   @Override
		   public DataType getDataType() {
				return DATA_TYPE;
		   }
                   
		   @PrimaryKey
		   private int pk1;
		  
		   @Column(value = "key")
		   private String key;
                   
                   @Column(value = "default_value")
		   private String default_value;
		   
                   // Can we force this to save as a BLOB?? Yes, see below & schema.xml 
		   @Column(value = "additional_properties", lob = true, multiByte = true )
		   private String additional_properties;

	   /**
		 * @return the name_id
		 */
		public int getNameId() {
			return pk1;
		}
			
		/**
		 * @return the key
		 */
		public String getKey() {
			return key;
		}

		/**
		 * @param val the key to set
		 */
		public void setKey(String val) {
			this.key = val;
                        this.imsName.setKey(val);
		}
                
                /**
		 * @return the default_value
		 */
		public String getDefaultValue() {
			return default_value;
		}

		/**
		 * @param val the defaultValue to set
		 */
		public void setDefaultValue(String val) {
			this.default_value = val;
                        this.imsName.setDefault_value(val);
		}
                

		/**
		 * @return the additional_properties
		 */
		public String getAdditionalProperties() {
			return additional_properties;
		}

		/**
		 * @param additional_properties the additional_properties to set
		 */
		public void setAdditionalProperties(String additional_properties) {
                        String name = null;
                        Object value = null;
			this.additional_properties = additional_properties;
                        Gson gson = new Gson();
                        
                        Map map = gson.fromJson(additional_properties, Map.class);
                        // From: http://www.mkyong.com/java/how-to-loop-a-map-in-java/
                        // Map -> Set -> Iterator -> Map.Entry -> 

                        Iterator<Entry<String,Object>> iterator = map.entrySet().iterator();
                        while (iterator.hasNext()) {
                            Map.Entry<String,Object> entry = (Map.Entry<String,Object>) iterator.next();
                            name =  entry.getKey();
                            value = entry.getValue();
                            this.imsName.setAdditionalProperties(name, value);
                        }
		}
                
                // Turn the data in the DB table to an LTI object. Return that object.
                public Name getName() {
                    Gson gson = new Gson();
                    String name = null;
                    Object value = null;
                    
                    String df = this.getDefaultValue();
                    String ky = this.getKey();
                    if (this.imsName == null){
                        this.imsName = new Name(df);
                    } else {
                        this.imsName.setDefault_value(df);
                    }
                    this.imsName.setKey(ky);
                    String aProps = this.getAdditionalProperties();
                    // Turn the JSON string into a Map.
                    Map map = gson.fromJson(aProps, Map.class);
                    // From: http://www.mkyong.com/java/how-to-loop-a-map-in-java/
                    // Map -> Set -> Iterator -> Map.Entry -> 

                    Iterator<Entry<String,Object>> iterator = map.entrySet().iterator();
                    while (iterator.hasNext()) {
                            Map.Entry<String,Object> entry = (Map.Entry<String,Object>) iterator.next();
                            name =  entry.getKey();
                            value = entry.getValue();
                            this.imsName.setAdditionalProperties(name, value);
                    }
                    
                    return this.imsName;
                }// getName
                
                // Turn the LTI object into data we store in the DB table.
                public void setName(Name imsName){
                    this.imsName = imsName;
                    String dv = imsName.getDefault_value();
                    this.setDefaultValue(dv);
                    String ky = imsName.getKey();
                    this.setKey(ky);
                    
                    // Take the LTI Object's additionalProperties and serialize it.
                    // TO DO: Turn this into utility code so we don't repeat it in every Lti2 Object Bean
                    // Can we get this to work with a BlOB?? (See concern in the link below.)
                    // Yes - see http://projects.oscelot.org/gf/project/oscegst/scmsvn/
                    // Use this for schema.xml: <column name="additional_properties" data-type="text" nullable="true"/>
                    //
                    // http://stackoverflow.com/questions/134492/how-to-serialize-an-object-into-a-string
                    // JSON http://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
                    Map map = imsName.getAdditionalProperties();
                    // Convert the map to a String using Gson
                    Gson gson = new Gson();
                    String json = gson.toJson(map);
                    this.setAdditionalProperties(json);
                    
                }// setName
                
} // public class Lti2Name

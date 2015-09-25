package bbdn.lti2.beans;

import blackboard.data.AbstractIdentifiable;
import blackboard.data.content.Content;
import blackboard.persist.DataType;
import blackboard.persist.Id;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.RefersTo;
import blackboard.persist.impl.mapping.annotation.Table;

import com.google.gson.Gson;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;
// This Lti2Contact class "wraps" an org.imsglobal.lti2.objects.Contact
import org.imsglobal.lti2.objects.Contact;

@Table("bbdn_lti2_contacts")
public class Lti2Contact  extends AbstractIdentifiable {

		   public static final DataType DATA_TYPE = new DataType( Lti2Contact.class );
                   
                   private Contact contact;
	   
		   public DataType getDataType() {
				return DATA_TYPE;
		   }
                   
		   @PrimaryKey
		   private int pk1;
		  
		   @Column(value = "email")
		   private String email;
		   
                   // Can we force this to save as a BLOB?? Yes, see below & schema.xml 
		   @Column(value = "additional_properties", lob = true, multiByte = true )
		   private String additional_properties;

	   /**
		 * @return the contact_id
		 */
		public int getContactId() {
			return pk1;
		}
			
		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param em the email to set
		 */
		public void setEmail(String em) {
			this.email = em;
                        this.contact.setEmail(em);
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
                            this.contact.setAdditionalProperties(name, value);
                        }
		}
                
                public Contact getContact() {
                    Gson gson = new Gson();
                    String name = null;
                    Object value = null;
                    String em = this.getEmail();
                    if (this.contact == null){
                        this.contact = new Contact(em);
                    } else {
                        this.contact.setEmail(em);
                    }
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
                            this.contact.setAdditionalProperties(name, value);
                    }
                    
                    return this.contact;
                }// getContact
                
                public void setContact(Contact contact){
                    this.contact = contact;
                    String em = contact.getEmail();
                    this.setEmail(em);
                    
                    // Take the Contact's additionalProperties and serialize it.
                    // TO DO: Turn this into utility code so we don't repeat it in ever Lti2 Object Bean
                    // Can we get this to work with a BlOB?? (See concern in the link below.)
                    // Yes - see http://projects.oscelot.org/gf/project/oscegst/scmsvn/
                    // Use this for schema.xml: <column name="additional_properties" data-type="text" nullable="true"/>
                    //
                    // http://stackoverflow.com/questions/134492/how-to-serialize-an-object-into-a-string
                    // JSON http://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
                    Map map = contact.getAdditionalProperties();
                    // Convert the map to a String using Gson
                    Gson gson = new Gson();
                    String json = gson.toJson(map);
                    this.setAdditionalProperties(json);
                    
                    /* Java method to serialize objects to strings. Save for if needed...
                    // see http://stackoverflow.com/questions/8887197/reliably-convert-any-object-to-string-and-then-back-again
                    String serializedObject = "";
                     try {
                         ByteArrayOutputStream bo = new ByteArrayOutputStream();
                         ObjectOutputStream so = new ObjectOutputStream(bo);
                         so.writeObject(map);
                         so.flush();
                         serializedObject = bo.toString();
                     } catch (Exception e) {
                         System.out.println(e);
                     }
                    */
                }// setContact
                
} // public class Lti2Contact

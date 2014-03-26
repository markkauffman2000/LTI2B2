package bbdn.lti2.beans;

import blackboard.data.AbstractIdentifiable;
import blackboard.data.content.Content;
import blackboard.persist.DataType;
import blackboard.persist.Id;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.RefersTo;
import blackboard.persist.impl.mapping.annotation.Table;

@Table("bbdn_lti2_links")
public class Lti2Link  extends AbstractIdentifiable {

		   public static final DataType DATA_TYPE = new DataType( Lti2Link.class );
	   
		   public DataType getDataType() {
				return DATA_TYPE;
		   }

		   @PrimaryKey
		   private int pk1;
		  
		   @Column(value = "link_title")
		   private String link_title;
		   
		   @Column(value = "link_url")
		   private String link_url;
		 
		   @Column(value = "link_key")
		   private String link_key;
		 
		   @Column(value = "link_secret")
		   private String link_secret;
		 
		   @Column(value = "link_customparams")
		   private String link_customparams;
		   
		   @Column(value = "link_tool_id")
		   @RefersTo(Lti2ProviderDomain.class)
		   private int link_tool_id;
		   
		   @Column(value = "link_content_id")
		   @RefersTo(Content.class)
		   private Id link_content_id;


	   /**
		 * @return the link_id
		 */
		public int getLinkId() {
			return pk1;
		}
			
		/**
		 * @return the link_title
		 */
		public String getTitle() {
			return link_title;
		}

		/**
		 * @param link_title the link_title to set
		 */
		public void setTitle(String link_title) {
			this.link_title = link_title;
		}

		/**
		 * @return the link_url
		 */
		public String getUrl() {
			return link_url;
		}

		/**
		 * @param link_url the link_url to set
		 */
		public void setUrl(String link_url) {
			this.link_url = link_url;
		}

		/**
		 * @return the link_key
		 */
		public String getConsumerKey() {
			return link_key;
		}

		/**
		 * @param link_key the link_key to set
		 */
		public void setConsumerKey(String link_key) {
			this.link_key = link_key;
		}

		/**
		 * @return the link_secret
		 */
		public String getSharedSecret() {
			return link_secret;
		}

		/**
		 * @param link_secret the link_secret to set
		 */
		public void setSharedSecret(String link_secret) {
			this.link_secret = link_secret;
		}

		/**
		 * @return the link_customparams
		 */
		public String getCustomParams() {
			return link_customparams;
		}

		/**
		 * @param link_customparams the link_customparams to set
		 */
		public void setCustomParams(String link_customparams) {
			this.link_customparams = link_customparams;
		}

		/**
		 * @return the link_tool_id
		 */
		public int getToolId() {
			return link_tool_id;
		}

		/**
		 * @param link_tool_id the link_tool_id to set
		 */
		public void setToolId(int link_tool_id) {
			this.link_tool_id = link_tool_id;
		}

		/**
		 * @return the link_content_id
		 */
		public Id getContentId() {
			return link_content_id;
		}

		/**
		 * @param link_content_id the link_content_id to set
		 */
		public void setContentId(Id link_content_id) {
			this.link_content_id = link_content_id;
		}

		
}

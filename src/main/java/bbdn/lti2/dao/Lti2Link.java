package bbdn.lti2.dao;

import blackboard.data.AbstractIdentifiable;
import blackboard.persist.DataType;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.Table;

@Table("bbdn_lti2_links")
public class Lti2Link  extends AbstractIdentifiable {

		   public static final DataType DATA_TYPE = new DataType( Lti2Link.class );
	   
		   public DataType getDataType() {
				return DATA_TYPE;
		   }

		   @PrimaryKey
		   private int link_id;
		  
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
		   private int link_tool_id;
		   
		   @Column(value = "link_content_id")
		   private int link_content_id;

		/**
		 * @return the link_id
		 */
		public int getLink_id() {
			return link_id;
		}

		/**
		 * @param link_id the link_id to set
		 */
		public void setLink_id(int link_id) {
			this.link_id = link_id;
		}

		/**
		 * @return the link_title
		 */
		public String getLink_title() {
			return link_title;
		}

		/**
		 * @param link_title the link_title to set
		 */
		public void setLink_title(String link_title) {
			this.link_title = link_title;
		}

		/**
		 * @return the link_url
		 */
		public String getLink_url() {
			return link_url;
		}

		/**
		 * @param link_url the link_url to set
		 */
		public void setLink_url(String link_url) {
			this.link_url = link_url;
		}

		/**
		 * @return the link_key
		 */
		public String getLink_key() {
			return link_key;
		}

		/**
		 * @param link_key the link_key to set
		 */
		public void setLink_key(String link_key) {
			this.link_key = link_key;
		}

		/**
		 * @return the link_secret
		 */
		public String getLink_secret() {
			return link_secret;
		}

		/**
		 * @param link_secret the link_secret to set
		 */
		public void setLink_secret(String link_secret) {
			this.link_secret = link_secret;
		}

		/**
		 * @return the link_customparams
		 */
		public String getLink_customparams() {
			return link_customparams;
		}

		/**
		 * @param link_customparams the link_customparams to set
		 */
		public void setLink_customparams(String link_customparams) {
			this.link_customparams = link_customparams;
		}

		/**
		 * @return the link_tool_id
		 */
		public int getLink_tool_id() {
			return link_tool_id;
		}

		/**
		 * @param link_tool_id the link_tool_id to set
		 */
		public void setLink_tool_id(int link_tool_id) {
			this.link_tool_id = link_tool_id;
		}

		/**
		 * @return the link_content_id
		 */
		public int getLink_content_id() {
			return link_content_id;
		}

		/**
		 * @param link_content_id the link_content_id to set
		 */
		public void setLink_content_id(int link_content_id) {
			this.link_content_id = link_content_id;
		}

		
}

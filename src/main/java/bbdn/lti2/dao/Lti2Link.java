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
		   private int bbdn_link_id;
		  
		   @Column(value = "bbdn_link_title")
		   private String bbdn_link_title;
		   
		   @Column(value = "bbdn_link_url")
		   private String bbdn_link_url;
		 
		   @Column(value = "bbdn_link_key")
		   private String bbdn_link_key;
		 
		   @Column(value = "bbdn_link_secret")
		   private String bbdn_link_secret;
		 
		   @Column(value = "bbdn_link_custom_params")
		   private String bbdn_link_custom_params;
		   
		   @Column(value = "bbdn_link_tool_id")
		   private int bbdn_link_tool_id;
		   
		   @Column(value = "bbdn_link_content_id")
		   private int bbdn_link_content_id;

		/**
		 * @return the bbdn_link_id
		 */
		public int getBbdn_link_id() {
			return bbdn_link_id;
		}

		/**
		 * @param bbdn_link_id the bbdn_link_id to set
		 */
		public void setBbdn_link_id(int bbdn_link_id) {
			this.bbdn_link_id = bbdn_link_id;
		}

		/**
		 * @return the bbdn_link_title
		 */
		public String getBbdn_link_title() {
			return bbdn_link_title;
		}

		/**
		 * @param bbdn_link_title the bbdn_link_title to set
		 */
		public void setBbdn_link_title(String bbdn_link_title) {
			this.bbdn_link_title = bbdn_link_title;
		}

		/**
		 * @return the bbdn_link_url
		 */
		public String getBbdn_link_url() {
			return bbdn_link_url;
		}

		/**
		 * @param bbdn_link_url the bbdn_link_url to set
		 */
		public void setBbdn_link_url(String bbdn_link_url) {
			this.bbdn_link_url = bbdn_link_url;
		}

		/**
		 * @return the bbdn_link_key
		 */
		public String getBbdn_link_key() {
			return bbdn_link_key;
		}

		/**
		 * @param bbdn_link_key the bbdn_link_key to set
		 */
		public void setBbdn_link_key(String bbdn_link_key) {
			this.bbdn_link_key = bbdn_link_key;
		}

		/**
		 * @return the bbdn_link_secret
		 */
		public String getBbdn_link_secret() {
			return bbdn_link_secret;
		}

		/**
		 * @param bbdn_link_secret the bbdn_link_secret to set
		 */
		public void setBbdn_link_secret(String bbdn_link_secret) {
			this.bbdn_link_secret = bbdn_link_secret;
		}

		/**
		 * @return the bbdn_link_custom_params
		 */
		public String getBbdn_link_custom_params() {
			return bbdn_link_custom_params;
		}

		/**
		 * @param bbdn_link_custom_params the bbdn_link_custom_params to set
		 */
		public void setBbdn_link_custom_params(String bbdn_link_custom_params) {
			this.bbdn_link_custom_params = bbdn_link_custom_params;
		}

		/**
		 * @return the bbdn_link_tool_id
		 */
		public int getBbdn_link_tool_id() {
			return bbdn_link_tool_id;
		}

		/**
		 * @param bbdn_link_tool_id the bbdn_link_tool_id to set
		 */
		public void setBbdn_link_tool_id(int bbdn_link_tool_id) {
			this.bbdn_link_tool_id = bbdn_link_tool_id;
		}

		/**
		 * @return the bbdn_link_content_id
		 */
		public int getBbdn_link_content_id() {
			return bbdn_link_content_id;
		}

		/**
		 * @param bbdn_link_content_id the bbdn_link_content_id to set
		 */
		public void setBbdn_link_content_id(int bbdn_link_content_id) {
			this.bbdn_link_content_id = bbdn_link_content_id;
		}
		
		   
}

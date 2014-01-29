package bbdn.lti2.dao;

import blackboard.data.AbstractIdentifiable;
import blackboard.persist.DataType;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.Table;

@Table("bbdn_lti2_tools")
public class Lti2ProviderDomain  extends AbstractIdentifiable {

		   public static final DataType DATA_TYPE = new DataType( Lti2ProviderDomain.class );
		   
		   public DataType getDataType() {
				return DATA_TYPE;
		   }

		   @PrimaryKey
		   private int tool_id;
		  
		   @Column(value = "tool_domain")
		   private String tool_domain;
		   
		   @Column(value = "tool_status_ind")
		   private char tool_status_ind;
		 
		   @Column(value = "tool_sechostnames")
		   private String tool_sechostnames;
		 
		   @Column(value = "tool_key")
		   private String tool_key;
		 
		   @Column(value = "tool_secret")
		   private String tool_secret;
		   
		   @Column(value = "tool_customparams")
		   private String tool_customparams;
		   
		   @Column(value = "tool_postgrades_ind")
		   private char tool_postgrades_ind;
		   
		   @Column(value = "tool_getgrades_ind")
		   private char tool_getgrades_ind;
		   
		   @Column(value = "tool_toolcfg_ind")
		   private char tool_toolcfg_ind;
		   
		   @Column(value = "tool_senddata")
		   private int tool_senddata;
		   
		   @Column(value = "tool_sendrole_ind")
		   private char tool_sendrole_ind;

		   @Column(value = "tool_sendname_ind")
		   private char tool_sendname_ind;

		   @Column(value = "tool_sendemail_ind")
		   private char tool_sendemail_ind;

		   @Column(value = "tool_userack_ind")
		   private char tool_userack_ind;

		   @Column(value = "tool_ackmsg")
		   private String tool_ackmsg;

		/**
		 * @return the tool_id
		 */
		public int getTool_id() {
			return tool_id;
		}

		/**
		 * @param tool_id the tool_id to set
		 */
		public void setTool_id(int tool_id) {
			this.tool_id = tool_id;
		}

		/**
		 * @return the tool_domain
		 */
		public String getTool_domain() {
			return tool_domain;
		}

		/**
		 * @param tool_domain the tool_domain to set
		 */
		public void setTool_domain(String tool_domain) {
			this.tool_domain = tool_domain;
		}

		/**
		 * @return the tool_status_ind
		 */
		public char getTool_status_ind() {
			return tool_status_ind;
		}

		/**
		 * @param tool_status_ind the tool_status_ind to set
		 */
		public void setTool_status_ind(char tool_status_ind) {
			this.tool_status_ind = tool_status_ind;
		}

		/**
		 * @return the tool_sechostnames
		 */
		public String getTool_sechostnames() {
			return tool_sechostnames;
		}

		/**
		 * @param tool_sechostnames the tool_sechostnames to set
		 */
		public void setTool_sechostnames(String tool_sechostnames) {
			this.tool_sechostnames = tool_sechostnames;
		}

		/**
		 * @return the tool_key
		 */
		public String getTool_key() {
			return tool_key;
		}

		/**
		 * @param tool_key the tool_key to set
		 */
		public void setTool_key(String tool_key) {
			this.tool_key = tool_key;
		}

		/**
		 * @return the tool_secret
		 */
		public String getTool_secret() {
			return tool_secret;
		}

		/**
		 * @param tool_secret the tool_secret to set
		 */
		public void setTool_secret(String tool_secret) {
			this.tool_secret = tool_secret;
		}

		/**
		 * @return the tool_customparams
		 */
		public String getTool_customparams() {
			return tool_customparams;
		}

		/**
		 * @param tool_customparams the tool_customparams to set
		 */
		public void setTool_customparams(String tool_customparams) {
			this.tool_customparams = tool_customparams;
		}

		/**
		 * @return the tool_postgrades_ind
		 */
		public char getTool_postgrades_ind() {
			return tool_postgrades_ind;
		}

		/**
		 * @param tool_postgrades_ind the tool_postgrades_ind to set
		 */
		public void setTool_postgrades_ind(char tool_postgrades_ind) {
			this.tool_postgrades_ind = tool_postgrades_ind;
		}

		/**
		 * @return the tool_getgrades_ind
		 */
		public char getTool_getgrades_ind() {
			return tool_getgrades_ind;
		}

		/**
		 * @param tool_getgrades_ind the tool_getgrades_ind to set
		 */
		public void setTool_getgrades_ind(char tool_getgrades_ind) {
			this.tool_getgrades_ind = tool_getgrades_ind;
		}

		/**
		 * @return the tool_toolsettings_ind
		 */
		public char getTool_toolsettings_ind() {
			return tool_toolcfg_ind;
		}

		/**
		 * @param tool_toolsettings_ind the tool_toolsettings_ind to set
		 */
		public void setTool_toolsettings_ind(char tool_toolsettings_ind) {
			this.tool_toolcfg_ind = tool_toolsettings_ind;
		}

		/**
		 * @return the tool_senddata
		 */
		public int getTool_senddata() {
			return tool_senddata;
		}

		/**
		 * @param tool_senddata the tool_senddata to set
		 */
		public void setTool_senddata(int tool_senddata) {
			this.tool_senddata = tool_senddata;
		}

		/**
		 * @return the tool_sendrole_ind
		 */
		public char getTool_sendrole_ind() {
			return tool_sendrole_ind;
		}

		/**
		 * @param tool_sendrole_ind the tool_sendrole_ind to set
		 */
		public void setTool_sendrole_ind(char tool_sendrole_ind) {
			this.tool_sendrole_ind = tool_sendrole_ind;
		}

		/**
		 * @return the tool_sendname_ind
		 */
		public char getTool_sendname_ind() {
			return tool_sendname_ind;
		}

		/**
		 * @param tool_sendname_ind the tool_sendname_ind to set
		 */
		public void setTool_sendname_ind(char tool_sendname_ind) {
			this.tool_sendname_ind = tool_sendname_ind;
		}

		/**
		 * @return the tool_sendemail_ind
		 */
		public char getTool_sendemail_ind() {
			return tool_sendemail_ind;
		}

		/**
		 * @param tool_sendemail_ind the tool_sendemail_ind to set
		 */
		public void setTool_sendemail_ind(char tool_sendemail_ind) {
			this.tool_sendemail_ind = tool_sendemail_ind;
		}

		/**
		 * @return the tool_userack_ind
		 */
		public char getTool_userack_ind() {
			return tool_userack_ind;
		}

		/**
		 * @param tool_userack_ind the tool_userack_ind to set
		 */
		public void setTool_userack_ind(char tool_userack_ind) {
			this.tool_userack_ind = tool_userack_ind;
		}

		/**
		 * @return the tool_ackmsg
		 */
		public String getTool_ackmsg() {
			return tool_ackmsg;
		}

		/**
		 * @param tool_ackmsg the tool_ackmsg to set
		 */
		public void setTool_ackmsg(String tool_ackmsg) {
			this.tool_ackmsg = tool_ackmsg;
		}

}

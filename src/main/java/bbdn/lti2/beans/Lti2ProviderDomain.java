package bbdn.lti2.beans;

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
		   private int pk1;
		  
		   @Column(value = "tool_domain")
		   private String tool_domain;
		   
		   @Column(value = "tool_status")
		   private int tool_status;
		   
		   @Column(value = "tool_global_ind")
		   private String tool_global_ind;
		 
		   @Column(value = "tool_sechost")
		   private String tool_sechost;
		 
		   @Column(value = "tool_key")
		   private String tool_key;
		 
		   @Column(value = "tool_secret")
		   private String tool_secret;
		   
		   @Column(value = "tool_customparams")
		   private String tool_customparams;
		   
		   @Column(value = "tool_postgrades_ind")
		   private String tool_postgrades_ind;
		   
		   @Column(value = "tool_getgrades_ind")
		   private String tool_getgrades_ind;
		   
		   @Column(value = "tool_toolcfg_ind")
		   private String tool_toolcfg_ind;
		   
		   @Column(value = "tool_senddata")
		   private int tool_senddata;
		   
		   @Column(value = "tool_sendrole_ind")
		   private String tool_sendrole_ind;

		   @Column(value = "tool_sendname_ind")
		   private String tool_sendname_ind;

		   @Column(value = "tool_sendemail_ind")
		   private String tool_sendemail_ind;

		   @Column(value = "tool_userack_ind")
		   private String tool_userack_ind;

		   @Column(value = "tool_ackmsg")
		   private String tool_ackmsg;

		   /**
			 * @return the tool_id
			 */
			public int getToolId() {
				return pk1;
			}
			
		/**
		 * @return the tool_domain
		 */
		public String getDomain() {
			return tool_domain;
		}

		/**
		 * @param tool_domain the tool_domain to set
		 */
		public void setDomain(String tool_domain) {
			this.tool_domain = tool_domain;
		}

		/**
		 * @return the tool_status_ind
		 */
		public int getDomainStatus() {
			return this.tool_status;
		}

		/**
		 * @param flag : If true, set tool_status_ind to 'Y', else 'N'
		 */
		public void setDomainStatus(int domainStatus) {
			this.tool_status = domainStatus;
			
		}
		
		/**
		 * @return the tool_status_ind
		 */
		public Boolean isDomainConfiguredGlobally() {
			if ( this.tool_global_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set tool_status_ind to 'Y', else 'N'
		 */
		public void setDomainConfigGlobally(Boolean flag) {
			if (flag) {
				this.tool_global_ind = "Y";
			} else {
				this.tool_global_ind = "N";
			}
			
		}

		/**
		 * @return the tool_sechostnames
		 */
		public String getSecHostNames() {
			return tool_sechost;
		}

		/**
		 * @param tool_sechostnames the tool_sechostnames to set
		 */
		public void setSecHostNames(String tool_sechostnames) {
			this.tool_sechost = tool_sechostnames;
		}

		/**
		 * @return the tool_key
		 */
		public String getConsumerKey() {
			return tool_key;
		}

		/**
		 * @param tool_key the tool_key to set
		 */
		public void setConsumerKey(String tool_key) {
			this.tool_key = tool_key;
		}

		/**
		 * @return the tool_secret
		 */
		public String getSharedSecret() {
			return tool_secret;
		}

		/**
		 * @param tool_secret the tool_secret to set
		 */
		public void setSharedSecret(String tool_secret) {
			this.tool_secret = tool_secret;
		}

		/**
		 * @return the tool_customparams
		 */
		public String getCustomParams() {
			return tool_customparams;
		}

		/**
		 * @param tool_customparams the tool_customparams to set
		 */
		public void setCustomParams(String tool_customparams) {
			this.tool_customparams = tool_customparams;
		}

		/**
		 * @return the tool_postgrades_ind
		 */
		public Boolean isPostGradesEnabled() {
			if ( this.tool_postgrades_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set tool_postgrades_ind to 'Y', else 'N'
		 */
		public void enablePostGrades(Boolean flag) {
			if (flag) {
				this.tool_postgrades_ind = "Y";
			} else {
				this.tool_postgrades_ind = "N";
			}
			
		}

		/**
		 * @return the tool_getgrades_ind
		 */
		public Boolean isGetGradesEnabled() {
			if ( this.tool_getgrades_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set tool_getgrades_ind to 'Y', else 'N'
		 */
		public void enableGetGrades(Boolean flag) {
			if (flag) {
				this.tool_getgrades_ind = "Y";
			} else {
				this.tool_getgrades_ind = "N";
			}
			
		}
		
		/**
		 * @return the tool_toolcfg_ind
		 */
		public Boolean isToolSettingsEnabled() {
			if ( this.tool_toolcfg_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set tool_toolcfg_ind to 'Y', else 'N'
		 */
		public void enableToolSettings(Boolean flag) {
			if (flag) {
				this.tool_toolcfg_ind = "Y";
			} else {
				this.tool_toolcfg_ind = "N";
			}
			
		}

		/**
		 * @return the tool_senddata
		 */
		public int getSendDataConfig() {
			return tool_senddata;
		}

		/**
		 * @param tool_senddata the tool_senddata to set
		 */
		public void setSendDataConfig(int tool_senddata) {
			this.tool_senddata = tool_senddata;
		}

		/**
		 * @return the tool_sendrole_ind
		 */
		public Boolean isSendRoleEnabled() {
			if ( this.tool_sendrole_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set tool_sendrole_ind to 'Y', else 'N'
		 */
		public void enableSendRole(Boolean flag) {
			if (flag) {
				this.tool_sendrole_ind = "Y";
			} else {
				this.tool_sendrole_ind = "N";
			}
			
		}

		/**
		 * @return the tool_sendname_ind
		 */
		public Boolean isSendNameEnabled() {
			if ( this.tool_sendname_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set tool_sendname_ind to 'Y', else 'N'
		 */
		public void enableSendName(Boolean flag) {
			if (flag) {
				this.tool_sendname_ind = "Y";
			} else {
				this.tool_sendname_ind = "N";
			}
			
		}

		/**
		 * @return the tool_sendemail_ind
		 */
		public Boolean isSendEMailEnabled() {
			if ( this.tool_sendemail_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set tool_sendemail_ind to 'Y', else 'N'
		 */
		public void enableSendEMail(Boolean flag) {
			if (flag) {
				this.tool_sendemail_ind = "Y";
			} else {
				this.tool_sendemail_ind = "N";
			}
			
		}

		/**
		 * @return the tool_userack_ind
		 */
		public Boolean isSplashScreenEnabled() {
			if ( this.tool_userack_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set tool_status_ind to 'Y', else 'N'
		 */
		public void enableSplashScreen(Boolean flag) {
			if (flag) {
				this.tool_userack_ind = "Y";
			} else {
				this.tool_userack_ind = "N";
			}
			
		}

		/**
		 * @return the tool_ackmsg
		 */
		public String getSplashScreenMessage() {
			return tool_ackmsg;
		}

		/**
		 * @param tool_ackmsg the tool_ackmsg to set
		 */
		public void setSplashScreenMessage(String tool_ackmsg) {
			this.tool_ackmsg = tool_ackmsg;
		}
}
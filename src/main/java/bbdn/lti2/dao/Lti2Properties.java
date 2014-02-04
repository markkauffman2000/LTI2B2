package bbdn.lti2.dao;

import blackboard.data.AbstractIdentifiable;
import blackboard.persist.DataType;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.Table;

@Table("bbdn_lti2_props")
public class Lti2Properties  extends AbstractIdentifiable {

		   public static final DataType DATA_TYPE = new DataType( Lti2Properties.class );
		   
		   public DataType getDataType() {
				return DATA_TYPE;
		   }

		   @PrimaryKey
		   private int pk1;
		  
		   @Column(value = "props_crs_ind")
		   private String props_crs_ind;
		   
		   @Column(value = "props_orgs_ind")
		   private String props_orgs_ind;
		 
		   @Column(value = "props_links")
		   private int props_links;
		 
		   @Column(value = "props_postgrades_ind")
		   private String props_postgrades_ind;
		 
		   @Column(value = "props_getgrades_ind")
		   private String props_getgrades_ind;

		   @Column(value = "props_toolcfg_ind")
		   private String props_toolcfg_ind;
		   
		   @Column(value = "props_senddata")
		   private int props_senddata;
		   
		   @Column(value = "props_sendrole_ind")
		   private String props_sendrole_ind;
		   
		   @Column(value = "props_sendname_ind")
		   private String props_sendname_ind;
		   
		   @Column(value = "props_sendemail_ind")
		   private String props_sendemail_ind;

		   @Column(value = "props_userack_ind")
		   private String props_userack_ind;

		   @Column(value = "props_ackmsg")
		   private String props_ackmsg;


		   /**
			 * @return the props_id
			 */
			public int getPropertyId() {
				return pk1;
			}
			
		/**
		 * @return the props_crs_ind
		 */
		public Boolean isCourseEnabled() {
			if ( this.props_crs_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_crs_ind to 'Y', else 'N'
		 */
		public void enableCourses(Boolean flag) {
			if (flag) {
				this.props_crs_ind = "Y";
			} else {
				this.props_crs_ind = "N";
			}
			
		}

		/**
		 * @return the props_orgs_ind
		 */
		public Boolean isOrgsEnabled() {
			if ( this.props_orgs_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_orgs_ind to 'Y', else 'N'
		 */
		public void enableOrgs(Boolean flag) {
			if (flag) {
				this.props_orgs_ind = "Y";
			} else {
				this.props_orgs_ind = "N";
			}
			
		}

		/**
		 * @return the props_links
		 */
		public int getPropertyLinkType() {
			return props_links;
		}

		/**
		 * @param props_links the props_links to set
		 */
		public void setPropertyLinkType(int props_links) {
			this.props_links = props_links;
		}

		/**
		 * @return the props_postgrades_ind
		 */
		public Boolean isPostGradesEnabled() {
			if ( this.props_postgrades_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_postgrades_ind to 'Y', else 'N'
		 */
		public void enablePostGrades(Boolean flag) {
			if (flag) {
				this.props_postgrades_ind = "Y";
			} else {
				this.props_postgrades_ind = "N";
			}
			
		}

		/**
		 * @return the props_getgrades_ind
		 */
		public Boolean isGetGradesEnabled() {
			if ( this.props_getgrades_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_getgrades_ind to 'Y', else 'N'
		 */
		public void enableGetGrades(Boolean flag) {
			if (flag) {
				this.props_getgrades_ind = "Y";
			} else {
				this.props_getgrades_ind = "N";
			}
			
		}

		/**
		 * @return the props_toolcfg_ind
		 */
		public Boolean isToolSettingsEnabled() {
			if ( this.props_toolcfg_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_toolcfg_ind to 'Y', else 'N'
		 */
		public void enableToolSettings(Boolean flag) {
			if (flag) {
				this.props_toolcfg_ind = "Y";
			} else {
				this.props_toolcfg_ind = "N";
			}
			
		}

		/**
		 * @return the props_senddata
		 */
		public int getSendDataConfig() {
			return props_senddata;
		}

		/**
		 * @param props_senddata the props_senddata to set
		 */
		public void setSendDataConfig(int props_senddata) {
			this.props_senddata = props_senddata;
		}

		/**
		 * @return the props_sendrole_ind
		 */
		public Boolean isSendRoleEnabled() {
			if ( this.props_sendrole_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_sendrole_ind to 'Y', else 'N'
		 */
		public void enableSendRole(Boolean flag) {
			if (flag) {
				this.props_sendrole_ind = "Y";
			} else {
				this.props_sendrole_ind = "N";
			}
			
		}

		/**
		 * @return the props_sendname_ind
		 */
		public Boolean isSendNameEnabled() {
			if ( this.props_sendname_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_sendname_ind to 'Y', else 'N'
		 */
		public void enableSendName(Boolean flag) {
			if (flag) {
				this.props_sendname_ind = "Y";
			} else {
				this.props_sendname_ind = "N";
			}
			
		}

		/**
		 * @return the props_sendemail_ind
		 */
		public Boolean isSendEMailEnabled() {
			if ( this.props_sendemail_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_sendemail_ind to 'Y', else 'N'
		 */
		public void enableSendEMail(Boolean flag) {
			if (flag) {
				this.props_sendemail_ind = "Y";
			} else {
				this.props_sendemail_ind = "N";
			}
			
		}

		/**
		 * @return the props_userack_ind
		 */

		public Boolean isSplashScreenEnabled() {
			if ( this.props_userack_ind.equals("Y") ) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @param flag : If true, set props_userack_ind to 'Y', else 'N'
		 */
		public void enableSplashScreen(Boolean flag) {
			if (flag) {
				this.props_userack_ind = "Y";
			} else {
				this.props_userack_ind = "N";
			}
			
		}

		/**
		 * @return the props_ackmsg
		 */
		public String getSplashScreenMessage() {
			return props_ackmsg;
		}

		/**
		 * @param props_ackmsg the props_ackmsg to set
		 */
		public void setSplashScreenMessage(String props_ackmsg) {
			this.props_ackmsg = props_ackmsg;
		}
		   
}

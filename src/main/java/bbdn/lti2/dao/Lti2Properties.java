package bbdn.lti2.dao;

import blackboard.data.AbstractIdentifiable;
import blackboard.persist.DataType;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.Table;

@Table("bbdn_lti2_properties")
public class Lti2Properties  extends AbstractIdentifiable {

		   public static final DataType DATA_TYPE = new DataType( Lti2Properties.class );
		   
		   public DataType getDataType() {
				return DATA_TYPE;
		   }

		   @PrimaryKey
		   private int props_id;
		  
		   @Column(value = "props_courses_ind")
		   private char props_courses_ind;
		   
		   @Column(value = "props_orgs_ind")
		   private char props_orgs_ind;
		 
		   @Column(value = "props_links")
		   private int props_links;
		 
		   @Column(value = "props_postgrades_ind")
		   private char props_postgrades_ind;
		 
		   @Column(value = "props_getgrades_ind")
		   private char props_getgrades_ind;

		   @Column(value = "props_toolsettings_ind")
		   private char props_toolsettings_ind;
		   
		   @Column(value = "props_senddata")
		   private int props_senddata;
		   
		   @Column(value = "props_sendrole_ind")
		   private char props_sendrole_ind;
		   
		   @Column(value = "props_sendname_ind")
		   private char props_sendname_ind;
		   
		   @Column(value = "props_sendemail_ind")
		   private char props_sendemail_ind;

		   @Column(value = "props_userack_ind")
		   private char props_userack_ind;

		   @Column(value = "props_ackmsg")
		   private String props_ackmsg;

		/**
		 * @return the props_id
		 */
		public int getProps_id() {
			return props_id;
		}

		/**
		 * @param props_id the props_id to set
		 */
		public void setProps_id(int props_id) {
			this.props_id = props_id;
		}

		/**
		 * @return the props_courses_ind
		 */
		public char getProps_courses_ind() {
			return props_courses_ind;
		}

		/**
		 * @param props_courses_ind the props_courses_ind to set
		 */
		public void setProps_courses_ind(char props_courses_ind) {
			this.props_courses_ind = props_courses_ind;
		}

		/**
		 * @return the props_orgs_ind
		 */
		public char getProps_orgs_ind() {
			return props_orgs_ind;
		}

		/**
		 * @param props_orgs_ind the props_orgs_ind to set
		 */
		public void setProps_orgs_ind(char props_orgs_ind) {
			this.props_orgs_ind = props_orgs_ind;
		}

		/**
		 * @return the props_links
		 */
		public int getProps_links() {
			return props_links;
		}

		/**
		 * @param props_links the props_links to set
		 */
		public void setProps_links(int props_links) {
			this.props_links = props_links;
		}

		/**
		 * @return the props_postgrades_ind
		 */
		public char getProps_postgrades_ind() {
			return props_postgrades_ind;
		}

		/**
		 * @param props_postgrades_ind the props_postgrades_ind to set
		 */
		public void setProps_postgrades_ind(char props_postgrades_ind) {
			this.props_postgrades_ind = props_postgrades_ind;
		}

		/**
		 * @return the props_getgrades_ind
		 */
		public char getProps_getgrades_ind() {
			return props_getgrades_ind;
		}

		/**
		 * @param props_getgrades_ind the props_getgrades_ind to set
		 */
		public void setProps_getgrades_ind(char props_getgrades_ind) {
			this.props_getgrades_ind = props_getgrades_ind;
		}

		/**
		 * @return the props_toolsettings_ind
		 */
		public char getProps_toolsettings_ind() {
			return props_toolsettings_ind;
		}

		/**
		 * @param props_toolsettings_ind the props_toolsettings_ind to set
		 */
		public void setProps_toolsettings_ind(char props_toolsettings_ind) {
			this.props_toolsettings_ind = props_toolsettings_ind;
		}

		/**
		 * @return the props_senddata
		 */
		public int getProps_senddata() {
			return props_senddata;
		}

		/**
		 * @param props_senddata the props_senddata to set
		 */
		public void setProps_senddata(int props_senddata) {
			this.props_senddata = props_senddata;
		}

		/**
		 * @return the props_sendrole_ind
		 */
		public char getProps_sendrole_ind() {
			return props_sendrole_ind;
		}

		/**
		 * @param props_sendrole_ind the props_sendrole_ind to set
		 */
		public void setProps_sendrole_ind(char props_sendrole_ind) {
			this.props_sendrole_ind = props_sendrole_ind;
		}

		/**
		 * @return the props_sendname_ind
		 */
		public char getProps_sendname_ind() {
			return props_sendname_ind;
		}

		/**
		 * @param props_sendname_ind the props_sendname_ind to set
		 */
		public void setProps_sendname_ind(char props_sendname_ind) {
			this.props_sendname_ind = props_sendname_ind;
		}

		/**
		 * @return the props_sendemail_ind
		 */
		public char getProps_sendemail_ind() {
			return props_sendemail_ind;
		}

		/**
		 * @param props_sendemail_ind the props_sendemail_ind to set
		 */
		public void setProps_sendemail_ind(char props_sendemail_ind) {
			this.props_sendemail_ind = props_sendemail_ind;
		}

		/**
		 * @return the props_userack_ind
		 */
		public char getProps_userack_ind() {
			return props_userack_ind;
		}

		/**
		 * @param props_userack_ind the props_userack_ind to set
		 */
		public void setProps_userack_ind(char props_userack_ind) {
			this.props_userack_ind = props_userack_ind;
		}

		/**
		 * @return the props_ackmsg
		 */
		public String getProps_ackmsg() {
			return props_ackmsg;
		}

		/**
		 * @param props_ackmsg the props_ackmsg to set
		 */
		public void setProps_ackmsg(String props_ackmsg) {
			this.props_ackmsg = props_ackmsg;
		}

		   
}

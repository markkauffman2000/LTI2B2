package bbdn.lti2.dao;

import blackboard.base.FormattedText;
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
		   private int bbdn_tool_id;
		  
		   @Column(value = "bbdn_tool_domain")
		   private String bbdn_tool_domain;
		   
		   @Column(value = "bbdn_tool_approved_ind")
		   private char bbdn_tool_approved_ind;
		 
		   @Column(value = "bbdn_tool_secondary_hostnames")
		   private String bbdn_tool_secondary_hostnames;
		 
		   @Column(value = "bbdn_tool_key")
		   private String bbdn_tool_key;
		 
		   @Column(value = "bbdn_tool_secret")
		   private String bbdn_tool_secret;
		   
		   @Column(value = "bbdn_tool_custom_params")
		   private String bbdn_tool_custom_params;
		   
		   @Column(value = "bbdn_tool_grades_enabled_post_ind")
		   private char bbdn_tool_grades_enabled_post_ind;
		   
		   @Column(value = "bbdn_tool_grades_enabled_get_ind")
		   private char bbdn_tool_grades_enabled_get_ind;
		   
		   @Column(value = "bbdn_tool_put_tool_settings_ind")
		   private char bbdn_tool_put_tool_settings_ind;
		   
		   @Column(value = "bbdn_tool_send_userdata")
		   private int bbdn_tool_send_userdata;
		   
		   @Column(value = "bbdn_tool_send_role_ind")
		   private char bbdn_tool_send_role_ind;

		   @Column(value = "bbdn_tool_send_username_ind")
		   private char bbdn_tool_send_username_ind;

		   @Column(value = "bbdn_tool_send_email_ind")
		   private char bbdn_tool_send_email_ind;

		   @Column(value = "bbdn_tool_provide_roster_ind")
		   private char bbdn_tool_provide_roster_ind;

		   @Column(value = "bbdn_tool_external_settings_ind")
		   private char bbdn_tool_external_settings_ind;

		   @Column(value = "bbdn_tool_access_lessons_ind")
		   private char bbdn_tool_access_lessons_ind;

		   @Column(value = "bbdn_tool_user_ack_ind")
		   private char bbdn_tool_user_ack_ind;

		   @Column(value = "bbdn_tool_user_ack_msg")
		   private FormattedText bbdn_tool_user_ack_msg;

		/**
		 * @return the bbdn_tool_id
		 */
		public int getBbdn_tool_id() {
			return bbdn_tool_id;
		}

		/**
		 * @param bbdn_tool_id the bbdn_tool_id to set
		 */
		public void setBbdn_tool_id(int bbdn_tool_id) {
			this.bbdn_tool_id = bbdn_tool_id;
		}

		/**
		 * @return the bbdn_tool_domain
		 */
		public String getBbdn_tool_domain() {
			return bbdn_tool_domain;
		}

		/**
		 * @param bbdn_tool_domain the bbdn_tool_domain to set
		 */
		public void setBbdn_tool_domain(String bbdn_tool_domain) {
			this.bbdn_tool_domain = bbdn_tool_domain;
		}

		/**
		 * @return the bbdn_tool_approved_ind
		 */
		public char getBbdn_tool_approved_ind() {
			return bbdn_tool_approved_ind;
		}

		/**
		 * @param bbdn_tool_approved_ind the bbdn_tool_approved_ind to set
		 */
		public void setBbdn_tool_approved_ind(char bbdn_tool_approved_ind) {
			this.bbdn_tool_approved_ind = bbdn_tool_approved_ind;
		}

		/**
		 * @return the bbdn_tool_secondary_hostnames
		 */
		public String getBbdn_tool_secondary_hostnames() {
			return bbdn_tool_secondary_hostnames;
		}

		/**
		 * @param bbdn_tool_secondary_hostnames the bbdn_tool_secondary_hostnames to set
		 */
		public void setBbdn_tool_secondary_hostnames(
				String bbdn_tool_secondary_hostnames) {
			this.bbdn_tool_secondary_hostnames = bbdn_tool_secondary_hostnames;
		}

		/**
		 * @return the bbdn_tool_key
		 */
		public String getBbdn_tool_key() {
			return bbdn_tool_key;
		}

		/**
		 * @param bbdn_tool_key the bbdn_tool_key to set
		 */
		public void setBbdn_tool_key(String bbdn_tool_key) {
			this.bbdn_tool_key = bbdn_tool_key;
		}

		/**
		 * @return the bbdn_tool_secret
		 */
		public String getBbdn_tool_secret() {
			return bbdn_tool_secret;
		}

		/**
		 * @param bbdn_tool_secret the bbdn_tool_secret to set
		 */
		public void setBbdn_tool_secret(String bbdn_tool_secret) {
			this.bbdn_tool_secret = bbdn_tool_secret;
		}

		/**
		 * @return the bbdn_tool_custom_params
		 */
		public String getBbdn_tool_custom_params() {
			return bbdn_tool_custom_params;
		}

		/**
		 * @param bbdn_tool_custom_params the bbdn_tool_custom_params to set
		 */
		public void setBbdn_tool_custom_params(String bbdn_tool_custom_params) {
			this.bbdn_tool_custom_params = bbdn_tool_custom_params;
		}

		/**
		 * @return the bbdn_tool_grades_enabled_post_ind
		 */
		public char getBbdn_tool_grades_enabled_post_ind() {
			return bbdn_tool_grades_enabled_post_ind;
		}

		/**
		 * @param bbdn_tool_grades_enabled_post_ind the bbdn_tool_grades_enabled_post_ind to set
		 */
		public void setBbdn_tool_grades_enabled_post_ind(
				char bbdn_tool_grades_enabled_post_ind) {
			this.bbdn_tool_grades_enabled_post_ind = bbdn_tool_grades_enabled_post_ind;
		}

		/**
		 * @return the bbdn_tool_grades_enabled_get_ind
		 */
		public char getBbdn_tool_grades_enabled_get_ind() {
			return bbdn_tool_grades_enabled_get_ind;
		}

		/**
		 * @param bbdn_tool_grades_enabled_get_ind the bbdn_tool_grades_enabled_get_ind to set
		 */
		public void setBbdn_tool_grades_enabled_get_ind(
				char bbdn_tool_grades_enabled_get_ind) {
			this.bbdn_tool_grades_enabled_get_ind = bbdn_tool_grades_enabled_get_ind;
		}

		/**
		 * @return the bbdn_tool_put_tool_settings_ind
		 */
		public char getBbdn_tool_put_tool_settings_ind() {
			return bbdn_tool_put_tool_settings_ind;
		}

		/**
		 * @param bbdn_tool_put_tool_settings_ind the bbdn_tool_put_tool_settings_ind to set
		 */
		public void setBbdn_tool_put_tool_settings_ind(
				char bbdn_tool_put_tool_settings_ind) {
			this.bbdn_tool_put_tool_settings_ind = bbdn_tool_put_tool_settings_ind;
		}

		/**
		 * @return the bbdn_tool_send_userdata
		 */
		public int getBbdn_tool_send_userdata() {
			return bbdn_tool_send_userdata;
		}

		/**
		 * @param bbdn_tool_send_userdata the bbdn_tool_send_userdata to set
		 */
		public void setBbdn_tool_send_userdata(int bbdn_tool_send_userdata) {
			this.bbdn_tool_send_userdata = bbdn_tool_send_userdata;
		}

		/**
		 * @return the bbdn_tool_send_role_ind
		 */
		public char getBbdn_tool_send_role_ind() {
			return bbdn_tool_send_role_ind;
		}

		/**
		 * @param bbdn_tool_send_role_ind the bbdn_tool_send_role_ind to set
		 */
		public void setBbdn_tool_send_role_ind(char bbdn_tool_send_role_ind) {
			this.bbdn_tool_send_role_ind = bbdn_tool_send_role_ind;
		}

		/**
		 * @return the bbdn_tool_send_username_ind
		 */
		public char getBbdn_tool_send_username_ind() {
			return bbdn_tool_send_username_ind;
		}

		/**
		 * @param bbdn_tool_send_username_ind the bbdn_tool_send_username_ind to set
		 */
		public void setBbdn_tool_send_username_ind(char bbdn_tool_send_username_ind) {
			this.bbdn_tool_send_username_ind = bbdn_tool_send_username_ind;
		}

		/**
		 * @return the bbdn_tool_send_email_ind
		 */
		public char getBbdn_tool_send_email_ind() {
			return bbdn_tool_send_email_ind;
		}

		/**
		 * @param bbdn_tool_send_email_ind the bbdn_tool_send_email_ind to set
		 */
		public void setBbdn_tool_send_email_ind(char bbdn_tool_send_email_ind) {
			this.bbdn_tool_send_email_ind = bbdn_tool_send_email_ind;
		}

		/**
		 * @return the bbdn_tool_provide_roster_ind
		 */
		public char getBbdn_tool_provide_roster_ind() {
			return bbdn_tool_provide_roster_ind;
		}

		/**
		 * @param bbdn_tool_provide_roster_ind the bbdn_tool_provide_roster_ind to set
		 */
		public void setBbdn_tool_provide_roster_ind(char bbdn_tool_provide_roster_ind) {
			this.bbdn_tool_provide_roster_ind = bbdn_tool_provide_roster_ind;
		}

		/**
		 * @return the bbdn_tool_external_settings_ind
		 */
		public char getBbdn_tool_external_settings_ind() {
			return bbdn_tool_external_settings_ind;
		}

		/**
		 * @param bbdn_tool_external_settings_ind the bbdn_tool_external_settings_ind to set
		 */
		public void setBbdn_tool_external_settings_ind(
				char bbdn_tool_external_settings_ind) {
			this.bbdn_tool_external_settings_ind = bbdn_tool_external_settings_ind;
		}

		/**
		 * @return the bbdn_tool_access_lessons_ind
		 */
		public char getBbdn_tool_access_lessons_ind() {
			return bbdn_tool_access_lessons_ind;
		}

		/**
		 * @param bbdn_tool_access_lessons_ind the bbdn_tool_access_lessons_ind to set
		 */
		public void setBbdn_tool_access_lessons_ind(char bbdn_tool_access_lessons_ind) {
			this.bbdn_tool_access_lessons_ind = bbdn_tool_access_lessons_ind;
		}

		/**
		 * @return the bbdn_tool_user_ack_ind
		 */
		public char getBbdn_tool_user_ack_ind() {
			return bbdn_tool_user_ack_ind;
		}

		/**
		 * @param bbdn_tool_user_ack_ind the bbdn_tool_user_ack_ind to set
		 */
		public void setBbdn_tool_user_ack_ind(char bbdn_tool_user_ack_ind) {
			this.bbdn_tool_user_ack_ind = bbdn_tool_user_ack_ind;
		}

		/**
		 * @return the bbdn_tool_user_ack_msg
		 */
		public FormattedText getBbdn_tool_user_ack_msg() {
			return bbdn_tool_user_ack_msg;
		}

		/**
		 * @param bbdn_tool_user_ack_msg the bbdn_tool_user_ack_msg to set
		 */
		public void setBbdn_tool_user_ack_msg(FormattedText bbdn_tool_user_ack_msg) {
			this.bbdn_tool_user_ack_msg = bbdn_tool_user_ack_msg;
		}

		   
}

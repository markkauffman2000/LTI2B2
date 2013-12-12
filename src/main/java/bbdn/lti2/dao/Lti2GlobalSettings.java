package bbdn.lti2.dao;

import blackboard.data.AbstractIdentifiable;
import blackboard.persist.DataType;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.Table;

@Table("bbdn_lti2_global_settings")
public class Lti2GlobalSettings  extends AbstractIdentifiable {

		   public static final DataType DATA_TYPE = new DataType( Lti2GlobalSettings.class );
		   
		   public DataType getDataType() {
				return DATA_TYPE;
		   }

		   @PrimaryKey
		   private int bbdn_global_settings_id;
		  
		   @Column(value = "bbdn_settings_courses_enabled_ind")
		   private char bbdn_settings_courses_enabled_ind;
		   
		   @Column(value = "bbdn_settings_courses_enabled_ind")
		   private char bbdn_settings_orgs_enabled_ind;
		 
		   @Column(value = "bbdn_settings_links_allowed")
		   private int bbdn_settings_links_allowed;
		 
		   @Column(value = "bbdn_settings_grades_enabled_post_ind")
		   private char bbdn_settings_grades_enabled_post_ind;
		 
		   @Column(value = "bbdn_settings_grades_enabled_get_ind")
		   private char bbdn_settings_grades_enabled_get_ind;
		   
		   @Column(value = "bbdn_settings_post_proxy_tools_ind")
		   private char bbdn_settings_post_proxy_tools_ind;
		   
		   @Column(value = "bbdn_settings_put_tool_settings_ind")
		   private char bbdn_settings_put_tool_settings_ind;
		   
		   @Column(value = "bbdn_settings_send_userdata")
		   private int bbdn_settings_send_userdata;
		   
		   @Column(value = "bbdn_settings_send_role_ind")
		   private char bbdn_settings_send_role_ind;
		   
		   @Column(value = "bbdn_settings_send_username_ind")
		   private char bbdn_settings_send_username_ind;
		   
		   @Column(value = "bbdn_settings_send_email_ind")
		   private char bbdn_settings_send_email_ind;

		   @Column(value = "bbdn_settings_user_ack_ind")
		   private char bbdn_settings_user_ack_ind;

		   @Column(value = "bbdn_settings_user_ack_msg")
		   private String bbdn_settings_user_ack_msg;

		/**
		 * @return the bbdn_global_settings_id
		 */
		public int getBbdn_global_settings_id() {
			return bbdn_global_settings_id;
		}

		/**
		 * @param bbdn_global_settings_id the bbdn_global_settings_id to set
		 */
		public void setBbdn_global_settings_id(int bbdn_global_settings_id) {
			this.bbdn_global_settings_id = bbdn_global_settings_id;
		}

		/**
		 * @return the bbdn_settings_courses_enabled_ind
		 */
		public char getBbdn_settings_courses_enabled_ind() {
			return bbdn_settings_courses_enabled_ind;
		}

		/**
		 * @param bbdn_settings_courses_enabled_ind the bbdn_settings_courses_enabled_ind to set
		 */
		public void setBbdn_settings_courses_enabled_ind(
				char bbdn_settings_courses_enabled_ind) {
			this.bbdn_settings_courses_enabled_ind = bbdn_settings_courses_enabled_ind;
		}

		/**
		 * @return the bbdn_settings_orgs_enabled_ind
		 */
		public char getBbdn_settings_orgs_enabled_ind() {
			return bbdn_settings_orgs_enabled_ind;
		}

		/**
		 * @param bbdn_settings_orgs_enabled_ind the bbdn_settings_orgs_enabled_ind to set
		 */
		public void setBbdn_settings_orgs_enabled_ind(
				char bbdn_settings_orgs_enabled_ind) {
			this.bbdn_settings_orgs_enabled_ind = bbdn_settings_orgs_enabled_ind;
		}

		/**
		 * @return the bbdn_settings_links_allowed
		 */
		public int getBbdn_settings_links_allowed() {
			return bbdn_settings_links_allowed;
		}

		/**
		 * @param bbdn_settings_links_allowed the bbdn_settings_links_allowed to set
		 */
		public void setBbdn_settings_links_allowed(int bbdn_settings_links_allowed) {
			this.bbdn_settings_links_allowed = bbdn_settings_links_allowed;
		}

		/**
		 * @return the bbdn_settings_grades_enabled_post_ind
		 */
		public char getBbdn_settings_grades_enabled_post_ind() {
			return bbdn_settings_grades_enabled_post_ind;
		}

		/**
		 * @param bbdn_settings_grades_enabled_post_ind the bbdn_settings_grades_enabled_post_ind to set
		 */
		public void setBbdn_settings_grades_enabled_post_ind(
				char bbdn_settings_grades_enabled_post_ind) {
			this.bbdn_settings_grades_enabled_post_ind = bbdn_settings_grades_enabled_post_ind;
		}

		/**
		 * @return the bbdn_settings_grades_enabled_get_ind
		 */
		public char getBbdn_settings_grades_enabled_get_ind() {
			return bbdn_settings_grades_enabled_get_ind;
		}

		/**
		 * @param bbdn_settings_grades_enabled_get_ind the bbdn_settings_grades_enabled_get_ind to set
		 */
		public void setBbdn_settings_grades_enabled_get_ind(
				char bbdn_settings_grades_enabled_get_ind) {
			this.bbdn_settings_grades_enabled_get_ind = bbdn_settings_grades_enabled_get_ind;
		}

		/**
		 * @return the bbdn_settings_post_proxy_tools_ind
		 */
		public char getBbdn_settings_post_proxy_tools_ind() {
			return bbdn_settings_post_proxy_tools_ind;
		}

		/**
		 * @param bbdn_settings_post_proxy_tools_ind the bbdn_settings_post_proxy_tools_ind to set
		 */
		public void setBbdn_settings_post_proxy_tools_ind(
				char bbdn_settings_post_proxy_tools_ind) {
			this.bbdn_settings_post_proxy_tools_ind = bbdn_settings_post_proxy_tools_ind;
		}

		/**
		 * @return the bbdn_settings_put_tool_settings_ind
		 */
		public char getBbdn_settings_put_tool_settings_ind() {
			return bbdn_settings_put_tool_settings_ind;
		}

		/**
		 * @param bbdn_settings_put_tool_settings_ind the bbdn_settings_put_tool_settings_ind to set
		 */
		public void setBbdn_settings_put_tool_settings_ind(
				char bbdn_settings_put_tool_settings_ind) {
			this.bbdn_settings_put_tool_settings_ind = bbdn_settings_put_tool_settings_ind;
		}

		/**
		 * @return the bbdn_settings_send_userdata
		 */
		public int getBbdn_settings_send_userdata() {
			return bbdn_settings_send_userdata;
		}

		/**
		 * @param bbdn_settings_send_userdata the bbdn_settings_send_userdata to set
		 */
		public void setBbdn_settings_send_userdata(int bbdn_settings_send_userdata) {
			this.bbdn_settings_send_userdata = bbdn_settings_send_userdata;
		}

		/**
		 * @return the bbdn_settings_send_role_ind
		 */
		public char getBbdn_settings_send_role_ind() {
			return bbdn_settings_send_role_ind;
		}

		/**
		 * @param bbdn_settings_send_role_ind the bbdn_settings_send_role_ind to set
		 */
		public void setBbdn_settings_send_role_ind(char bbdn_settings_send_role_ind) {
			this.bbdn_settings_send_role_ind = bbdn_settings_send_role_ind;
		}

		/**
		 * @return the bbdn_settings_send_username_ind
		 */
		public char getBbdn_settings_send_username_ind() {
			return bbdn_settings_send_username_ind;
		}

		/**
		 * @param bbdn_settings_send_username_ind the bbdn_settings_send_username_ind to set
		 */
		public void setBbdn_settings_send_username_ind(
				char bbdn_settings_send_username_ind) {
			this.bbdn_settings_send_username_ind = bbdn_settings_send_username_ind;
		}

		/**
		 * @return the bbdn_settings_send_email_ind
		 */
		public char getBbdn_settings_send_email_ind() {
			return bbdn_settings_send_email_ind;
		}

		/**
		 * @param bbdn_settings_send_email_ind the bbdn_settings_send_email_ind to set
		 */
		public void setBbdn_settings_send_email_ind(char bbdn_settings_send_email_ind) {
			this.bbdn_settings_send_email_ind = bbdn_settings_send_email_ind;
		}

		/**
		 * @return the bbdn_settings_user_ack_ind
		 */
		public char getBbdn_settings_user_ack_ind() {
			return bbdn_settings_user_ack_ind;
		}

		/**
		 * @param bbdn_settings_user_ack_ind the bbdn_settings_user_ack_ind to set
		 */
		public void setBbdn_settings_user_ack_ind(char bbdn_settings_user_ack_ind) {
			this.bbdn_settings_user_ack_ind = bbdn_settings_user_ack_ind;
		}

		/**
		 * @return the bbdn_settings_user_ack_msg
		 */
		public String getBbdn_settings_user_ack_msg() {
			return bbdn_settings_user_ack_msg;
		}

		/**
		 * @param bbdn_settings_user_ack_msg the bbdn_settings_user_ack_msg to set
		 */
		public void setBbdn_settings_user_ack_msg(
				String bbdn_settings_user_ack_msg) {
			this.bbdn_settings_user_ack_msg = bbdn_settings_user_ack_msg;
		}
		   
		   
}

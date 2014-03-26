package bbdn.lti2.beans;

import blackboard.data.AbstractIdentifiable;
import blackboard.persist.DataType;
import blackboard.persist.impl.mapping.annotation.Column;
import blackboard.persist.impl.mapping.annotation.PrimaryKey;
import blackboard.persist.impl.mapping.annotation.Table;

@Table("bbdn_lti2_sc")
public class Lti2Config extends AbstractIdentifiable {
	
	public static final DataType DATA_TYPE = new DataType( Lti2Link.class );
	   
	public DataType getDataType() {
		return DATA_TYPE;
	}

	@PrimaryKey
	private int pk1;
	  
	@Column(value = "sc_guid")
	private String guid;
	
	@Column(value = "sc_support_email")
	private String support_email;
	
	@Column(value = "sc_owner_id" )
	private String owner_id;
	
	@Column(value = "sc_owner_name")
	private String owner_name;
	
	@Column(value = "sc_owner_description" )
	private String owner_description;
	
	@Column(value = "sc_owner_email")
	private String owner_email;
	
	@Column(value = "sc_provider_id" )
	private String provider_id;
	
	@Column(value = "sc_provider_name")
	private String provider_name;
	
	@Column(value = "sc_provider_description" )
	private String provider_description;
	
	@Column(value = "sc_provider_email")
	private String provider_email;
	
	@Column(value = "sc_product_code")
	private String product_code;
	
	@Column(value = "sc_vendor_code")
	private String vendor_code;
	
	@Column(value = "sc_vendor_name")
	private String vendor_name;
	
	@Column(value = "sc_vendor_description")
	private String vendor_description;
	
	@Column(value = "sc_vendor_url")
	private String vendor_url;
	
	@Column(value = "sc_vendor_email")
	private String vendor_email;
	
	@Column(value = "sc_product_name")
	private String product_name;
	
	@Column(value = "sc_product_version")
	private String product_version;
	
	@Column(value = "sc_product_description")
	private String product_description;
	

	public int getServiceId() {
		return this.pk1;
	}
	// A globally unique identifier for the service.  The domain name is typical.
	// The scope for this is tenant/customer
	public String getGuid() {
		return this.guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getSupport_email() {
		return this.support_email;
	}
	public void setSupport_email(String support_email) {
		this.support_email = support_email;
	}
	
	// In a multi-tenant environment this data describes the tenant / customer.
	public String getService_owner_id() {
		return this.owner_id;
	}
	public void setService_owner_id(String owner_id) {
		this.owner_id = owner_id;
	}
	public String getService_owner_owner_name() {
		return this.owner_name;
	}
	public void setService_owner_owner_name(String owner_name) {
		this.owner_name = owner_name;
	}
	public String getService_owner_description() {
		return this.owner_description;
	}
	public void setService_owner_description(String owner_description) {
		this.owner_description = owner_description;
	}
	public String getService_owner_support_email() {
		return this.owner_email;
	}
	public void setService_owner_support_email(String owner_email) {
		this.owner_email = owner_email;
	}

	// This represents the service provider that hosts a product. 
	// If this is self hosted, it is reasonable that these values
	// are the same as the "owner" values above.
	public String getService_provider_id() {
		return this.provider_id;
	}
	public void setService_provider_id(String provider_id) {
		this.provider_id = provider_id;
	}
	public String getService_provider_provider_name() {
		return this.provider_name;
	}
	public void setService_provider_provider_name(String provider_name) {
		this.provider_name = provider_name;
	}
	public String getService_provider_description() {
		return this.provider_description;
	}
	public void setService_provider_description(String provider_description) {
		this.provider_description = provider_description;
	}
	public String getService_provider_support_email() {
		return this.provider_email;
	}
	public void setService_provider_support_email(String provider_email) {
		this.provider_email = provider_email;
	}

	// This section is about the software product
	public String getProduct_family_product_code() {
		return this.product_code;
	}
	public void setProduct_family_product_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_family_vendor_code() {
		return this.vendor_code;
	}
	public void setProduct_family_vendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}
	public String getProduct_family_vendor_name() {
		return this.vendor_name;
	}
	public void setProduct_family_vendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	public String getProduct_family_vendor_description() {
		return this.vendor_description;
	}
	public void setProduct_family_vendor_description(String vendor_description) {
		this.vendor_description = vendor_description;
	}
	public String getProduct_family_vendor_website() {
		return this.vendor_url;
	}
	public void setProduct_family_vendor_website(String vendor_url) {
		this.vendor_url = vendor_url;
	}
	public String getProduct_family_vendor_contact() {
		return this.vendor_email;
	}
	public void setProduct_family_vendor_contact(String vendor_email) {
		this.vendor_email = vendor_email;
	}

	// This is about one particular version of a product.
	public String getProduct_info_product_name() {
		return this.product_name;
	}
	public void setProduct_info_product_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_info_product_version() {
		return this.product_version;
	}
	public void setProduct_info_product_version(String product_version) {
		this.product_version = product_version;
	}
	public String getProduct_info_product_description() {
		return this.product_description;
	}
	public void setProduct_info_product_description(String product_description) {
		this.product_description = product_description;
	}
}

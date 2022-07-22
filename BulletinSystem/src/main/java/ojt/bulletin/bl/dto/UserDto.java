package ojt.bulletin.bl.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.NoArgsConstructor;
import ojt.bulletin.persistence.entity.User;

@NoArgsConstructor
public class UserDto {
	 private Integer id;

	    /**
	     * <h2>name</h2>
	     * <p>
	     * name
	     * </p>
	     */
	    @NotEmpty
	    private String name;

	    /**
	     * <h2>email</h2>
	     * <p>
	     * email
	     * </p>
	     */
	    @Email
	    @NotEmpty
	    private String email;

	    /**
	     * <h2>password</h2>
	     * <p>
	     * password
	     * </p>
	     */
	    @Size(min = 8, max = 80)
	    @NotEmpty
	    private String password;

	    

	    /**
	     * <h2>type</h2>
	     * <p>
	     * type
	     * </p>
	     */
	    @NotEmpty
	    private String type;

	    /**
	     * <h2>phone</h2>
	     * <p>
	     * phone
	     * </p>
	     */
	    @NotEmpty
	    private String phone;

	    /**
	     * <h2>address</h2>
	     * <p>
	     * address
	     * </p>
	     */
	    private String address;

	    /**
	     * <h2>dob</h2>
	     * <p>
	     * dob
	     * </p>
	     */
	    @NotEmpty
	    private String dob;
	    private Date createdAt;

	    /**
	     * <h2>updatedAt</h2>
	     * <p>
	     * updatedAt
	     * </p>
	     */
	    private Date updatedAt;

	    /**
	     * <h2>deletedAt</h2>
	     * <p>
	     * deletedAt
	     * </p>
	     */
	    private Date deletedAt;
	    
	    public Integer getId() {
	        return id;
	    }

	    /**
	     * <h2>setId</h2>
	     * <p>
	     * 
	     * </p>
	     *
	     * @param id
	     * @return void
	     */
	    public void setId(Integer id) {
	        this.id = id;
	    }

	    /**
	     * <h2>getName</h2>
	     * <p>
	     * 
	     * </p>
	     *
	     * @return
	     * @return String
	     */
	    public String getName() {
	        return name;
	    }

	    /**
	     * <h2>setName</h2>
	     * <p>
	     * 
	     * </p>
	     *
	     * @param name
	     * @return void
	     */
	    public void setName(String name) {
	        this.name = name;
	    }

	    /**
	     * <h2>getEmail</h2>
	     * <p>
	     * 
	     * </p>
	     *
	     * @return
	     * @return String
	     */
	    public String getEmail() {
	        return email;
	    }

	    /**
	     * <h2>setEmail</h2>
	     * <p>
	     * 
	     * </p>
	     *
	     * @param email
	     * @return void
	     */
	    public void setEmail(String email) {
	        this.email = email;
	    }

	    
	    public String getPassword() {
	        return password;
	    }

	    
	    public void setPassword(String password) {
	        this.password = password;
	    }

	 
	 

	   
	    public String getType() {
	        return type;
	    }

	  
	    public void setType(String type) {
	        this.type = type;
	    }

	    
	    public String getPhone() {
	        return phone;
	    }

	    
	    public void setPhone(String phone) {
	        this.phone = phone;
	    }

	   
	    public String getAddress() {
	        return address;
	    }

	   
	    public void setAddress(String address) {
	        this.address = address;
	    }

	    
	    public String getDob() {
	        return dob;
	    }

	   
	    public void setDob(String dob) {
	        this.dob = dob;
	    }
	    
	    public Date getCreatedAt() {
	        return createdAt;
	    }

	   
	    public void setCreatedAt(Date createdAt) {
	        this.createdAt = createdAt;
	    }

	  
	    public Date getUpdatedAt() {
	        return updatedAt;
	    }

	    public void setUpdatedAt(Date updatedAt) {
	        this.updatedAt = updatedAt;
	    }

	    
	    public Date getDeletedAt() {
	        return deletedAt;
	    }

	    
	    public void setDeletedAt(Date deletedAt) {
	        this.deletedAt = deletedAt;
	    }
	    public UserDto(User user) {
	        super();
	        this.id = user.getId();
	        this.name = user.getName();
	        this.email = user.getEmail();
	        this.password = user.getPassword();
	      
	        this.type = user.getType();
	        this.phone = user.getPhone();
	        this.address = user.getAddress();
	        this.dob = user.getDob();
	        this.createdAt = user.getCreatedAt();
	        this.updatedAt = user.getUpdatedAt();
	        this.deletedAt = user.getDeletedAt();
	    }
}

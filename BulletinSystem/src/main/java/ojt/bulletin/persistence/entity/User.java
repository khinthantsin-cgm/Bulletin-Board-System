package ojt.bulletin.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.NumberFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ojt.bulletin.web.form.UserForm;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "type")
    private String type;

    @Column(name = "dob")
    private String dob;

    @NumberFormat
    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;
    
   
    
    @Column(name = "created_user_id")
    private Integer createdUserId;

    /**
     * <h2>updatedUserId</h2>
     * <p>
     * updatedUserId
     * </p>
     */
    @Column(name = "updated_user_id")
    private Integer updatedUserId;

    /**
     * <h2>deletedUserId</h2>
     * <p>
     * deletedUserId
     * </p>
     */
    @Column(name = "deleted_user_id")
    private Integer deletedUserId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
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

    /**
     * <h2>getPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * <h2>setPassword</h2>
     * <p>
     * 
     * </p>
     *
     * @param password
     * @return void
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * <h2>getType</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getType() {
        return type;
    }

    /**
     * <h2>setType</h2>
     * <p>
     * 
     * </p>
     *
     * @param type
     * @return void
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * <h2>getPhone</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getPhone() {
        return phone;
    }

    /**
     * <h2>setPhone</h2>
     * <p>
     * 
     * </p>
     *
     * @param phone
     * @return void
     */
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

    /**
     * <h2>setDob</h2>
     * <p>
     * 
     * </p>
     *
     * @param dob
     * @return void
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

 
    
    public Integer getCreatedUserId() {
        return createdUserId;
    }

    /**
     * <h2>setCreatedUserId</h2>
     * <p>
     * 
     * </p>
     *
     * @param createdUserId
     * @return void
     */
    public void setCreatedUserId(Integer createdUserId) {
        this.createdUserId = createdUserId;
    }

    /**
     * <h2>getUpdatedUserId</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return int
     */
    public Integer getUpdatedUserId() {
        return updatedUserId;
    }

    /**
     * <h2>setUpdatedUserId</h2>
     * <p>
     * 
     * </p>
     *
     * @param updatedUserId
     * @return void
     */
    public void setUpdatedUserId(Integer updatedUserId) {
        this.updatedUserId = updatedUserId;
    }

    /**
     * <h2>getDeletedUserId</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return int
     */
    public Integer getDeletedUserId() {
        return deletedUserId;
    }

    /**
     * <h2>setDeletedUserId</h2>
     * <p>
     * 
     * </p>
     *
     * @param deletedUserId
     * @return void
     */
    public void setDeletedUserId(Integer deletedUserId) {
        this.deletedUserId = deletedUserId;
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

    public User(UserForm userForm) {
        this.id = userForm.getId();
        this.name = userForm.getName();
        this.email = userForm.getEmail();
        this.password = userForm.getPassword();
        this.type = userForm.getType();
        this.phone = userForm.getPhone();
        this.address = userForm.getAddress();
        this.dob = userForm.getDob();
        this.createdUserId = userForm.getCreatedUserId();
        this.updatedUserId = userForm.getUpdatedUserId();
        this.deletedUserId = userForm.getDeletedUserId();
        this.createdAt = userForm.getCreatedAt();
        this.updatedAt = userForm.getUpdatedAt();
        this.deletedAt = userForm.getDeletedAt();
    
    }

}

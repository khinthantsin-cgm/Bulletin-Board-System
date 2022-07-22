package ojt.bulletin.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import ojt.bulletin.web.form.PostForm;

@Getter
@Setter
@Entity
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image")
    private String image;
    
    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "deleted_at")
    private Date deletedAt;

    @Column(name = "created_user_name")
    private String createdUserName;

    @Column(name = "created_user_id")
    private Integer createdUserId;

    @Column(name = "updated_user_id")
    private Integer updatedUserId;

    @Column(name = "deleted_user_id")
    private Integer deletedUserId;

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
     * <h2>getTitle</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getTitle() {
        return title;
    }

    /**
     * <h2>setTitle</h2>
     * <p>
     * 
     * </p>
     *
     * @param title
     * @return void
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * <h2>getDescription</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * <h2>setDescription</h2>
     * <p>
     * 
     * </p>
     *
     * @param description
     * @return void
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    /**
     * <h2>setTitle</h2>
     * <p>
     * 
     * </p>
     *
     * @param title
     * @return void
     */
    public void setImage(String image) {
        this.image = image;
    }

    
    /**
     * <h2>getCreatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Date
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * <h2>setCreatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @param createdAt
     * @return void
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * <h2>getUpdatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Date
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * <h2>setUpdatedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @param updatedAt
     * @return void
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * <h2>getDeletedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Date
     */
    public Date getDeletedAt() {
        return deletedAt;
    }

    /**
     * <h2>setDeletedAt</h2>
     * <p>
     * 
     * </p>
     *
     * @param deletedAt
     * @return void
     */
    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getCreatedUserName() {
        return createdUserName;
    }

    public void setCreatedUserName(String createdUserName) {
        this.createdUserName = createdUserName;
    }

    public Integer getCreatedUserID() {
        return createdUserId;
    }

    /**
     * <h2>setCreatedUserID</h2>
     * <p>
     * 
     * </p>
     *
     * @param createdUserID
     * @return void
     */
    public void setCreatedUserID(Integer createdUserID) {
        this.createdUserId = createdUserID;
    }

    /**
     * <h2>getUpdatedUserID</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Integer
     */
    public Integer getUpdatedUserID() {
        return updatedUserId;
    }

    /**
     * <h2>setUpdatedUserID</h2>
     * <p>
     * 
     * </p>
     *
     * @param updatedUserID
     * @return void
     */
    public void setUpdatedUserID(Integer updatedUserID) {
        this.updatedUserId = updatedUserID;
    }

    /**
     * <h2>getDeletedUserID</h2>
     * <p>
     * 
     * </p>
     *
     * @return
     * @return Integer
     */
    public Integer getDeletedUserID() {
        return deletedUserId;
    }

    /**
     * <h2>setDeletedUserID</h2>
     * <p>
     * 
     * </p>
     *
     * @param deletedUserID
     * @return void
     */
    public void setDeletedUserID(Integer deletedUserID) {
        this.deletedUserId = deletedUserID;
    }

    public Post() {
        super();
    }

    public Post(PostForm postForm) {
        this.id = postForm.getId();
        this.title = postForm.getTitle();
        this.description = postForm.getDescription();
        this.image = postForm.getImage();
        this.createdAt = postForm.getCreatedAt();
        this.updatedAt = postForm.getUpdatedAt();
        this.deletedAt = postForm.getDeletedAt();
        this.createdUserName = postForm.getCreatedUserName();
        this.createdUserId = postForm.getCreatedUserID();
        this.updatedUserId = postForm.getUpdatedUserID();
        this.deletedUserId = postForm.getDeletedUserID();
    }
}
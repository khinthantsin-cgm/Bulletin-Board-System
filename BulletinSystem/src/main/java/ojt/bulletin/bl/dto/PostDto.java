package ojt.bulletin.bl.dto;

import java.io.Serializable;
import java.util.Date;

import ojt.bulletin.persistence.entity.Post;

public class PostDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * <h2>id</h2>
     * <p>
     * id
     * </p>
     */
    private Integer id;

    /**
     * <h2>title</h2>
     * <p>
     * title
     * </p>
     */
    private String title;

    /**
     * <h2>description</h2>
     * <p>
     * description
     * </p>
     */
    private String description;

    private String image;
    /**
     * <h2>createdAt</h2>
     * <p>
     * createdAt
     * </p>
     */
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

    private String createdUserName;

    private Integer createdUserId;

    private Integer updatedUserId;

    private Integer deletedUserId;

    /**
     * <h2>getID</h2>
     * <p>
     * Getter method for Id
     * </p>
     *
     * @return
     * @return Integer
     */
    public Integer getId() {
        return id;
    }

    /**
     * <h2>setID</h2>
     * <p>
     * Setter method for Id
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
     * Getter method for Title
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
     * Setter method for title
     * </p>
     *
     * @param title
     * @return void
     */
    public void setTitle(String title) {
        this.title = title;
    }

    
    public String getImage() {
        return image;
    }

    /**
     * <h2>setTitle</h2>
     * <p>
     * Setter method for title
     * </p>
     *
     * @param title
     * @return void
     */
    public void setImage(String image) {
        this.image = image;
    }
    /**
     * <h2>getDescription</h2>
     * <p>
     * Getter method for Description
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
     * Setter method for Description
     * </p>
     *
     * @param description
     * @return void
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * <h2>getCreatedAt</h2>
     * <p>
     * Getter method ofr CreatedAt
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
     * Setter method for CreatedAt
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
     * Setter method for UpdatedAt
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
     * Setter method for UpdatedAt
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
     * Getter Method for DeletedAt
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
     * Setter method for DeletedAt
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

    /**
     * <h2>Constructor for PostDto</h2>
     * <p>
     * Constructor for PostDto
     * </p>
     */
    public PostDto() {
        super();
    }

    /**
     * <h2>Constructor for PostDto</h2>
     * <p>
     * Constructor for PostDto
     * </p>
     * 
     * @param post
     */
    public PostDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.description = post.getDescription();
        this.createdAt = post.getCreatedAt();
        this.updatedAt = post.getUpdatedAt();
        this.deletedAt = post.getDeletedAt();
        this.createdUserName = post.getCreatedUserName();
        this.createdUserId = post.getCreatedUserID();
        this.updatedUserId = post.getUpdatedUserID();
        this.deletedUserId = post.getDeletedUserID();
    }
}

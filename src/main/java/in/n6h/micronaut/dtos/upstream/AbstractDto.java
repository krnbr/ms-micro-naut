package in.n6h.micronaut.dtos.upstream;

import java.sql.Timestamp;

/**
 * Created by Karanbir Singh on 5/25/2019.
 **/
public class AbstractDto<T> {

    private T id;

    private String encryptedId;

    private Timestamp createdOn;

    private Timestamp updatedOn;

    private UserDto updatedBy;

    private boolean enabled;

    private boolean editable;

    private boolean deleted;

    private boolean expired;

    private boolean locked;

    private UserDto editable_by;

    private boolean createdSuccessfully;

    public T getId() {
        return id;
    }

    public void setId(T id) {
        this.id = id;
    }

    public String getEncryptedId() {
        return encryptedId;
    }

    public void setEncryptedId(String encryptedId) {
        this.encryptedId = encryptedId;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }

    public UserDto getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(UserDto updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public UserDto getEditable_by() {
        return editable_by;
    }

    public void setEditable_by(UserDto editable_by) {
        this.editable_by = editable_by;
    }

    public boolean isCreatedSuccessfully() {
        return createdSuccessfully;
    }

    public void setCreatedSuccessfully(boolean createdSuccessfully) {
        this.createdSuccessfully = createdSuccessfully;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
}
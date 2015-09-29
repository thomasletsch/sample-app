package org.moserp.common.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.moserp.common.rest.HateoasLinkContainer;

public class IdentifiableEntity extends HateoasLinkContainer {

    public IdentifiableEntity() {
    }

    @JsonIgnore
    public String getId() {
        if(getSelf() == null || getSelf().getHref() == null || !getSelf().getHref().contains("/")) {
            return null;
        }

        String href = getSelf().getHref();
        return href.substring(href.lastIndexOf("/") + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdentifiableEntity that = (IdentifiableEntity) o;

        return !(getId() != null ? !getId().equals(that.getId()) : that.getId() != null);

    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "id=" + getId();
    }
}

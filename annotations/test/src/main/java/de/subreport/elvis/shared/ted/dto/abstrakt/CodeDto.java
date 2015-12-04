package de.subreport.elvis.shared.ted.dto.abstrakt;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Every Code in TED has a {@link #code} and {@link #name} as field.
 * This is the parent class for every Code Dto.
 * 
 * @param <E> This Parameter defines the type of the {@link List} from the {@link #children}. <br>
 *            Please commit the Dto who extends from the {@link CodeDto}.
 * 
 * @author Heinrichs
 *
 */
public abstract class CodeDto<E> implements Serializable {

	private static final long serialVersionUID = 4679736415598919208L;

	/**
	 * The whole code of an item.
	 */
	protected String code;
	/**
	 * The name of the code, can be multi language.
	 */
	private String name;
	/**
	 * List of children who have the same type as the dto who extends the {@link CodeDto}.
	 */
	private List<E> children;
	private boolean hasChildren = false;

	public CodeDto() {
		children = new ArrayList<E>();
	}

	public CodeDto(String code, String name, List<E> children) {
		super();
		this.code = code;
		this.name = name;
		this.children = children;
	}

	public abstract String getCode();

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<E> getChildren() {
		return children;
	}

	public void setChildren(List<E> children) {
		this.children = children;
	}

	public void setHasChildren(Boolean hasChildren) {
		this.hasChildren = hasChildren;
	}

	public boolean hasChildren() {
		return hasChildren;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((children == null) ? 0 : children.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CodeDto<?> other = (CodeDto<?>) obj;
		if (children == null) {
			if (other.children != null) {
				return false;
			}
		} else if (!children.equals(other.children)) {
			return false;
		}
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "CodeDto [name=" + getName() + ", hasChildren=" + hasChildren() + "]";
	}

}

package com.bs.career.service.model;

/**
 * @author bharat
 *
 * @param <T1>
 */
public class ValueResult<T1> {

	public ValueResult() {
		setSuccess(true);
	}

	public ValueResult(T1 resource) {
		setSuccess(true);
		setValue(resource);
	}

	private T1 value;
	private boolean success;

	public T1 getValue() {
		return value;
	}

	public void setValue(T1 value) {
		this.value = value;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}

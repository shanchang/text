package model;

/**
 * Account entity. @author MyEclipse Persistence Tools
 */

public class Account implements java.io.Serializable {

	// Fields

	private String accountId;
	private String customerKey;
	private Double balance;
	private Integer state;

	// Constructors

	/** default constructor */
	public Account() {
	}

	/** full constructor */
	public Account(String accountId, String customerKey, Double balance,
			Integer state) {
		this.accountId = accountId;
		this.customerKey = customerKey;
		this.balance = balance;
		this.state = state;
	}

	// Property accessors

	public String getAccountId() {
		return this.accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getCustomerKey() {
		return this.customerKey;
	}

	public void setCustomerKey(String customerKey) {
		this.customerKey = customerKey;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

}